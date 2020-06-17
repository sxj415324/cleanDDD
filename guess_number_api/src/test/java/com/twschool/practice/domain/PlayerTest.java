package com.twschool.practice.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Map;

public class PlayerTest {
    private GuessNumberGame guessNumberGame;


    @Before
    public void setUp() throws Exception {
        Answer answer = new Answer(Arrays.asList("1", "2", "3", "4"));
        RandomAnswerGenerator randomAnswerGenerator = Mockito.mock(RandomAnswerGenerator.class);
        Mockito.when(randomAnswerGenerator.generateAnswer()).thenReturn(answer);
        guessNumberGame = new GuessNumberGame(randomAnswerGenerator);
    }

    @Test
    public void should_return_6_when_win_twice() {
        Player player = new Player("1","zhang",guessNumberGame);
        player.playGame(Arrays.asList("1", "2", "3", "4"));
        player.playGame(Arrays.asList("1", "2", "3", "4"));

        String grade = String.valueOf(guessNumberGame.getGrade());

        Assert.assertEquals("6", grade);
    }
}
