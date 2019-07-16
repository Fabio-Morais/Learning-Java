package com.timbuchalka;

public class Monitor {
    private String model;
    private String manufacturer;
    private int size;
    private Resolution nativeResultoion;//COMPOSITION

    public Monitor(String model, String manufacturer, int size, Resolution nativeResultoion) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.size = size;
        this.nativeResultoion = nativeResultoion;
    }
    public void draPixelAt(int x, int y, String color){
        System.out.println("Drawing at "+x+","+y+" in color "+color);
    }
}
