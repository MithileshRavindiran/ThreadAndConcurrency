package com.bol.mancala.service;

import com.bol.mancala.model.Mancala;

import java.util.concurrent.atomic.AtomicInteger;

public interface MancalaRule {
    void setNextRule(MancalaRule mancalaRule);

    Mancala executeRule(Mancala mancala, AtomicInteger remainderStone);
}
