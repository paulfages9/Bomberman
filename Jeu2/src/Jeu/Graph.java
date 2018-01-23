package Jeu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.ImageObserver;
import java.sql.Time;
import java.util.Map;
import java.util.TimerTask;
import  java.util.Timer;

public class Graph extends JPanel implements KeyListener {
    //Initialisation de variable
    private Case laMap;
    private int posX;
    private int posY;
    private static Image bombe;
    private boolean possedeDisque = true;
    private Image image;
    private Image img;
    private static int pX;
    private static int pY;
    private static int p2X;

    private static int p2Y;

    private Timer timer;
    private Timer timer2;
    private int delay = 2000;
    private int delay2 = 2000;

    //Permet de de mettre en relation cette classe avec la Case et d'initialiser nos futur emplacement de personnage
    public Graph(Case map) {
        this.laMap = map;
        this.pX = 80;
        this.pY = 80;
        this.p2X = 80*21;
        this.p2Y = 80 * 11;
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        addKeyListener(this);
    }

    @Override
    public boolean isFocusTraversable() {
        return true;
    }

    //Fonction qui permet de dessiner la map et le personnage dans notre fenêtre
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;
        //Partie qui crée la map
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

        //Partie qui crée et place les personnages sur la map selon les emplacement pX,pY et p2X,p2Y
        Graphics2D g2 = (Graphics2D) g;
        //Condition pour savoir si les personnage se trouve dans les explosion pour les tuer
        if (!laMap.perdu) {
            image = Toolkit.getDefaultToolkit().getImage("hero2.png");
            g2.drawImage(image, pX, pY, (ImageObserver) this);
        }
        else {
            repaint();
        }
        if (!laMap.perdu2) {
            img = Toolkit.getDefaultToolkit().getImage("bomber.png");
            g2.drawImage(img, p2X, p2Y, (ImageObserver) this);
        }
        else {
            //g2.drawImage(img, p2X, p2Y, (ImageObserver) this);
            repaint();
        }
        g2.dispose();
        Toolkit.getDefaultToolkit().sync();

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //Permet d'activer la détection des touche enfoncée
    @Override
    public void keyPressed(final KeyEvent e) {
        final int keyCode = e.getKeyCode();
        // ---
        try {
            deplace(keyCode);
        } catch (AWTException e1) {
            e1.printStackTrace();
        }
        // ---
        try {
            deplace2(keyCode);
        } catch (AWTException e1) {
            e1.printStackTrace();
        }
        setFocusable(true);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    //Fonction qui permet d'associer les déplacements aux touches "Z,Q,S,D" du clavier --> premier perso
    public void deplace(int keycode) throws AWTException {
        int x = pX;
        int y = pY;
        if (!laMap.perdu){
        if (keycode == KeyEvent.VK_S) {
            y += 80;
        } else if (keycode == KeyEvent.VK_Z) {
            y -= 80;
        } else if (keycode == KeyEvent.VK_D) {
            x += 80;
        } else if (keycode == KeyEvent.VK_Q) {
            x -= 80;
        } else if (keycode == KeyEvent.VK_SPACE) {
            laMap.poseBombe(pY / 80, pX / 80);
            bombe();
        }
            Robot robot = new Robot();
            /**
             * Fixer le delai entre chaque mouvement à 250 ms
             */
            robot.setAutoWaitForIdle(false);
            /**
             * Envoyer les touches axel une à une
             */
            robot.keyPress(KeyEvent.VK_P);
        }
        x = x / 80;
        y = y / 80;

        //Condition pour savoir si c'est possible de se déplacer pour le deuxieme personnage grace à la fonction getElement et setElement de la classe Case, premier personnnage
        int test = Case.getElementMap(y, x);
        if (test == 15) {
            System.out.println("Erreur out of index");
        }
        if (test == 0 || test == 4 || test == 5 || test == 6 || test == 7 || test == 8 || test == 9 || test == 10) {
            Case.setElementMap(pX / 80, pY / 80, false);
            Case.setElementMap(y, x, true);
            this.pY = y * 80;
            this.pX = x * 80;
            this.repaint();
        }
        laMap.gameOver(y,x);
    }

    //Fonction qui permet d'associer les déplacements aux touches "flêche" du clavier --> deuxieme perso
    public void deplace2(int keycode) throws AWTException {
        int x = p2X;
        int y = p2Y;
        if (!laMap.perdu2){
            if (keycode == KeyEvent.VK_DOWN) {
                y += 80;
            } else if (keycode == KeyEvent.VK_UP) {
                y -= 80;
            } else if (keycode == KeyEvent.VK_RIGHT) {
                x += 80;
            } else if (keycode == KeyEvent.VK_LEFT) {
                x -= 80;
            } else if (keycode == KeyEvent.VK_ENTER) {
                laMap.poseBombe2(p2Y / 80, p2X / 80);
                bombe2();

            }
            Robot robot = new Robot();
            /**
             * Fixer le delai entre chaque mouvement à 250 ms
             */
            robot.setAutoWaitForIdle(false);
            /**
             * Envoyer les touches axel une à une
             */
            robot.keyPress(KeyEvent.VK_P);
        }
        x = x / 80;
        y = y / 80;

        //Condition pour savoir si c'est possible de se déplacer pour le deuxieme personnage grace à la fonction getElement et setElement de la classe Case, deuxieme personnnage
        int test = Case.getElementMap(y, x);
        if (test == 15) {
            System.out.println("Erreur out of index");
        }
        if (test == 0 || test == 4 || test == 5 || test == 6 || test == 7 || test == 8 || test == 9 || test == 10) {
            Case.setElementMap(p2X / 80, p2Y / 80, false);
            Case.setElementMap(y, x, true);
            this.p2Y = y * 80;
            this.p2X = x * 80;
            this.repaint();
        }
        laMap.gameOver2(y,x);
    }

    //Permet de poser une bombe pour le premier personnage
    public void bombe() {
        int x=pX/80;
        int y=pY/80;
        System.out.println("Tu poses une bombe");
        Timer timer = new Timer();
        timer.schedule(new TimerTask(){
            public void run() {
                //Appel de la fonction pour faire exploser les bombe de la classe Case pour premier personnage
                laMap.exploseBombe(y, x);
                //laMap.newCase(y,x);
                repaint();

            }
        }, delay);
    }

    //Permet de poser une bombe pour le deuxieme personnage
    public void bombe2 (){
        int x2 = p2X/80;
        int y2 = p2Y/80;
        System.out.println("Tu poses une bombe");
        Timer timer2 = new Timer();
        timer2.schedule(new TimerTask(){
            public void run() {
                //Appel de la fonction pour faire exploser les bombe de la classe Case pour deuxieme personnage
                laMap.exploseBombe2(y2,x2);
                repaint();
            }

        }, delay2);


    }
    //GETTER / SETTER

    public Case getCase() {
        return laMap;
    }
    public void setCase(Case map) {
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

    public static int getP2X() {
        return p2X;
    }

    public static void setP2X(int p2X) {
        Graph.p2X = p2X;
    }

    public static int getP2Y() {
        return p2Y;
    }

    public static void setP2Y(int p2Y) {
        Graph.p2Y = p2Y;
    }
}
