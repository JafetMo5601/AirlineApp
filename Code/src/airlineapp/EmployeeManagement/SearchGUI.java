package airlineapp.EmployeeManagement;

import airlineapp.DBHandling.DBManagement;
import airlineapp.Registration.*;
import java.sql.*;
import static airlineapp.DBHandling.DBManagement.workerRetrieve;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SearchGUI extends javax.swing.JFrame {
    public SearchGUI() {
        initComponents();
        this.setTitle("Searching");
        this.setLocationRelativeTo(null);
    }

    public void search(String id) {
        try {
            CallableStatement st = workerRetrieve(id);
            updateTable(this.JTinfo, st);
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    public void updateTable(JTable tbl, CallableStatement st) throws SQLException{
        DefaultTableModel m = (DefaultTableModel) tbl.getModel();
        m.addRow(new Object[]{
            st.getString("out_name"), 
            st.getString("out_last_name"),
            st.getString("out_birthday"),
            st.getString("out_email"),
            st.getString("out_admin_access")});
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        JTinfo = new javax.swing.JTable();
        JLtitle0 = new javax.swing.JLabel();
        JL0 = new javax.swing.JLabel();
        txtWorkerID = new javax.swing.JTextField();
        JBback0 = new javax.swing.JButton();
        JBconfirm = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JTinfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Last name", "Email", "Birthday", "Access"
            }
        ));
        JTinfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTinfoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(JTinfo);

        JLtitle0.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        JLtitle0.setText("Employ Management");

        JL0.setText("Put the id of the worker you want to delete");
        JL0.setName("JL0"); // NOI18N

        txtWorkerID.setText("      Worker ID");
        txtWorkerID.setName("txtWorkerID"); // NOI18N
        txtWorkerID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtWorkerIDMouseClicked(evt);
            }
        });
        txtWorkerID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtWorkerIDActionPerformed(evt);
            }
        });

        JBback0.setText("Back");
        JBback0.setName("JBback0"); // NOI18N
        JBback0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JBback0MouseClicked(evt);
            }
        });
        JBback0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBback0ActionPerformed(evt);
            }
        });

        JBconfirm.setText("Delete");
        JBconfirm.setName("JBconfirm"); // NOI18N
        JBconfirm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JBconfirmMouseClicked(evt);
            }
        });
        JBconfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBconfirmActionPerformed(evt);
            }
        });

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(JLtitle0)
                .addGap(0, 138, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(JBback0, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBconfirm))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtWorkerID, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1))
                            .addComponent(JL0))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JLtitle0, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JL0)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtWorkerID, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBconfirm)
                    .addComponent(JBback0)
                    .addComponent(btnEdit))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBconfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBconfirmActionPerformed
        new DBManagement().deleteWorker(txtWorkerID.getText());
    }//GEN-LAST:event_JBconfirmActionPerformed

    private void JBback0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBback0ActionPerformed
        new NewPerson().goBack();
        this.dispose();
    }//GEN-LAST:event_JBback0ActionPerformed

    private void txtWorkerIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtWorkerIDMouseClicked
        txtWorkerID.setText("");
    }//GEN-LAST:event_txtWorkerIDMouseClicked

    private void txtWorkerIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtWorkerIDActionPerformed

    }//GEN-LAST:event_txtWorkerIDActionPerformed

    private void JTinfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTinfoMouseClicked

    }//GEN-LAST:event_JTinfoMouseClicked

    private void JBback0MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JBback0MouseClicked
        new EmployeeManagementGUI();
        this.dispose();
    }//GEN-LAST:event_JBback0MouseClicked

    private void JBconfirmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JBconfirmMouseClicked
    }//GEN-LAST:event_JBconfirmMouseClicked

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        new EditGUI().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnEditActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.search(txtWorkerID.getText());
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBback0;
    private javax.swing.JButton JBconfirm;
    private javax.swing.JLabel JL0;
    private javax.swing.JLabel JLtitle0;
    private javax.swing.JTable JTinfo;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtWorkerID;
    // End of variables declaration//GEN-END:variables
}
