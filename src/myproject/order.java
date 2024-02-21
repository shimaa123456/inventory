
package myproject;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class order extends javax.swing.JFrame {

   
    public order() {
        initComponents();
        SelectProd();
        SelectCust();
        GetToday();
    }
  Connection Con = null;
    Statement St = null;
    ResultSet Rs = null;
    
   public void SelectProd(){
        try{
             Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventorydb" ,"root" , "");
             St = Con.createStatement();
             Rs = St.executeQuery("select * from PRODUCTTBL");
             ProductTable.setModel(MyUtils.resultSetTableModel(Rs));
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
         public void SelectCust(){
        try{
             Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventorydb" ,"root" , "");
             St = Con.createStatement();
             Rs = St.executeQuery("select * from CUSTOMERTBL");
             CustomerTbl.setModel(MyUtils.resultSetTableModel(Rs));
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
         private void GetToday(){
             DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
             LocalDateTime now = LocalDateTime.now();
             datelbl.setText(dtf.format(now));
         }
         private void update(){
      int newqty = oldqty - Integer.valueOf(Qtytb1.getText());
            try{
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventorydb" ,"root" , "");
                String UpdateQuery = "update PRODUCTTBL set PRODQTY = '"+Qtytb1.getText()+"'"+"where ProdId ="+productid;
                Statement Add = Con.createStatement();
                Add.executeUpdate(UpdateQuery);
              
                SelectProd();

            }
            catch(Exception e){
                e.printStackTrace();
            }
        
         }
 //  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AddBtn = new javax.swing.JButton();
        Qtytb = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        price = new javax.swing.JTextField();
        AddToBtn1 = new javax.swing.JButton();
        TotAmtbi = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        BillTbl = new javax.swing.JTable();
        AddToBtn = new javax.swing.JButton();
        TotAmtbi1 = new javax.swing.JLabel();
        customername = new javax.swing.JLabel();
        nameib = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Billid = new javax.swing.JTextField();
        dateib = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        CustomerTbl = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ProductTable = new javax.swing.JTable();
        AddBtn1 = new javax.swing.JButton();
        Qtytb1 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        price1 = new javax.swing.JTextField();
        AddToBtn2 = new javax.swing.JButton();
        amount = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        OrderTbl = new javax.swing.JTable();
        AddToBtn3 = new javax.swing.JButton();
        TotAmtbi3 = new javax.swing.JLabel();
        customername1 = new javax.swing.JLabel();
        customerNameLbl = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        OrderId = new javax.swing.JTextField();
        datelbl = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        AddBtn.setBackground(new java.awt.Color(204, 0, 51));
        AddBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AddBtn.setText("Add to order");
        AddBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddBtnMouseClicked(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(204, 0, 51));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("View Order");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 0, 51));
        jLabel6.setText("Price");

        jButton3.setBackground(new java.awt.Color(204, 0, 51));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setText("Home");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        AddToBtn1.setBackground(new java.awt.Color(204, 0, 51));
        AddToBtn1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AddToBtn1.setText("Print");
        AddToBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddToBtn1MouseClicked(evt);
            }
        });
        AddToBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddToBtn1ActionPerformed(evt);
            }
        });

        TotAmtbi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TotAmtbi.setForeground(new java.awt.Color(255, 51, 51));
        TotAmtbi.setText("Amount");
        TotAmtbi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TotAmtbiMouseClicked(evt);
            }
        });

        BillTbl.setBackground(new java.awt.Color(204, 204, 204));
        BillTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Num", "Product", "Quantity", "UPrice", "Total"
            }
        ));
        jScrollPane3.setViewportView(BillTbl);

        AddToBtn.setBackground(new java.awt.Color(204, 0, 51));
        AddToBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AddToBtn.setText("Add to order");
        AddToBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddToBtnMouseClicked(evt);
            }
        });
        AddToBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddToBtnActionPerformed(evt);
            }
        });

        TotAmtbi1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TotAmtbi1.setForeground(new java.awt.Color(255, 51, 51));
        TotAmtbi1.setText("Rs");
        TotAmtbi1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TotAmtbi1MouseClicked(evt);
            }
        });

        customername.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        customername.setForeground(new java.awt.Color(204, 0, 51));
        customername.setText("Customer Name");

        nameib.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nameib.setForeground(new java.awt.Color(255, 51, 51));
        nameib.setText("cusname");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 0, 51));
        jLabel8.setText("Order ID");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 0, 51));
        jLabel5.setText("Date");

        Billid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BillidActionPerformed(evt);
            }
        });

        dateib.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        dateib.setForeground(new java.awt.Color(255, 51, 51));
        dateib.setText("date");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 0, 51));
        jLabel7.setText("Quantity");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 0, 51));
        jLabel4.setText("Customer List");

        CustomerTbl.setBackground(new java.awt.Color(204, 204, 204));
        CustomerTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "CUSTID", "CUSTNAME", "CUSTPHONE"
            }
        ));
        CustomerTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CustomerTblMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(CustomerTbl);

        jLabel3.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 0, 51));
        jLabel3.setText("Product List");

        ProductTable.setBackground(new java.awt.Color(204, 204, 204));
        ProductTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "PRODID", "PRODNAME", "PRODQTY", "PRODESC", "PRODCAT"
            }
        ));
        ProductTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProductTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ProductTable);

        AddBtn1.setBackground(new java.awt.Color(204, 0, 51));
        AddBtn1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AddBtn1.setText("Add to order");
        AddBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddBtn1MouseClicked(evt);
            }
        });
        AddBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBtn1ActionPerformed(evt);
            }
        });

        Qtytb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Qtytb1ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(204, 0, 51));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setText("View Order");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 0, 51));
        jLabel9.setText("Price");

        jButton5.setBackground(new java.awt.Color(204, 0, 51));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton5.setText("Home");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        price1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                price1ActionPerformed(evt);
            }
        });

        AddToBtn2.setBackground(new java.awt.Color(204, 0, 51));
        AddToBtn2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AddToBtn2.setText("Print");
        AddToBtn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddToBtn2MouseClicked(evt);
            }
        });
        AddToBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddToBtn2ActionPerformed(evt);
            }
        });

        amount.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        amount.setForeground(new java.awt.Color(255, 51, 51));
        amount.setText("Amount");
        amount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                amountMouseClicked(evt);
            }
        });

        OrderTbl.setBackground(new java.awt.Color(204, 204, 204));
        OrderTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Num", "Product", "Quantity", "UPrice", "Total"
            }
        ));
        OrderTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OrderTblMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(OrderTbl);

        AddToBtn3.setBackground(new java.awt.Color(204, 0, 51));
        AddToBtn3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AddToBtn3.setText("Add to order");
        AddToBtn3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddToBtn3MouseClicked(evt);
            }
        });
        AddToBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddToBtn3ActionPerformed(evt);
            }
        });

        TotAmtbi3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TotAmtbi3.setForeground(new java.awt.Color(255, 51, 51));
        TotAmtbi3.setText("Rs");
        TotAmtbi3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TotAmtbi3MouseClicked(evt);
            }
        });

        customername1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        customername1.setForeground(new java.awt.Color(204, 0, 51));
        customername1.setText("Customer Name");

        customerNameLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        customerNameLbl.setForeground(new java.awt.Color(255, 51, 51));
        customerNameLbl.setText("cusname");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 0, 51));
        jLabel10.setText("Order ID");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 0, 51));
        jLabel11.setText("Date");

        OrderId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderIdActionPerformed(evt);
            }
        });

        datelbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        datelbl.setForeground(new java.awt.Color(255, 51, 51));
        datelbl.setText("date");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 0, 51));
        jLabel12.setText("Quantity");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(140, 140, 140)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(OrderId, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel12)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Qtytb1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(38, 38, 38)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(price1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(AddToBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(AddBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(84, 84, 84)
                                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(customername1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(29, 29, 29)
                                            .addComponent(customerNameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(588, 588, 588))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(86, 86, 86)
                                    .addComponent(datelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(180, 180, 180)
                        .addComponent(TotAmtbi3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(AddToBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 12, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(401, 401, 401)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(OrderId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Qtytb1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel9)
                    .addComponent(price1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddToBtn3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(customername1)
                                    .addComponent(customerNameLbl))
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(datelbl))
                                .addGap(39, 39, 39)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(AddBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(75, 75, 75))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TotAmtbi3)
                                    .addComponent(amount))))
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(AddToBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))))
        );

        jPanel2.setBackground(new java.awt.Color(255, 0, 0));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Inventory Managment System  ");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("MANAGE    ORDERS");

        jLabel14.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("X");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(392, 392, 392)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(353, 353, 353)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(17, 17, 17))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CustomerTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CustomerTblMouseClicked
        DefaultTableModel model = (DefaultTableModel)CustomerTbl.getModel();
        int Myindex = CustomerTbl.getSelectedRow();
       // CustId.setText(model.getValueAt(Myindex,0).toString());
        customerNameLbl.setText(model.getValueAt(Myindex,1).toString());
      //  CustPhone.setText(model.getValueAt(Myindex,2).toString());
    }//GEN-LAST:event_CustomerTblMouseClicked
