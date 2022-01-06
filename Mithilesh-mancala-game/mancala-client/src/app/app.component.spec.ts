import {TestBed} from '@angular/core/testing';
import {RouterTestingModule} from '@angular/router/testing';
import {AppComponent} from './app.component';
import {GameService} from './game.service';
import {Mancala, PlayerPosition} from './model/mancala';
import {of} from 'rxjs';

describe('AppComponent', () => {
  let gameService: GameService;
  const gameServiceMock = {
    retrieveBoardDetails() {
    }
  };
  beforeEach((() => {
    TestBed.configureTestingModule({
      imports: [
        RouterTestingModule
      ],
      declarations: [
        AppComponent
      ],
      providers: [
        {provide: GameService, useValue: gameServiceMock}
      ]
    });
    gameService = TestBed.get(GameService);
  }));

  it('should create the app', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });

  it('should call the service on OnInit', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    const gameSpy = spyOn(gameService, 'retrieveBoardDetails').and.returnValue(of({playerTurn: PlayerPosition.PLAYER_TWO} as Mancala));
    app.ngOnInit();
    expect(gameSpy).toHaveBeenCalled();
    expect(gameSpy).toHaveBeenCalledTimes(1);
  });
});
