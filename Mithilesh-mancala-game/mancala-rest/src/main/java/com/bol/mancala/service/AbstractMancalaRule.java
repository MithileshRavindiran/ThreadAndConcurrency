package com.bol.mancala.service;

public abstract class AbstractMancalaRule implements MancalaRule {
    protected MancalaRule mancalaRule;

    public void setNextRule(MancalaRule mancalaRule) {
        this.mancalaRule = mancalaRule;
    }
}
