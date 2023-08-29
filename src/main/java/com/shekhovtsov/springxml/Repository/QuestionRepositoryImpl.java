package com.shekhovtsov.springxml.Repository;

import com.shekhovtsov.springxml.Model.Question;
import lombok.RequiredArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class QuestionRepositoryImpl implements QuestionRepository{

    private final Map<Long,Question> repository = new HashMap<>();
    private final String file;
    private Long counter= 0L;

//list refactor
    @Override
    public Map<Long, Question> loadCsv() {
        try (BufferedReader reader =
                     new BufferedReader(
                             new InputStreamReader(getClass().getResourceAsStream("/" + file)))) {
            while(reader.ready()) {
                String s = reader.readLine();
                String[] arr = s.split(";");
                Question question = new Question(arr[0],arr[1]);
                repository.put(counter++, question);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return repository;
    }

    @Override
    public void print() {
        for (Map.Entry<Long, Question> entry : repository.entrySet()) {
            System.out.println("Ключ: " + entry.getKey() + ", Вопрос: " + entry.getValue().getQuestion() + ", Ответ: " + entry.getValue().getAnswer()));
        }

    }
}
