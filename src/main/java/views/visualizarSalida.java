/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import controllers.SalidaController;
import java.util.List;
import models.Salidas;

/**
 *
 * @author arteaga
 */
public class visualizarSalida extends javax.swing.JFrame {

    /**
     * Creates new form visualizarEntrada
     */
    
    
    SalidaController salidaController = new SalidaController();
    public visualizarSalida() {
        initComponents();
        showSalidas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableSalidas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnViewProductos = new javax.swing.JButton();
        btnViewMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        tableSalidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Descripcion", "Cantidad Anterior", "Cantidad Retirada", "Cantidad Actual", "Cliente", "Fecha de Salida"
            }
        ));
        tableSalidas.setEnabled(false);
        tableSalidas.setGridColor(new java.awt.Color(0, 0, 0));
        tableSalidas.setShowGrid(true);
        jScrollPane1.setViewportView(tableSalidas);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel1.setText("Salidas");

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel2.setText("Hola, estas son todas las salidas de materiales:");

        btnViewProductos.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        btnViewProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconMenuProductos.png"))); // NOI18N
        btnViewProductos.setText("PRODUCTOS");
        btnViewProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewProductosActionPerformed(evt);
            }
        });

        btnViewMenu.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        btnViewMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconMenu.png"))); // NOI18N
        btnViewMenu.setText("MENU");
        btnViewMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(435, 435, 435))
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 933, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnViewProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108)
                .addComponent(btnViewMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(198, 198, 198))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnViewMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewProductosActionPerformed
        // TODO add your handling code here:
        mainView mv = new mainView();
        this.setVisible(false);
        mv.setLocationRelativeTo(null);
        mv.setVisible(true);
    }//GEN-LAST:event_btnViewProductosActionPerformed

    private void btnViewMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewMenuActionPerformed
        // TODO add your handling code here:
        menuView mev = new menuView();
        this.setVisible(false);
        mev.setLocationRelativeTo(null);
        mev.setVisible(true);
    }//GEN-LAST:event_btnViewMenuActionPerformed

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
            java.util.logging.Logger.getLogger(visualizarSalida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(visualizarSalida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(visualizarSalida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(visualizarSalida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                visualizarSalida vs = new visualizarSalida();
                vs.setLocationRelativeTo(null);
                vs.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnViewMenu;
    private javax.swing.JButton btnViewProductos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableSalidas;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JTable getTableSalidas() {
        return tableSalidas;
    }
    private void showSalidas() {
        
        List<Salidas> salidas = salidaController.getAllSalidasOrderedById();
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tableSalidas.getModel();
        model.setRowCount(0); // Limpiar la tabla antes de agregar los nuevos datos
        for (Salidas s : salidas) {
            Object[] rowData = new Object[7];
            rowData[0] = s.getIdProduct();
            rowData[1] = s.getDescProduct();
            rowData[2] = s.getStockAnterior();
            rowData[3] = s.getStockRetirado();
            rowData[4] = s.getStockActual();
            rowData[5] = s.getCliente();
            rowData[6] = s.getDateOut(); // Valor inicial para la columna adicional
            model.addRow(rowData);
        }
        
    }
}
