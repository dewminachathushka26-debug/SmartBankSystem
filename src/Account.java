import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author User
 */
public class Account extends javax.swing.JFrame {

    public Account() {
        initComponents();
        tableLoad();
    }

    @SuppressWarnings("unchecked")
    public void tableLoad() {

        try {

        Connection con = DBConnect.getConnection();

        String sql = "SELECT * FROM accounts";

        PreparedStatement pst = con.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        while (rs.next()) {

            String customerId = rs.getString("customer_id");
            String accountId = rs.getString("account_id");
            String balance = rs.getString("balance");
            String accountType = rs.getString("account_type");

            model.addRow(new Object[]{
                accountId,
                customerId,
                balance,
                accountType
            });
        }

    } catch (Exception e) {

        JOptionPane.showMessageDialog(this, e);

    }
}
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblAccounts = new javax.swing.JLabel();
        lblAccount_ID = new javax.swing.JLabel();
        lblCustomer_ID = new javax.swing.JLabel();
        lblBalance = new javax.swing.JLabel();
        lblAccount_Type = new javax.swing.JLabel();
        tAccount_ID = new javax.swing.JTextField();
        tCustomer_ID = new javax.swing.JTextField();
        tBalance = new javax.swing.JTextField();
        cmbAccount_Type = new javax.swing.JComboBox<>();
        btnAdd = new javax.swing.JButton();
        btnModify = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setForeground(new java.awt.Color(102, 102, 102));

        lblAccounts.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblAccounts.setForeground(new java.awt.Color(0, 51, 51));
        lblAccounts.setText("Accounts");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAccounts, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lblAccounts)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 130, 30));

        lblAccount_ID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblAccount_ID.setForeground(new java.awt.Color(255, 255, 255));
        lblAccount_ID.setText("Account ID");
        jPanel1.add(lblAccount_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 83, 104, -1));

        lblCustomer_ID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCustomer_ID.setForeground(new java.awt.Color(255, 255, 255));
        lblCustomer_ID.setText("Customer ID");
        jPanel1.add(lblCustomer_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 136, 104, -1));

        lblBalance.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblBalance.setForeground(new java.awt.Color(255, 255, 255));
        lblBalance.setText("Balance");
        jPanel1.add(lblBalance, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 189, 104, -1));

        lblAccount_Type.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblAccount_Type.setForeground(new java.awt.Color(255, 255, 255));
        lblAccount_Type.setText("Account Type");
        jPanel1.add(lblAccount_Type, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 242, 124, -1));

        tAccount_ID.setBackground(new java.awt.Color(102, 102, 102));
        tAccount_ID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tAccount_ID.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(tAccount_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 78, 238, -1));

        tCustomer_ID.setBackground(new java.awt.Color(102, 102, 102));
        tCustomer_ID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tCustomer_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tCustomer_IDActionPerformed(evt);
            }
        });
        jPanel1.add(tCustomer_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 131, 238, -1));

        tBalance.setBackground(new java.awt.Color(102, 102, 102));
        tBalance.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(tBalance, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 184, 190, -1));

        cmbAccount_Type.setBackground(new java.awt.Color(102, 102, 102));
        cmbAccount_Type.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbAccount_Type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SAVINGS", "CURRENT", "FIXED" }));
        jPanel1.add(cmbAccount_Type, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 237, 220, -1));

        btnAdd.setBackground(new java.awt.Color(0, 153, 51));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 290, 91, -1));

        btnModify.setBackground(new java.awt.Color(0, 0, 153));
        btnModify.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnModify.setForeground(new java.awt.Color(255, 255, 255));
        btnModify.setText("Modify");
        btnModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyActionPerformed(evt);
            }
        });
        jPanel1.add(btnModify, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 290, 97, -1));

        btnRemove.setBackground(new java.awt.Color(102, 102, 102));
        btnRemove.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnRemove.setForeground(new java.awt.Color(255, 255, 255));
        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });
        jPanel1.add(btnRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, -1, -1));

        btnClear.setBackground(new java.awt.Color(102, 102, 102));
        btnClear.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel1.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(348, 290, 92, -1));

        btnBack.setBackground(new java.awt.Color(153, 153, 153));
        btnBack.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnBack.setForeground(new java.awt.Color(204, 51, 0));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(458, 290, 86, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Accounts.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 590, 360));

        jTable1.setBackground(new java.awt.Color(102, 102, 102));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Account ID", "Customer ID", "Balance", "Account Type"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        
         if (tCustomer_ID.getText().isEmpty()
                || tBalance.getText().isEmpty()) {

            JOptionPane.showMessageDialog(this, "Please Fill All Fields");
            return;
        }
        try {

        Double.parseDouble(tBalance.getText());
        
        Connection con = DBConnect.getConnection();

        String sql = "INSERT INTO accounts(customer_id,balance,account_type) VALUES (?,?,?)";

        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, tCustomer_ID.getText());
        pst.setString(2, tBalance.getText());
        pst.setString(3, cmbAccount_Type.getSelectedItem().toString());

        pst.executeUpdate();
        
        tableLoad();

        JOptionPane.showMessageDialog(this, "Account Added Successfully!");

    }catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(this, "Balance Must Be Numeric");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, e);

        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyActionPerformed
        
        if (tAccount_ID.getText().isEmpty()) {

            JOptionPane.showMessageDialog(this, "Enter Account ID");
            return;
        }
         try {

        Connection con = DBConnect.getConnection();

        String sql = "UPDATE accounts SET customer_id=?, balance=?, account_type=? WHERE account_id=?";

        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, tCustomer_ID.getText());
        pst.setString(2, tBalance.getText());
        pst.setString(3, cmbAccount_Type.getSelectedItem().toString());
        pst.setString(4, tAccount_ID.getText());

        pst.executeUpdate();
        
        tableLoad();

        JOptionPane.showMessageDialog(this, "Account Updated Successfully!");

    } catch (Exception e) {

        JOptionPane.showMessageDialog(this, e);

    }
    }//GEN-LAST:event_btnModifyActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        
        if (tAccount_ID.getText().isEmpty()) {

            JOptionPane.showMessageDialog(this, "Enter Account ID");
            return;
        }

         try {

        Connection con = DBConnect.getConnection();

        String sql = "DELETE FROM accounts WHERE account_id=?";

        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, tAccount_ID.getText());

        pst.executeUpdate();
        
        tableLoad();

        JOptionPane.showMessageDialog(this, "Account Removed Successfully!");

    } catch (Exception e) {

        JOptionPane.showMessageDialog(this, e);

    }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        
        tAccount_ID.setText("");
        tCustomer_ID.setText("");
        tBalance.setText("");
        cmbAccount_Type.setSelectedIndex(0);
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        
        Dashboard dashboard = new Dashboard();
        dashboard.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void tCustomer_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tCustomer_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tCustomer_IDActionPerformed

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
            java.util.logging.Logger.getLogger(Account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Account().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnModify;
    private javax.swing.JButton btnRemove;
    private javax.swing.JComboBox<String> cmbAccount_Type;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblAccount_ID;
    private javax.swing.JLabel lblAccount_Type;
    private javax.swing.JLabel lblAccounts;
    private javax.swing.JLabel lblBalance;
    private javax.swing.JLabel lblCustomer_ID;
    private javax.swing.JTextField tAccount_ID;
    private javax.swing.JTextField tBalance;
    private javax.swing.JTextField tCustomer_ID;
    // End of variables declaration//GEN-END:variables
}
