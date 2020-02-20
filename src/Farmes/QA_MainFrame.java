
package Farmes;

import DatabaseConnection.DatabaseConnection;
import static GraphCreation.GraphCreation.AddNode;
import static GraphCreation.GraphCreation.FinalNode;
import static GraphCreation.GraphCreation.GraphCreation;
import static GraphCreation.GraphCreation.PanelData;
import static GraphCreation.GraphCreation.ReadDictionary;
import static GraphCreation.GraphCreation.getRoot;
import com.mxrck.autocompleter.TextAutoCompleter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import ontologynew.Steamming;
import ontologynew.StopwordsLoaderAndRemoval;
import static ontologynew.StopwordsLoaderAndRemoval.count;
import static ontologynew.StopwordsLoaderAndRemoval.lines;


public class QA_MainFrame extends javax.swing.JFrame {

   
    public static DatabaseConnection db;
    public static String AfteSWremover = "";

    public QA_MainFrame() {

        initComponents();

        db = new DatabaseConnection();
        db.dbconnection();
        setLocationRelativeTo(null);

        File[] files = new File("dictionary").listFiles();

        for (File file : files) {
            jComboBox1.addItem(file.getName());
        }
        jButton1.setEnabled(false);
        jButton3.setEnabled(false);
        jButton5.setEnabled(false);
        jButton4.setEnabled(false);


    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel5.setText("Ontology Based Question Answer System ");

        jLabel3.setText("Select Ontology File:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(459, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap())
        );

        jTextField1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jButton1.setText("GET ANSWER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel1.setText("Stopwords Removed :");

        jButton3.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jButton3.setText("Tokenization");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jButton4.setText("Stemming");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jButton5.setText("Remove Stop words");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setAutoscrolls(false);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 28, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(155, 155, 155))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void autoCom() {
        try {
            TextAutoCompleter complete = new TextAutoCompleter(jTextField1);
            String query = jTextField1.getText();
            System.out.println("query: " + query);
            query = query.replace("'", "\\'");
            if (query.trim().length() > 0) {
                ResultSet rs = db.getResultSet("select query from log where query like '%" + query + "%'");

                int sug_count = 0;
                while (rs.next()) {
                    if (sug_count < 5) {
                        complete.addItem(rs.getString("query"));
                    }
                    sug_count++;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(QA_MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String query = jTextField1.getText();

        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        db.getUpdate("insert into `log`(`query`,`timestamp`) values ( '" + query.trim().replace("'", "\\'") + "','" + timeStamp + "')");

        if (query.trim().length() > 0) {
            try {

                query = query.replace("'s", "");
                query = query.replaceAll("[&\\/\\\\#,+()$~%.'\":*?<>{}^@!।'’”“]", "").toLowerCase();
                System.out.println("After Removing Special characters:" + query);
                StopwordsLoaderAndRemoval sw = new StopwordsLoaderAndRemoval();
                sw.StopWordLoader();
                query = sw.StopwordsRemoval(query);
                jLabel2.setText(count + "");

                ArrayList<String> WordsToProcess = new ArrayList<String>();
                String querySplit[] = query.split("\\s");
                for (String querySplit1 : querySplit) {
                    WordsToProcess.add(querySplit1.trim());
                }
                FinalNode.clear();
                ReadDictionary();
                String Root = getRoot(WordsToProcess);
                WordsToProcess = AddNode(WordsToProcess, Root);
                GraphCreation(WordsToProcess, Root);

                jTextArea1.setText(PanelData);

                System.out.println("query: " + query);
                String url = "http://localhost/ontology/Graph.html";
                if (Desktop.isDesktopSupported()) {
                    Desktop desktop = Desktop.getDesktop();
                    try {
                        desktop.browse(new URI(url));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    Runtime runtime = Runtime.getRuntime();
                    try {
                        runtime.exec("xdg-open " + url);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(QA_MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please Enter Query");
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped

    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
    

    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
       
        autoCom();
        jButton1.setEnabled(false);
        jButton3.setEnabled(true);
        jButton5.setEnabled(false);
        jButton4.setEnabled(false);
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jButton1.setEnabled(true);
        jButton3.setEnabled(true);
        jButton5.setEnabled(true);
        jButton4.setEnabled(false);
        String query = jTextField1.getText();
        
         int i = 1; 
        String querys[] = query.split("\\s");
        query = "";
        for (String query1 : querys) {
        
         query =query+i+"\t"+query1+"\n";
         i++;
        }
        
        jTextArea1.setText(query);
        System.out.println("After Removing Special characters:" + query);
        query = query.replace("'s", "");
        query = query.replaceAll("[&\\/\\\\#,+()$~%.'\":*?<>{}^@!।'’”“]", "").toLowerCase();
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        jButton1.setEnabled(true);
        jButton3.setEnabled(false);
        jButton5.setEnabled(false);
        jButton4.setEnabled(true);
        
        Steamming s = new Steamming();

        String words[] = AfteSWremover.split("\\s+");
        String filtrateContent = "";
        for (String w : words) {
            filtrateContent = filtrateContent + " " + s.Steamming(w);
        }

        
        String querys[] = filtrateContent.split("\\s");
        filtrateContent = "";

        
         int i = 1; 
        for (String query1 : querys) {
             if(query1.trim().length()>0){
         
         filtrateContent =filtrateContent+i+"\t"+query1+"\n";
         i++;
             }
        }
        
        jTextArea1.setText(filtrateContent);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String query = jTextField1.getText();
        jButton1.setEnabled(true);
        jButton3.setEnabled(true);
        jButton5.setEnabled(true);
        jButton4.setEnabled(true);

        StopwordsLoaderAndRemoval sw = new StopwordsLoaderAndRemoval();
        sw.StopWordLoader();
        query = sw.StopwordsRemoval(query);
        AfteSWremover = query;
           
        String querys[] = query.split("\\s");
        query = "";

        
         int i = 1; 
        for (String query1 : querys) {
            if(query1.trim().length()>0){
        
         query =query+i+"\t"+query1+"\n";
         i++;
            }
        }
        
        
        
        
        jTextArea1.setText(query);
        
        
        jLabel2.setText(count + "");

        
    }//GEN-LAST:event_jButton5ActionPerformed

   
    public static void main(String args[]) 
    
    {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
             UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(QA_MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(QA_MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(QA_MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(QA_MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                   
                new QA_MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    public static javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
