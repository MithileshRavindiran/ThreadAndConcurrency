package com.bol.mancala.rules;

import com.bol.mancala.constants.MancalaConstants;
import com.bol.mancala.model.Mancala;
import com.bol.mancala.service.AbstractMancalaRule;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class GameCompletionRule extends AbstractMancalaRule {

    public Mancala executeRule(Mancala mancala, AtomicInteger remainingStones) {
        if (checkStonesPresentInPits(mancala.getPlayerOnePositions()) || checkStonesPresentInPits(mancala.getPlayerTwoPositions())) {
            mancala.setWinner(mancala.getPlayerOnePositions().get(MancalaConstants.MANCALA_PITS) >
                    mancala.getPlayerTwoPositions().get(MancalaConstants.MANCALA_PITS)
                    ? Mancala.PlayerTurn.PLAYER_ONE : Mancala.PlayerTurn.PLAYER_TWO);
        }
        return mancalaRule == null ? mancala : mancalaRule.executeRule(mancala, remainingStones);
    }

    private boolean checkStonesPresentInPits(List<Integer> positions) {
        return positions.subList(0, positions.size() - 1).stream().mapToInt(Integer::intValue).sum() == 0;
    }
}
