package com.rocketzki.domain.model;


public class Laptop {
    private String producer;
    private String model;
    private Double price;
    private String processorManufacturer;

    public Laptop(String producer, String model, Double price, String processorManufacturer) {
        this.model = model;
        this.producer = producer;
        this.price = price;
        this.processorManufacturer = processorManufacturer;
    }

    public String getModel() {
        return model;
    }

    public String getProducer() {
        return producer;
    }

    public Double getPrice() {
        return price;
    }

    public String getProcessorManufacturer() {
        return processorManufacturer;
    }
}
