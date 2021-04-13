package airlineapp.EmployeeManagement;

public class EmployeeManagementGUI extends javax.swing.JPanel {

    public EmployeeManagementGUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        JLtitulo = new javax.swing.JLabel();
        JLopciones = new javax.swing.JLabel();
        JBcrear = new javax.swing.JButton();
        JBedi = new javax.swing.JButton();
        JBelim = new javax.swing.JButton();
        JBregresar = new javax.swing.JButton();

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        JLtitulo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        JLtitulo.setText("Employ Management");

        JLopciones.setText("Please choose the option you want to do");

        JBcrear.setText("Search Worker");
        JBcrear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JBcrearMouseClicked(evt);
            }
        });
        JBcrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBcrearActionPerformed(evt);
            }
        });

        JBedi.setText("Edit Worker");
        JBedi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JBediMouseClicked(evt);
            }
        });
        JBedi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBediActionPerformed(evt);
            }
        });

        JBelim.setText("Delete Worker");
        JBelim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JBelimMouseClicked(evt);
            }
        });
        JBelim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBelimActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(JBregresar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(JBcrear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBedi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBelim)
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(JLtitulo)
                        .addGap(78, 78, 78))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(JLopciones)
                        .addGap(57, 57, 57))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(JLtitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLopciones)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBelim)
                    .addComponent(JBcrear)
                    .addComponent(JBedi))
                .addGap(46, 46, 46)
                .addComponent(JBregresar)
                .addContainerGap(15, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JBediActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBediActionPerformed
        new SearchGUI().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_JBediActionPerformed

    private void JBcrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBcrearActionPerformed
        new SearchGUI().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_JBcrearActionPerformed

    private void JBcrearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JBcrearMouseClicked
        new SearchGUI().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_JBcrearMouseClicked

    private void JBregresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JBregresarMouseClicked
        new AdministratorGUI().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_JBregresarMouseClicked

    private void JBediMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JBediMouseClicked
        new SearchGUI().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_JBediMouseClicked

    private void JBelimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JBelimMouseClicked
        new SearchGUI().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_JBelimMouseClicked

    private void JBelimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBelimActionPerformed
        new SearchGUI().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_JBelimActionPerformed

    private void JBregresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBregresarActionPerformed
        new AdministratorGUI().setVisible(true);
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
    private javax.swing.JButton JBcrear;
    private javax.swing.JButton JBedi;
    private javax.swing.JButton JBelim;
    private javax.swing.JButton JBregresar;
    private javax.swing.JLabel JLopciones;
    private javax.swing.JLabel JLtitulo;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
