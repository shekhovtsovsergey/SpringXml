package com.shekhovtsov.springxml.Service;

import com.shekhovtsov.springxml.Repository.QuestionRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService{

    private final QuestionRepository repository;

    @Override
    public void print(){
        repository.print();
    }

}
