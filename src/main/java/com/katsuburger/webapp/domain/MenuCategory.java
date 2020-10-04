package com.katsuburger.webapp.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class MenuCategory {
    @Id @GeneratedValue private Integer id;
    public String name;
    private String description;
    private int index;
    @OneToMany private List<MenuItem> menuItems;
}
