package com.twschool.practice.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Map;

public class PlayerTest {
    private GuessNumberGame guessNumberGame;

    @Test
    public void should_return_6_when_win_twice() {
        Answer answer = new Answer(Arrays.asList("1", "2", "3", "4"));
        RandomAnswerGenerator randomAnswerGenerator = Mockito.mock(RandomAnswerGenerator.class);
        Mockito.when(randomAnswerGenerator.generateAnswer()).thenReturn(answer);
        guessNumberGame = new GuessNumberGame(randomAnswerGenerator);
        Player player = new Player("1","zhang",guessNumberGame);
        player.playGame(Arrays.asList("1", "2", "3", "4"));
        player.playGame(Arrays.asList("1", "2", "3", "4"));

        String grade = String.valueOf(guessNumberGame.getGrade());

        Assert.assertEquals("6", grade);
    }

    @Test
    public void should_return_3_when_win_twice_given_two_player() {
        Answer answer = new Answer(Arrays.asList("1", "2", "3", "4"));
        RandomAnswerGenerator randomAnswerGenerator = Mockito.mock(RandomAnswerGenerator.class);
        Mockito.when(randomAnswerGenerator.generateAnswer()).thenReturn(answer);
        GuessNumberGame guessNumberGame1 = new GuessNumberGame(randomAnswerGenerator);
        GuessNumberGame guessNumberGame2 = new GuessNumberGame(randomAnswerGenerator);
        Player player1 = new Player("1","zhang",guessNumberGame1);
        Player player2 = new Player("2","li",guessNumberGame2);

        player1.playGame(Arrays.asList("1", "2", "3", "4"));
        player2.playGame(Arrays.asList("1", "2", "3", "4"));

        String grade1 = String.valueOf(guessNumberGame1.getGrade());
        String grade2 = String.valueOf(guessNumberGame1.getGrade());

        Assert.assertEquals("3", grade1);
        Assert.assertEquals("3", grade2);
    }
}
