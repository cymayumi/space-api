package com.example.elo7.service;

import com.example.elo7.dto.LandSpacecraftsDTO;
import com.example.elo7.dto.MoveSpacecraftDTO;
import com.example.elo7.dto.SpacecraftDetailsDTO;
import com.example.elo7.entity.SpacecraftEntity;
import com.example.elo7.repository.SpacecraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpacecraftService {

    @Autowired
    private SpacecraftRepository spacecraftRepository;

    public String landSpacecrafts(LandSpacecraftsDTO landSpacecraftsDTO) {

        for(SpacecraftDetailsDTO item : landSpacecraftsDTO.getSpacecraftList()) {
            SpacecraftEntity spacecraft = new SpacecraftEntity();
            spacecraft.setNameSpacecraft(item.getNameSpacecraft());
            spacecraft.setPlanetName(landSpacecraftsDTO.getPlanet());
            spacecraft.setPositionFront(item.getPositionFront());
            spacecraft.setPositionH(item.getPositionH());
            spacecraft.setPositionV(item.getPositionV());

            spacecraftRepository.save(spacecraft);
        }

        return "";
    }

    public String moveSpacecraft(MoveSpacecraftDTO moveSpacecraftDTO) {

        SpacecraftEntity spacecraft = spacecraftRepository.getOne(moveSpacecraftDTO.getNameSpacecraft());

        if(moveSpacecraftDTO.getMove().equals("M")) {
            spacecraft.setPositionH(spacecraft.getPositionH() + 1);
        } else if(moveSpacecraftDTO.getMove().equals("L")) {
            if(spacecraft.getPositionFront().equals("N")) {
                spacecraft.setPositionFront("W");
            } else if(spacecraft.getPositionFront().equals("E")) {
                spacecraft.setPositionFront("N");
            } else if(spacecraft.getPositionFront().equals("S")) {
                spacecraft.setPositionFront("E");
            } else {
                spacecraft.setPositionFront("S");
            }
        } else {
            if(spacecraft.getPositionFront().equals("N")) {
                spacecraft.setPositionFront("E");
            } else if(spacecraft.getPositionFront().equals("E")) {
                spacecraft.setPositionFront("S");
            } else if(spacecraft.getPositionFront().equals("S")) {
                spacecraft.setPositionFront("W");
            } else {
                spacecraft.setPositionFront("N");
            }
        }

        spacecraftRepository.save(spacecraft);

        return "";
    }
}
