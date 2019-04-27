/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.TimerTask;
import java.util.Timer;
import javax.swing.*;

/**
 *
 * @author Castilin
 */
public class Interface{
    JFrame f;
    Graphics gg;
    Color[] cs = new Color[10];
    Logic l;
    Timer timer;
    Panel p;
    
    public Interface(){
        l = new Logic();
        p=new Panel();
        cs[0] = new Color(194,200,151);
        cs[1] = new Color(76,72,105); 
        cs[2] = new Color(150,194,198);
        cs[3] = new Color(243,219,133);
        cs[4] = new Color(132,253,56);
        cs[5] = new Color(255,0,0);
        cs[6] = new Color(48,45,45);
        cs[7] = new Color(54,209,46);
        cs[8] = new Color(201,201,201);
        cs[9] = new Color(244,244,40);
        f = new JFrame();
        f.add(p);
        f.setSize(448,477);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Tráfego: 0");
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run()
            {
                p.repaint();
                f.setTitle("Tráfego: "+l.update());
            }
        };
        timer.schedule( task, 0L, 100L );
    }
    
    class Panel extends JPanel {
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            for(int i=0;i<430;i+=10){
                for(int j=0;j<430;j+=10){
                    Draw(i, j, g);
                }
            }
        }
        public void Draw(int y, int x, Graphics g){
            g.setColor(cs[l.grid[x/10][y/10]]);
            g.fillRect(x, y, 10, 10);
            //repaint();
        }
    }
    
    
}
