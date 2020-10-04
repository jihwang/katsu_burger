package com.katsuburger.webapp.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Tag {
    @Id private String name;
    private String description;
    // private Binary icon;
}
