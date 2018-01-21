package tile;

import javax.swing.*;
import java.awt.*;
import java.util.TimerTask;
import java.util.Timer;

public class Map {
    Timer timer;
    private int mapWidth, mapHeight, tileWidth, tileHeight, positionY, positionX;
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

    public void poseBombe(int x, int y) {
        map[x][y]= 3;
    }

    public void exploseBombe(int x, int y) {
        if (map[x][y] == 3) {
            map[x][y]= 0;
        }
    }

    public Image[] tileImage;
    public Map(){};
    public Map(Integer mapWidth, Integer mapHeight){
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        this.tileImage = new Image[4];
        this.tileImage[0] = new ImageIcon("ground.png").getImage();
        this.tileImage[1] = new ImageIcon("casse.png").getImage();
        this.tileImage[2] = new ImageIcon("block.png").getImage();
        this.tileImage[3] = new ImageIcon("bombes.png").getImage();
       //this.tileImage[3] = new ImageIcon("perso.png").getImage();
        this.tileWidth = this.tileImage[0].getWidth(null);
        this.tileHeight = this.tileImage[0].getHeight(null);
    }

    public int getMapWidth(){
        return this.mapWidth;
    }

    public static int[][] getMap() {
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

    public static void setMap(int[][] map) {
        Map.map = map;
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

    /*public static void setElementMap (int i, int j) {
        map[i]=j;
    }*/
    public static int getElementMap(int i, int j){
        if(i<13 && j<23) {
            return map[i][j];
        }
        else return 9;
    }

}
