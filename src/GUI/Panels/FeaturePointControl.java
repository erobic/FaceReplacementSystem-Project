/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Panels;

import CurveFitting.SquarePolynomial;
import Image.Image_002;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.util.List;

/**
 *
 * @author power
 */
public class FeaturePointControl extends AbstractControlPanel {

    public FeaturePointControl() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        leftEyeButton = new javax.swing.JButton();
        leftEyeLabel = new javax.swing.JLabel();
        rightEyeButton = new javax.swing.JButton();
        rightEyeLabel = new javax.swing.JLabel();
        lipCenterButton = new javax.swing.JButton();
        lipCenterLabel = new javax.swing.JLabel();
        chinEdgeButton = new javax.swing.JButton();
        chinEdgeLabel = new javax.swing.JLabel();
        chinEdgeLeftButton = new javax.swing.JButton();
        chinEdgeLeftLabel = new javax.swing.JLabel();
        chinEdgeRightButton = new javax.swing.JButton();
        chinEdgeRightLabel = new javax.swing.JLabel();
        lipLeftEdgeButton = new javax.swing.JButton();
        lipLeftEdgeLabel = new javax.swing.JLabel();
        lipRightEdgeButton = new javax.swing.JButton();
        lipRightEdgeLabel = new javax.swing.JLabel();
        leftEyeEdgeButton = new javax.swing.JButton();
        leftEyeEdgeLabel = new javax.swing.JLabel();
        rightEyeEdgeButton = new javax.swing.JButton();
        rightEyeEdgeLabel = new javax.swing.JLabel();
        curveEstimateButton = new javax.swing.JButton();

