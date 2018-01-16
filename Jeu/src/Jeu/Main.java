package Jeu;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        //Personnage pers = new Personnage();
        Case c = new Case(11, 15);
        Graph terrain = new Graph(new Case(13,23),new Personnage());
       // frame.setContentPane(new Personnage());
        terrain.setBounds(900,800,1100,1100);
        frame.setTitle("Bomberman");
        terrain.setAlignmentX(Component.CENTER_ALIGNMENT);
        terrain.setAlignmentY(Component.CENTER_ALIGNMENT);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(terrain);
        frame.pack();
        frame.setSize(1845, 1075);
        frame.setVisible(true);
        System.out.println(terrain.getPosX());
        System.out.println(terrain.getPosY());

}
}
