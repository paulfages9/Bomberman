package Jeu;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.util.Map;

import javax.swing.*;

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
        //this.personnage = personnage;
        this.map = map;
        this.pX = 80;
        this.pY = 80;
        //setBackground(new Color(1.0f,1.0f,1.0f,0.5f));
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        addKeyListener(this);

        this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "left");
    }

    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;

        int index = 0;
        while (index < (map.getCaseWidthInTiles() * map.getCaseHeightInTiles())) {
            for (int i = 0; i < map.getCaseWidthInTiles(); i++) {
                for (int j = 0; j < map.getCaseHeightInTiles(); j++) {
                    g2d.drawImage(map.getTileImage(index), posX, posY, this);
                    posX += map.getTileWidth();
                    index++;
                }
                posX = 0;
                posY += map.getTileHeight();
            }
            posY = 0;
        }

        //g2d.drawImage(personnage.getImage(), personnage.getX(), personnage.getY(), this);
        Graphics2D g2 = (Graphics2D) g;
        image = Toolkit.getDefaultToolkit().getImage("hero.png");
        g2.drawImage(image, pX, pY, (ImageObserver) this);

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    public Case getCase() {
        return map;
    }

    public void setCase(Case map) {
        this.map = map;
    }

    public Personnage getPersonnage() {
        return personnage;
    }

    public void setPersonnage(Personnage personnage) {
        this.personnage = personnage;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

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
        }
        setFocusable(true);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void deplace (int keycode) {
        if (keycode == KeyEvent.VK_S) {}
    }
}