String Prodname;
int flag=0,productid,oldqty;
    private void ProductTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductTableMouseClicked
        DefaultTableModel model=(DefaultTableModel)ProductTable.getModel();
        int Myindex=ProductTable.getSelectedRow();
        productid =Integer.valueOf(model.getValueAt(Myindex,0).toString());
       // OrderId.setText(model.getValueAt(Myindex,0).toString());
       // OrderId= Integer.valueOf(model.getValueAt(Myindex,0).toString());
        Prodname=model.getValueAt(Myindex,1).toString();
        oldqty=Integer.valueOf(model.getValueAt(Myindex, 2).toString());
        flag=1;
        update();
    }//GEN-LAST:event_ProductTableMouseClicked

    private void AddBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddBtnMouseClicked

     if(OrderId.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Enter the order id");
        }else{
            try{

        Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventorydb" ,"root" , "");
        PreparedStatement add = Con.prepareStatement("insert into ORDERTBL values(?,?,?,?)");
        add.setInt(1, Integer.valueOf(OrderId.getText()));
        add.setString(2, customerNameLbl.getText());
        add.setString(3, datelbl.getText());
       add.setInt(4, Integer.valueOf(amount.getText()));

       int row = add.executeUpdate();
                JOptionPane.showMessageDialog(this, "order successfully added");
                Con.close();
                SelectProd();
            }
            catch(SQLException e)
            {
                e.printStackTrace();}}
            
    }//GEN-LAST:event_AddBtnMouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        new homeform().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void AddToBtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddToBtn1MouseClicked