        leftEyeButton.setText("leftEye");
        leftEyeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftEyeButtonActionPerformed(evt);
            }
        });

        leftEyeLabel.setText("Not Set");

        rightEyeButton.setText("rightEye");
        rightEyeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightEyeButtonActionPerformed(evt);
            }
        });

        rightEyeLabel.setText("Not Set");

        lipCenterButton.setText("lipCenter");
        lipCenterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lipCenterButtonActionPerformed(evt);
            }
        });

        lipCenterLabel.setText("Not Set");

        chinEdgeButton.setText("chinEdge");
        chinEdgeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chinEdgeButtonActionPerformed(evt);
            }
        });

        chinEdgeLabel.setText("Not Set");

        chinEdgeLeftButton.setText("LeftChinEdge");
        chinEdgeLeftButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chinEdgeLeftButtonActionPerformed(evt);
            }
        });

        chinEdgeLeftLabel.setText("Not Set");

        chinEdgeRightButton.setText("RightChinEdge");
        chinEdgeRightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chinEdgeRightButtonActionPerformed(evt);
            }
        });

        chinEdgeRightLabel.setText("Not Set");

        lipLeftEdgeButton.setText("LeftLipEdge");
        lipLeftEdgeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lipLeftEdgeButtonActionPerformed(evt);
            }
        });

        lipLeftEdgeLabel.setText("Not Set");

        lipRightEdgeButton.setText("RightLipEdge");
        lipRightEdgeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lipRightEdgeButtonActionPerformed(evt);
            }
        });

        lipRightEdgeLabel.setText("Not Set");

        leftEyeEdgeButton.setText("leftEyeEdge");
        leftEyeEdgeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftEyeEdgeButtonActionPerformed(evt);
            }
        });

        leftEyeEdgeLabel.setText("Not Set");

        rightEyeEdgeButton.setText("rightEyeEdge");
        rightEyeEdgeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightEyeEdgeButtonActionPerformed(evt);
            }
        });

        rightEyeEdgeLabel.setText("Not Set");

        curveEstimateButton.setText("curveEstimate");
        curveEstimateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                curveEstimateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lipCenterButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lipCenterLabel))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(chinEdgeButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(chinEdgeLabel))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(chinEdgeLeftButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(chinEdgeLeftLabel))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(chinEdgeRightButton)
                            .addGap(18, 18, 18)
                            .addComponent(chinEdgeRightLabel))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(rightEyeButton)
                                .addComponent(leftEyeButton))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(rightEyeLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(leftEyeLabel, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lipLeftEdgeButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lipLeftEdgeLabel))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lipRightEdgeButton)
                                .addComponent(leftEyeEdgeButton))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(leftEyeEdgeLabel)
                                .addComponent(lipRightEdgeLabel)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(rightEyeEdgeButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rightEyeEdgeLabel)))
                    .addComponent(curveEstimateButton))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(leftEyeButton)
                    .addComponent(leftEyeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rightEyeButton)
                    .addComponent(rightEyeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lipCenterButton)
                    .addComponent(lipCenterLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chinEdgeButton)
                    .addComponent(chinEdgeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chinEdgeLeftButton)
                    .addComponent(chinEdgeLeftLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chinEdgeRightButton)
                    .addComponent(chinEdgeRightLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lipLeftEdgeButton)
                    .addComponent(lipLeftEdgeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lipRightEdgeButton)
                    .addComponent(lipRightEdgeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(leftEyeEdgeButton)
                    .addComponent(leftEyeEdgeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rightEyeEdgeButton)
                    .addComponent(rightEyeEdgeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(curveEstimateButton))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void leftEyeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftEyeButtonActionPerformed
        Shape s=parent.picturePanel.s;
        int x=s.x;
        int y=s.y;
        if( x>0 && y>0 ){
            parent.ActiveImage.leftEye=new Point(x,y);
            this.leftEyeLabel.setText("OK");
        }
    }//GEN-LAST:event_leftEyeButtonActionPerformed

    private void rightEyeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightEyeButtonActionPerformed
        Shape s=parent.picturePanel.s;
        int x=s.x;
        int y=s.y;
        if( x>0 && y>0 ){
            parent.ActiveImage.rightEye=new Point(x,y);
            this.rightEyeLabel.setText("OK");
        }
    }//GEN-LAST:event_rightEyeButtonActionPerformed

    private void lipCenterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lipCenterButtonActionPerformed
        Shape s=parent.picturePanel.s;
        int x=s.x;
        int y=s.y;
        if( x>0 && y>0 ){
            parent.ActiveImage.lipCenter=new Point(x,y);
            this.lipCenterLabel.setText("OK");
        }
    }//GEN-LAST:event_lipCenterButtonActionPerformed

    private void chinEdgeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chinEdgeButtonActionPerformed
        Shape s=parent.picturePanel.s;
        int x=s.x;
        int y=s.y;
        if( x>0 && y>0 ){
            parent.ActiveImage.chinPoint=new Point(x,y);
            this.chinEdgeLabel.setText("OK");
        }
    }//GEN-LAST:event_chinEdgeButtonActionPerformed

    private void chinEdgeLeftButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chinEdgeLeftButtonActionPerformed
        Shape s=parent.picturePanel.s;
        int x=s.x;
        int y=s.y;
        if( x>0 && y>0 ){
            parent.ActiveImage.leftChinEdge=new Point(x,y);
            this.chinEdgeLeftLabel.setText("OK");
        }
    }//GEN-LAST:event_chinEdgeLeftButtonActionPerformed

    private void chinEdgeRightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chinEdgeRightButtonActionPerformed
        Shape s=parent.picturePanel.s;
        int x=s.x;
        int y=s.y;
        if( x>0 && y>0 ){
            parent.ActiveImage.rightChinEdge=new Point(x,y);
            this.chinEdgeRightLabel.setText("OK");
        }
    }//GEN-LAST:event_chinEdgeRightButtonActionPerformed

    private void lipLeftEdgeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lipLeftEdgeButtonActionPerformed
        Shape s=parent.picturePanel.s;
        int x=s.x;
        int y=s.y;
        if( x>0 && y>0 ){
            parent.ActiveImage.leftLipEdge=new Point(x,y);
            this.lipLeftEdgeLabel.setText("OK");
        }
    }//GEN-LAST:event_lipLeftEdgeButtonActionPerformed

    private void lipRightEdgeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lipRightEdgeButtonActionPerformed
        Shape s=parent.picturePanel.s;
        int x=s.x;
        int y=s.y;
        if( x>0 && y>0 ){
            parent.ActiveImage.rightLipEdge=new Point(x,y);
            this.lipRightEdgeLabel.setText("OK");
        }
    }//GEN-LAST:event_lipRightEdgeButtonActionPerformed

    private void leftEyeEdgeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftEyeEdgeButtonActionPerformed
        Shape s=parent.picturePanel.s;
        int x=s.x;
        int y=s.y;
        if( x>0 && y>0 ){
            parent.ActiveImage.leftEyeEdge=new Point(x,y);
            this.leftEyeEdgeLabel.setText("OK");
        }
    }//GEN-LAST:event_leftEyeEdgeButtonActionPerformed

    private void rightEyeEdgeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightEyeEdgeButtonActionPerformed
        Shape s=parent.picturePanel.s;
        int x=s.x;
        int y=s.y;
        if( x>0 && y>0 ){
            parent.ActiveImage.rightEyeEdge=new Point(x,y);
            this.rightEyeEdgeLabel.setText("OK");
        }
    }//GEN-LAST:event_rightEyeEdgeButtonActionPerformed

    private Point reducePoint(Point p,Point p2){
        return new Point(p.x-p2.x,p.y-p2.y);
    }
    private Point addPoint(Point p, Point p2){
        return new Point(p.x+p2.x,p.y+p2.y);
    }
    private void curveEstimateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_curveEstimateButtonActionPerformed
        Image_002 a=parent.ActiveImage;
        a.estimateCurve();
        a.drawEdgeCurve(parent.picturePanel.getGraphics());
        //        SquarePolynomial sq=new SquarePolynomial();
