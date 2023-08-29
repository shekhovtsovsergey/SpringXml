package com.shekhovtsov.springxml.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Question {

    private final String question;
    private final String answer;

}
