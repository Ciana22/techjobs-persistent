package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
public class Employer extends AbstractEntity {

    @NotBlank(message = "Enter a location.")
    @Size(max = 400, message = "Location must be 400 characters or less.")
    private String location;

    public Employer(String location) {
        this.location = location;
    }
    public Employer () {
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


}
