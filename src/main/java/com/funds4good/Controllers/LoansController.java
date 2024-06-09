package com.funds4good.Controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.funds4good.Models.User;
import com.funds4good.Payloads.loans.LoanDto;
import com.funds4good.Service.Impl.FileServiceImpl;
import com.funds4good.Service.LoanService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/loans")
@SecurityRequirement(name = "Bearer Token")
@RequiredArgsConstructor
public class LoansController {
    private final LoanService loanService;

    @PostMapping("/apply")
    public ResponseEntity<?> createLoan(@AuthenticationPrincipal User user, @RequestParam String loanRequest, @RequestParam(value = "image", required = false) MultipartFile image) {
        if (image != null && !image.isEmpty() && FileServiceImpl.fileValidation(new MultipartFile[]{image}))
            return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body("File is not of image type(JPEG/ JPG or PNG)!!!");
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        LoanDto loanDto = null;
        try {
            loanDto = mapper.readValue(loanRequest, LoanDto.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(this.loanService.createLoan(loanDto, image, user), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getLoans(
            @RequestParam(required = false, defaultValue = "") String category
    ) {
        return new ResponseEntity<>(this.loanService.getAllLoans(category), HttpStatus.OK);
    }

    @GetMapping("/getUserLoans")
    public ResponseEntity<?> getUserLoans(@AuthenticationPrincipal User user) {
        return new ResponseEntity<>(this.loanService.getUserLoans(user), HttpStatus.OK);
    }

    @PostMapping("/bookMark/{postId}")
    public ResponseEntity<?> bookMarkLoan(@AuthenticationPrincipal User user, @PathVariable("postId") String postId) {
        if (user == null) return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        this.loanService.bookMark(user, postId);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @GetMapping("/getBookMarks")
    public ResponseEntity<?> getBookMarks(@AuthenticationPrincipal User user) {
        if (user == null) return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(this.loanService.getUserBookMarkLoans(user), HttpStatus.OK);
    }
}
