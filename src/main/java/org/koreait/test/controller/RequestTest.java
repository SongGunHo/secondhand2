package org.koreait.test.controller;


import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RequestTest {
    @NotBlank
    @Email
    private String param1;
    @NotBlank
    private String param2;
    @NotBlank
    private String param3;
    @AssertTrue
    private String param4;






}
