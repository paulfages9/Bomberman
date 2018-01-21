package tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.ImageObserver;
import java.sql.Time;
import java.util.TimerTask;
import  java.util.Timer;

public class Graph extends JPanel implements KeyListener {
    private static int INTENSITE = 2;
    private Map laMap;
    //private Personnage personnage;
    private int posX;
    private int posY;
    private static Image bombe;
    private boolean possedeDisque = true;
    private Image image;
    private static int pX;
    private static int pY;
    private Timer timer;
    private int delay = 2000;

    public Graph(Map map) {
        this.laMap = map;
        this.pX = 80;
        this.pY = 80;
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        addKeyListener(this);
    }

    @Override
    public boolean isFocusTraversable() {
        return true;
    }

    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;

        int index = 0;
        while (index < (laMap.getMapWidth() * laMap.getMapHeight())) {
            for (int i = 0; i < laMap.getMapWidth(); i++) {
                for (int j = 0; j < laMap.getMapHeight(); j++) {
                    g2d.drawImage(laMap.getTileImage(index), posX, posY, this);
                    posX += laMap.getTileWidth();
                    index++;
                }
                posX = 0;
                posY += laMap.getTileHeight();
            }
            posY = 0;
        }
        //g2d.drawImage(personnage.getImage(), personnage.getX(), personnage.getY(), this);
        Graphics2D g2 = (Graphics2D) g;
        image = Toolkit.getDefaultToolkit().getImage("bomber.png");

        g2.drawImage(image, pX, pY, (ImageObserver) this);

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(final KeyEvent e) {
        final int keyCode = e.getKeyCode();
        // ---
        deplace(keyCode);
        // ---
        setFocusable(true);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void deplace(int keycode) {
        int x = pX;
        int y = pY;
        if (keycode == KeyEvent.VK_S || keycode == KeyEvent.VK_DOWN) {
            y += 80;
        } else if (keycode == KeyEvent.VK_Z || keycode == KeyEvent.VK_UP) {
            y -= 80;
        } else if (keycode == KeyEvent.VK_D || keycode == KeyEvent.VK_RIGHT) {
            x += 80;
        } else if (keycode == KeyEvent.VK_Q || keycode == KeyEvent.VK_LEFT) {
            x -= 80;
        } else if (keycode == KeyEvent.VK_SPACE) {
            laMap.poseBombe(pY/80, pX/80);
            bombe();
        }
        x=x/80;
        y=y/80;

        int test = Map.getElementMap(y, x);
        if (test == 9) {System.out.println("Erreur out of index");}
        if (test == 0) {
            Map.setElementMap(pX/80, pY/80, false);
            Map.setElementMap(y, x, true);
            this.pY = y*80;
            this.pX = x*80;
            this.repaint();
        }
    }
    public void bombe() {
        int x=pX/80;
        int y=pY/80;
        System.out.println("Tu poses une bombe");
                Timer timer = new Timer();
                timer.schedule(new TimerTask(){
                    public void run() {
                        laMap.exploseBombe(y, x);
                        repaint();
                    }
        }, delay);
    }

    //GETTER / SETTER
    public Map getMap() {
        return laMap;
    }

    public void setMap(Map map) {
        this.laMap = map;
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

    public static int getpX() {
        return pX;
    }

    public void setpX(int pX) {
        this.pX = pX;
    }

    public static int getpY() {
        return pY;
    }

    public void setpY(int pY) {
        this.pY = pY;
    }
}