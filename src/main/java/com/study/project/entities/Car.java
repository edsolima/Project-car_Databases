package com.study.project.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Entity
public class Car implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer year;
    private String model;
    private Float price;

    public Car() {
    }

    public Car(Long id, Integer year, String model, Float price) {
        this.id = id;
        this.year = year;
        this.model = model;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id) && Objects.equals(year, car.year) && Objects.equals(model, car.model) && Objects.equals(price, car.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, year, model, price);
    }
}

