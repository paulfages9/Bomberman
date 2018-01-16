package Jeu;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Personnage extends JPanel {
    private int[] position;

    private Graphics g;
    private boolean pers = true;
    private Image image  = Toolkit.getDefaultToolkit().getImage("hero.png");



    public Personnage(){
        position = new int[2];
        this.position[0] = 0; // X
        this.position[1] = 0; // Y

    }


    public void setImage(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return image;
    }

    public void setPosition(int x, int y){
        this.position[0] = x;
        this.position[1] = y;
    }

    public int[] getPosition(){
        return this.position;
    }

    public int getX(){
        return this.position[0];
    }

    public int getY(){
        return this.position[1];
    }

   public void setPers(final boolean pers) {
       this.pers = pers;
   }


}