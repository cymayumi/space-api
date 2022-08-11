package com.example.elo7.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LandSpacecraftsDTO {

    @NotNull
    private String planet;

    @Valid
    @NotEmpty
    private List<SpacecraftDetailsDTO> spacecraftList;

}
