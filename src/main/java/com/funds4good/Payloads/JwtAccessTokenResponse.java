package com.funds4good.Payloads;

import com.funds4good.Models.Role;

import java.util.Set;

public record JwtAccessTokenResponse (
    String accessToken,
    String name,
    String Email,
    Set<Role> roles
){}
