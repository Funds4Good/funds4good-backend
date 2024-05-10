package com.funds4good.Controllers;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SecurityRequirement(name = "Bearer Token")
public class StatusController {
    @GetMapping("/test")
    public String test(){
        return "Token is validated successfully!!";
    }
}
