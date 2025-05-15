package com.vehicle;

import com.engine.Engine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("myCarBean")
public class Car {
    private String company;
    private String model;
    private Engine engine;

    public Car() {
    }

    public Car(String company, String model, Engine engine) {
        this.company = company;
        this.model = model;
        this.engine = engine;
    }

    @Autowired
    @Qualifier("dieselEngine")
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Engine getEngine() {
        return engine;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public void carStart(){
        engine.start();
        System.out.println("Car started with \n" +
                "Company : "+this.company+"\n" +
                "Model : "+this.model);
    }
}

