package com.example.elo7.controller;

import com.example.elo7.dto.LandSpacecraftsDTO;
import com.example.elo7.dto.MoveSpacecraftDTO;
import com.example.elo7.service.SpacecraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpacecraftController {

    @Autowired
    private SpacecraftService spacecraftService;

    @PostMapping("/land")
    public ResponseEntity landSpacecraft(@RequestBody LandSpacecraftsDTO landSpacecraftsDTO) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(spacecraftService.landSpacecrafts(landSpacecraftsDTO));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("It was not possible to land your spacecrafts.");
        }
    }

    @PutMapping("/move")
    public ResponseEntity moveSpacecraft(@RequestBody MoveSpacecraftDTO moveSpacecraftDTO) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(spacecraftService.moveSpacecraft(moveSpacecraftDTO));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("It was not possible to land your spacecrafts.");
        }
    }
}
