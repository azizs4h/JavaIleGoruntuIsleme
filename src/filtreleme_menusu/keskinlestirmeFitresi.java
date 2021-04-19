package filtreleme_menusu;

import java.awt.image.BufferedImage;
import pkg171220048_ömer_aziz_şahin.mainComponent;

public class keskinlestirmeFitresi {

    public static BufferedImage keskinlestirmeFitresiMetodu() {

        BufferedImage img = mainComponent.resimler[1];
        BufferedImage result = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());

        final int H = img.getHeight() - 1;
        final int W = img.getWidth() - 1;
        int currentPixel = 0;
        int newPixel = 0;
        int komsuluklarToplami = 0;
        int P1, P2, P3, P4, P5, P6, P7, P8, P9;
        P1 = P2 = P3 = P4 = P5 = P6 = P7 = P8 = P9 = 0;

        for (int c = 0; c < img.getRaster().getNumBands(); c++) // for all the channels/bands
        {
            for (int x = 1; x < W; x++) // For all the image
            {
                for (int y = 1; y < H; y++) {
                    newPixel = 0;
                    komsuluklarToplami = 0;

                    P2 = img.getRaster().getSample(x, y - 1, c);
                    P4 = img.getRaster().getSample(x - 1, y, c);
                    P5 = img.getRaster().getSample(x, y, c);
                    P6 = img.getRaster().getSample(x + 1, y, c);
                    P8 = img.getRaster().getSample(x, y + 1, c);

                    P2 *= -2;
                    P4 *= -2;
                    P6 *= -2;
                    P8 *= -2;
                    P5 *= 11;

                    currentPixel = img.getRaster().getSample(x, y, c);
                    newPixel = (P2+P4+P5+P6+P8)/3;
                    if (newPixel < 0) {
                        newPixel = 0;
                    }
                    if (newPixel > 255) {
                        newPixel = 255;
                    }
                    result.getRaster().setSample(x, y, c, newPixel);
                }
            }
        }

        return result;
    }
    /*
        [ 0,-2,0;
        -2, 11,-2;
        0,-2,0];
     */

}
