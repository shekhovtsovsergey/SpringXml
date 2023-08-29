package com.shekhovtsov.springxml.Repository;

import com.shekhovtsov.springxml.Model.Question;

import java.util.List;
import java.util.Map;

public interface QuestionRepository {

    List<Question> loadCsv();
    void print();

}
