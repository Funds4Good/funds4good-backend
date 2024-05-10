package com.funds4good.Controllers;
import com.funds4good.Payloads.UserDto;
import com.funds4good.Security.JwtAuthRequest;
import com.funds4good.Service.AuthService;
import com.funds4good.Service.JWTTokenGenerator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController @RequiredArgsConstructor
@RequestMapping(path ="/api/auth")
public class AuthController {
    private final AuthService userService;
    private final JWTTokenGenerator jwtTokenGenerator;

// User as well as the host login API and          -------------------------/TOKEN GENERATOR User/-----------------------
    @Operation(summary = "This is the API to login into the Application as user, it also acts as a token generator")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Login Successful, Access Token and Refresh Token is generated", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "User Not found", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "401", description = "Wrong Password", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "400", description = "(Validation)Invalid Email or Password Format", content = @Content(mediaType = "application/json"))})
    @PostMapping("/login")
    public ResponseEntity<?> createToken(@Valid @RequestBody JwtAuthRequest request) {
        return this.userService.LoginAPI(request, 1002);
    }

//Regenerate refresh token
    @Operation(summary = "This is the API to regenerate access token")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The refresh token is correct and access token is generated", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "408", description = "Token Expired", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "User Not found", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "400", description = "Enter string is not a refresh token", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "400", description = "(Validation)Invalid Email or Password Format", content = @Content(mediaType = "application/json"))
    })
    @GetMapping("/regenerateToken")
    public ResponseEntity<?> refreshToken(@RequestParam String token) {
        return this.jwtTokenGenerator.getRefreshTokenGenerate(token);
    }

//Register Email
    @Operation(summary = "Email to verify for signup")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OTP successfully send to user account", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "409", description = "User already exist", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "503", description = "Can't able to make your request", content = @Content(mediaType = "application/json"))
    })
    @PostMapping("/signup")
    public ResponseEntity<?> registerEmail(@Valid @RequestBody UserDto emailDto) throws Exception {
        return this.userService.signupUser(emailDto);
    }
}