package com.katsuburger.webapp.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Location {
    @Id private String name;

    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String zip;

    private String doordashURL;
    private String pickupURL;

    private String phoneNumber;

    private boolean enabled;

    @ManyToMany private List<MenuCategory> menu;

    public void updateLocation(Location location) {
        this.addressLine1 = location.addressLine1;
        this.city = location.addressLine1;
        this.city = location.city;
        this.state = location.state;
        this.doordashURL = location.doordashURL;
        this.pickupURL = location.pickupURL;
        this.phoneNumber = location.phoneNumber;
    }

    @Override
    public String toString() {
        return name;
    }
}
