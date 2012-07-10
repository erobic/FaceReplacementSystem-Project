/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Frames;

import GUI.Panels.AbstractControlPanel;
import GUI.Panels.PicturePanel_001;
import GUI.Panels.RootPanel;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBoxMenuItem;

/**
 *
 * @author power
 */
public class Frame_002 extends RootFrame {

    GUI.Panels.RootPanel rootPanel = new RootPanel();
    
    public Frame_002() {
        initComponents();
        this.setTitle("Face Replacement System");
        this.setContentPane(rootPanel);
        rootPanel.rootFrame=this;
        
    }

    public JCheckBoxMenuItem getSequenceMode() {
        return sequenceMode;
    }

    @Override
    public void setVisible(boolean value){
        super.setVisible(value);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        SourceImageMenu = new javax.swing.JMenuItem();
        TargetImageMenu = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        ImageSelectionControl = new javax.swing.JMenuItem();
        generalControls = new javax.swing.JMenuItem();
        featurePointPanel = new javax.swing.JMenuItem();
        testingPanel2 = new javax.swing.JMenuItem();
        pixelAnalysis = new javax.swing.JMenuItem();
        sequenceMode = new javax.swing.JCheckBoxMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        jMenuBar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuBar1MouseClicked(evt);
            }
        });
        jMenuBar1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                jMenuBar1ComponentHidden(evt);
            }
        });

        jMenu1.setText("File");

        jMenuItem1.setText("NewProject");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Close");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("View");

        SourceImageMenu.setText("SourceImage");
        SourceImageMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SourceImageMenuActionPerformed(evt);
            }
        });
        jMenu3.add(SourceImageMenu);

        TargetImageMenu.setText("TargetImage");
        TargetImageMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TargetImageMenuActionPerformed(evt);
            }
        });
        jMenu3.add(TargetImageMenu);

        jMenuBar1.add(jMenu3);

        jMenu2.setText("Edit");

        ImageSelectionControl.setText("ImageSelection");
        ImageSelectionControl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImageSelectionControlActionPerformed(evt);
            }
        });
        jMenu2.add(ImageSelectionControl);

        generalControls.setText("GeneralControls");
        generalControls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generalControlsActionPerformed(evt);
            }
        });
        jMenu2.add(generalControls);

        featurePointPanel.setText("FeaturePointPanel");
        featurePointPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                featurePointPanelActionPerformed(evt);
            }
        });
        jMenu2.add(featurePointPanel);

        testingPanel2.setText("TestingPanel2");
        testingPanel2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testingPanel2ActionPerformed(evt);
            }
        });
        jMenu2.add(testingPanel2);

        pixelAnalysis.setText("pixelAnalysis");
        pixelAnalysis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pixelAnalysisActionPerformed(evt);
            }
        });
        jMenu2.add(pixelAnalysis);

        sequenceMode.setSelected(true);
        sequenceMode.setText("SequentialMode");
        sequenceMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sequenceModeActionPerformed(evt);
            }
        });
        jMenu2.add(sequenceMode);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 645, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 396, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void SourceImageMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SourceImageMenuActionPerformed
        //System.out.println("Hello world");
        if(rootPanel.sourceImage!=null){
            //System.out.println("The source Image is not null");
            try {
                rootPanel.drawImage(rootPanel.sourceImage);
            } catch (Exception ex) {
                //Logger.getLogger(Frame_002.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Frame_002 "+ex.getMessage());
            }
        }else{
            System.out.println("null");
        }
    }//GEN-LAST:event_SourceImageMenuActionPerformed

    private void TargetImageMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TargetImageMenuActionPerformed
        if(rootPanel.targetImage!=null){
            try {
                rootPanel.drawImage(rootPanel.targetImage);
            } catch (Exception ex) {
                Logger.getLogger(Frame_002.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_TargetImageMenuActionPerformed

    private void generalControlsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generalControlsActionPerformed
        rootPanel.setActiveControlPanel(rootPanel.generalControls);
    }//GEN-LAST:event_generalControlsActionPerformed

    private void featurePointPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_featurePointPanelActionPerformed
        rootPanel.setActiveControlPanel(rootPanel.featureControls);
        rootPanel.setActivePicturePanel(rootPanel.featurePointPanel);
    }//GEN-LAST:event_featurePointPanelActionPerformed

    private void sequenceModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sequenceModeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sequenceModeActionPerformed

    private void ImageSelectionControlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImageSelectionControlActionPerformed
        rootPanel.setActiveControlPanel(rootPanel.newProjectPanel);
    }//GEN-LAST:event_ImageSelectionControlActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        //this.rootPanel.picturePanel.DrawImage(rootPanel.picturePanel.lastDrawnImage);
    }//GEN-LAST:event_formComponentResized

    private void jMenuBar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuBar1MouseClicked
        this.rootPanel.picturePanel.DrawImage(rootPanel.picturePanel.lastDrawnImage);
    }//GEN-LAST:event_jMenuBar1MouseClicked

    private void jMenuBar1ComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jMenuBar1ComponentHidden
        this.rootPanel.picturePanel.DrawImage(rootPanel.picturePanel.lastDrawnImage);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuBar1ComponentHidden

    private void testingPanel2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testingPanel2ActionPerformed
        rootPanel.setActiveControlPanel(rootPanel.testingPanel2);
    }//GEN-LAST:event_testingPanel2ActionPerformed

    private void pixelAnalysisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pixelAnalysisActionPerformed
        rootPanel.setActiveControlPanel(rootPanel.pixelAnalyser);
        rootPanel.setActivePicturePanel(rootPanel.featurePointPanel);
    }//GEN-LAST:event_pixelAnalysisActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frame_002.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_002.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_002.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_002.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Frame_002().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ImageSelectionControl;
    private javax.swing.JMenuItem SourceImageMenu;
    private javax.swing.JMenuItem TargetImageMenu;
    private javax.swing.JMenuItem featurePointPanel;
    private javax.swing.JMenuItem generalControls;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem pixelAnalysis;
    private javax.swing.JCheckBoxMenuItem sequenceMode;
    private javax.swing.JMenuItem testingPanel2;
    // End of variables declaration//GEN-END:variables
}