//        try{
//            BillTbl.print();
//        }catch(Exception exp){
//            exp.printStackTrace();
//        }
    }//GEN-LAST:event_AddToBtn1MouseClicked

    private void AddToBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddToBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddToBtn1ActionPerformed

    private void TotAmtbiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TotAmtbiMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TotAmtbiMouseClicked

    private void AddToBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddToBtnMouseClicked
//        if(flag==0||Qtytb.getText().isEmpty()||price.getText().isEmpty()){
//            JOptionPane.showMessageDialog(this, "select product and enter qty");
//
//        }
//        else{
//            Uprice=Integer.valueOf(price.getText());
//            tot=Uprice*Integer.valueOf(Qtytb.getText());
//            Vector v=new Vector();
//            v.add(i);
//            v.add(Prodname);
//            v.add(Qtytb.getText());
//            v.add(Uprice);
//            v.add(tot);
//            DefaultTableModel dt=( DefaultTableModel)BillTbl.getModel();
//            dt.addRow(v);
//            total=tot+total;
//            TotAmtbi.setText(""+total);
//            Update();
//            i++;
//
//        }
    }//GEN-LAST:event_AddToBtnMouseClicked

    private void AddToBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddToBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddToBtnActionPerformed

    private void TotAmtbi1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TotAmtbi1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TotAmtbi1MouseClicked

    private void BillidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BillidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BillidActionPerformed

    private void AddBtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddBtn1MouseClicked
    if(OrderId.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Enter the order id");
        }else{
            try{

        Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventorydb" ,"root" , "");
        PreparedStatement add = Con.prepareStatement("insert into ORDERTBL values(?,?,?,?)");
        add.setInt(1, Integer.valueOf(OrderId.getText()));
        add.setString(2, customerNameLbl.getText());
        add.setString(3, datelbl.getText());
       add.setInt(4, Integer.valueOf(amount.getText()));

       int row = add.executeUpdate();
                JOptionPane.showMessageDialog(this, "order successfully added");
                Con.close();
                SelectProd();
            }
            catch(SQLException e)
            {
                e.printStackTrace();}}
    }//GEN-LAST:event_AddBtn1MouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        new homeform().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void AddToBtn2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddToBtn2MouseClicked
        try{
            OrderTbl.print();
        }catch(Exception exp){
            exp.printStackTrace();
        }
    }//GEN-LAST:event_AddToBtn2MouseClicked

    private void AddToBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddToBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddToBtn2ActionPerformed

    private void amountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_amountMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_amountMouseClicked
