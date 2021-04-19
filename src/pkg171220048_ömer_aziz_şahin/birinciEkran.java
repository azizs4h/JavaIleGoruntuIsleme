package pkg171220048_ömer_aziz_şahin;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import static pkg171220048_ömer_aziz_şahin.mainComponent.resimler;
import tools.Tools;

public class birinciEkran extends javax.swing.JPanel {

    public boolean islem = false;
    ImageIcon background = null;

    public birinciEkran() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        resimAc = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                formAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        resimAc.setText("Resim Aç");
        resimAc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resimAcActionPerformed(evt);
            }
        });

        jLabel1.setText("Açılan Resim :");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 400));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(resimAc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(resimAc)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void resimAcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resimAcActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        fileChooser.setAcceptAllFileFilterUsed(false);
        FileFilter png = new FileNameExtensionFilter("Png dosyaları", "png");
        FileFilter jpg = new FileNameExtensionFilter("Jpg dosyaları", "jpg");
        FileFilter bmp = new FileNameExtensionFilter("bmp dosyaları", "bmp");
        fileChooser.addChoosableFileFilter(png);
        fileChooser.addChoosableFileFilter(jpg);
        fileChooser.addChoosableFileFilter(bmp);
        fileChooser.setFileFilter(png);

        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            String selectedFilePath = fileChooser.getSelectedFile().getAbsolutePath();
            try {

                resimler[0] = ImageIO.read(new File(selectedFilePath));
                resimler[0] = Tools.resizeImage(resimler[0], 400, 400);
//                System.out.println(selectedFilePath);
//                ImageIcon background = new ImageIcon(resimler[0].getScaledInstance(400, 400, Image.SCALE_SMOOTH));
//                jLabel2.setIcon(background);
                islem = true;
                for (int i = 1; i < 6; i++) {
                    resimler[i] = null;
                }
                ikinciEkran.islem = false;
                ucuncuEkran.islem = false;
                dorduncuEkran.islem = false;
                besinciEkran.islem = false;

            } catch (IOException ex) {
                Logger.getLogger(birinciEkran.class.getName()).log(Level.SEVERE, null, ex);
            }
            background = new ImageIcon(resimler[0].getScaledInstance(400, 400, Image.SCALE_SMOOTH));
            jLabel2.setIcon(background);

// resim
        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "Lütfen Dosya Seçin",
                    "Dosya Seçim Hatası",
                    JOptionPane.ERROR_MESSAGE
            );
        }

    }//GEN-LAST:event_resimAcActionPerformed

    private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded
        if (islem) {
            background = new ImageIcon(resimler[0].getScaledInstance(400, 400, Image.SCALE_SMOOTH));
            jLabel2.setIcon(background);
        }
    }//GEN-LAST:event_formAncestorAdded


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton resimAc;
    // End of variables declaration//GEN-END:variables
}
