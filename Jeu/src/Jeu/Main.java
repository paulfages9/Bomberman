//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package Jeu;

import javax.swing.JFrame;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        new Case(11, 15);
        Graph terrain = new Graph(new Case(13, 23), new Personnage());
        terrain.setBounds(900, 800, 1100, 1100);
        frame.setTitle("Bomberman");
        terrain.setAlignmentX(0.5F);
        terrain.setAlignmentY(0.5F);
        frame.setDefaultCloseOperation(3);
        frame.add(terrain);
        frame.pack();
        frame.setSize(1845, 1075);
        frame.setVisible(true);
        System.out.println(terrain.getPosX());
        System.out.println(terrain.getPosY());
    }
}
