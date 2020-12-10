import java.awt.*;
import java.util.Random;
public class Stage {
    static Random rng = new Random();
    static int bombPosX = rng.nextInt(10);
    static int bombPosY = rng.nextInt(10);
    Grid grid;
    public Stage(){
        grid = new Grid();
    }


    public void makeBomb(int x, int y, Graphics g){
        g.setColor(Color.orange);
        g.drawArc(11+(x*70), 11+(y*70), 68, 68, 0, 360);
        g.fillArc(11+(x*70),11+(y*70), 68,68, 0, 360);
    }
    public void paint(Graphics g, Point mouseLoc){
        grid.paint(g,mouseLoc);
        g.setColor(Color.RED);
        String position = "Location X: " + ((int)mouseLoc.getX()-10)/70 + " Location: Y: " + ((int)mouseLoc.getY()-10)/70;
        g.drawString(position, 780, 50);
        g.drawString(bombPosX + "", 820, 80);
        g.drawString(bombPosY + "", 820, 110);
        g.drawString(mouseLoc.toString(), 820, 150);
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
            makeBomb(i, j, g);
            }
        }
    }
}