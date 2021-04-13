package airlineapp.EmployeeManagement;

public class EmployeePaymentGUI extends javax.swing.JPanel { 
    public EmployeePaymentGUI() {
        initComponents();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        JLtitulo = new javax.swing.JLabel();
        JLopciones = new javax.swing.JLabel();
        JBregresar = new javax.swing.JButton();
        JBshow = new javax.swing.JButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        JLtitulo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        JLtitulo.setText("Employee Payment Management");

        JLopciones.setText("Please choose the option you want to do");

        JBregresar.setText("Back");
        JBregresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JBregresarMouseClicked(evt);
            }
        });
        JBregresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBregresarActionPerformed(evt);
            }
        });

        JBshow.setText("Show salary");
        JBshow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JBshowMouseClicked(evt);
            }
        });
        JBshow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBshowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(JLtitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(JBshow)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(JLopciones)
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(JBregresar)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(JLtitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLopciones)
                .addGap(29, 29, 29)
                .addComponent(JBshow)
                .addGap(18, 18, 18)
                .addComponent(JBregresar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JBshowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBshowActionPerformed
        EmployeePayment em = new EmployeePayment();
        em.showSalary();
    }//GEN-LAST:event_JBshowActionPerformed

    private void JBshowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JBshowMouseClicked
        EmployeePayment em = new EmployeePayment();
        em.showSalary();
    }//GEN-LAST:event_JBshowMouseClicked

    private void JBregresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JBregresarMouseClicked
        new AdministratorGUI();
        this.setVisible(false);
    }//GEN-LAST:event_JBregresarMouseClicked

    private void JBregresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBregresarActionPerformed
        new AdministratorGUI();
        this.setVisible(false);
    }//GEN-LAST:event_JBregresarActionPerformed

      public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeManagementGUI().setVisible(true);
            }
        });
      }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBregresar;
    private javax.swing.JButton JBshow;
    private javax.swing.JLabel JLopciones;
    private javax.swing.JLabel JLtitulo;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
