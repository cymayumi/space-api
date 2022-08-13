package com.example.elo7.service;

import com.example.elo7.dto.LandSpacecraftsDTO;
import com.example.elo7.dto.MoveSpacecraftDTO;
import com.example.elo7.dto.SpacecraftDTO;
import com.example.elo7.dto.SpacecraftDetailsDTO;
import com.example.elo7.entity.SpacecraftEntity;
import com.example.elo7.exceptionHandler.IncorrectParameterException;
import com.example.elo7.repository.SpacecraftRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpacecraftService {

    @Autowired
    private SpacecraftRepository spacecraftRepository;

    public SpacecraftDTO getSpacecraftPosition(String nameSpacecraft) {
        SpacecraftDTO spacecraft = new SpacecraftDTO();
        SpacecraftEntity entity = spacecraftRepository.findByNameSpacecraft(nameSpacecraft);
        BeanUtils.copyProperties(entity, spacecraft);
        return spacecraft;
    }

    public List<SpacecraftDTO> landSpacecrafts(LandSpacecraftsDTO landSpacecraftsDTO) {

        List<SpacecraftDTO> listSpacecraftDTO = new ArrayList<>();
        for(SpacecraftDetailsDTO spacecraft : landSpacecraftsDTO.getSpacecraftList()) {

            SpacecraftEntity spacecraftEntity = new SpacecraftEntity();

            spacecraftEntity.setNameSpacecraft(spacecraft.getNameSpacecraft());
            spacecraftEntity.setPlanetName(landSpacecraftsDTO.getPlanet());
            spacecraftEntity.setPositionFront(spacecraft.getPositionFront());
            spacecraftEntity.setPositionH(spacecraft.getPositionH());
            spacecraftEntity.setPositionV(spacecraft.getPositionV());

            spacecraftRepository.save(spacecraftEntity);

            SpacecraftDTO spacecraftDTO = new SpacecraftDTO();
            BeanUtils.copyProperties(spacecraftEntity, spacecraftDTO);
            listSpacecraftDTO.add(spacecraftDTO);
        }

        return listSpacecraftDTO;
    }

    public SpacecraftEntity moveSpacecraft(MoveSpacecraftDTO moveSpacecraftDTO) throws IncorrectParameterException {
        String[] moves = moveSpacecraftDTO.getMove().split("");

        for(String move : moves) {
            SpacecraftEntity spacecraft = spacecraftRepository.findByNameSpacecraft(moveSpacecraftDTO.getNameSpacecraft());

            if (move.equals("M")) {
                switch (spacecraft.getPositionFront()) {
                    case "N":
                        spacecraft.setPositionV(spacecraft.getPositionV() + 1);
                        break;
                    case "S":
                        spacecraft.setPositionV(spacecraft.getPositionV() - 1);
                        break;
                    case "E":
                        spacecraft.setPositionH(spacecraft.getPositionH() + 1);
                        break;
                    default:
                        spacecraft.setPositionH(spacecraft.getPositionH() - 1);
                        break;
                }
            } else if (move.equals("L")) {
                switch (spacecraft.getPositionFront()) {
                    case "N":
                        spacecraft.setPositionFront("W");
                        break;
                    case "E":
                        spacecraft.setPositionFront("N");
                        break;
                    case "S":
                        spacecraft.setPositionFront("E");
                        break;
                    default:
                        spacecraft.setPositionFront("S");
                        break;
                }
            } else {
                switch (spacecraft.getPositionFront()) {
                    case "N":
                        spacecraft.setPositionFront("E");
                        break;
                    case "E":
                        spacecraft.setPositionFront("S");
                        break;
                    case "S":
                        spacecraft.setPositionFront("W");
                        break;
                    default:
                        spacecraft.setPositionFront("N");
                        break;
                }
            }

            if(spacecraft.getPositionH() < 0 || spacecraft.getPositionH() >= 6 ||
                    spacecraft.getPositionV() < 0 || spacecraft.getPositionV() >= 6) {
                throw new IncorrectParameterException("Your spacecraft can't move in this direction, out of planet bounds.");
            } else {
                spacecraftRepository.save(spacecraft);
            }
        }

        return spacecraftRepository.findByNameSpacecraft(moveSpacecraftDTO.getNameSpacecraft());
    }
}
