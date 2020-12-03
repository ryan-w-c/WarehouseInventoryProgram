/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import Control.TableCellListener;
import Control.OrderItemControl;
import Control.ProductControl;
import Entity.Orderitem;
import static Main.Main.controlfactory;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author minkyaw
 */
public class EditInvoiceBalance extends javax.swing.JFrame {

    /**
     * Creates new form EditInvoiceBalance
     */
    private int invID;
    public EditInvoiceBalance(int invID1) {
        invID = invID1;
        initComponents();
        invoiceID.setText("InvoiceID: " + invID);
        updateTable();
        TableCellListener obs = new TableCellListener(InvoiceBalanceTable, action);
    }
    
    private void updateTable (){
        OrderItemControl oc = Main.Main.controlfactory.getOrderItem();
        List <Orderitem> list = oc.getAllOrderItemResultSet(invID);
        
        DefaultTableModel model = (DefaultTableModel) InvoiceBalanceTable.getModel();
        Object rowData[] = new Object[3];
        for(int i = 0; i < list.size(); i++)
        {
            rowData[0] = list.get(i).getInvoice().getInvoiceid();
            rowData[1] = list.get(i).getProduct();
            rowData[2] = list.get(i).getProduct().getWarehouse().getWarehousename();
            rowData[3] = list.get(i).getQuantity();
            model.addRow(rowData);
        }
    }
    
    Action action = new AbstractAction()
    {
        public void actionPerformed(ActionEvent e)
        {
            TableCellListener tcl = (TableCellListener)e.getSource();
            if (!tcl.getNewValue().equals(tcl.getOldValue())) {
                OrderItemControl oc = Main.Main.controlfactory.getOrderItem();
                if (Integer.parseInt(tcl.getNewValue().toString()) < 0){
                    InvoiceBalanceTable.setValueAt(0, tcl.getRow(), 2);
                    oc.updateQuantity(invID, InvoiceBalanceTable.getValueAt(tcl.getRow(), 1).toString(), InvoiceBalanceTable.getValueAt(tcl.getRow(), 2).toString(), 0);
                    JOptionPane.showMessageDialog(null, "Quantity must be greater than or equal to 0", "Alert", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    oc.updateQuantity(invID, InvoiceBalanceTable.getValueAt(tcl.getRow(), 1).toString(), InvoiceBalanceTable.getValueAt(tcl.getRow(), 2).toString(), Integer.parseInt(tcl.getNewValue().toString()));
                }
            }
        }
    };
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        InvoiceBalanceTable = new javax.swing.JTable();
        updateBalance = new javax.swing.JButton();
        invoiceID = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        InvoiceBalanceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Invoice ID", "Product Name", "Warehouse Name", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(InvoiceBalanceTable);

        updateBalance.setText("Update Balance");
        updateBalance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBalanceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(invoiceID)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(updateBalance)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(backButton))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(invoiceID)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(updateBalance))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new OpenInvoices().setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    private void updateBalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBalanceActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new Invoices().setVisible(true);
    }//GEN-LAST:event_updateBalanceActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(EditInvoiceBalance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(EditInvoiceBalance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(EditInvoiceBalance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(EditInvoiceBalance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new EditInvoiceBalance().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable InvoiceBalanceTable;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel invoiceID;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton updateBalance;
    // End of variables declaration//GEN-END:variables
}
