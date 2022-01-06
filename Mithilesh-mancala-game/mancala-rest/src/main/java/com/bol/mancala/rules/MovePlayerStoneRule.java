package com.bol.mancala.rules;

import com.bol.mancala.constants.MancalaConstants;
import com.bol.mancala.model.Mancala;
import com.bol.mancala.model.Player;
import com.bol.mancala.service.AbstractMancalaRule;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MovePlayerStoneRule extends AbstractMancalaRule {

    public Mancala executeRule(Mancala mancala, AtomicInteger remainderStone) {
        Player currentPlayer = mancala.getCurrentPlayer();
        List<Integer> playersPit = currentPlayer.getPosition();
        // Get pits in the selected position
        Integer gatheredStones = playersPit.get(currentPlayer.getSelectedPosition() - 1);
        // Clear the pits in the selected position
        playersPit.set(currentPlayer.getSelectedPosition() - 1, 0);
        int selectedPosition = currentPlayer.getSelectedPosition();
        while (gatheredStones > 0) {
            if (gatheredStones == 1 && selectedPosition != MancalaConstants.MANCALA_PITS && playersPit.get(selectedPosition) == 0) {
                // Snatch the opposite players Stones
                currentPlayer.addToBigPit(1 + getOppositonStones(selectedPosition + 1, mancala.getOpponentPlayer()));
            } else {
                // Add stones to pit and move position
                selectedPosition = moveStonesToPit(remainderStone, playersPit, selectedPosition);
            }
            gatheredStones--;
        }
        return this.mancalaRule != null ? mancalaRule.executeRule(mancala, remainderStone) : mancala;
    }

    private int moveStonesToPit(AtomicInteger remainderStone, List<Integer> playersPit, int position) {
        if (MancalaConstants.MANCALA_PITS > position) {
            playersPit.set(position, playersPit.get(position) + 1);
            position++;
        } else {
            remainderStone.getAndIncrement();
        }
        return position;
    }

    private Integer getOppositonStones(Integer currentPlayerIndex, Player opponentPlayer) {
        Integer stonesInOppositePosition = opponentPlayer.getPosition().get(MancalaConstants.MANCALA_PITS - currentPlayerIndex);
        opponentPlayer.getPosition().set(MancalaConstants.MANCALA_PITS - currentPlayerIndex, 0);
        return stonesInOppositePosition;
    }
}
