package com.katsuburger.webapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MenuItem {
    @Id @GeneratedValue private Long id;
    private String nameOverride;
    private float price;
    private int index;
    boolean visible;
    @ManyToOne private Item item;

    @Override
    public String toString() {
        return item.getName() + ": " + item.getDescription() + " - $" + price;
    }
}
