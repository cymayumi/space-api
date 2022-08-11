package com.example.elo7.controller;

import com.example.elo7.dto.LandSpacecraftsDTO;
import com.example.elo7.dto.MoveSpacecraftDTO;
import com.example.elo7.exceptionHandler.IncorrectParameterException;
import com.example.elo7.exceptionHandler.Validation;
import com.example.elo7.service.SpacecraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class SpacecraftController {

    @Autowired
    private SpacecraftService spacecraftService;

    @PostMapping("/land")
    public ResponseEntity landSpacecraft(@RequestBody LandSpacecraftsDTO landSpacecraftsDTO) {
        try {
            Validation.validateLanding(landSpacecraftsDTO);
            return ResponseEntity.status(HttpStatus.OK).body(spacecraftService.landSpacecrafts(landSpacecraftsDTO));
        } catch (IncorrectParameterException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("It was not possible to land your spacecrafts.");
        }
    }

    @PutMapping("/move")
    public ResponseEntity moveSpacecraft(@RequestBody MoveSpacecraftDTO moveSpacecraftDTO) {
        try {
            Validation.validateMove(moveSpacecraftDTO);
            return ResponseEntity.status(HttpStatus.OK).body(spacecraftService.moveSpacecraft(moveSpacecraftDTO));
        } catch (IncorrectParameterException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("It was not possible to move your spacecraft.");
        }
    }

    @GetMapping("/{nameSpacecraft}")
    public ResponseEntity positionSpacecraft(@PathVariable String nameSpacecraft) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(spacecraftService.getSpacecraftPosition(nameSpacecraft));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("It was not possible to find your spacecraft.");
        }
    }
}
