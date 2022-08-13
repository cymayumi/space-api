package com.example.elo7.exceptionHandler;

import com.example.elo7.dto.LandSpacecraftsDTO;
import com.example.elo7.dto.MoveSpacecraftDTO;
import com.example.elo7.dto.SpacecraftDetailsDTO;


public class Validation {

    public static void validateLandingParameters(LandSpacecraftsDTO landSpacecraftsDTO) throws IncorrectParameterException {

        for(SpacecraftDetailsDTO spacecraft : landSpacecraftsDTO.getSpacecraftList()) {
            if(landSpacecraftsDTO.getPlanet() == null || landSpacecraftsDTO.getPlanet().isEmpty()) {
                throw new IncorrectParameterException("Name your planet!");
            }
            if(spacecraft.getPositionH() < 0 || spacecraft.getPositionH() >= 6) {
                throw new IncorrectParameterException("Your move is out of planet bounds!");
            }
            if(spacecraft.getPositionV() < 0 || spacecraft.getPositionV() >= 6) {
                throw new IncorrectParameterException("Your move is out of planet bounds!");
            }
            if(!spacecraft.getPositionFront().equals("N") && !spacecraft.getPositionFront().equals("S") &&
                    !spacecraft.getPositionFront().equals("E") && !spacecraft.getPositionFront().equals("W")) {
                throw new IncorrectParameterException("Your move is not a valid position!");
            }
        }
    }

    public static void validateMoveParameters(MoveSpacecraftDTO moveSpacecraftDTO) throws IncorrectParameterException {

        if(moveSpacecraftDTO.getNameSpacecraft() == null || moveSpacecraftDTO.getNameSpacecraft().isEmpty()) {
            throw new IncorrectParameterException("You need to insert your spacecraft name!");
        }

        String[] moves = moveSpacecraftDTO.getMove().split("");

        for(String move : moves) {
            if (!move.equals("M") && !move.equals("L") && !move.equals("R")) {
                throw new IncorrectParameterException("Your move is not valid!");
            }
        }
    }
}
