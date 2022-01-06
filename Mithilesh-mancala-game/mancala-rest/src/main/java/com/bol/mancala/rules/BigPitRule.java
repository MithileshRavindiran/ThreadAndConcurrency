package com.bol.mancala.rules;

import com.bol.mancala.model.Mancala;
import com.bol.mancala.service.AbstractMancalaRule;

import java.util.concurrent.atomic.AtomicInteger;

public class BigPitRule extends AbstractMancalaRule {

    public Mancala executeRule(Mancala mancala, AtomicInteger remainingStones) {
        int remainder = remainingStones.intValue();
        if (remainder >= 1) {
            mancala.getCurrentPlayer().addToBigPit(1);
            remainingStones.getAndDecrement();
        }
        if (remainder == 0 || remainder > 1) {
            mancala.interChangeTurn();
        }
        return mancalaRule.executeRule(mancala, remainingStones);
    }
}
