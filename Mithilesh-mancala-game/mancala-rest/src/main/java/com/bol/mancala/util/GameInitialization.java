package com.bol.mancala.util;

import com.bol.mancala.constants.MancalaConstants;
import com.bol.mancala.model.Mancala;
import com.bol.mancala.model.Player;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameInitialization {

    public static Mancala loadInitialSet() {
        Mancala mancala = new Mancala();
        Player player = new Player();
        List<Integer> mancalaPitValues = IntStream.range(0, MancalaConstants.MANCALA_PITS).mapToObj(i -> MancalaConstants.MANCALA_STONES).collect(Collectors.toList());
        mancalaPitValues.add(0);  //Big Pit
        player.setPosition(mancalaPitValues);
        mancala.setPlayer1(player);
        mancala.setPlayer2(player);
        mancala.setPlayerTurn(Mancala.PlayerTurn.PLAYER_ONE);
        return mancala;
    }
}
