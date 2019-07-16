package com.timbuchalka;

public class Pc {
    private Case thecase;
    private Monitor monitor;
    private Motherboard motherboard;

    public Pc(Case thecase, Monitor monitor, Motherboard motherboard) {
        this.thecase = thecase;
        this.monitor = monitor;
        this.motherboard = motherboard;
    }

    public void powerUp(){
        thecase.pressPowerButton();;
        drawLogo();
    }
    private void drawLogo(){
        //fancy graphics
        monitor.draPixelAt(122,50,"yellow");
    }

    public Case getThecase() {
        return thecase;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public Motherboard getMotherboard() {
        return motherboard;
    }
}
