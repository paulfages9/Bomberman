//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package Jeu;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

public class Personnage extends JPanel {
    private int[] position = new int[2];
    private Graphics g;
    private boolean pers = true;
    private Image image = Toolkit.getDefaultToolkit().getImage("hero.png");

    public Personnage() {
        this.position[0] = 0;
        this.position[1] = 0;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return this.image;
    }

    public void setPosition(int x, int y) {
        this.position[0] = x;
        this.position[1] = y;
    }

    public int[] getPosition() {
        return this.position;
    }

    public int getX() {
        return this.position[0];
    }

    public int getY() {
        return this.position[1];
    }

    public void setPers(boolean pers) {
        this.pers = pers;
    }
}
