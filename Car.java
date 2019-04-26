/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Random;

/**
 *
 * @author aluno
 */

public class Car {
    private int x1, x2, y1, y2, min=1, max=8, orientation, progress, x0, y0;
    private long startTime, currentTime;
    //private double vel ;
    Random r;
    
    public Car(){
        r = new Random();
        startTime = System.currentTimeMillis();
        orientation=r.nextInt((max - min)+1)+min;
        switch(orientation){
            case 1:
            case 2:{
                x1=x2=23;
                y1=y2=42;
                break;
            }
            case 3:
            case 4:{
                x1=x2=42;
                y1=y2=18;
                break;
            }
            case 5:
            case 6:{
                x1=x2=18;
                y1=y2=0;
                break;
           }
            case 7:
            case 8:{
                x1=x2=0;
                y1=y2=23;
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
        if(currentTime - startTime<=300.0){
            move();
            startTime = currentTime;
        }
    }
    
    public void move(){
        if(progress<=20){
           switch(orientation){
           case 1:
           case 2:{
               if(progress>1) y0=y1;
               y1=y2--;
               break;
           }
           case 3:
           case 4:{
               if(progress>1) x0=x1;
               x1=x2--;
               break;
           }
           case 5:
           case 6:{
               if(progress>1) y0=y1;
                y1=y2++;
                break;
           }
           case 7:
           case 8:{
               if(progress>1) x0=x1;
               x1=x2++;
               break;
          }
        }
        progress++;
        }
        else{
            
        }
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
    
}
