package com.bol.mancala.rules;

import com.bol.mancala.model.Mancala;
import com.bol.mancala.model.Player;
import com.bol.mancala.service.AbstractMancalaRule;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MoveStoneToOpponentRule extends AbstractMancalaRule {

    public Mancala executeRule(Mancala mancala, AtomicInteger remainderStone) {
        if (remainderStone.get() > 0) {
            while (remainderStone.get() > 0) {
                fillPits(remainderStone, mancala.getCurrentPlayer());
                fillPits(remainderStone, mancala.getOpponentPlayer());
            }
        }
        return mancalaRule.executeRule(mancala, remainderStone);
    }

    private void fillPits(AtomicInteger remainderStone, Player player) {
        List<Integer> playersPit = player.getPosition();
        for (int j = 0; j < playersPit.size() - 1 && remainderStone.get() > 0; j++) {
            playersPit.set(j, playersPit.get(j) + 1);
            remainderStone.getAndDecrement();
        }
    }
}
