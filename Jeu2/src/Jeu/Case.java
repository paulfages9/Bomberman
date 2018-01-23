package Jeu;

import javax.swing.*;
import java.awt.*;
import java.util.TimerTask;
import java.util.Timer;

public class Case {
    //Initialisation de variable
    Timer timer2;
    private int delay = 1000;
    private int delay2 = 1000;
    public boolean perdu = false;
    public boolean perdu2 = false;
    private int mapWidth, mapHeight, tileWidth, tileHeight, positionY, positionX;

    //Construction du tableau avec des chiffre qui seront par la suite associé a des images
    public static int[][] map =
            {       {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,},
                    {2,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,2,},
                    {2,0,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,0,2,},
                    {2,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,2,},
                    {2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,},
                    {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,},
                    {2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,},
                    {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,},
                    {2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,},
                    {2,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,2,},
                    {2,0,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,0,2,},
                    {2,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,2,},
                    {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,}
            };

    //Permet de poser la bombe du premier personnage à l'endroit ou il se trouve
    public void poseBombe(int x, int y) {
        map[x][y]= 3;
    }

    //Permet de poser la bombe du deuxième personnage à l'endroit où il se trouve
    public void poseBombe2(int x, int y) {
        map[x][y]= 3;
    }

    //Permet de remplacer les image de l'explosion par de l'herbe après pour le premier personnage
    public void newCase (int a, int b){

            if (map[a][b + 1] == 7) {
                map[a][b + 1] = 0;
            }
            if (map[a][b - 1] == 8) {
                map[a][b - 1] = 0;
            }
            if (map[a + 1][b] == 5) {
                map[a + 1][b] = 0;
            }
            if (map[a - 1][b] == 4) {
                map[a - 1][b] = 0;
            }
            if (map[a][b] == 10) {
                map[a][b] = 0;
            }
    }

    //Permet de remplacer les images d'expolsion par de l'herbe pour le deuxieme personnage
    public void newCase2 (int a1, int b1){

        if (map[a1][b1 + 1] == 7) {
            map[a1][b1 + 1] = 0;
        }
        if (map[a1][b1 - 1] == 8) {
            map[a1][b1 - 1] = 0;
        }
        if (map[a1 + 1][b1] == 5) {
            map[a1 + 1][b1] = 0;
        }
        if (map[a1 - 1][b1] == 4) {
            map[a1 - 1][b1] = 0;
        }
        if (map[a1][b1] == 10) {
            map[a1][b1] = 0;
        }
    }

    //permet de mettre en place les images de l'explosion de la bombe pour le premier personnage
    public void exploseBombe(int x, int y) {


        if (map[x][y+1] == 0 || map[x][y+1] == 1) {map[x][y + 1] = 7;}
        if (map[x][y-1] == 0 || map[x][y-1] == 1) {map[x][y - 1] = 8;}
        if (map[x+1][y] == 0 || map[x+1][y] == 1) {map[x + 1][y] = 5;}
        if (map[x-1][y] == 0 || map[x-1][y] == 1) {map[x - 1][y] = 4;}
        if (map[x][y] == 3 || map[x][y] == 0) {map[x][y] = 10;}
        Timer timer2 = new Timer();
        timer2.schedule(new TimerTask() {
            @Override
            public void run() {
                newCase(x,y);
            }
        },delay);
    }

