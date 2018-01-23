package Jeu;

import javax.swing.*;

public class Fenetre extends JFrame{
    public Fenetre (){
        Case map = new Case(13,23);
        Personnage personnage = new Personnage();
        Graph graph = new Graph(map);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.add(graph);
        this.setSize(1900, 1600);
        this.setVisible(true);
        System.out.println();
    }

    public void popupGo (){

    }
}
