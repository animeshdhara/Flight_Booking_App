package com.springjwt.dto;

public record AuthenticationResponse(Long id,String name, String email,String jwtToken,Boolean success) {

}
