export interface Mancala {
  playerTurn: PlayerPosition;
  player1: Player;
  player2: Player;
  winner: PlayerPosition;
}

export interface Player {
  position: number[];
  selectedPosition: number;
}

export enum PlayerPosition {
  PLAYER_ONE = 'PLAYER_ONE',
  PLAYER_TWO = 'PLAYER_TWO'
}
