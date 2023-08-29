package com.shekhovtsov.springxml.Repository;

import com.shekhovtsov.springxml.Model.Question;
import lombok.RequiredArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class QuestionRepositoryImpl implements QuestionRepository{

    private final List<Question> repository = new ArrayList<>();
    private final String file;

    @Override
    public List<Question> loadCsv() {
        try (BufferedReader reader =
                     new BufferedReader(
                             new InputStreamReader(getClass().getResourceAsStream("/" + file)))) {
            while(reader.ready()) {
                String s = reader.readLine();
                String[] arr = s.split(";");
                Question question = new Question(arr[0],arr[1]);
                repository.add(question);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return repository;
    }

    @Override
    public void print() {
        for (Question question : repository) {
            System.out.println("Вопрос: " + question.getQuestion() + ", Ответ: " + question.getAnswer());
        }
    }
}
