package com.bol.mancala.controller;

import com.bol.mancala.util.GameInitialization;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GameController.class)
class GameControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Check if the board initialization is done")
    void loadInitialBoard() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        this.mockMvc.perform(get("/load")).andExpect(status().isOk()).andExpect(content().string(objectMapper.writeValueAsString(GameInitialization.loadInitialSet())));
    }

    @Test
    @DisplayName("Check if play operation is performed")
    void makePlayerMove() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        this.mockMvc.perform(put("/play").content("{\"playerTurn\":\"PLAYER_ONE\",\"player1\":{\"position\":[1,2,3,4,5,6,0],\"selectedPosition\":5},\"player2\":{\"position\":[6,6,6,6,6,6,0]}}")
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(content().string("{\"playerTurn\":\"PLAYER_TWO\",\"player1\":{\"position\":[1,2,3,4,0,7,1]},\"player2\":{\"position\":[7,7,7,6,6,6,0]}}"));
    }

    @Test
    @DisplayName("Check if play operation is performed - player1's stone in last pit")
    void makePlayerMove_Pit() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        this.mockMvc.perform(put("/play").content("{\"playerTurn\":\"PLAYER_ONE\",\"player1\":{\"position\":[6,6,6,6,5,6,0],\"selectedPosition\":1},\"player2\":{\"position\":[6,6,6,6,6,6,0]}}")
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(content().string("{\"playerTurn\":\"PLAYER_ONE\",\"player1\":{\"position\":[0,7,7,7,6,7,1]},\"player2\":{\"position\":[6,6,6,6,6,6,0]}}"));
    }
}
