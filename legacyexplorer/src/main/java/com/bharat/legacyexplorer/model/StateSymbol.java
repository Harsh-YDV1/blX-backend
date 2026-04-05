package com.bharat.legacyexplorer.model;

import jakarta.persistence.Entity;

import jakarta.persistence.Table;

@Entity
@Table(name = "state_symbols")
public class StateSymbol extends BaseNamedEntity {

    private String image;

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
}
