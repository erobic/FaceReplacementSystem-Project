/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Panels;

import GUI.Frames.Frame_002;
import Image.Image_002;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.JScrollPane;

/**
 *
 * @author power
 */
public class RootPanel extends javax.swing.JPanel {
    
    public Image_002 ActiveImage=null;
    public Frame_002 rootFrame=null;//parent for this panel
    
//    public String sourceImagePath=null;
//    public String targetImagePath=null;
    
    public Image_002 sourceImage=null;
    public Image_002 targetImage=null;

    //panel iterators
    public GUI.Panels.AbstractControlPanel controlPanel;//controlPanel iterator
    public GUI.Panels.AbstractPicturePanel picturePanel;//picturePanel iterator
    
    //picturePanels
    public GUI.Panels.PicturePanel_001 generalPicturePanel=new PicturePanel_001();
    public GUI.Panels.AbstractPicturePanel featurePointPanel=new FeaturePointPanel_001();
    
    //controlPanels
    public GUI.Panels.AbstractControlPanel newProjectPanel=new NewProjectPanel_001();
    public GUI.Panels.AbstractControlPanel generalControls=new GeneralImageControls();
    public GUI.Panels.AbstractControlPanel featureControls=new FeaturePointControl();
    public GUI.Panels.AbstractControlPanel testingPanel2=new TestingPanel_002();
    public GUI.Panels.AbstractControlPanel pixelAnalyser=new pixelAnalysis();
    
    public RootPanel() {
        initComponents();
        controlPanel=newProjectPanel;
        picturePanel=this.generalPicturePanel;
        //picturePanel=this.featurePointPanel;
        this.add(this.picturePanel);
        this.add(this.controlPanel);
        
        manualInit();

    }
    public void manualInit(){
        controlPanel.parent=this;
        generalControls.parent=this;
        featureControls.parent=this;
        testingPanel2.parent=this;
        pixelAnalyser.parent=this;
        
        this.picturePanel.parent=this;
        this.generalPicturePanel.parent=this;
        this.featurePointPanel.parent=this;
    }
    public void setActiveControlPanel (GUI.Panels.AbstractControlPanel controlPanel){
        this.invalidate();
        this.remove(this.controlPanel);
        this.controlPanel=controlPanel;
        this.add(this.controlPanel);
        int width=(int) this.getWidth()-controlPanel.width-20;
        int height=this.getHeight();
        controlPanel.setMaximumSize(new Dimension(controlPanel.width,height+20));
        controlPanel.setMinimumSize(new Dimension(controlPanel.width,height));
        this.revalidate();
        this.repaint();
        if(controlPanel!=this.featureControls||controlPanel!=this.pixelAnalyser){
            this.setActivePicturePanel(this.generalPicturePanel);
        }
    }
    public void setActivePicturePanel (GUI.Panels.AbstractPicturePanel picturePanel){
        this.invalidate();
        this.removeAll();
        BufferedImage b=this.picturePanel.lastDrawnImage;
        this.picturePanel=picturePanel;
        this.add(this.picturePanel);
        this.add(this.controlPanel);
        int width=(int) this.getWidth()-controlPanel.width-20;
        int height=this.getHeight();
        controlPanel.setMaximumSize(new Dimension(controlPanel.width,height+20));
        controlPanel.setMinimumSize(new Dimension(controlPanel.width,height));
        this.revalidate();
        this.repaint();
        this.picturePanel.DrawImage(b);
    }
    public void drawImage(String path) throws IOException{
        //not recomended
        generalPicturePanel.clear();
        generalPicturePanel.DrawImage(Image.ImageProcessor.createImage(path));
    }
    public void drawImage(Image_002 image){
        if(image!=null){
            this.ActiveImage=image;
            this.picturePanel.DrawImage(image.originalImage);
        }
    }
    public void setSourcePath(String path) throws IOException{
        //this.sourceImagePath=path;
        this.sourceImage=new Image_002();
        sourceImage.setSource(path);
        drawImage(this.sourceImage);
//        this.ActiveImage=sourceImage;//already drawn
    }
    public void setTargetPath(String path) throws IOException{
        //this.targetImagePath=path;
        this.targetImage=new Image_002();
        targetImage.setSource(path);
        drawImage(this.targetImage);
//        this.ActiveImage=targetImage;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(0, 255, 255));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        int width=(int) this.getWidth()-controlPanel.width-20;
        int height=this.getHeight();
        //System.out.println("In RootPanel Resized w= "+width+" h="+height);
        //pictureScrool.setSize(width, height);
        generalPicturePanel.setSize(width, height);
        controlPanel.setSize(controlPanel.width, height);
        //System.out.println("controlPanel.width="+controlPanel.width);
        controlPanel.setMaximumSize(new Dimension(controlPanel.width,height+20));
        controlPanel.setMinimumSize(new Dimension(controlPanel.width,height));
        //controlPanel.setLocation(width+10,0);
        this.revalidate();
        this.setVisible(true);
    }//GEN-LAST:event_formComponentResized

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
