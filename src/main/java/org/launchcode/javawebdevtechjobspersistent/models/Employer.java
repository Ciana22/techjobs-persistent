package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Employer extends AbstractEntity {

    @NotBlank(message = "Enter a location.")
    @Size(max = 400, message = "Location must be 400 characters or less.")
    private String location;

    @OneToMany(mappedBy= "employer")

    private List<Job> jobs = new ArrayList<>();

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
