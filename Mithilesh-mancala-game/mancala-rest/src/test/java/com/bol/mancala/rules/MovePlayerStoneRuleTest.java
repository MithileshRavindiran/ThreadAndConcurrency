package com.bol.mancala.rules;

import com.bol.mancala.model.Mancala;
import com.bol.mancala.sample.TestSample;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

class MovePlayerStoneRuleTest {

    MovePlayerStoneRule movePlayerStoneRule = new MovePlayerStoneRule();

    @BeforeEach
    void setUp() {
        this.movePlayerStoneRule.setNextRule(new GameCompletionRule());
    }

    @Test
    @DisplayName("Move stones < pit")
    void executeRule() {
        Mancala userInput = TestSample.getDummyValues();
        userInput.getCurrentPlayer().setSelectedPosition(2);
        Mancala mancala = movePlayerStoneRule.executeRule(userInput, new AtomicInteger(0));
        assertIterableEquals(mancala.getPlayerOnePositions(), Arrays.asList(1, 0, 4, 5, 5, 6, 7));
        assertEquals(Mancala.PlayerTurn.PLAYER_ONE, mancala.getPlayerTurn());
        assertNull(mancala.getWinner());
    }

    @Test
    @DisplayName("Move stones > pit")
    void executeRule_pitExceed() {
        Mancala userInput = TestSample.getDummyValues();
        userInput.getCurrentPlayer().setPosition(Arrays.asList(1, 2, 3, 3, 5, 6, 7));
        userInput.getCurrentPlayer().setSelectedPosition(4);
        Mancala mancala = movePlayerStoneRule.executeRule(userInput, new AtomicInteger(0));
        assertIterableEquals(mancala.getPlayerOnePositions(), Arrays.asList(1, 2, 3, 0, 6, 7, 7));
        assertEquals(Mancala.PlayerTurn.PLAYER_ONE, mancala.getPlayerTurn());
        assertNull(mancala.getWinner());
    }

    @Test
    @DisplayName("Move stones + capture Opponent stones in pit")
    void executeRule_captureOpponent() {
        Mancala userInput = TestSample.getDummyValues();
        userInput.getCurrentPlayer().setPosition(Arrays.asList(1, 0, 3, 3, 5, 6, 7));
        userInput.getOpponentPlayer().setPosition(Arrays.asList(1, 2, 3, 10, 5, 6, 7));
        userInput.getCurrentPlayer().setSelectedPosition(1);
        Mancala mancala = movePlayerStoneRule.executeRule(userInput, new AtomicInteger(0));
        assertIterableEquals(mancala.getPlayerOnePositions(), Arrays.asList(0, 0, 3, 3, 5, 6, 13));
        assertIterableEquals(mancala.getPlayerTwoPositions(), Arrays.asList(1, 2, 3, 10, 0, 6, 7));
        assertEquals(Mancala.PlayerTurn.PLAYER_ONE, mancala.getPlayerTurn());
        assertNull(mancala.getWinner());
    }
}
