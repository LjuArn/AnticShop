package com.example.anticshop.domain.bindingModel;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class OrderBindingModel {


    @Size(min = 5, message = " Address length must be min 5  characters")
    private String address;

    @Size(min = 11, max = 20)
    private String gsm;

    @Future
    private LocalDateTime deliveredOn;



    public OrderBindingModel() {
    }


    public String getAddress() {
        return address;
    }

    public OrderBindingModel setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getGsm() {
        return gsm;
    }

    public OrderBindingModel setGsm(String gsm) {
        this.gsm = gsm;
        return this;
    }

    public LocalDateTime getDeliveredOn() {
        return deliveredOn;
    }

    public OrderBindingModel setDeliveredOn(LocalDateTime deliveredOn) {
        this.deliveredOn = deliveredOn;
        return this;
    }
}