    //Permet de mettre en place les images de l'explosion de la bombe du deuxieme personnage
    public void exploseBombe2(int px, int py) {


        if (map[px][py+1] == 0 || map[px][py+1] == 1) {map[px][py + 1] = 7;}
        if (map[px][py-1] == 0 || map[px][py-1] == 1) {map[px][py - 1] = 8;}
        if (map[px+1][py] == 0 || map[px+1][py] == 1) {map[px + 1][py] = 5;}
        if (map[px-1][py] == 0 || map[px-1][py] == 1) {map[px - 1][py] = 4;}
        if (map[px][py] == 3 || map[px][py] == 0) {map[px][py] = 10;}
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                newCase2(px,py);
            }
        },delay2);

    }

    //permet de tuer le personnage 1 si il touche l'explosion de la bombe
    public void gameOver(int pX, int pY){
        if (map[pX][pY] == 4 || map[pX][pY] == 5 || map[pX][pY] == 6 || map[pX][pY] == 7 || map[pX][pY] == 8 || map[pX][pY] == 9 || map[pX][pY] == 10){
            System.out.println("you loose");
            String perd = "Le joueur 1 a perdu pour cette fois !!";
            javax.swing.JOptionPane.showMessageDialog(null,perd);
            perdu = true;
        }
        else {
            perdu = false;
        }
    }

    //permet de tuer le personnage 2 si il touche l'explosion de la bombe
    public void gameOver2(int p2X, int p2Y){
        if (map[p2X][p2Y] == 4 || map[p2X][p2Y] == 5 || map[p2X][p2Y] == 6 || map[p2X][p2Y] == 7 || map[p2X][p2Y] == 8 || map[p2X][p2Y] == 9 || map[p2X][p2Y] == 10){
            System.out.println("you loose 2");
            String perd = "Le joueur 2 a perdu pour cette fois !!";
            javax.swing.JOptionPane.showMessageDialog(null,perd);
            Fenetre fen = new Fenetre();
            perdu2 = true;
        }
        else {
            perdu2 = false;
        }
    }

    //Permet d'associer des image pour chaque numero dans le tableau, pour créer la map, les explosions
    public Image[] tileImage;
    public Case(){};
    public Case(Integer mapWidth, Integer mapHeight){
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        this.tileImage = new Image[11];
        this.tileImage[0] = new ImageIcon("ground.png").getImage();
        this.tileImage[1] = new ImageIcon("casse.png").getImage();
        this.tileImage[2] = new ImageIcon("block.png").getImage();
        this.tileImage[3] = new ImageIcon("bombes.png").getImage();
        this.tileImage[4] = new ImageIcon("explohautfin.png").getImage();
        this.tileImage[5] = new ImageIcon("explobasfin.png").getImage();
        this.tileImage[6] = new ImageIcon("explohautbas.png").getImage();
        this.tileImage[7] = new ImageIcon("explodroitefin.png").getImage();
        this.tileImage[8] = new ImageIcon("explogauchefin.png").getImage();
        this.tileImage[9] = new ImageIcon("explodroitegauche.png").getImage();
        this.tileImage[10] = new ImageIcon("explocentre.png").getImage();
        this.tileWidth = this.tileImage[0].getWidth(null);
        this.tileHeight = this.tileImage[0].getHeight(null);
    }

    public int getMapWidth(){
        return this.mapWidth;
    }

    public static int[][] getCase() {
        return map;
    }

    public static int getPosition(int positionY, int positionX) {
        return map[positionY][positionX];
    }

    /*public void setPosition(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
        position[][] = map[this.positionY][this.positionX];
    }*/

    public static void setCase(int[][] map) {
        Case.map = map;
    }

    public int getMapHeight(){
        return this.mapHeight;
    }

    public int getTileWidth(){
        return this.tileWidth;
    }

    public int getTileHeight(){
        return this.tileHeight;
    }

    //Permet d'associer les bonne image au bon chiffre
    public Image getTileImage(int index){
        // gestion des images pas mises
        if (index<300) {return this.tileImage[map[(int)index/23][index%23]];}
        else {return this.tileImage[0];}
    }

    public static void setElementMap (int i, int j, boolean newEmplacement) {
        if (newEmplacement) {
            getPosition(i, j);
        }
    }

    //Permet de verifier si on se trouve bien dans notre tableau
    public static int getElementMap(int i, int j){
        if(i<13 && j<23) {
            return map[i][j];
        }
        else return 15;
    }

}
