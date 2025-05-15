package com.app;

import com.engine.DieselEngine;
import com.engine.Engine;
import com.engine.PetrolEngine;
import com.vehicle.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.*")
public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome to Spring Core Annotation based configuration !\n");

        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        // When using Java Configuration file, we provided configuration class as below :
        // ApplicationContext context = new ClassPathXmlApplicationContext(BeanConfiguration.class)

        //Since no bean set up manually, we have no configuration class.
        //Hence put @ComponentScan on main class

        //@Scope("prototype") annotation :
        // PetrolEngine : new bean every time get from context
        // DieselEngine : singleton bean --> same object every time get from context

        // Access by type -> class type Car
        // Getting bean and setting values
        System.out.println("Access bean by type :");
        Car car = context.getBean(Car.class);
        car.setCompany("TATA");
        car.setModel("Harrier");
        PetrolEngine petrolEngine = context.getBean("petrolEngine", PetrolEngine.class);
        petrolEngine.setFuel("Petrol");
        petrolEngine.setWeight(600);
        car.setEngine(petrolEngine);
        car.carStart();

        // Access car bean by custom name
        // Getting bean and setting values
        System.out.println("\nAccess bean by custom name :");
        Car car2 = (Car) context.getBean("myCarBean");
        car2.setCompany("Mahindra");
        car2.setModel("Scorpio");
        DieselEngine dieselEngine = context.getBean("dieselEngine", DieselEngine.class);
        dieselEngine.setFuel("Diesel");
        dieselEngine.setWeight(900);
        car2.setEngine(dieselEngine);
        car2.carStart();

        // PetrolEngine class is marked with @Scope("prototype")
        // So, spring will create new object every time we ask
        // See that are not set, it gives us null or 0 because it is new object
        System.out.println("\nAccess bean by type and name :");
        Engine pengine = context.getBean("petrolEngine", PetrolEngine.class);
        pengine.start();

        // DieselEngine class is not marked with @Scope("prototype")
        // So, spring will create singleton object
        // See that values are not set in new object yet it gives us values because object has value previously assigned
        System.out.println("\nAccess bean by default name :");
        Engine dengine = (Engine) context.getBean("dieselEngine");
        dengine.start();
    }
}