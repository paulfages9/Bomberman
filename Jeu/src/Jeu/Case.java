package Jeu;

import java.awt.Image;

import javax.swing.ImageIcon;


public class Case {
    private int caseWidth, caseHeight, tileWidth, tileHeight;
    public int[] tabmap =
            {       2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,
                    2,0,0,0,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,0,0,0,2,
                    2,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,2,
                    2,0,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,0,2,
                    2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,
                    2,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,2,
                    2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,
                    2,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,2,
                    2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,
                    2,0,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,0,2,
                    2,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,2,
                    2,0,0,0,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,0,0,0,2,
                    2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,
            };
    private Image[] tileImage;

    public Case(int caseWidth, int caseHeight){
        this.caseWidth = caseWidth;
        this.caseHeight = caseHeight;
        this.tileImage = new Image[3];
        this.tileImage[2] = new ImageIcon("murtenace.png").getImage();
        this.tileImage[1] = new ImageIcon("murcassable.png").getImage();
        this.tileImage[0] = new ImageIcon("herbe.png").getImage();
        this.tileWidth = this.tileImage[0].getWidth(null);
        this.tileHeight = this.tileImage[0].getHeight(null);
    }



    public boolean bonneCase(){
        for (int i = 0; i < tabmap.length; i++){
            if (tabmap[i] == 0) {
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }

    public int getCaseWidthInTiles(){
        return this.caseWidth;
    }

    public int getCaseHeightInTiles(){
        return this.caseHeight;
    }

    public int getTileWidth(){
        return this.tileWidth;
    }

    public int getTileHeight(){
        return this.tileHeight;
    }

    public Image getTileImage(int index){
        return this.tileImage[tabmap[index]];
    }
}
