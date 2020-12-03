/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package boundary;

import Control.ProductControl;
import Control.TableCellListener;
import Entity.Product;
import Entity.Warehouse;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ryancavanagh
 */
public class ViewWarehouseQuantity extends javax.swing.JFrame {

    /** Creates new form ViewWarehouseQuantity */
    private Warehouse w;
    public ViewWarehouseQuantity(Warehouse w1) {
        initComponents();
        w = w1;
        warehouseName.setText("All Quantity - Warehouse: " + w.getWarehousename());
        updateTable();
        TableCellListener obs = new TableCellListener(allTable, action);
    }

    private void updateTable (){
        ProductControl pc = Main.Main.controlfactory.getProduct();
        List <Product> list = pc.getAllProductResultSet(w); 
        
        DefaultTableModel model = (DefaultTableModel) allTable.getModel();
//        List<Salesperson> list = lst;
        Object rowData[] = new Object[2];
        for(int i = 0; i < list.size(); i++)
        {
            rowData[0] = list.get(i).getProductPK().getProductname();
            rowData[1] = list.get(i).getQuantity();
            model.addRow(rowData);
        }
//        java.sql.ResultSet rs1 = (java.sql.ResultSet) rs;
//        SalespersonTable.setModel(DbUtils.resultSetToTableModel(rs));
       
    }
    
    Action action = new AbstractAction()
    {
        public void actionPerformed(ActionEvent e)
        {
            TableCellListener tcl = (TableCellListener)e.getSource();
            if (!tcl.getNewValue().equals(tcl.getOldValue())) {
                ProductControl pc = Main.Main.controlfactory.getProduct();
                if (Integer.parseInt(tcl.getNewValue().toString()) < 0){
                    allTable.setValueAt(0, tcl.getRow(), 2);
                    pc.updateQuantity(allTable.getValueAt(tcl.getRow(), 0).toString(), w.getWarehousename(), 0);
                    JOptionPane.showMessageDialog(null, "Quantity must be greater than or equal to 0", "Alert", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    pc.updateQuantity(allTable.getValueAt(tcl.getRow(), 0).toString(), w.getWarehousename(), Integer.parseInt(tcl.getNewValue().toString()));
                }
            }
        }
    };
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        allTable = new javax.swing.JTable();
        saveButton = new javax.swing.JButton();
        warehouseName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        allTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Name", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(allTable);

        saveButton.setText("Save Quantities");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        warehouseName.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(warehouseName))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(saveButton)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(warehouseName)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(saveButton)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
        try {
            allTable.editCellAt(allTable.getEditingRow(), 0);
        }
        catch (Exception e) {
            
        }
        this.setVisible(false);
        new ManageWarehouse(w).setVisible(true);
    }//GEN-LAST:event_saveButtonActionPerformed

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
//            java.util.logging.Logger.getLogger(ViewWarehouseQuantity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ViewWarehouseQuantity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ViewWarehouseQuantity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ViewWarehouseQuantity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ViewWarehouseQuantity().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable allTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel warehouseName;
    // End of variables declaration//GEN-END:variables

}
