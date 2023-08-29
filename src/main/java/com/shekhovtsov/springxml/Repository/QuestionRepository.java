package com.shekhovtsov.springxml.Repository;

import com.shekhovtsov.springxml.Model.Question;

import java.util.Map;

public interface QuestionRepository {

    Map<Long, Question> loadCsv();
    void print();

}
