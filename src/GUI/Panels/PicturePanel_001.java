/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Panels;

import Image.ImageProcessor;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import javax.swing.SwingUtilities;

/**
 *
 * @author power
 */
public class PicturePanel_001 extends AbstractPicturePanel {

    /**
     * Creates new form PicturePanel_001
     */
    
    
    public PicturePanel_001() {
        initComponents();
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 486, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 353, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        if(lastDrawnImage!=null){
        dragging = true;
        startX=previousX=evt.getX();
        startY=previousY=evt.getY();
        /*
            System.out.print(" "+startX+","+startY);
            if(lastDrawnImage!=null&&startX<lastDrawnImage.getHeight()&&startY<lastDrawnImage.getWidth()){
                int []a=new int[3];
                a=wr.getPixel(startX,startY,a);
                System.out.print("\t"+a[0]+","+a[1]+","+a[2]+"\n");
            }
            
         */
        }
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        if(dragging){
            previousX=evt.getX();
            previousY=evt.getY();
            reDraw();
            drawRectangle(previousX,previousY);
        }
    }//GEN-LAST:event_formMouseDragged

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        dragging = false;
    }//GEN-LAST:event_formMouseReleased

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        this.reDraw();
        wr=this.lastDrawnImage.getRaster();
        float[] a=null;
        int [] b = null;
        a=ImageProcessor.getPixelRatio(wr.getPixel(evt.getX(), evt.getY(), b));
//        a=wr.getPixel(evt.getX(), evt.getY(), a);
//        System.out.println("r="+a[0]+" g="+a[1]+" b="+a[2]);
//        float tot=a[0]+a[1]+a[2]+1;
        System.out.println("("+a[0]+","+a[1]+","+a[2]+")");
    }//GEN-LAST:event_formMouseClicked

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        this.DrawImage(this.lastDrawnImage);
    }//GEN-LAST:event_formComponentResized

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
