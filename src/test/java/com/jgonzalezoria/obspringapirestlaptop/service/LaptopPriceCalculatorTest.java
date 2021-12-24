package com.jgonzalezoria.obspringapirestlaptop.service;

import com.jgonzalezoria.obspringapirestlaptop.entities.Laptop;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LaptopPriceCalculatorTest {

    @Test
    void calculatePrice() {

        // configuración de la prueba
        Laptop laptop = new Laptop(1L, "HP", "i7", 32, 1000, true, 1200);
        LaptopPriceCalculator calculator = new LaptopPriceCalculator();

        // se ejecuta el comportamiento a testear
        double price = calculator.calculatePrice(laptop);
        System.out.println(price);

        // comprobación aserciones
        assertTrue(price > 0);
        assertEquals(price, 1530);
    }

}