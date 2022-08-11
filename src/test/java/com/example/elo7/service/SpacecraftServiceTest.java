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
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class SpacecraftServiceTest {

    @InjectMocks
    SpacecraftService spacecraftService;

    @Mock
    SpacecraftRepository spacecraftRepository;

    private LandSpacecraftsDTO landSpacecrafts;

    @BeforeEach
    public void initialize() {
        MockitoAnnotations.initMocks(this);

        List<SpacecraftDetailsDTO> spacecraftList = new ArrayList<SpacecraftDetailsDTO>();
        spacecraftList.add(new SpacecraftDetailsDTO("SondaA", 1, 2, "N"));
        this.landSpacecrafts = new LandSpacecraftsDTO("Terra", spacecraftList);
    }

    @Test
    public void testGetPositionSpacecraft() {
        SpacecraftEntity spacecraft = new SpacecraftEntity();
        spacecraft.setIdSpaceraft(1);
        spacecraft.setNameSpacecraft("SondaA");
        spacecraft.setPlanetName("Terra");
        spacecraft.setPositionH(1);
        spacecraft.setPositionV(2);
        spacecraft.setPositionFront("N");

        when(spacecraftRepository.findByNameSpacecraft(anyString())).thenReturn(spacecraft);

        SpacecraftDTO spacecraftResult = spacecraftService.getSpacecraftPosition("SondaA");

        assertNotNull(spacecraftResult);
        assertEquals("Terra", spacecraftResult.getPlanetName());
        assertEquals("SondaA", spacecraftResult.getNameSpacecraft());
        assertEquals("N", spacecraftResult.getPositionFront());
        assertEquals(1, spacecraftResult.getPositionH());
        assertEquals(2, spacecraftResult.getPositionV());
    }
}
