package com.timbuchalka;

public class Point {
    private int x;
    private int y;

    public Point() {
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double distance(){
        return Math.sqrt(Math.pow((double)this.x,2) + Math.pow((double)this.y,2));
    }
    public double distance(int x, int y){
        return Math.sqrt(Math.pow((double)(x-this.x), 2) + Math.pow((double)(y-this.y), 2));
    }
    public double distance(Point point){
        return Math.sqrt(Math.pow(point.getX()-this.x, 2) + Math.pow(point.getY()-this.y, 2));

    }
}
