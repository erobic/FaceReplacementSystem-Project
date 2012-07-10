/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Panels;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author power
 */
public class Shape {
    int x,y;
    
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    
    public void setX(int x){
        this.x=x;
    }
    public void setY(int y){
        this.y=y;
    }
    
    public void draw(Graphics g){
        int length=14;
        Color color=g.getColor();
        g.setColor(Color.orange);
        g.drawOval(x-10, y-10, 20, 20);
        g.drawLine(x, y-length, x, y+length);
        g.drawLine(x-length, y, x+length, y);
        g.setColor(color);
    }
}
