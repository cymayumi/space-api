package com.example.elo7.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LandSpacecraftsDTO {

    private String planet;
    private List<SpacecraftDetailsDTO> spacecraftList;

}
