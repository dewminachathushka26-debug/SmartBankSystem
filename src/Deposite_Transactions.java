import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author User
 */
public class Deposite_Transactions extends javax.swing.JFrame {


    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public Deposite_Transactions() {
        initComponents();
        connect();
        tableLoad();
    }
    public void tableLoad() {

    try {

        String sql = "SELECT * FROM deposit_transactions";

        pst = con.prepareStatement(sql);

        rs = pst.executeQuery();

        javax.swing.table.DefaultTableModel model =
                (javax.swing.table.DefaultTableModel) jTable1.getModel();

        model.setRowCount(0);

        while (rs.next()) {

            model.addRow(new Object[]{

                rs.getString("deposit_id"),
                rs.getString("transaction_type"),
                rs.getString("transaction_amount"),
                rs.getString("transaction_date"),
                rs.getString("reference_no")

            });
        }

    } catch (Exception e) {

        JOptionPane.showMessageDialog(this, e);
    }
}

    @SuppressWarnings("unchecked")
    public void connect() {

    try {

        Class.forName("com.mysql.cj.jdbc.Driver");

        con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/fixed_deposit_system",
                "root",
                "dc12345"
        );

    } catch (Exception e) {

        JOptionPane.showMessageDialog(this, e);
    }
}
     public void clearFields() {

        tDeposit_ID.setText("");
        tAmount.setText("");
        tTransaction_Date.setText("YYYY-MM-DD");
        tReference_No.setText("");

        cmbTransaction_Type.setSelectedIndex(0);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblDeposit_Transaction = new javax.swing.JLabel();
        lblDeposit_ID = new javax.swing.JLabel();
        lblTransaction_Type = new javax.swing.JLabel();
        lblAmount = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblReference_No = new javax.swing.JLabel();
        tDeposit_ID = new javax.swing.JTextField();
        tAmount = new javax.swing.JTextField();
        tTransaction_Date = new javax.swing.JTextField();
        tReference_No = new javax.swing.JTextField();
        cmbTransaction_Type = new javax.swing.JComboBox<>();
        btnAdd = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnModify = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        lblDeposit_Transaction.setBackground(new java.awt.Color(102, 102, 102));
        lblDeposit_Transaction.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblDeposit_Transaction.setForeground(new java.awt.Color(0, 51, 51));
        lblDeposit_Transaction.setText("Deposit Transaction");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 15, Short.MAX_VALUE)
                .addComponent(lblDeposit_Transaction))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lblDeposit_Transaction, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 240, 40));

        lblDeposit_ID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblDeposit_ID.setForeground(new java.awt.Color(255, 255, 255));
        lblDeposit_ID.setText("Deposit ID");
        jPanel1.add(lblDeposit_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 103, -1, -1));

        lblTransaction_Type.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTransaction_Type.setForeground(new java.awt.Color(255, 255, 255));
        lblTransaction_Type.setText("Transaction Type");
        jPanel1.add(lblTransaction_Type, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 156, -1, -1));

        lblAmount.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblAmount.setForeground(new java.awt.Color(255, 255, 255));
        lblAmount.setText("Amount");
        jPanel1.add(lblAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 209, 73, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Transaction Date ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 257, -1, -1));

        lblReference_No.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblReference_No.setForeground(new java.awt.Color(255, 255, 255));
        lblReference_No.setText("Reference No");
        jPanel1.add(lblReference_No, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 310, -1, -1));

        tDeposit_ID.setBackground(new java.awt.Color(102, 102, 102));
        tDeposit_ID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(tDeposit_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 98, 165, -1));

        tAmount.setBackground(new java.awt.Color(102, 102, 102));
        tAmount.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(tAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 204, 189, -1));

        tTransaction_Date.setBackground(new java.awt.Color(102, 102, 102));
        tTransaction_Date.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(tTransaction_Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 252, 200, -1));

        tReference_No.setBackground(new java.awt.Color(102, 102, 102));
        tReference_No.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(tReference_No, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 305, 96, -1));

        cmbTransaction_Type.setBackground(new java.awt.Color(102, 102, 102));
        cmbTransaction_Type.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbTransaction_Type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DEPOSIT", "WITHDRAWAL", "INTEREST", "PENALTY" }));
        jPanel1.add(cmbTransaction_Type, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 151, 189, -1));

        btnAdd.setBackground(new java.awt.Color(0, 153, 0));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 360, 80, -1));

        btnBack.setBackground(new java.awt.Color(153, 153, 153));
        btnBack.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnBack.setForeground(new java.awt.Color(204, 51, 0));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(401, 358, -1, -1));

        btnClear.setBackground(new java.awt.Color(102, 102, 102));
        btnClear.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel1.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 358, -1, -1));

        btnRemove.setBackground(new java.awt.Color(102, 102, 102));
        btnRemove.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnRemove.setForeground(new java.awt.Color(255, 255, 255));
        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });
        jPanel1.add(btnRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 358, -1, -1));

        btnModify.setBackground(new java.awt.Color(0, 0, 153));
        btnModify.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnModify.setForeground(new java.awt.Color(255, 255, 255));
        btnModify.setText("Modify");
        btnModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyActionPerformed(evt);
            }
        });
        jPanel1.add(btnModify, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 358, -1, -1));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DepositeTransaction.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 440));

        jTable1.setBackground(new java.awt.Color(102, 102, 102));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Deposit ID", "Transaction Type", "Amount", "Transaction Date", "Reference No"
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        
    String depositID  = tDeposit_ID.getText().trim();
    String transType  = cmbTransaction_Type.getSelectedItem().toString();
    String amount     = tAmount.getText().trim();
    String date       = tTransaction_Date.getText().trim();
    String refNo      = tReference_No.getText().trim();

    if (depositID.equals("") || amount.equals("") || date.equals("YYYY-MM-DD")) {

        JOptionPane.showMessageDialog(this,
                "Please fill all fields!");

        return;
    }

    try {

        String sql =
                "INSERT INTO deposit_transactions " +
                "(deposit_id, transaction_type, transaction_amount, transaction_date, reference_no) " +
                "VALUES (?, ?, ?, ?, ?)";

        pst = con.prepareStatement(sql);

        pst.setInt(1, Integer.parseInt(depositID));
        pst.setString(2, transType);
        pst.setDouble(3, Double.parseDouble(amount));
        pst.setString(4, date);
        pst.setString(5, refNo);

        pst.executeUpdate();
        
        tableLoad();

        JOptionPane.showMessageDialog(this,
                "Transaction added successfully!");

        clearFields();

    } catch (Exception ex) {

        JOptionPane.showMessageDialog(this,
                "Error: " + ex.getMessage());
    }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyActionPerformed


    String depositID = tDeposit_ID.getText().trim();

    if (depositID.equals("")) {

        JOptionPane.showMessageDialog(this,
                "Please enter Deposit ID to update!");

        return;
    }

    try {

        String sql =
                "UPDATE deposit_transactions SET " +
                "transaction_type=?, " +
                "transaction_amount=?, " +
                "transaction_date=?, " +
                "reference_no=? " +
                "WHERE deposit_id=?";

        pst = con.prepareStatement(sql);

        pst.setString(1,
                cmbTransaction_Type.getSelectedItem().toString());

        pst.setDouble(2,
                Double.parseDouble(tAmount.getText().trim()));

        pst.setString(3,
                tTransaction_Date.getText().trim());

        pst.setString(4,
                tReference_No.getText().trim());

        pst.setInt(5,
                Integer.parseInt(depositID));

        int rows = pst.executeUpdate();

        if (rows > 0) {

            JOptionPane.showMessageDialog(this,
                    "Transaction updated successfully!");

        } else {

            JOptionPane.showMessageDialog(this,
                    "Deposit ID not found!");
        }

        clearFields();

    } catch (Exception ex) {

        JOptionPane.showMessageDialog(this,
                "Error: " + ex.getMessage());
    }
    }//GEN-LAST:event_btnModifyActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        
        String depositID = tDeposit_ID.getText().trim();

    if (depositID.equals("")) {

        JOptionPane.showMessageDialog(this,
                "Please enter Deposit ID to delete!");

        return;
    }

    int confirm = JOptionPane.showConfirmDialog(
            this,
            "Are you sure you want to delete?",
            "Confirm",
            JOptionPane.YES_NO_OPTION
    );

    if (confirm == JOptionPane.YES_OPTION) {

        try {

            String sql =
                    "DELETE FROM deposit_transactions " +
                    "WHERE deposit_id=?";

            pst = con.prepareStatement(sql);

            pst.setInt(1,
                    Integer.parseInt(depositID));

            int rows = pst.executeUpdate();
            
            tableLoad();
            
            tableLoad();

            if (rows > 0) {

                JOptionPane.showMessageDialog(this,
                        "Transaction deleted successfully!");

            } else {

                JOptionPane.showMessageDialog(this,
                        "Deposit ID not found!");
            }

            clearFields();

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(this,
                    "Error: " + ex.getMessage());
        }
    }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        
        tDeposit_ID.setText("");
        tAmount.setText("");
        tTransaction_Date.setText("YYYY-MM-DD");
        tReference_No.setText("");

        cmbTransaction_Type.setSelectedIndex(0);
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        
        Dashboard dashboard = new Dashboard();
        dashboard.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(Deposite_Transactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Deposite_Transactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Deposite_Transactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Deposite_Transactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Deposite_Transactions().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnModify;
    private javax.swing.JButton btnRemove;
    private javax.swing.JComboBox<String> cmbTransaction_Type;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblAmount;
    private javax.swing.JLabel lblDeposit_ID;
    private javax.swing.JLabel lblDeposit_Transaction;
    private javax.swing.JLabel lblReference_No;
    private javax.swing.JLabel lblTransaction_Type;
    private javax.swing.JTextField tAmount;
    private javax.swing.JTextField tDeposit_ID;
    private javax.swing.JTextField tReference_No;
    private javax.swing.JTextField tTransaction_Date;
    // End of variables declaration//GEN-END:variables
}
