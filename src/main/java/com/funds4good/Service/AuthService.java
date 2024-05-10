package com.funds4good.Service;

import com.funds4good.Payloads.UserDto;
import com.funds4good.Security.JwtAuthRequest;
import org.springframework.http.ResponseEntity;

import java.util.concurrent.ExecutionException;

public interface AuthService {
    ResponseEntity<?> LoginAPI(JwtAuthRequest request, Integer RoleID);
//    ResponseEntity<?> registerEmail(EmailDto emailDto) throws Exception;
//    ResponseEntity<?> verifyToRegister(OtpDto otpDto) throws ExecutionException;
    ResponseEntity<?> signupUser(UserDto userDto) throws ExecutionException;
//    ResponseEntity<?> verifyOTPPasswordChange(OtpDto otpDto) throws ExecutionException;
//    ResponseEntity<?> resetPassword(ForgetPassword forgetPassword) throws ExecutionException;
//    ResponseEntity<?> sendOTPForget(EmailDto emailDto) throws Exception;
}
