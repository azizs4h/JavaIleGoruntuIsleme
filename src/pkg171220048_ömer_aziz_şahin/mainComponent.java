package pkg171220048_ömer_aziz_şahin;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;
import javax.swing.UIManager;
import tools.uyarilar;

public class mainComponent extends javax.swing.JFrame {

    JComponent[] ekranlar = new JComponent[6];
    int gecerliEkran = 0;
    public static BufferedImage[] resimler = new BufferedImage[6];

    public mainComponent() {
        initComponents();
        this.setLocationRelativeTo(null);
        ekranlar[0] = new birinciEkran();
        ekranlar[1] = new ikinciEkran();
        ekranlar[2] = new ucuncuEkran();
        ekranlar[3] = new dorduncuEkran();
        ekranlar[4] = new besinciEkran();
        ekranlar[5] = new altinciEkran();

        anaPanel.setLayout(new BorderLayout());
        anaPanel.add(ekranlar[0]);
        geriButonu.setVisible(false);
        anaPanel.revalidate();
        anaPanel.repaint();
        this.revalidate();
        this.repaint();
        for (int i = 0; i < 6; i++) {
            resimler[i] = null;
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        anaPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        geriButonu = new javax.swing.JButton();
        ileriButonu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(860, 600));
        setPreferredSize(new java.awt.Dimension(860, 600));

        anaPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        anaPanel.setPreferredSize(new java.awt.Dimension(4, 500));

        javax.swing.GroupLayout anaPanelLayout = new javax.swing.GroupLayout(anaPanel);
        anaPanel.setLayout(anaPanelLayout);
        anaPanelLayout.setHorizontalGroup(
            anaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        anaPanelLayout.setVerticalGroup(
            anaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 415, Short.MAX_VALUE)
        );

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        geriButonu.setText("Geri");
        geriButonu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                geriButonuActionPerformed(evt);
            }
        });
        jPanel1.add(geriButonu, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, -1, -1));

        ileriButonu.setText("İleri");
        ileriButonu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ileriButonuActionPerformed(evt);
            }
        });
        jPanel1.add(ileriButonu, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(anaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 831, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(anaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void geriButonuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_geriButonuActionPerformed

        if (resimler[0] != null) {
            gecerliEkran--;

            if (gecerliEkran == 0) {
                geriButonu.setVisible(false);
            }
            if (gecerliEkran > -1) {
                ileriButonu.setVisible(true);

                anaPanel.removeAll();
                anaPanel.add(ekranlar[gecerliEkran]);
                anaPanel.revalidate();
                anaPanel.repaint();
            }
        } else {
            uyarilar.dosyaSecilmediUyarisi();
        }


    }//GEN-LAST:event_geriButonuActionPerformed

    private void ileriButonuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ileriButonuActionPerformed

        if (resimler[0] != null) {
            gecerliEkran++;

            if (gecerliEkran == 5) {
                ileriButonu.setVisible(false);
            }
            if (gecerliEkran < 6) {
                geriButonu.setVisible(true);

                anaPanel.removeAll();
                anaPanel.add(ekranlar[gecerliEkran]);
                anaPanel.revalidate();
                anaPanel.repaint();
            }
        } else {
            uyarilar.dosyaSecilmediUyarisi();

        }


    }//GEN-LAST:event_ileriButonuActionPerformed

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
            java.util.logging.Logger.getLogger(mainComponent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainComponent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainComponent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainComponent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        try {

            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("Look and Feel not set");
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainComponent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel anaPanel;
    private javax.swing.JButton geriButonu;
    private javax.swing.JButton ileriButonu;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
