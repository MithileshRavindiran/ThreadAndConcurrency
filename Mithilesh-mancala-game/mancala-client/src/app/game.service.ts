import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Mancala} from "./model/mancala";

@Injectable({
  providedIn: 'root'
})
export class GameService {

  constructor(private httpClient: HttpClient) {
  }

  retrieveBoardDetails() {
    return this.httpClient.get('http://localhost:8080/load')
  }

  makeMove(board: Mancala) {
    return this.httpClient.put('http://localhost:8080/play', board)
  }

}
