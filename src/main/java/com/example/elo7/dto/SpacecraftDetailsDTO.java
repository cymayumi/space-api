package com.example.elo7.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpacecraftDetailsDTO {

    private String nameSpacecraft;
    private Integer positionH;
    private Integer positionV;
    private String positionFront;

}
