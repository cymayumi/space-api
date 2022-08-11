package com.example.elo7.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpacecraftDetailsDTO {

    @NotNull
    private String nameSpacecraft;

    @NotNull
    @Positive(message = "PositionH must be bigger than 0.")
    @Max(value = 5, message = "PositionH must be lower than 5.")
    private Integer positionH;

    @NotNull
    @Positive(message = "PositionV must be bigger than 0.")
    @Max(value = 5, message = "PositionV must be lower than 5.")
    private Integer positionV;

    @NotNull
    private String positionFront;

}
