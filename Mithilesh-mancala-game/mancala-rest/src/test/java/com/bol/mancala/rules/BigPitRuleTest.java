package com.bol.mancala.rules;

import com.bol.mancala.model.Mancala;
import com.bol.mancala.sample.TestSample;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

class BigPitRuleTest {

    BigPitRule bigPitRule = new BigPitRule();

    @BeforeEach
    void setup() {
        bigPitRule.setNextRule(new GameCompletionRule());
    }

    @Test
    @DisplayName("Check if player turn doesn't interchange")
    void executeRule_SamePlayer() {
        Mancala mancala = bigPitRule.executeRule(TestSample.getDummyValues(), new AtomicInteger(1));
        assertIterableEquals(mancala.getPlayerOnePositions(), Arrays.asList(1, 2, 3, 4, 5, 6, 8));
        assertEquals(Mancala.PlayerTurn.PLAYER_ONE, mancala.getPlayerTurn());
        assertNull(mancala.getWinner());
    }

    @Test
    @DisplayName("Check if Player changes")
    void executeRule_DifferentPlayer() {
        Mancala mancala = bigPitRule.executeRule(TestSample.getDummyValues(), new AtomicInteger(0));
        assertIterableEquals(mancala.getPlayerOnePositions(), Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        assertEquals(Mancala.PlayerTurn.PLAYER_TWO, mancala.getPlayerTurn());
        assertNull(mancala.getWinner());
    }

    @Test
    @DisplayName("Check if Player changes")
    void executeRule_DifferentPlayer_Stones() {
        Mancala mancala = bigPitRule.executeRule(TestSample.getDummyValues(), new AtomicInteger(2));
        assertIterableEquals(mancala.getPlayerOnePositions(), Arrays.asList(1, 2, 3, 4, 5, 6, 8));
        assertEquals(Mancala.PlayerTurn.PLAYER_TWO, mancala.getPlayerTurn());
        assertNull(mancala.getWinner());
    }
}
