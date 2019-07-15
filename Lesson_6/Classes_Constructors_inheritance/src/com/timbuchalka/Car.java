package com.timbuchalka;

public class Car {
    /*
    * Private-> nao acessivel fora da class
    * */
    private int doors;
    private int wheels;
    private String model;
    private String engine;
    private String colour;

    /*Ao fazer o NEW chama isto, para inicializar coisas
    * Nao chamar metodos, como o SET
    * */
    public Car(){
        this(4,4,"Default mercedes", "Default v8", "Default azul");
        System.out.println("Empty constructor called");
    }
    public Car(String model){
        this(4,4,model, "Default v8", "Default azul");
        System.out.println("Empty constructor called");
    }
    public Car( int doors, int wheels, String model, String engine, String colour){
        this.model = model;
        this.doors=doors;
        this.wheels=wheels;
        System.out.println("Constructor with\n"+model+"\n"+doors+"\n"+wheels);
    }
    public void setModel(String model){
        String validModel = model.toLowerCase();
        if(validModel.equals("carrera"))
            this.model = model;//this.model -> vai buscar a variavel que está na classe
        else
            this.model = "Unknown";
    }
    public String getModel(){
        return this.model;
    }
}
