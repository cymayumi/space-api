package com.example.elo7.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_spacecraft")
public class SpacecraftEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_spaceraft")
    private Integer idSpaceraft;

    @Column(name = "nm_spaceraft")
    private String nameSpacecraft;

    @Column(name = "position_h")
    private Integer positionH;

    @Column(name = "position_v")
    private Integer positionV;

    @Column(name = "position_front")
    private String positionFront;

    @Column(name = "nm_planet")
    private String planetName;

}
