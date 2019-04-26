/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Timer;

/**
 *
 * @author aluno
 */

public class TrafLight {
    Timer timer;
    private int statusH=4, statusV=5, aux=1;
    private long startTime;
    
    public TrafLight(){
        startTime = System.currentTimeMillis();
    }
    
    public void verify(){
        
        if(System.currentTimeMillis()-startTime>=8000.0){
            if(aux==1){
                setStatusH(5);
                setStatusV(4);
                aux=0;
            }
            else{
                setStatusH(4);
                setStatusV(5);
                aux=1;
            }
            startTime = System.currentTimeMillis();
        }
    }
    
    public int getStatusH() {
        verify();
        return statusH;
    }

    public void setStatusH(int statusH) {
        this.statusH = statusH;
    }

    public int getStatusV() {
        verify();
        return statusV;
    }

    public void setStatusV(int statusV) {
        this.statusV = statusV;
    }
    
    
}
