/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication15;

import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Usuario
 */
public class Play extends JPanel implements ActionListener, KeyListener{
    private Timer timer;
    private Ghost ghost1;
    private Pacman pacman;
    private Nivel1 nivel1;
    private int dx,dy,secuencia,x,y,direccion, puntosTotales, noPaint;

    public Play() {
        addKeyListener(new TAdapter());
        setFocusable(true);
        this.timer = new Timer(25,this);
        this.timer.start();
        this.nivel1 = new Nivel1();
        this.ghost1 = new Ghost(20,20,2,5,8); 
         //Movimiento en pantalla de pac-mUN
       this.dx=0;
       this.dy=0;
       //Es para cambiar la direccion de la imagen
       this.direccion=2;
       this.secuencia=0;  
       this.puntosTotales = 0;
       this.noPaint=0;
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        nivel1.paintComponent(g);
        Image pac = loadImage("pac.png");
        Image pac1 = loadImage("pacInv.png");
        g.drawImage(loadImage("Fblue.png"), ghost1.x, ghost1.y, 20, 20, this);
//        System.out.println(ghost1.x + " " + ghost1.y);
//        System.out.println(x + " " + y);
        //El pacman siempre abre y cierra la boca, no solo al presionar la tecla
        //if(){
        //}
        x += dx;
        y += dy;

        //Derecha
        if (direccion == 0) {
            g.drawImage(pac, 0 + x, 0 + y, 20 + x, 20 + y, 280, 0 + (secuencia * 40), 320, 40 + (secuencia * 40), this);
        }
        //Izquierda
        if (direccion == 1) {
            g.drawImage(pac, 0 + x, 0 + y, 20 + x, 20 + y, 320, 40 + (secuencia * 40), 280, 0 + (secuencia * 40), this);
        }
        //Abajo                                                           
        if (direccion == 2) {
            g.drawImage(pac1, 0 + x, 0 + y, 20 + x, 20 + y, 0 + (secuencia * 40), 280, 40 + (secuencia * 40), 320, this);
        }
        
        //Arriba
        if (direccion == 3) {
            g.drawImage(pac1, 0 + x, 0 + y, 20 + x, 20 + y, 40 + (secuencia * 40), 320, 0 + (secuencia * 40), 280, this);
        }        
    }

    public Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }
    public void checkCollision(){
        int i=5, j=5;
        //up
                if(this.ghost1.getDirection()==0){
                    if(this.ghost1.x % 20 == 0 && this.ghost1.y % 20 == 0){
                        if(this.nivel1.getLevel1()[(this.ghost1.y/20)-1][this.ghost1.x/20] !=0){
                            
                            try {
                                Thread.sleep(25);
                                
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Play.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            if(this.nivel1.getLevel1()[(this.ghost1.y/20)-1][(this.ghost1.x/20)+1] !=0){
                                i=2;
                            }if(this.nivel1.getLevel1()[(this.ghost1.y/20)-1][(this.ghost1.x/20)-1] !=0){
                                i=3;
                            }
                            this.ghost1.changeDirection(i);
                        }
                    }
                }
        //down
                if(this.ghost1.getDirection()==1){
                    if(this.ghost1.x % 20 == 0 && this.ghost1.y % 20 == 0){
                        if(this.nivel1.getLevel1()[(this.ghost1.y/20)+1][this.ghost1.x/20] != 0){
                            
                            try {
                                Thread.sleep(25);
                                
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Play.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            if(this.nivel1.getLevel1()[(this.ghost1.y/20)+1][(this.ghost1.x/20)+1] !=0){
                                i=2;
                            }if(this.nivel1.getLevel1()[(this.ghost1.y/20)+1][(this.ghost1.x/20)-1] !=0){
                                i=3;
                            }
                            this.ghost1.changeDirection(i);
                        }
                    }
                }
        //right
                if(this.ghost1.getDirection()==2){
                    if(this.ghost1.x % 20 == 0 && this.ghost1.y % 20 == 0){
                        if(this.nivel1.getLevel1()[this.ghost1.y/20][(this.ghost1.x/20)+1] != 0){
                            
                            try {
                                Thread.sleep(25);
                                
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Play.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            if(this.nivel1.getLevel1()[(this.ghost1.y/20)-1][(this.ghost1.x/20)+1] !=0){
                                i=0;
                            }if(this.nivel1.getLevel1()[(this.ghost1.y/20)+1][(this.ghost1.x/20)+1] !=0){
                                i=1;
                            }
                            this.ghost1.changeDirection(i);
                        }
                    }
                }
        //left
            if(this.ghost1.getDirection()==3){
                if(this.ghost1.x % 20 == 0 && this.ghost1.y % 20 == 0){
                    if(this.nivel1.getLevel1()[this.ghost1.y/20][(this.ghost1.x/20)-1] != 0){
                        
                        try {
                            Thread.sleep(25);
                        
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Play.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        if(this.nivel1.getLevel1()[(this.ghost1.y/20)-1][(this.ghost1.x/20)-1] !=0){
                                i=0;
                            }if(this.nivel1.getLevel1()[(this.ghost1.y/20)+1][(this.ghost1.x/20)-1] !=0){
                                i=1;
                            }
                    this.ghost1.changeDirection(i);
                }
            }
        }    
//            System.out.println(nivel1.getLevel1()[this.y/20][this.x/20]);
//--------- Colision con los puntos, llamado al metodo para aumentar puntaje y cambio del mapa para que desaparezcan los puntos
            if (this.nivel1.getLevel1()[this.y /20][this.x / 20] == 9) {
//                            System.out.println("sisisis");

                try {
                            Thread.sleep(25);
                        
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Play.class.getName()).log(Level.SEVERE, null, ex);
                    }
                int[][] aux = this.nivel1.getLevel1();
                aux[this.y / 20][this.x / 20] = 0;
                puntaje();                
                nivel1.setMatriz(aux);
            }
       
    }
    public void puntaje(){
        puntosTotales += 1;
        System.out.println(puntosTotales);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        ghost1.move();
        checkCollision();
        noPaint++;
        if(noPaint==3){
        secuencia++;
        noPaint=0;
        if (this.secuencia == 4) {
            this.secuencia = 0;
        }
        }
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public class TAdapter extends KeyAdapter {
        
        @Override
        public void keyReleased(KeyEvent e){
           
        }
        
        @Override
        public void keyPressed(KeyEvent e){
            
            int key = e.getKeyCode();  
            
            
            //Los dy y dx en 0 es porque no puede hacer desplazamientos en diagonal 
            //Solo debe estar un delta activo
            
             if(key==KeyEvent.VK_RIGHT){
                dx=2;
                dy=0;
                direccion=0;
            }
            
            if(key== KeyEvent.VK_LEFT){
                dx=-2;                
                dy=0;
                direccion=1;
            }

            if(key==KeyEvent.VK_DOWN){
                dy=2;
                dx=0;
                direccion=2;
            }
    
            if(key== KeyEvent.VK_UP){
                dy=-2;
                dx=0;
                direccion=3;
            }
           
            
            
     }
        
}
    
}