//        Image_002 b=parent.ActiveImage;
//        Point[] p={reducePoint(b.leftLipEdge,b.leftChinEdge),
//                    reducePoint(b.leftChinEdge,b.leftChinEdge),
//                    reducePoint(b.chinPoint,b.leftChinEdge),
//                    reducePoint(b.rightChinEdge,b.leftChinEdge),
//                    reducePoint(b.rightLipEdge,b.leftChinEdge)};//,b.leftLipEdge,b.rightLipEdge
//        sq.setPoints(p);
//        Point []v={reducePoint(b.leftLipEdge,b.leftChinEdge),
//                    reducePoint(b.rightLipEdge,b.leftChinEdge)};//{b.leftLipEdge,b.rightLipEdge};
//        List<Point> points=sq.getPoints(v);
//        plot(points,Color.red);
    }//GEN-LAST:event_curveEstimateButtonActionPerformed

//    private void plot(List<Point> p,Color c){
//        Graphics g=this.parent.picturePanel.getGraphics();
//        g.setColor(c);
//        Image_002 b=parent.ActiveImage;
//        Point point;
//        for(int i=0;i<p.size();i++){
//            point = addPoint(p.get(i),b.leftChinEdge);
//            System.out.println(point.x+","+point.y);
//            g.drawOval(point.x, point.y, 1, 1);
//        }
//    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chinEdgeButton;
    private javax.swing.JLabel chinEdgeLabel;
    private javax.swing.JButton chinEdgeLeftButton;
    private javax.swing.JLabel chinEdgeLeftLabel;
    private javax.swing.JButton chinEdgeRightButton;
    private javax.swing.JLabel chinEdgeRightLabel;
    private javax.swing.JButton curveEstimateButton;
    private javax.swing.JButton leftEyeButton;
    private javax.swing.JButton leftEyeEdgeButton;
    private javax.swing.JLabel leftEyeEdgeLabel;
    private javax.swing.JLabel leftEyeLabel;
    private javax.swing.JButton lipCenterButton;
    private javax.swing.JLabel lipCenterLabel;
    private javax.swing.JButton lipLeftEdgeButton;
    private javax.swing.JLabel lipLeftEdgeLabel;
    private javax.swing.JButton lipRightEdgeButton;
    private javax.swing.JLabel lipRightEdgeLabel;
    private javax.swing.JButton rightEyeButton;
    private javax.swing.JButton rightEyeEdgeButton;
    private javax.swing.JLabel rightEyeEdgeLabel;
    private javax.swing.JLabel rightEyeLabel;
    // End of variables declaration//GEN-END:variables
}
