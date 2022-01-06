package com.bol.mancala.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Mancala {
    PlayerTurn playerTurn;
    PlayerTurn winner;
    Player player1;
    Player player2;

    public enum PlayerTurn {
        PLAYER_ONE,
        PLAYER_TWO
    }

    @JsonIgnore
    public List<Integer> getPlayerOnePositions() {
        return this.player1.getPosition();
    }

    @JsonIgnore
    public List<Integer> getPlayerTwoPositions() {
        return this.player2.getPosition();
    }

    @JsonIgnore
    public Player getCurrentPlayer() {
        return this.playerTurn == PlayerTurn.PLAYER_ONE ? this.player1 : this.player2;
    }

    @JsonIgnore
    public Player getOpponentPlayer() {
        return this.playerTurn == PlayerTurn.PLAYER_ONE ? this.player2 : this.player1;
    }

    public void interChangeTurn() {
        this.playerTurn = this.playerTurn == PlayerTurn.PLAYER_ONE ? PlayerTurn.PLAYER_TWO : PlayerTurn.PLAYER_ONE;
    }
}
