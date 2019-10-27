/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import static conn.connector.conUrl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Acer
 */
public class AddFrame extends javax.swing.JFrame {

    
     
    public void LoadAllProducts() {

        try {
                   Class.forName("com.mysql.jdbc.Driver");
                   Connection con = DriverManager.getConnection(conUrl);
                   String query = "SELECT * FROM product";
                   
                   PreparedStatement pstmt = con.prepareStatement(query);
                   ResultSet rs = pstmt.executeQuery();

    DefaultTableModel tblModel = (DefaultTableModel) productTable.getModel();
    tblModel.setRowCount(0);

    int row = 0;
    while(rs.next()){

        tblModel.addRow(new Object[]{});
         productTable.setValueAt(rs.getString("product_id"), row, 0);
         productTable.setValueAt(rs.getString("name"), row, 1);
         productTable.setValueAt(rs.getString("quantity"), row, 2);
         productTable.setValueAt(rs.getString("price"), row, 3);
        row++;
    }

} catch (ClassNotFoundException | SQLException ex) {
    Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    final void search(String keyword) {
         try {
                   Class.forName("com.mysql.jdbc.Driver");
                   Connection con = DriverManager.getConnection(conUrl);
                   String query = "SELECT * FROM product WHERE product_id LIKE ? OR name LIKE ? ";
                   PreparedStatement pstmt = con.prepareStatement(query);
                   
           

            pstmt.setString(1, "%" + keyword + "%");
            pstmt.setString(2, "%" + keyword + "%");
            
            ResultSet rs = pstmt.executeQuery();
            
            DefaultTableModel model = (DefaultTableModel) productTable.getModel();
            model.setRowCount(0);
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("product_id"), rs.getString("name"), rs.getString("quantity"), rs.getString("price")});
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AddFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Creates new form AddProductFrame
     */
    public AddFrame() {
        
        initComponents();
        LoadAllProducts();
        this.setLocationRelativeTo(null);
    }
    
    public AddFrame(String username) {
        initComponents();
        jLabel5.setText("Welcome  "+username);   
       LoadAllProducts();
       this.setLocationRelativeTo(null);
    }
    
    AddProduct ap = new AddProduct();
    Object id = null;

       void clearProduct(){
        proName.setText("");
        proQuan.setValue(0);
        proPrice.setText("");
        proName.requestFocus();
        excQuan.setText(null);
 }
       void enableAndClearFields(){
        proName.setEnabled(true);
        proQuan.setEnabled(true);
        proPrice.setEnabled(true);
        clearProduct();
       }
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ProductForm = new javax.swing.JFrame();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        proName = new javax.swing.JTextField();
        proPrice = new javax.swing.JFormattedTextField();
        addProductbtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        proQuan = new javax.swing.JSpinner();
        savebtn = new javax.swing.JButton();
        excQuan = new javax.swing.JLabel();
        addQuantitybtn = new javax.swing.JButton();
        ProductTableFrame = new javax.swing.JFrame();
        view1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        label1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        searchtf = new javax.swing.JTextField();
        searchbtn = new javax.swing.JButton();
        addproductf = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        addqty = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();

        ProductForm.setMinimumSize(new java.awt.Dimension(434, 348));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Product Name:");

        jLabel2.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Quantity:");

        jLabel3.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Price:");

        proPrice.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        proPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proPriceActionPerformed(evt);
            }
        });

        addProductbtn.setBackground(new java.awt.Color(0, 0, 0));
        addProductbtn.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        addProductbtn.setForeground(new java.awt.Color(255, 255, 255));
        addProductbtn.setText("Add Product");
        addProductbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductbtnActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Rockwell", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 0, 0));
        jLabel4.setText("Product Form");

        jSeparator1.setBackground(new java.awt.Color(204, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(204, 0, 0));

        proQuan.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        savebtn.setBackground(new java.awt.Color(0, 0, 0));
        savebtn.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        savebtn.setForeground(new java.awt.Color(255, 255, 255));
        savebtn.setText("Save");
        savebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savebtnActionPerformed(evt);
            }
        });

        excQuan.setForeground(new java.awt.Color(255, 255, 255));

        addQuantitybtn.setBackground(new java.awt.Color(0, 0, 0));
        addQuantitybtn.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        addQuantitybtn.setForeground(new java.awt.Color(255, 255, 255));
        addQuantitybtn.setText("Add Quantity");
        addQuantitybtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addQuantitybtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(proName)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(excQuan, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(proQuan))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                            .addComponent(jSeparator1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(proPrice)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(194, 194, 194)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addQuantitybtn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(addProductbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(savebtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 103, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(proName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(proQuan, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(excQuan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(proPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addQuantitybtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(addProductbtn)
                .addGap(39, 39, 39)
                .addComponent(savebtn)
                .addContainerGap())
        );

        javax.swing.GroupLayout ProductFormLayout = new javax.swing.GroupLayout(ProductForm.getContentPane());
        ProductForm.getContentPane().setLayout(ProductFormLayout);
        ProductFormLayout.setHorizontalGroup(
            ProductFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ProductFormLayout.setVerticalGroup(
            ProductFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        ProductTableFrame.setMinimumSize(new java.awt.Dimension(472, 486));

        view1.setBackground(new java.awt.Color(0, 0, 0));

        productTable.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Product Name", "Quantity", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        productTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(productTable);
        if (productTable.getColumnModel().getColumnCount() > 0) {
            productTable.getColumnModel().getColumn(0).setResizable(false);
            productTable.getColumnModel().getColumn(1).setResizable(false);
            productTable.getColumnModel().getColumn(2).setResizable(false);
            productTable.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel4.setBackground(new java.awt.Color(204, 0, 0));

        label1.setFont(new java.awt.Font("Rockwell", 0, 24)); // NOI18N

        searchtf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchtfKeyReleased(evt);
            }
        });

        searchbtn.setText("Search");
        searchbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchtf, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchtf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchbtn))
                .addContainerGap())
        );

        addproductf.setBackground(new java.awt.Color(0, 0, 0));
        addproductf.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        addproductf.setForeground(new java.awt.Color(255, 255, 255));
        addproductf.setText("Add Product");
        addproductf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addproductfActionPerformed(evt);
            }
        });

        btndelete.setBackground(new java.awt.Color(0, 0, 0));
        btndelete.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        btndelete.setForeground(new java.awt.Color(255, 255, 255));
        btndelete.setText("Delete");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        btnedit.setBackground(new java.awt.Color(0, 0, 0));
        btnedit.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        btnedit.setForeground(new java.awt.Color(255, 255, 255));
        btnedit.setText("Edit");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });

        addqty.setBackground(new java.awt.Color(0, 0, 0));
        addqty.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        addqty.setForeground(new java.awt.Color(255, 255, 255));
        addqty.setText("Add Quanity");
        addqty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addqtyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout view1Layout = new javax.swing.GroupLayout(view1);
        view1.setLayout(view1Layout);
        view1Layout.setHorizontalGroup(
            view1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(view1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(view1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(view1Layout.createSequentialGroup()
                        .addGroup(view1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(addqty, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnedit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(13, 13, 13))
                    .addGroup(view1Layout.createSequentialGroup()
                        .addGroup(view1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btndelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addproductf, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        view1Layout.setVerticalGroup(
            view1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, view1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(view1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(view1Layout.createSequentialGroup()
                        .addComponent(addproductf, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnedit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addqty, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout ProductTableFrameLayout = new javax.swing.GroupLayout(ProductTableFrame.getContentPane());
        ProductTableFrame.getContentPane().setLayout(ProductTableFrameLayout);
        ProductTableFrameLayout.setHorizontalGroup(
            ProductTableFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(view1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ProductTableFrameLayout.setVerticalGroup(
            ProductTableFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(view1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Product");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addContainerGap(144, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(116, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addProductbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductbtnActionPerformed
product();
ProductForm.setVisible(false);
ProductTableFrame.setVisible(true);
LoadAllProducts();
    }//GEN-LAST:event_addProductbtnActionPerformed

    private void proPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_proPriceActionPerformed

    private void addproductfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addproductfActionPerformed

        ProductForm.setVisible(true);
        ProductForm.setAlwaysOnTop(true);
        ProductForm.setLocationRelativeTo(null);
        savebtn.setVisible(false);
        addProductbtn.setVisible(true);
        addQuantitybtn.setVisible(false);
        
        this.enableAndClearFields();
    }//GEN-LAST:event_addproductfActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       this.setVisible(false);
       ProductTableFrame.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        
        int selRow = productTable.getSelectedRow();
        
            
        if(selRow == -1){
            JOptionPane.showMessageDialog(rootPane, "Please select a row to delete","Warning",JOptionPane.WARNING_MESSAGE);
        }else{   
            Object product_id = productTable.getValueAt(selRow, 0);
            Object name = productTable.getValueAt(selRow, 1);
            int a = JOptionPane.showConfirmDialog(rootPane, "This will delete "+name+".\nClick OK to continue","Confirm Delete",JOptionPane.OK_CANCEL_OPTION);
            
            if(a==JOptionPane.OK_OPTION){
                int aa = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to delete "+name+"?", "Delete", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
                
                if(aa == JOptionPane.YES_OPTION){
                    
                    int rs = ap.DeleteProduct(product_id);
                    if(rs == 1){
                        JOptionPane.showMessageDialog(rootPane, "Product "+name+" deleted!","Product Deleted",JOptionPane.WARNING_MESSAGE);
                        LoadAllProducts();
                    }
                }
            }
            
        }
    
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        
         this.clearProduct();
        int row = productTable.getSelectedRow();

        if (row != -1) {
            ProductForm.setVisible(true);
            ProductForm.setAlwaysOnTop(true);
            ProductForm.setLocationRelativeTo(null);
            addProductbtn.setVisible(false);
            addProductbtn.setVisible(true);
            addQuantitybtn.setVisible(false);
            proQuan.setEnabled(false);

            id = productTable.getValueAt(row, 0);
            Object pname = productTable.getValueAt(row, 1);
            Object pqty = productTable.getValueAt(row, 2);
            Object pprice = productTable.getValueAt(row, 3);

            proName.setText((String) pname);
            proQuan.setValue(Integer.valueOf(pqty.toString()));
            proPrice.setValue(Double.valueOf(pprice.toString()));

        } else {
            JOptionPane.showMessageDialog(rootPane, "Please select a row", "Warning", JOptionPane.WARNING_MESSAGE);
        }


    }//GEN-LAST:event_btneditActionPerformed

    private void savebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savebtnActionPerformed
       String name = proName.getText();
        Object price = proPrice.getValue();

        int r = ap.editProduct(id, name, price);
        if (r == 1) {
            JOptionPane.showMessageDialog(ProductForm, "Product Edited");
            ProductForm.setVisible(false);
            this.LoadAllProducts();
        } else {
            JOptionPane.showMessageDialog(ProductForm, "Problem Editing a product", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_savebtnActionPerformed

    private void addQuantitybtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addQuantitybtnActionPerformed
       
         Object pn = proName.getText();
        Object qty = proQuan.getValue();
        int c = JOptionPane.showConfirmDialog(ProductForm, "Would you like to add\n"+qty+ "\nto the product\n"+pn+"?", "Add Quantity", JOptionPane.YES_NO_OPTION);
        if(c==JOptionPane.YES_OPTION){
            int r = ap.addQuantity(id, qty);
            if(r==1){
                JOptionPane.showMessageDialog(ProductForm, "Product Quantity Updated!");
                ProductForm.setVisible(false);
                this.LoadAllProducts();
            }else{
                JOptionPane.showMessageDialog(ProductForm, "Problem Updating a product", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_addQuantitybtnActionPerformed

    private void addqtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addqtyActionPerformed
        this.enableAndClearFields();
           int row = productTable.getSelectedRow();
           if(row != -1){
                ProductForm.setVisible(true);
                ProductForm.setAlwaysOnTop(true);
                ProductForm.setLocationRelativeTo(this);
                addProductbtn.setVisible(false);
                savebtn.setVisible(false);
                addQuantitybtn.setVisible(true);
                
                id = productTable.getValueAt(row, 0);
                Object pn = productTable.getValueAt(row, 1);
                Object qt = productTable.getValueAt(row, 2);
                Object pr = productTable.getValueAt(row, 3);
                
                proName.setText(pn.toString());
                excQuan.setText(qt.toString());
                proPrice.setValue(Double.valueOf(pr.toString()));
                
                proName.setEnabled(false);
                proPrice.setEnabled(false);
                
           }else{
               JOptionPane.showMessageDialog(rootPane, "Please select a row", "Warning", JOptionPane.WARNING_MESSAGE);
           }
    }//GEN-LAST:event_addqtyActionPerformed

    private void searchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbtnActionPerformed
        String keyword = searchtf.getText();
        this.search(keyword);
    }//GEN-LAST:event_searchbtnActionPerformed

    private void searchtfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchtfKeyReleased
         String keyword = searchtf.getText();
        this.search(keyword);
    }//GEN-LAST:event_searchtfKeyReleased
private void product() {
            
            String prname = proName.getText();
            int prqty = (int) proQuan.getValue();
            Object prprice = proPrice.getValue();
  
           ap.addProduct(prname, prqty,prprice);
           this. clearProduct();
           
           
}

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
            java.util.logging.Logger.getLogger(AddFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame ProductForm;
    private javax.swing.JFrame ProductTableFrame;
    private javax.swing.JButton addProductbtn;
    private javax.swing.JButton addQuantitybtn;
    private javax.swing.JButton addproductf;
    private javax.swing.JButton addqty;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnedit;
    private javax.swing.JLabel excQuan;
    private javax.swing.JButton jButton2;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel label1;
    private javax.swing.JTextField proName;
    private javax.swing.JFormattedTextField proPrice;
    private javax.swing.JSpinner proQuan;
    private javax.swing.JTable productTable;
    private javax.swing.JButton savebtn;
    private javax.swing.JButton searchbtn;
    private javax.swing.JTextField searchtf;
    private javax.swing.JPanel view1;
    // End of variables declaration//GEN-END:variables

}

