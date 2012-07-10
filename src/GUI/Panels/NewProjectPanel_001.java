/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Panels;

import javax.swing.JFileChooser;

/**
 *
 * @author power
 */
public class NewProjectPanel_001 extends AbstractControlPanel {

    /**
     * Creates new form NewProjectPanel_001
     */
    
    
    JFileChooser fcSource=new JFileChooser();
    JFileChooser fcTarget=new JFileChooser();
    
    String sourcePath=null;
    String targetPath=null;
    
    public NewProjectPanel_001() {
        initComponents();
        this.Next.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sourceSelectionButton = new javax.swing.JButton();
        targetSelectionButton = new javax.swing.JButton();
        Next = new javax.swing.JButton();

        sourceSelectionButton.setText("SourceImage");
        sourceSelectionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sourceSelectionButtonActionPerformed(evt);
            }
        });

        targetSelectionButton.setText("TargetImage");
        targetSelectionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                targetSelectionButtonActionPerformed(evt);
            }
        });

        Next.setText("Next");
        Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sourceSelectionButton)
                    .addComponent(targetSelectionButton)
                    .addComponent(Next))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sourceSelectionButton)
                .addGap(18, 18, 18)
                .addComponent(targetSelectionButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 191, Short.MAX_VALUE)
                .addComponent(Next)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void targetSelectionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_targetSelectionButtonActionPerformed
        //target Image 
        fcTarget.showDialog(this, "choose Target File");
        targetPath=fcTarget.getSelectedFile().getAbsolutePath();
        //parent.targetImagePath=targetPath;
        try{
            parent.setTargetPath(targetPath);
//            parent.drawImage(targetPath);
            if(fcSource.getSelectedFile()!=null)
            if(fcSource.getSelectedFile().isFile() && fcTarget.getSelectedFile().isFile()){
                this.Next.setEnabled(true);
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }//GEN-LAST:event_targetSelectionButtonActionPerformed

    private void sourceSelectionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sourceSelectionButtonActionPerformed
        //source Image
        fcSource.showDialog(this, "choose Source File");
        sourcePath=fcSource.getSelectedFile().getAbsolutePath();
        //parent.sourceImagePath=sourcePath;
        
        try{
            parent.setSourcePath(sourcePath);
//            System.out.println("printing");
//            parent.drawImage(sourcePath);
            if(fcTarget.getSelectedFile()!=null)
            if(fcSource.getSelectedFile().isFile() && fcTarget.getSelectedFile().isFile()){
                this.Next.setEnabled(true);
            }
            
        }catch(Exception e){
            System.out.println("throwing exception "+e.getMessage());
        }
    }//GEN-LAST:event_sourceSelectionButtonActionPerformed

    private void NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextActionPerformed
//        parent.sourceImagePath=sourcePath;
//        parent.targetImagePath=targetPath;
        parent.remove(parent.controlPanel);
        parent.controlPanel=parent.generalControls;
        parent.add(parent.controlPanel);
        parent.revalidate();
    }//GEN-LAST:event_NextActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Next;
    private javax.swing.JButton sourceSelectionButton;
    private javax.swing.JButton targetSelectionButton;
    // End of variables declaration//GEN-END:variables
}