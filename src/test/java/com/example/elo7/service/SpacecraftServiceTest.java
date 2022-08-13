package com.example.elo7.service;

import com.example.elo7.dto.LandSpacecraftsDTO;
import com.example.elo7.dto.SpacecraftDTO;
import com.example.elo7.dto.SpacecraftDetailsDTO;
import com.example.elo7.entity.SpacecraftEntity;
import com.example.elo7.repository.SpacecraftRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class SpacecraftServiceTest {

    @InjectMocks
    SpacecraftService spacecraftService;

    @Mock
    SpacecraftRepository spacecraftRepository;

    private SpacecraftEntity spacecraftEntity;

    @BeforeEach
    public void initialize() {
        MockitoAnnotations.initMocks(this);

//        List<SpacecraftDetailsDTO> spacecraftList = new ArrayList<SpacecraftDetailsDTO>();
//        spacecraftList.add(new SpacecraftDetailsDTO("SondaA", 1, 2, "N"));
//        this.landSpacecrafts = new LandSpacecraftsDTO("Terra", spacecraftList);

        this.spacecraftEntity = new SpacecraftEntity();
        spacecraftEntity.setIdSpaceraft(1);
        spacecraftEntity.setNameSpacecraft("SondaA");
        spacecraftEntity.setPlanetName("Terra");
        spacecraftEntity.setPositionH(1);
        spacecraftEntity.setPositionV(2);
        spacecraftEntity.setPositionFront("N");
    }

    @Test
    public void testGetPositionSpacecraft() {
//        SpacecraftEntity spacecraft = new SpacecraftEntity();
//        spacecraft.setIdSpaceraft(1);
//        spacecraft.setNameSpacecraft("SondaA");
//        spacecraft.setPlanetName("Terra");
//        spacecraft.setPositionH(1);
//        spacecraft.setPositionV(2);
//        spacecraft.setPositionFront("N");

        when(spacecraftRepository.findByNameSpacecraft(anyString())).thenReturn(this.spacecraftEntity);

        SpacecraftDTO spacecraftResult = spacecraftService.getSpacecraftPosition("SondaA");

        assertNotNull(spacecraftResult);
        assertEquals("Terra", spacecraftResult.getPlanetName());
        assertEquals("SondaA", spacecraftResult.getNameSpacecraft());
        assertEquals("N", spacecraftResult.getPositionFront());
        assertEquals(1, spacecraftResult.getPositionH());
        assertEquals(2, spacecraftResult.getPositionV());
    }

    @Test
    public void testLandSpacecrafts() {
        List<SpacecraftDetailsDTO> spacecraftList = new ArrayList<>();
        spacecraftList.add(new SpacecraftDetailsDTO("SondaA", 1, 2, "N"));

        LandSpacecraftsDTO spacecraftsDTO = new LandSpacecraftsDTO("Terra", spacecraftList);

        when(spacecraftRepository.save(any(SpacecraftEntity.class))).thenReturn(this.spacecraftEntity);
        List<SpacecraftDTO> spacecraftResult = spacecraftService.landSpacecrafts(spacecraftsDTO);

        assertNotNull(spacecraftResult);
        assertFalse(spacecraftResult.isEmpty());
        assertEquals("SondaA", spacecraftResult.get(0).getNameSpacecraft());
        assertEquals(1, spacecraftResult.get(0).getPositionH());
        assertEquals(2, spacecraftResult.get(0).getPositionV());
        assertEquals("N", spacecraftResult.get(0).getPositionFront());
    }
}