int i=1;
String prodname;
int Uprice,tot=0,total;
    private void AddToBtn3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddToBtn3MouseClicked
        if(flag==0||Qtytb1.getText().isEmpty()||price1.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "select product and enter qty");

        }
        else{
            Uprice=Integer.valueOf(price1.getText());
            tot=Uprice * Integer.valueOf(Qtytb1.getText());
            Vector v=new Vector();
            v.add(i);
            v.add(Prodname);
            v.add(Qtytb1.getText());
            v.add(Uprice);
            v.add(tot);
            DefaultTableModel dt=( DefaultTableModel)OrderTbl.getModel();
            dt.addRow(v);
            total=total+tot;
            amount.setText(""+total);
            update();
            i++;

        }
    }//GEN-LAST:event_AddToBtn3MouseClicked

    private void AddToBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddToBtn3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddToBtn3ActionPerformed

    private void TotAmtbi3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TotAmtbi3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TotAmtbi3MouseClicked

    private void OrderIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OrderIdActionPerformed

    private void AddBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddBtn1ActionPerformed

    private void Qtytb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Qtytb1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Qtytb1ActionPerformed

    private void price1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_price1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_price1ActionPerformed

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        System.exit(0);  
    }//GEN-LAST:event_jLabel14MouseClicked

    private void OrderTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrderTblMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_OrderTblMouseClicked

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new order().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtn;
    private javax.swing.JButton AddBtn1;
    private javax.swing.JButton AddToBtn;
    private javax.swing.JButton AddToBtn1;
    private javax.swing.JButton AddToBtn2;
    private javax.swing.JButton AddToBtn3;
    private javax.swing.JTable BillTbl;
    private javax.swing.JTextField Billid;
    private javax.swing.JTable CustomerTbl;
    private javax.swing.JTextField OrderId;
    private javax.swing.JTable OrderTbl;
    private javax.swing.JTable ProductTable;
    private javax.swing.JTextField Qtytb;
    private javax.swing.JTextField Qtytb1;
    private javax.swing.JLabel TotAmtbi;
    private javax.swing.JLabel TotAmtbi1;
    private javax.swing.JLabel TotAmtbi3;
    private javax.swing.JLabel amount;
    private javax.swing.JLabel customerNameLbl;
    private javax.swing.JLabel customername;
    private javax.swing.JLabel customername1;
    private javax.swing.JLabel dateib;
    private javax.swing.JLabel datelbl;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel nameib;
    private javax.swing.JTextField price;
    private javax.swing.JTextField price1;
    // End of variables declaration//GEN-END:variables
}
