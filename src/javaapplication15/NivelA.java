/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication15;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public abstract class NivelA extends JPanel{
    protected int[][] matriz;
    public NivelA(){     
    }
    protected abstract Image loadImage(String imageName);

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }
    
}
