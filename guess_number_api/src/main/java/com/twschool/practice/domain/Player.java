package com.twschool.practice.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {
    private String id;
    private String name;
    private GuessNumberGame guessNumberGame;

    public Player(String id, String name, GuessNumberGame guessNumberGame) {
        this.id = id;
        this.name = name;
        this.guessNumberGame = guessNumberGame;
    }

    public Map<String,String> playGame(List<String> numbers){
        Map resultMap = new HashMap();
        String result = guessNumberGame.guess(numbers);
        int grade = guessNumberGame.getGrade();
        resultMap.put("result",result);
        resultMap.put("grade",grade);
        return resultMap;
    }
}
