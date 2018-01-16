//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package Jeu;

<<<<<<< HEAD
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
=======
import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.util.Map;

import javax.swing.*;
>>>>>>> 1af554aa3ed83595257e9270d170a3d59d5cafa3

public class Graph extends JPanel implements KeyListener {
    private Case map;
    private Personnage personnage;
    private int posX;
    private int posY;
    private boolean possedeDisque = true;
    private Image image;
    private int pX;
    private int pY;

    public Graph(Case map, Personnage personnage) {
        this.map = map;
        this.pX = 80;
        this.pY = 80;
<<<<<<< HEAD
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(this);
    }

    public boolean isFocusTraversable() {
        return true;
=======
        //setBackground(new Color(1.0f,1.0f,1.0f,0.5f));
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        addKeyListener(this);

        this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "left");
>>>>>>> 1af554aa3ed83595257e9270d170a3d59d5cafa3
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;

        for(int index = 0; index < this.map.getCaseWidthInTiles() * this.map.getCaseHeightInTiles(); this.posY = 0) {
            for(int i = 0; i < this.map.getCaseWidthInTiles(); ++i) {
                for(int j = 0; j < this.map.getCaseHeightInTiles(); ++j) {
                    g2d.drawImage(this.map.getTileImage(index), this.posX, this.posY, this);
                    this.posX += this.map.getTileWidth();
                    ++index;
                }

                this.posX = 0;
                this.posY += this.map.getTileHeight();
            }
        }

        Graphics2D g2 = (Graphics2D)g;
        this.image = Toolkit.getDefaultToolkit().getImage("hero.png");
        g2.drawImage(this.image, this.pX, this.pY, this);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    public Case getCase() {
        return this.map;
    }

    public void setCase(Case map) {
        this.map = map;
    }

    public Personnage getPersonnage() {
        return this.personnage;
    }

    public void setPersonnage(Personnage personnage) {
        this.personnage = personnage;
    }

    public int getPosX() {
        return this.posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return this.posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void keyTyped(KeyEvent e) {
    }

<<<<<<< HEAD
    public void keyPressed(KeyEvent e) {
        int keyCode;
        if ((this.getPosX() <= 0 || this.getPosX() >= 1040) && (this.getPosY() <= 0 || this.getPosY() >= 1840)) {
            keyCode = e.getKeyCode();
            if (keyCode == 83) {
                this.pY += 0;
                this.repaint();
            } else if (keyCode == 90) {
                this.pY -= 0;
                this.repaint();
            } else if (keyCode == 68) {
                this.pX += 0;
                this.repaint();
            } else if (keyCode == 81) {
                this.pX -= 0;
                this.repaint();
            }
        } else {
            keyCode = e.getKeyCode();
            if (keyCode == 83) {
                this.pY += 80;
                this.repaint();
            } else if (keyCode == 90) {
                this.pY -= 80;
                this.repaint();
            } else if (keyCode == 68) {
                this.pX += 80;
                this.repaint();
            } else if (keyCode == 81) {
                this.pX -= 80;
                this.repaint();
            }
=======
    @Override
    public void keyPressed(final KeyEvent e) {
        final int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_S) {
            System.out.println("s");
            this.pY += 80;
            this.repaint();
        } else if (keyCode == KeyEvent.VK_Z) {
            this.pY -= 80;
            this.repaint();
        } else if (keyCode == KeyEvent.VK_D) {
            this.pX += 80;
            this.repaint();
        } else if (keyCode == KeyEvent.VK_Q) {
            this.pX -= 80;
            this.repaint();
>>>>>>> 1af554aa3ed83595257e9270d170a3d59d5cafa3
        }
        setFocusable(true);
    }

        this.setFocusable(true);
    }

    public void keyReleased(KeyEvent e) {
    }

    public void deplace (int keycode) {
        if (keycode == KeyEvent.VK_S) {}
    }
}
