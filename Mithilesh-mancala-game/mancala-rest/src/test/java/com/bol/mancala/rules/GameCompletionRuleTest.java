package com.bol.mancala.rules;

import com.bol.mancala.model.Mancala;
import com.bol.mancala.sample.TestSample;
import com.bol.mancala.service.MancalaRule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

class GameCompletionRuleTest {

    GameCompletionRule gameCompletionRule = new GameCompletionRule();

    @Test
    @DisplayName("No winners yet")
    void executeRule() {
        Mancala mancala = gameCompletionRule.executeRule(TestSample.getDummyValues(), new AtomicInteger(0));
        assertIterableEquals(mancala.getPlayerOnePositions(), Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        assertEquals(Mancala.PlayerTurn.PLAYER_ONE, mancala.getPlayerTurn());
        assertNull(mancala.getWinner());
    }

    @Test
    @DisplayName("Player1 is winner")
    void executeRule_Player1() {
        Mancala mancala = gameCompletionRule.executeRule(TestSample.player1_emptyPits(), new AtomicInteger(0));
        assertIterableEquals(mancala.getPlayerOnePositions(), Arrays.asList(0, 0, 0, 0, 0, 0, 7));
        assertEquals(Mancala.PlayerTurn.PLAYER_ONE, mancala.getPlayerTurn());
        assertEquals(mancala.getWinner(), Mancala.PlayerTurn.PLAYER_ONE);
    }

    @Test
    @DisplayName("Player2 is winner")
    void executeRule_Player2() {
        Mancala mancala = gameCompletionRule.executeRule(TestSample.player2_emptyPits(), new AtomicInteger(0));
        assertIterableEquals(mancala.getPlayerTwoPositions(), Arrays.asList(0, 0, 0, 0, 0, 0, 7));
        assertEquals(Mancala.PlayerTurn.PLAYER_ONE, mancala.getPlayerTurn());
        assertEquals(mancala.getWinner(), Mancala.PlayerTurn.PLAYER_TWO);
    }
}
