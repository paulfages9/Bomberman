//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package Jeu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

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
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(this);
    }

    public boolean isFocusTraversable() {
        return true;
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
        }

        this.setFocusable(true);
    }

    public void keyReleased(KeyEvent e) {
    }
}
