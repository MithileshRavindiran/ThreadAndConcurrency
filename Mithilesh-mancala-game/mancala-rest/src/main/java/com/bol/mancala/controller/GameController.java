package com.bol.mancala.controller;

import com.bol.mancala.model.Mancala;
import com.bol.mancala.service.*;
import com.bol.mancala.util.GameInitialization;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class GameController {

    @GetMapping("/load")
    public ResponseEntity<Mancala> loadInitialBoard() {
        Mancala mancala = GameInitialization.loadInitialSet();
        return ResponseEntity.ok().body(mancala);
    }


    @PutMapping("/play")
    public ResponseEntity<Mancala> makePlayerMove(@RequestBody Mancala playerSelection) {
        MancalaRuleExecutioner mancalaRuleExecutioner = new MancalaRuleExecutioner();
        MancalaRule mancalaRule = mancalaRuleExecutioner.prepareGameRules();
        return ResponseEntity.ok().body(mancalaRule.executeRule(playerSelection, new AtomicInteger(0)));
    }
}
