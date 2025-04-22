/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library_Management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author rahul
 */
public final class book extends javax.swing.JFrame {

    /**
     * Creates new form category
     */
    public book() {
        initComponents();
        connect();
        Category();
        Author();
        Publisher();
        book_Load();
    }


       
    
    public class CategoryItem
    {
        int id;
        String name;
        
        public CategoryItem(int id, String name)
        {
            this.id=id;
            this.name=name;
        }
        @Override
          public String toString()
          {
              return name;
          }
    }  
          
    public class AuthorItem
    {
        int id;
        String name;
        
        public AuthorItem(int id, String name)
        {
            this.id=id;
            this.name=name;
        }
          public String toString()
          {
              return name;
          }
    }
    
    public class PublisherItem
    {
        int id;
        String name;
        
        public PublisherItem(int id, String name)
        {
            this.id=id;
            this.name=name;
        }
        @Override
          public String toString()
          {
              return name;
          }
    } 
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public void connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/SLibrary","root","");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
    
    public void Category()
    {
        try {
            pst=con.prepareStatement("Select * from Category");
            rs=pst.executeQuery();
            
            txtcategory.removeAllItems();
            while (rs.next())
            {
                txtcategory.addItem(new CategoryItem (rs.getInt(1),(rs.getString(2))));
            }
                 
        } catch (SQLException ex) {
            Logger.getLogger(book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Author()
    {
        try {
            pst=con.prepareStatement("Select * from Author");
            rs=pst.executeQuery();
            
            txtauthor.removeAllItems();
            while (rs.next())
            {
                txtauthor.addItem(new AuthorItem (rs.getInt(1),(rs.getString(2))));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Publisher()
    {
        try {
            pst=con.prepareStatement("Select * from Publisher");
            rs=pst.executeQuery();
            
            txtpublisher.removeAllItems();
            while (rs.next())
            {
                txtpublisher.addItem(new PublisherItem (rs.getInt(1),(rs.getString(2))));
            }
               
        } catch (SQLException ex) {
            Logger.getLogger(book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void book_Load()
    {
        int c;
        try {
            pst= con.prepareStatement("SELECT b.id, b.bname, c.catname, a.a_name, p.p_name, b.content, b.pages, b.edition \n" +
             "FROM book b \n" +
             "LEFT JOIN category c ON b.category = c.id \n" +
             "LEFT JOIN author a ON b.author = a.id \n" +
              "LEFT JOIN publisher p ON b.publisher = p.id;");
            rs = pst.executeQuery();
            
            ResultSetMetaData rsd = rs.getMetaData();
            c=rsd.getColumnCount(); 
            
            DefaultTableModel d = (DefaultTableModel)jTable1.getModel();
            d.setRowCount(0);
            
            while(rs.next())
            {
                Vector v2= new Vector();
                
                for(int i=1; i<=c; i++)
                {
                    v2.add(rs.getString("b.id"));
                    v2.add(rs.getString("b.bname"));
                    v2.add(rs.getString("c.catname"));
                    v2.add(rs.getString("a.a_name"));
                    v2.add(rs.getString("p.p_name"));
                    v2.add(rs.getString("b.content"));
                    v2.add(rs.getString("b.pages"));
                    v2.add(rs.getString("b.edition"));
                }
                d.addRow(v2);
            }      
            
        } catch (SQLException ex) {
            Logger.getLogger(book.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Database Error: " + ex.getMessage()); // Add this line
        }
    }
    
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtedition = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtcategory = new javax.swing.JComboBox();
        txtauthor = new javax.swing.JComboBox();
        txtpublisher = new javax.swing.JComboBox();
        txtcontents = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtpages = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setText("Book");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        jButton1.setText("Add");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Cancel");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Book Name", "Category", "Author", "Publisher", "Contents", "No.of pages", "Edition"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
        }

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setText("Edition");

        txtedition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txteditionActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setText("Category");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setText("Publisher");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel8.setText("Author");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel9.setText("Contents");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel10.setText("No. of Pages");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4)
                    .addComponent(jLabel1)
                    .addComponent(jLabel10)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcategory, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtauthor, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtpublisher, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcontents, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtpages, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtedition, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 798, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(64, 64, 64)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtcategory, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addGap(41, 41, 41)
                                            .addComponent(jLabel5)
                                            .addGap(11, 11, 11)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addComponent(jLabel8))
                            .addComponent(txtauthor, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtpublisher, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel7))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtcontents, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtpages, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtedition, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(105, 105, 105))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // This code is for storing the inserted data into mySQL file
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        String name = txtname.getText();
        CategoryItem citem = (CategoryItem) txtcategory.getSelectedItem();
        AuthorItem aitem = (AuthorItem) txtauthor.getSelectedItem();
        PublisherItem pitem = (PublisherItem) txtpublisher.getSelectedItem();
        String contents = txtcontents.getText();
        String pages = txtpages.getText();
        String edition = txtedition.getText();


        String p = txtedition.getText();
              
        try {
            pst = con.prepareStatement("Insert into book(bname,category,publisher,author,content,pages,edition)values(?,?,?,?,?,?,?)");
            pst.setString(1, name);
            pst.setInt(2,citem.id);
            pst.setInt(3,aitem.id);
            pst.setInt(4,pitem.id);
            pst.setString(5,contents);
            pst.setString(6,pages);
            pst.setString(7,edition);
            
            int k = pst.executeUpdate();
            
            if (k==1){
                JOptionPane.showMessageDialog(this, "Book Created");
                
                txtname.setText("");
                txtcategory.setSelectedIndex(-1);
                txtauthor.setSelectedIndex(-1);
                txtpublisher.setSelectedIndex(-1);
                txtcontents.setText("");
                txtpages.setText("");
                txtedition.setText("");
                
                book_Load();
                
            }
            else{
                JOptionPane.showMessageDialog(this,"Error");
            }                
                    
        } catch (SQLException ex) {
            Logger.getLogger(book.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel d1= (DefaultTableModel)jTable1.getModel();
        int selectIndex = jTable1.getSelectedRow();
        
        int id = Integer.parseInt(d1.getValueAt(selectIndex, 0).toString());
        
        try {
            pst = con.prepareStatement("Delete from book where id=?");
           
            pst.setInt(1,id);
            int k = pst.executeUpdate();
            
            if (k==1){
                JOptionPane.showMessageDialog(this, "book Deleted");
                
                txtname.setText("");
                txtcategory.setSelectedIndex(-1);
                txtauthor.setSelectedIndex(-1);
                txtpublisher.setSelectedIndex(-1);
                txtcontents.setText("");
                txtpages.setText("");
                txtedition.setText("");
                
                
                txtname.requestFocus();
                book_Load();
                jButton1.setEnabled(true);
                
            }
            else{
                JOptionPane.showMessageDialog(this,"Error");
            }
                                    
        } catch (SQLException ex) {
            Logger.getLogger(book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
          // Get selected row index
  
    DefaultTableModel d1 = (DefaultTableModel) jTable1.getModel();
    int selectedIndex = jTable1.getSelectedRow();

    if (selectedIndex == -1) {
        JOptionPane.showMessageDialog(this, "Please select a book to update.");
        return;
    }

    int id = Integer.parseInt(d1.getValueAt(selectedIndex, 0).toString());

    String name = txtname.getText();
    CategoryItem citem = (CategoryItem) txtcategory.getSelectedItem();
    AuthorItem aitem = (AuthorItem) txtauthor.getSelectedItem();
    PublisherItem pitem = (PublisherItem) txtpublisher.getSelectedItem();
    String contents = txtcontents.getText();
    String pages = txtpages.getText();
    String edition = txtedition.getText();

    try (PreparedStatement ppst = con.prepareStatement("UPDATE book SET bname = ?, category = ?, author = ?, publisher = ?, content = ?, pages = ?, edition = ? WHERE id = ?")) {
        ppst.setString(1, name);
        ppst.setInt(2, citem.id);
        ppst.setInt(3, aitem.id);
        ppst.setInt(4, pitem.id);
        ppst.setString(5, contents);
        ppst.setString(6, pages);
        ppst.setString(7, edition);
        ppst.setInt(8, id);

        int k = ppst.executeUpdate();

        if (k == 1) {
            JOptionPane.showMessageDialog(this, "Book Updated");
            book_Load();
            txtname.setText("");
            txtcategory.setSelectedIndex(-1);
            txtauthor.setSelectedIndex(-1);
            txtpublisher.setSelectedIndex(-1);
            txtcontents.setText("");
            txtpages.setText("");
            txtedition.setText("");
            jButton1.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(this, "Error updating book");
        }
    } catch (SQLException ex) {
        Logger.getLogger(book.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Database Error: " + ex.getMessage());
    }

    }//GEN-LAST:event_jButton2ActionPerformed

    /* By this code we can edit the category data (the data will automatically
    passed in the boxes and we can update directly from there)*/
    
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:      
       DefaultTableModel d1 = (DefaultTableModel) jTable1.getModel();
       int selectIndex = jTable1.getSelectedRow();

// Check if a row is selected
if (selectIndex == -1) {
    JOptionPane.showMessageDialog(null, "No row selected!", "Error", JOptionPane.ERROR_MESSAGE);
    return;  // Stop further execution
}

// Check if table has valid data
if (d1.getRowCount() == 0 || d1.getColumnCount() == 0) {
    JOptionPane.showMessageDialog(null, "Table is empty!", "Error", JOptionPane.ERROR_MESSAGE);
    return;
}

// Retrieve values safely
Object idObj = d1.getValueAt(selectIndex, 0);
Object nameObj = d1.getValueAt(selectIndex, 1);
Object categoryObj = d1.getValueAt(selectIndex, 2);
Object authorObj = d1.getValueAt(selectIndex, 3);
Object publisherObj = d1.getValueAt(selectIndex, 4);
Object contentsObj = d1.getValueAt(selectIndex, 5);
Object pagesObj = d1.getValueAt(selectIndex, 6);
Object editionObj = d1.getValueAt(selectIndex, 7);

if (idObj == null || nameObj == null || categoryObj == null || authorObj == null || 
    publisherObj == null || contentsObj == null || pagesObj == null || editionObj == null) {
    JOptionPane.showMessageDialog(null, "One or more table values are null!", "Error", JOptionPane.ERROR_MESSAGE);
    return;
}

// Convert values safely
int id = Integer.parseInt(idObj.toString());
txtname.setText(nameObj.toString());
txtcategory.setSelectedItem(categoryObj.toString());
txtauthor.setSelectedItem(authorObj.toString());
txtpublisher.setSelectedItem(publisherObj.toString());
txtcontents.setText(contentsObj.toString());
txtpages.setText(pagesObj.toString());
txtedition.setText(editionObj.toString());

jButton1.setEnabled(false);
       
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txteditionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txteditionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txteditionActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
         
    }//GEN-LAST:event_jButton1MouseClicked

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
            java.util.logging.Logger.getLogger(book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new book().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox txtauthor;
    private javax.swing.JComboBox txtcategory;
    private javax.swing.JTextField txtcontents;
    private javax.swing.JTextField txtedition;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtpages;
    private javax.swing.JComboBox txtpublisher;
    // End of variables declaration//GEN-END:variables

    private void Connect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private static class DefaultTableModel1 {

        public DefaultTableModel1() {
        }

        private Object getValueAt(int selectIndex, int i) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
