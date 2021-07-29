package org.launchcode.javawebdevtechjobspersistent.models;

import org.dom4j.tree.AbstractEntity;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Skill extends AbstractEntity {

    @NotBlank(message = "Enter a description.")
    @Size(max = 300)
    private String description;

    public Skill(String description) {
    this.description = description;
    }
    public Skill () {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}


