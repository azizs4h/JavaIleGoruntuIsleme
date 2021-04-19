package tools;

import javax.swing.JOptionPane;

public class uyarilar {

    public static void dosyaSecilmediUyarisi() {
        JOptionPane.showMessageDialog(
                null,
                "Lütfen Dosya Seçin",
                "Dosya Seçim Hatası",
                JOptionPane.ERROR_MESSAGE
        );
    }

    public static void noktaSecildiUyarisi() {
        JOptionPane.showMessageDialog(
                null,
                "Arka Plan Rengi Seçildi",
                "Nokta Secildi",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
