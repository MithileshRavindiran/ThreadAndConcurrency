package com.bol.mancala.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


import java.util.List;
import java.util.Objects;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Player {
    List<Integer> position;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    Integer selectedPosition;

    @JsonIgnore
    public void addToBigPit(Integer count) {
        int pitValue = this.position.get(this.position.size() - 1);
        this.position.set((this.position.size() - 1), pitValue + Objects.requireNonNullElse(count, 1));
    }
}
