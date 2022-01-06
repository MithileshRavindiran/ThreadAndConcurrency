package com.bol.mancala.sample;

import com.bol.mancala.constants.MancalaConstants;
import com.bol.mancala.model.Mancala;
import com.bol.mancala.model.Player;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestSample {
    public static Mancala getDummyValues() {
        Mancala mancala = new Mancala();
        Player player1 = new Player();
        player1.setPosition(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        mancala.setPlayer1(player1);
        Player player2 = new Player();
        player2.setPosition(Arrays.asList(7, 8, 9, 10, 11, 12, 3));
        mancala.setPlayer2(player2);
        mancala.setPlayerTurn(Mancala.PlayerTurn.PLAYER_ONE);
        return mancala;
    }

    public static Mancala player1_emptyPits() {
        Mancala mancala = new Mancala();
        Player player1 = new Player();
        player1.setPosition(Arrays.asList(0, 0, 0, 0, 0, 0, 7));
        mancala.setPlayer1(player1);
        Player player2 = new Player();
        player2.setPosition(Arrays.asList(7, 8, 9, 10, 11, 12, 3));
        mancala.setPlayer2(player2);
        mancala.setPlayerTurn(Mancala.PlayerTurn.PLAYER_ONE);
        return mancala;
    }

    public static Mancala player2_emptyPits() {
        Mancala mancala = new Mancala();
        Player player1 = new Player();
        player1.setPosition(Arrays.asList(7, 8, 9, 10, 11, 12, 3));
        mancala.setPlayer1(player1);
        Player player2 = new Player();
        player2.setPosition(Arrays.asList(0, 0, 0, 0, 0, 0, 7));
        mancala.setPlayer2(player2);
        mancala.setPlayerTurn(Mancala.PlayerTurn.PLAYER_ONE);
        return mancala;
    }
}
