/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

/**
 *
 * @author ryancavanagh
 */
public class Manage extends javax.swing.JFrame {

    /**
     * Creates new form Manage
     */
    public Manage() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addCustomerBtn = new javax.swing.JButton();
        editCustomerBtn = new javax.swing.JButton();
        addSalesperson = new javax.swing.JButton();
        editSalesperson = new javax.swing.JButton();
        addWarehouse = new javax.swing.JButton();
        customerLbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addCustomerBtn.setText("Add Customer");
        addCustomerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCustomerBtnActionPerformed(evt);
            }
        });

        editCustomerBtn.setText("Edit Customer");
        editCustomerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCustomerBtnActionPerformed(evt);
            }
        });

        addSalesperson.setText("Add Salesperson");
        addSalesperson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSalespersonActionPerformed(evt);
            }
        });

        editSalesperson.setText("Edit Salesperson");
        editSalesperson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editSalespersonActionPerformed(evt);
            }
        });

        addWarehouse.setText("Add Warehouse");
        addWarehouse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addWarehouseActionPerformed(evt);
            }
        });

        customerLbl.setText("Customers");

        jLabel1.setText("Salesperson");

        jLabel2.setText("Warehouses");

        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(customerLbl)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addSalesperson, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(editSalesperson, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addCustomerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(editCustomerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(112, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addWarehouse, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backBtn)
                        .addGap(22, 22, 22))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(customerLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editCustomerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addCustomerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addSalesperson, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editSalesperson, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addWarehouse, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backBtn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addWarehouseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addWarehouseActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new AddWarehouse().setVisible(true);
    }//GEN-LAST:event_addWarehouseActionPerformed

    private void addCustomerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCustomerBtnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new AddCustomer().setVisible(true);
    }//GEN-LAST:event_addCustomerBtnActionPerformed

    private void editCustomerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCustomerBtnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new EditCustomer().setVisible(true);
    }//GEN-LAST:event_editCustomerBtnActionPerformed

    private void addSalespersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSalespersonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new AddSalesperson().setVisible(true);
    }//GEN-LAST:event_addSalespersonActionPerformed

    private void editSalespersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editSalespersonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new ViewSalesperson().setVisible(true);
    }//GEN-LAST:event_editSalespersonActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new MainMenu().setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Manage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Manage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Manage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Manage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCustomerBtn;
    private javax.swing.JButton addSalesperson;
    private javax.swing.JButton addWarehouse;
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel customerLbl;
    private javax.swing.JButton editCustomerBtn;
    private javax.swing.JButton editSalesperson;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
