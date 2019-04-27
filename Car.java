/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Random;

/**
 *
 * @author Castilin
 */

public class Car {
    private int x1, x2, y1, y2, orientation, progress, color, vel;
    private long startTime, currentTime;
    private static int trafego=0;
    Random r;
    
    public Car(){
        r = new Random();
        startTime = System.currentTimeMillis();
        orientation=r.nextInt(8)+1;
        color = r.nextInt(4)+6;
        vel = r.nextInt(76)+50;
        trafego++;
        switch(orientation){
            case 1:
            case 2:{
                x1=23;x2=24;
                y1=y2=42;
                break;
            }
            case 3:
            case 4:{
                x1=x2=42;
                y1=18;y2=19;
                break;
            }
            case 5:
            case 6:{
                x1=18;x2=19;
                y1=y2=0;
                break;
           }
            case 7:
            case 8:{
                x1=x2=0;
                y1=23;y2=24;
                break;
           }
        }
        progress=1;
    }
    
    public boolean turn(){
        switch(orientation){
            case 2:
            case 4:
            case 6:
            case 8: return(true);
        }
        return(false);
    }
    
    public void waitTheRightTime(){
        currentTime = System.currentTimeMillis();
        if(currentTime - startTime>=vel){
            move();
        }
    }
    
    public void move(){
        if(progress<=21){
           switch(orientation){
                case 1:
                case 2:{
                    y1=y2--;
                    break;
                }
                case 3:
                case 4:{
                    x1=x2--;
                    break;
                }
                case 5:
                case 6:{
                     y1=y2++;
                     break;
                }
                case 7:
                case 8:{
                    x1=x2++;
                    break;
                }
           }
        }
        else{
            switch(orientation){
                case 4:
                case 1:{
                    y1=y2--;
                    break;
                }
                case 6:
                case 3:{
                    x1=x2--;
                    break;
                }
                case 8:
                case 5:{
                     y1=y2++;
                     break;
                }
                case 2:
                case 7:{
                    x1=x2++;
                    break;
                }
           }
        }
        progress++;
        startTime = currentTime;
    }
    
    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }
    
    public void incProgress(){
        progress++;
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
    
    public static int getTrafego() {
        return trafego;
    }

    public static void setTrafego(int trafego) {
        Car.trafego = trafego;
    }
    
}
