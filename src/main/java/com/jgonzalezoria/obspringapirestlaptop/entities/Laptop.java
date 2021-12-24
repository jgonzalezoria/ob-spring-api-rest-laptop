package com.jgonzalezoria.obspringapirestlaptop.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "laptops")
@ApiModel("Entidad portatil para representar los portatiles del mercado")
public class Laptop {

    // atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("Clave ficticia autoincremental tipo Long")
    private Long id;
    private String manufacturer;
    private String processor;
    @ApiModelProperty("Memoria RAM en GB")
    private Integer ramGB;
    @ApiModelProperty("Memoria del disco duro en GB")
    private Integer hardDriveGB;
    private Boolean isSSD;
    private double price;

    // constructores

    public Laptop() {
    }

    public Laptop(Long id, String manufacturer, String processor, Integer ramGB, Integer hardDriveGB, Boolean isSSD, double price) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.processor = processor;
        this.ramGB = ramGB;
        this.hardDriveGB = hardDriveGB;
        this.isSSD = isSSD;
        this.price = price;
    }

    // getter y setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public Integer getRamGB() {
        return ramGB;
    }

    public void setRamGB(Integer ramGB) {
        this.ramGB = ramGB;
    }

    public Integer getHardDriveGB() {
        return hardDriveGB;
    }

    public void setHardDriveGB(Integer hardDriveGB) {
        this.hardDriveGB = hardDriveGB;
    }

    public Boolean getSSD() {
        return isSSD;
    }

    public void setSSD(Boolean SSD) {
        isSSD = SSD;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // toString


    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", manufacturer='" + manufacturer + '\'' +
                ", processor='" + processor + '\'' +
                ", ramGB=" + ramGB +
                ", hardDriveGB=" + hardDriveGB +
                ", isSSD=" + isSSD +
                ", price=" + price +
                '}';
    }
}
