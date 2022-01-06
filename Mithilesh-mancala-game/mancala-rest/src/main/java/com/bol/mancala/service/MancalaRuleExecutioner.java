package com.bol.mancala.service;

import com.bol.mancala.rules.BigPitRule;
import com.bol.mancala.rules.GameCompletionRule;
import com.bol.mancala.rules.MovePlayerStoneRule;
import com.bol.mancala.rules.MoveStoneToOpponentRule;

public class MancalaRuleExecutioner {

    public MancalaRule prepareGameRules() {
        // Initial Rule to move the stones of the current player
        MancalaRule mancalaRule = new MovePlayerStoneRule();

        // Check and fill the BigPit if stones are available
        MancalaRule bigPitRule = new BigPitRule();
        mancalaRule.setNextRule(bigPitRule);

        // Move the stones to opposition if stones are not depleted
        MancalaRule moveStoneToOpponentRule = new MoveStoneToOpponentRule();
        bigPitRule.setNextRule(moveStoneToOpponentRule);

        // Final Rule to check whether the game is complete
        moveStoneToOpponentRule.setNextRule(new GameCompletionRule());
        return mancalaRule;
    }

}
