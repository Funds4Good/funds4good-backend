package com.funds4good.Service.Impl;

import com.funds4good.Models.BookMarkMap;
import com.funds4good.Models.User;
import com.funds4good.Models.loans.Loan;
import com.funds4good.Payloads.loans.LoanDto;
import com.funds4good.Repository.BookMarkMapRepo;
import com.funds4good.Repository.LoanRepo;
import com.funds4good.Service.FileService;
import com.funds4good.Service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {
    private final LoanRepo loanRepo;
    private final FileService fileService;
    private final BookMarkMapRepo bookMarkMapRepo;

    @Override
    public Loan createLoan(LoanDto loanDto, MultipartFile image, User user) {
        String imagePath = this.fileService.uploadImage(image, "loans");
        return loanRepo.save(new Loan(loanDto, imagePath, user));
    }

    @Override
    public void bookMark(User user, String id) {
        if (this.bookMarkMapRepo.existsByUserIdAndPostId(user.getUsername(), id)) {
            this.bookMarkMapRepo.deleteByUserIdAndPostId(user.getUsername(), id);
        } else {
            this.bookMarkMapRepo.save(new BookMarkMap(user.getUsername(), id));
        }
    }

    @Override
    public List<Loan> getUserLoans(User user) {
        return loanRepo.findByUserId(user.getUsername());
    }

    @Override
    public List<Loan> getUserBookMarkLoans(User user) {
        List<BookMarkMap> maps = this.bookMarkMapRepo.findByUserId(user.getUsername());
        return loanRepo.findAllById(maps.stream().map(BookMarkMap::getPostId).toList());
    }

    @Override
    public List<Loan> getAllLoans(String category) {
        if (category ==null || category.isEmpty()) {
            return loanRepo.findAllLoans();
        }
        return loanRepo.findByLoanCategory(category);
    }
}
