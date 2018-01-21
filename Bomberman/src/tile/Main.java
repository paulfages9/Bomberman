package tile;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Map map = new Map(13,23);
        Personnage personnage = new Personnage();
        Graph graph = new Graph(map);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(graph);
        frame.setSize(1900, 1600);
        frame.setVisible(true);
        System.out.println();
    }
}
