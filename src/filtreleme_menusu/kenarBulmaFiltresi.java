package filtreleme_menusu;

import java.awt.image.BufferedImage;
import pkg171220048_ömer_aziz_şahin.mainComponent;

public class kenarBulmaFiltresi {

    public static BufferedImage kenarBulmaFitresiMetodu() {

        BufferedImage img = mainComponent.resimler[1];
        BufferedImage result = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());

        final int H = img.getHeight() - 1;
        final int W = img.getWidth() - 1;
        int currentPixel = 0;
        int newPixel = 0;
        int P1, P2, P3, P4, P6, P7, P8, P9;
        P1 = P2 = P3 = P4 = P6 = P7 = P8 = P9 = 0;
        
/*(Prewitt Algoritması)*/

        for (int c = 0; c < img.getRaster().getNumBands(); c++) // for all the channels/bands
        {
            for (int x = 1; x < W; x++) // For all the image
            {
                for (int y = 1; y < H; y++) {
                    newPixel = 0;

                    P1 = img.getRaster().getSample(x - 1, y - 1, c);
                    P2 = img.getRaster().getSample(x, y - 1, c);
                    P3 = img.getRaster().getSample(x + 1, y - 1, c);
                    P4 = img.getRaster().getSample(x - 1, y, c);
                    P6 = img.getRaster().getSample(x + 1, y, c);
                    P7 = img.getRaster().getSample(x - 1, y + 1, c);
                    P8 = img.getRaster().getSample(x, y + 1, c);
                    P9 = img.getRaster().getSample(x + 1, y + 1, c);

                    int Gx = Math.abs(-P1 + P3 - P4 + P6 - P7 + P9); //Dikey çizgileri Bulur
                    int Gy = Math.abs(P1 + P2 + P3 - P7 - P8 - P9); //Yatay Çizgileri Bulur.
                    
                    newPixel = (int) Math.sqrt(Gx * Gx + Gy * Gy);
                            
                    if (newPixel > 255) {
                        newPixel = 255;
                    }
                    result.getRaster().setSample(x, y, c, newPixel);
                }
            }
        }

        return result;
    }
}
