import {Component, OnInit} from '@angular/core';
import {GameService} from './game.service';
import {Mancala, PlayerPosition} from './model/mancala';
import {DialogRole, MatDialog} from '@angular/material/dialog';
import {DialogWinner} from './dialogWinner';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  board: Mancala;
  pitCount: number;
  PlayerPosition = PlayerPosition;

  private playerTurn: PlayerPosition;

  constructor(private gameService: GameService, private dialog: MatDialog) {
  }

  ngOnInit(): void {
    this.initialiseBoard();
  }

  initialiseBoard() {
    this.gameService.retrieveBoardDetails().subscribe((mancala: Mancala) => {
      this.playerTurn = mancala.playerTurn;
      this.board = mancala;
      this.pitCount = mancala.player2.position.length - 1;
    });
  }

  pitClick(index: number, playerActor: PlayerPosition) {
    switch (playerActor) {
      case PlayerPosition.PLAYER_ONE:
        this.board.player1.selectedPosition = index;
        break;
      case PlayerPosition.PLAYER_TWO:
        this.board.player2.selectedPosition = index;
        break;
      default:
        console.warn('position not set properly');
    }
    this.gameService.makeMove(this.board).subscribe((data: Mancala) => {
      this.board = data;
      if (this.board.winner) {
        this.dialog.open(DialogWinner, {
          data: this.board.winner
        });
      }
    });
  }
}
