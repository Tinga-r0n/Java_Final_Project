package inventory_casheringsystem;

import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import javax.swing.UIManager;


public class LoginForm extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs;

    public LoginForm() {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        panel.setBackground(new Color(200, 152, 153, 200));
        showDate();
        showTime();
        
        try {
          
              UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
        
        }
        
        catch (Exception ex) {
            System.err.println(ex);
        }
    
         
    }
        
    void showDate() {

        DateFormat dateFormat = new SimpleDateFormat("MM-dd,yyyy");
        Date d = new Date();

        dateof.setText(dateFormat.format(d));

    }

    void showTime() {
        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date d = new Date();
                SimpleDateFormat f = new SimpleDateFormat("hh:mm:ss a");
                timeof.setText(f.format(d));
            }
        }).start();
    }

    public void logIn_Out() {
        Statement st;
        ResultSet rs;

        String info = "Login";

        try {

            con = Connections.getConnection();
            PreparedStatement ps = con.prepareStatement("Insert into  viewlogs(Date,Time,Details,User) values(?,?,?,?)");
            ps.setString(1, dateof.getText());
            ps.setString(2, timeof.getText());
            ps.setString(3, info);
            ps.setString(4, user.getText());
        

            System.out.println("logs recorded!");
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);

        }
    }

    public void login_form() {
        
        String User = user.getText().toString();

        try {

            con = Connections.getConnection();
            ps = con.prepareStatement("SELECT * FROM usertype_table WHERE user =? and pass =?");
            ps.setString(1, user.getText());
            ps.setString(2, password.getText());

            String useradmin = "Admin";
            String userstaff = "Staff";
            String usercashier = "Cashier";

            String status = "Active";
            String unstatus = "Pending...";
            String nostatus = "InActive";

            rs = ps.executeQuery();
            if (rs.next()) {
                if (rs.getString(11).equals(status) && rs.getString(10).equals(useradmin)) {
                    
                      JOptionPane.showMessageDialog(this, "Hello :) " + rs.getString("user") + "  Successfuly Login as " + rs.getString("usertype"));
                  

                    Home admin = new Home();
                    admin.setVisible(true);
                    admin.setLocationRelativeTo(null);
                    dispose();
                    admin.report.setVisible(true);
                    admin.register.setVisible(false);
                    admin.textlogin.setText(rs.getString("user"));
                    admin.username(User);
                    logIn_Out();
                                 
                } else if (rs.getString(11).equals(status) && rs.getString(10).equals(userstaff)) {
                    
                    JOptionPane.showMessageDialog(this, "Hello :) " + rs.getString("user") + "  Successfuly Login as " + rs.getString("usertype"));
                    
                    Home Staff = new Home();
                    Staff.setVisible(true);
                    Staff.setLocationRelativeTo(null);
                    dispose();
                    Staff.register.setVisible(true);
                    Staff.report.setVisible(false);
                    Staff.Casher.setVisible(false);
                    Staff.textlogin.setText(rs.getString("user"));
                    Staff.username(User);
                    logIn_Out();
                } else if (rs.getString(11).equals(status) && rs.getString(10).equals(usercashier)) {
                   
                  JOptionPane.showMessageDialog(this, "Hello :) " + rs.getString("user") + " You're Successfuly Login as " + rs.getString("usertype"));

                    Home casher = new Home();
                    casher.setVisible(true);
                    casher.setLocationRelativeTo(null);
                    dispose();
                    casher.register.setVisible(true);
                    casher.report.setVisible(false);
                    casher.inven_pro.setVisible(false);
                    casher.inven_stock.setVisible(false);
                    casher.textlogin.setText(rs.getString("user"));
                    casher.username(User);
                    logIn_Out();
                } else if (rs.getString(11).equals(unstatus)) {
                    JOptionPane.showMessageDialog(this, "Your Registration is Currently on process! Please Contact your Admin", "ERROR", JOptionPane.ERROR_MESSAGE);

                } else if (rs.getString(11).equals(nostatus)) {
                    JOptionPane.showMessageDialog(this, "Your Account is Inactive! Please Contact your Admin", "ERROR", JOptionPane.ERROR_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(this, "Something Went Wrong! Please Check Your Credentials And Try Again", "Login Error!", JOptionPane.ERROR_MESSAGE);

                }

            } else {
                JOptionPane.showMessageDialog(this, "Something Went Wrong! Please Check Your Credentials And Try Again", "Login Error!", JOptionPane.ERROR_MESSAGE);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "username and password do not matched");
        }
        
//        String uname = user.getText();
//        String pasS =String.valueOf( password.getPassword());
//        
//   
//      
//        if(uname.isEmpty() || (pasS.isEmpty())){
//            
//            JOptionPane.showMessageDialog(this,"All Field is Required");
//                      
//        }    
//    
//        else {
//                  try {
//                    con = Connections.getConnection();
//                    ps = con.prepareStatement("SELECT * FROM usertype_table  WHERE user ='"+ uname+"' and pass ='"+ pasS+"'");
//                    rs = ps.executeQuery();
//
//                 
//                    
//             while(rs.next()) {
//
//            
//                   if(rs.getString(11).equals("InActive")){
//                      
//                   JOptionPane.showMessageDialog(this,"Wait for  Admin  Approval");   
//
//                   
//             
//               }else if(uname.equals(uname)&&(pasS.equals(pasS))&&(rs.getString(11).equals("Active"))&&(rs.getString(10).equals("Admin")))
//               {
//                   JOptionPane.showMessageDialog(this, "Hello :) " + rs.getString("user") + "  Successfuly Login as " + rs.getString("usertype"));
//                  
//
//                    Home admin = new Home();
//                    admin.setVisible(true);
//                    admin.setLocationRelativeTo(null);
//                    dispose();
//                    admin.report.setVisible(true);
//                    admin.register.setVisible(false);
//                    admin.textlogin.setText(rs.getString("user"));
//                    logIn_Out();
//                                  
//               }
//               
//               else if(uname.equals(uname)&&(pasS.equals(pasS))&&(rs.getString(11).equals("Active"))&&(rs.getString(10).equals("Staff"))){
//                    JOptionPane.showMessageDialog(this, "Hello :) " + rs.getString("user") + "  Successfuly Login as " + rs.getString("usertype"));
//                    
//                    Home Staff = new Home();
//                    Staff.setVisible(true);
//                    Staff.setLocationRelativeTo(null);
//                    dispose();
//                    Staff.register.setVisible(true);
//                    Staff.report.setVisible(false);
//                    Staff.Casher.setVisible(false);
//                    Staff.textlogin.setText(rs.getString("user"));
//                    logIn_Out();
//               }else if(uname.equals(uname)&&(pasS.equals(pasS))&&(rs.getString(11).equals("Active"))&&(rs.getString(10).equals("Cashier"))){
//                   JOptionPane.showMessageDialog(this, "Hello :) " + rs.getString("user") + "  Successfuly Login as " + rs.getString("usertype"));
//
//                    Home casher = new Home();
//                    casher.setVisible(true);
//                    casher.setLocationRelativeTo(null);
//                    dispose();
//                    casher.register.setVisible(true);
//                    casher.report.setVisible(false);
//                    casher.inven_pro.setVisible(false);
//                    casher.inven_stock.setVisible(false);
//                    casher.textlogin.setText(rs.getString("user"));
//                    logIn_Out();
//              
//                   
//               
//                       
//               }else{
//                  JOptionPane.showMessageDialog(this,"Something went wrong please Contact your Admin","Error",JOptionPane.ERROR_MESSAGE); 
//                }
//                   
//          }
//                                       }
//        
//         catch (SQLException e) {
//            JOptionPane.showMessageDialog(null,e.getMessage());
//                 }
    
 }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        head = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        Exit = new javax.swing.JButton();
        minimize = new javax.swing.JButton();
        panel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        user = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        log = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        showpass = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel_title = new javax.swing.JLabel();
        img_display = new javax.swing.JLabel();
        footercolor = new javax.swing.JPanel();
        timeof = new javax.swing.JLabel();
        dateof = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Loading = new javax.swing.JPanel();
        Invent = new javax.swing.JLabel();
        barr = new javax.swing.JProgressBar();
        txtload = new javax.swing.JLabel();
        loadingnumbers = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        jPasswordField1.setText("jPasswordField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 589));
        setUndecorated(true);
        setSize(new java.awt.Dimension(900, 589));
        getContentPane().setLayout(null);

        head.setBackground(new java.awt.Color(153, 0, 0));
        head.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        head.setMaximumSize(new java.awt.Dimension(900, 100));
        head.setMinimumSize(new java.awt.Dimension(900, 100));
        head.setPreferredSize(new java.awt.Dimension(900, 100));
        head.setLayout(null);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory_casheringsystem/icon/siomaiking-logo2.png"))); // NOI18N
        head.add(jLabel7);
        jLabel7.setBounds(0, 0, 520, 130);

        Exit.setBackground(new java.awt.Color(255, 255, 255));
        Exit.setForeground(new java.awt.Color(255, 204, 204));
        Exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory_casheringsystem/icon/icons8_Cancel_32px.png"))); // NOI18N
        Exit.setToolTipText("Exit");
        Exit.setBorder(null);
        Exit.setContentAreaFilled(false);
        Exit.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory_casheringsystem/icon/icons8_Cancel_30px_3.png"))); // NOI18N
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        head.add(Exit);
        Exit.setBounds(480, 0, 38, 36);

        minimize.setForeground(new java.awt.Color(255, 204, 204));
        minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory_casheringsystem/icon/icons8_Minus_32px_1.png"))); // NOI18N
        minimize.setToolTipText("Minimize");
        minimize.setBorder(null);
        minimize.setBorderPainted(false);
        minimize.setContentAreaFilled(false);
        minimize.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory_casheringsystem/icon/icons8_Minus_30px_3.png"))); // NOI18N
        minimize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimizeActionPerformed(evt);
            }
        });
        head.add(minimize);
        minimize.setBounds(450, 0, 33, 36);

        getContentPane().add(head);
        head.setBounds(200, 0, 520, 110);

        panel.setBackground(java.awt.Color.pink);
        panel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Username");

        user.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        user.setMaximumSize(new java.awt.Dimension(6, 23));
        user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Password");

        password.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        password.setMaximumSize(new java.awt.Dimension(6, 23));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory_casheringsystem/icon/password.png"))); // NOI18N

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory_casheringsystem/icon/username.png"))); // NOI18N

        log.setBackground(new java.awt.Color(40, 127, 244));
        log.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        log.setForeground(new java.awt.Color(255, 255, 255));
        log.setText("Login");
        log.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Forgot password ?");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        showpass.setBorder(null);
        showpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showpassActionPerformed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory_casheringsystem/icon/eye.png"))); // NOI18N

        jLabel_title.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabel_title.setForeground(java.awt.Color.red);
        jLabel_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_title.setText("Login");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(142, 142, 142))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(showpass)
                                        .addGap(18, 18, 18)
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(log, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8)))))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel_title, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(66, 66, 66))))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel_title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(showpass)
                        .addGap(21, 21, 21)
                        .addComponent(log, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        getContentPane().add(panel);
        panel.setBounds(280, 110, 360, 430);

        img_display.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        img_display.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory_casheringsystem/A-SK 02.jpg"))); // NOI18N
        img_display.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(img_display);
        img_display.setBounds(200, 110, 520, 430);

        footercolor.setBackground(java.awt.Color.pink);
        footercolor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        footercolor.setMaximumSize(new java.awt.Dimension(900, 40));

        timeof.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        timeof.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        dateof.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dateof.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout footercolorLayout = new javax.swing.GroupLayout(footercolor);
        footercolor.setLayout(footercolorLayout);
        footercolorLayout.setHorizontalGroup(
            footercolorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, footercolorLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(timeof, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(dateof, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );
        footercolorLayout.setVerticalGroup(
            footercolorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(timeof, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
            .addComponent(dateof, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );

        getContentPane().add(footercolor);
        footercolor.setBounds(200, 540, 520, 50);

        jPanel1.setBackground(new java.awt.Color(189, 0, 0));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory_casheringsystem/SIOMAI.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory_casheringsystem/SiopaO.png"))); // NOI18N

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory_casheringsystem/SiomaI (1).png"))); // NOI18N

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory_casheringsystem/pork-siomai.png"))); // NOI18N

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory_casheringsystem/A - SK 046.png"))); // NOI18N

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory_casheringsystem/siopao_da_king_1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 505, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 211, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 980, 590);

        Loading.setBackground(new java.awt.Color(204, 0, 0));

        Invent.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 36)); // NOI18N
        Invent.setForeground(new java.awt.Color(255, 255, 255));
        Invent.setText("Inventory Cashiering System");

        barr.setBackground(new java.awt.Color(0, 255, 255));
        barr.setForeground(new java.awt.Color(51, 255, 255));

        txtload.setForeground(new java.awt.Color(255, 255, 255));
        txtload.setText("Loading...");

        loadingnumbers.setFont(new java.awt.Font("Digital-7 Mono", 1, 36)); // NOI18N
        loadingnumbers.setForeground(new java.awt.Color(51, 255, 255));
        loadingnumbers.setText("100%");

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory_casheringsystem/icon/siomaiking-logo2.png"))); // NOI18N

        javax.swing.GroupLayout LoadingLayout = new javax.swing.GroupLayout(Loading);
        Loading.setLayout(LoadingLayout);
        LoadingLayout.setHorizontalGroup(
            LoadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoadingLayout.createSequentialGroup()
                .addGroup(LoadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LoadingLayout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addGroup(LoadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(LoadingLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(barr, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(loadingnumbers))
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(LoadingLayout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addGroup(LoadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(LoadingLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(txtload))
                            .addComponent(Invent))))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        LoadingLayout.setVerticalGroup(
            LoadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoadingLayout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Invent, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(txtload)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(LoadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(barr, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loadingnumbers, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(139, Short.MAX_VALUE))
        );

        getContentPane().add(Loading);
        Loading.setBounds(0, 0, 970, 590);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logActionPerformed
        login_form();
    }//GEN-LAST:event_logActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JOptionPane.showMessageDialog(rootPane, "Please Contact your Administrator!");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void showpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showpassActionPerformed
        if(showpass.isSelected())
        {
            password.setEchoChar((char)0);
        }
        else
        {
            password.setEchoChar('*');
        
        }

    }//GEN-LAST:event_showpassActionPerformed

    private void userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userActionPerformed

    private void minimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizeActionPerformed
         setState(ICONIFIED);
    }//GEN-LAST:event_minimizeActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
         System.exit(0);
    }//GEN-LAST:event_ExitActionPerformed

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
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
                 LoginForm sign = new LoginForm();
         
//        sign.Loading.setVisible(true);
        sign.head.setVisible(false);
        sign.panel.setVisible(false);
        sign.jPanel1.setVisible(false);
        sign.footercolor.setVisible(false);
        sign.img_display.setVisible(false);
       

        try {
            for (int row = 0; row <=102; row++) {
                Thread.sleep(102);
                sign.loadingnumbers.setText(Integer.toString(row)+"%");
                sign.barr.setValue(row);
                if (row == 10) {
                   sign.txtload.setText("Turning on Modules...");
                

                  
                }
                 if (row == 20) {
                    sign.txtload.setText("Loading Modules...");
                
                 
                  
                }
                 if (row == 50) {
                   sign.txtload.setText("Connecting to Database...");
                
                   
                  
                }
                if (row == 50) {
                   sign.txtload.setText("Connecting to Database...");
                
                 
                  
                }if (row == 70) {
                    sign.txtload.setText("Connecting to Succesfull...");
                
                  
                  
                }
                if (row == 80) {
                   sign.txtload.setText("Launching Application...");
                
                    
                  
                }
                if (row == 101) {
                   sign.txtload.setText("Launching Application...");
                
                   
                   sign.Loading.setVisible(false);
//                   sign.img.setVisible(false);
                         
  
                  
                }
            }
        } catch (Exception e) {
        }
     
       
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
                 
       
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Exit;
    private javax.swing.JLabel Invent;
    private javax.swing.JPanel Loading;
    public javax.swing.JProgressBar barr;
    private static javax.swing.JLabel dateof;
    private javax.swing.JPanel footercolor;
    private javax.swing.JPanel head;
    private javax.swing.JLabel img_display;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_title;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    public javax.swing.JLabel loadingnumbers;
    private javax.swing.JButton log;
    private javax.swing.JButton minimize;
    private javax.swing.JPanel panel;
    private javax.swing.JPasswordField password;
    private javax.swing.JCheckBox showpass;
    private static javax.swing.JLabel timeof;
    private javax.swing.JLabel txtload;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}
