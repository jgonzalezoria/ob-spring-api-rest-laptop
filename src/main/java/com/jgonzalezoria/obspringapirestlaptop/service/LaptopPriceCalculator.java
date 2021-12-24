package com.jgonzalezoria.obspringapirestlaptop.service;

import com.jgonzalezoria.obspringapirestlaptop.entities.Laptop;

public class LaptopPriceCalculator {

    public double calculatePrice(Laptop laptop){
        double price = laptop.getPrice();
        price += priceProcessor(laptop.getProcessor());
        price += priceRAM(laptop.getRamGB());
        return price;
    }

    public double priceProcessor(String processor){
        double price = 0;
        if(processor.equalsIgnoreCase("i3")){
            price += 100;
        }
        else if(processor.equalsIgnoreCase("i5")){
            price += 200;
        }
        else if(processor.equalsIgnoreCase("i7")){
            price += 300;
        }
        else if(processor.equalsIgnoreCase("i9")){
            price += 400;
        }
        return price;
    }

    public double priceRAM(Integer ramGB){
        double price = 0;
        if(ramGB == 8){
            price += 10;
        }
        else if(ramGB == 16){
            price += 20;
        }
        else if(ramGB == 32){
            price += 30;
        }
        return price;
    }
}
