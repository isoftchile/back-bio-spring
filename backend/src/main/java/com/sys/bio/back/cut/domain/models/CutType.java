package com.sys.bio.back.cut.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sys.bio.back.models.cutting.CutBox;

import lombok.*;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity @Table(name = "cutTypes")
public class CutType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cutTypeId;

    private String name;
    private Double factor;
    private String description;
    private Boolean enabled;

    @OneToMany(mappedBy = "cutType", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<CutBox> cutBoxes = new LinkedHashSet<>();

    public CutType(String name) {
        this.name = name;
    }


}
