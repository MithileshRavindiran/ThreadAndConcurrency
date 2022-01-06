package com.bol.mancala.service;

import com.bol.mancala.rules.BigPitRule;
import com.bol.mancala.rules.GameCompletionRule;
import com.bol.mancala.rules.MovePlayerStoneRule;
import com.bol.mancala.rules.MoveStoneToOpponentRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MancalaRuleExecutionerTest {

    @Test
    @DisplayName("Check if the Game Rules are in the order")
    void prepareGameRules() {
        MancalaRuleExecutioner mancalaRuleExecutioner = new MancalaRuleExecutioner();
        MancalaRule mancalaRule = mancalaRuleExecutioner.prepareGameRules();
        assertTrue(mancalaRule instanceof MovePlayerStoneRule);
        assertTrue(((MovePlayerStoneRule) mancalaRule).mancalaRule instanceof BigPitRule);
        assertTrue(((BigPitRule) ((MovePlayerStoneRule) mancalaRule).mancalaRule).mancalaRule instanceof MoveStoneToOpponentRule);
        assertTrue(((MoveStoneToOpponentRule) ((BigPitRule) ((MovePlayerStoneRule) mancalaRule).mancalaRule).mancalaRule).mancalaRule instanceof GameCompletionRule);
    }
}
