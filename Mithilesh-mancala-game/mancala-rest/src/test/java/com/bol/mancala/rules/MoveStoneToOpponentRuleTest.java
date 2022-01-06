package com.bol.mancala.rules;

import com.bol.mancala.model.Mancala;
import com.bol.mancala.sample.TestSample;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

class MoveStoneToOpponentRuleTest {

    MoveStoneToOpponentRule moveStoneToOpponentRule = new MoveStoneToOpponentRule();

    @BeforeEach
    void setUp() {
        moveStoneToOpponentRule.setNextRule(new GameCompletionRule());
    }

    @Test
    @DisplayName("Fill the remaining stones in the opposite player pits")
    void executeRule_opposite() {
        Mancala mancala = moveStoneToOpponentRule.executeRule(TestSample.getDummyValues(), new AtomicInteger(5));
        assertIterableEquals(mancala.getPlayerOnePositions(), Arrays.asList(2, 3, 4, 5, 6, 6, 7));
        assertIterableEquals(mancala.getPlayerTwoPositions(), Arrays.asList(7, 8, 9, 10, 11, 12, 3));
        assertEquals(Mancala.PlayerTurn.PLAYER_ONE, mancala.getPlayerTurn());
        assertNull(mancala.getWinner());
    }

    @Test
    @DisplayName("Fill the remaining stones in the opposite player + current player when stones > pits")
    void executeRule_both() {
        Mancala mancala = moveStoneToOpponentRule.executeRule(TestSample.getDummyValues(), new AtomicInteger(10));
        assertIterableEquals(mancala.getPlayerOnePositions(), Arrays.asList(2, 3, 4, 5, 6, 7, 7));
        assertIterableEquals(mancala.getPlayerTwoPositions(), Arrays.asList(8, 9, 10, 11, 11, 12, 3));
        assertEquals(Mancala.PlayerTurn.PLAYER_ONE, mancala.getPlayerTurn());
        assertNull(mancala.getWinner());
    }
}
