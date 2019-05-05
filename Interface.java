/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.ScriptException;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Castilin
 */
public class Interface{
    JFrame f;
    JButton[] num = new JButton[10];
    JButton ce, undo, sum, sub, div, mul, equ;
    JPanel p;
    GridBagConstraints c;
    JTextArea t;
    int aux = 0;
    String text="";
    Logic l;
    
    public Interface(){
        l = new Logic();
        f = new JFrame();
        f.setSize(100,100);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.setTitle("Castilho's Calculator");
        p = new JPanel(new GridBagLayout());
        t = new JTextArea(1,10);
        t.setEditable(false);
        t.setBackground(new Color(195,255,182));t.setForeground(Color.black);
        p.setBackground(new Color(195,255,182));
        t.setFont(new Font("Arial", Font.BOLD, 25));
        c = new GridBagConstraints();
        Event e = new Event();
        for(int i=0;i<num.length;i++) {
                num[i] = new JButton(String.valueOf(i));
                num[i].addActionListener(e);
        }
        ce = new JButton("C");undo = new JButton("«");sum = new JButton("+");sub = new JButton("-");div = new JButton("/");mul = new JButton("*");equ = new JButton("=");
        ce.addActionListener(e);undo.addActionListener(e);sum.addActionListener(e);sub.addActionListener(e);div.addActionListener(e);mul.addActionListener(e);equ.addActionListener(e);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx=10;
        c.ipady=10;
        c.gridy=0;
        c.gridx=0;
        c.gridwidth=4;
        p.add(t, c);
        c.ipadx=50;
        c.ipady=50;
        c.gridwidth=1;
        c.gridx=0;
        c.gridy=1;
        p.add(ce,c);
        c.gridx=1;
        c.gridwidth=2;
        p.add(undo, c);
        c.gridx=3;
        c.gridwidth=1;
        p.add(div, c);
        c.gridy=2;
        c.gridx=0;
        p.add(num[7], c);
        c.gridx=1;
        p.add(num[8], c);
        c.gridx=2;
        p.add(num[9], c);
        c.gridx=3;
        p.add(mul, c);
        c.gridy=3;
        c.gridx=0;
        p.add(num[4], c);
        c.gridx=1;
        p.add(num[5], c);
        c.gridx=2;
        p.add(num[6], c);
        c.gridx=3;
        p.add(sub, c);
        c.gridy=4;
        c.gridx=0;
        p.add(num[1], c);
        c.gridx=1;
        p.add(num[2], c);
        c.gridx=2;
        p.add(num[3], c);
        c.gridx=3;
        p.add(sum, c);
        c.gridy=5;
        c.gridx=1;
        p.add(num[0], c);
        c.gridx=2;
        c.gridwidth=2;
        p.add(equ, c);
        f.add(p);
        f.pack();
    }
    
    class Event implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getActionCommand()=="C"){
                t.setText(null);
                text="";
                aux=0;
            }
            else if(e.getActionCommand()=="="){
                try {
                    text = l.resolve(text);
                } catch (ScriptException ex) {
                    Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
                }
                t.setText(text);
            }
            else if(e.getActionCommand()=="«"){
                text = backspace(text);
                t.setText(text);
            }
            else if(e.getActionCommand()=="+"||e.getActionCommand()=="-"||e.getActionCommand()=="/"||e.getActionCommand()=="*"){
                if(aux==2){
                    text = backspace(text);
                    text+=e.getActionCommand();
                    t.setText(text);
                }
                else if(aux!=0){
                    text+=" "+e.getActionCommand();
                    t.setText(text);
                }
                aux=2;
            }
            else if(Integer.parseInt(e.getActionCommand())>=0&&Integer.parseInt(e.getActionCommand())<=9){
                if(aux!=2){
                    text +=e.getActionCommand();
                    t.setText(text);
                }
                else{
                    text += " "+e.getActionCommand();
                    t.setText(text);
                }
                aux=1;
            }
            
        }
        public String backspace (String str){
                return str.substring(0,str.length()-1);
           }
    }
        
}
