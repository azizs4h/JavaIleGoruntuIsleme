package morfolojikIslemler;

import tools.siyahBeyazDonusturme;
import java.awt.image.BufferedImage;
import pkg171220048_ömer_aziz_şahin.mainComponent;
import tools.Tools;

public class genisletme {

    public static BufferedImage genisletmeMetodu(BufferedImage img) {
        img = siyahBeyazDonusturme.convertToSiyahBeyaz(img);
        BufferedImage result = Tools.deepCopy(img);

        final int H = img.getHeight() - 1;
        final int W = img.getWidth() - 1;
        int currentPixel = 0;
        int newPixel = 0;
        int P1, P2, P3, P4, P5, P6, P7, P8, P9;
        P1 = P2 = P3 = P4 = P5 = P6 = P7 = P8 = P9 = 0;

        /*(Prewitt Algoritması)*/
        for (int c = 0; c < img.getRaster().getNumBands(); c++) // for all the channels/bands
        {
            for (int x = 1; x < W; x++) // For all the image
            {
                for (int y = 1; y < H; y++) {
                    newPixel = 0;

                    P2 = img.getRaster().getSample(x, y - 1, c);
                    P4 = img.getRaster().getSample(x - 1, y, c);
                    P5 = img.getRaster().getSample(x, y, c);
                    P6 = img.getRaster().getSample(x + 1, y, c);
                    P8 = img.getRaster().getSample(x, y + 1, c);

                    if (P5 == 1) {
                        result.getRaster().setSample(x, y - 1, c, 255);
                        result.getRaster().setSample(x - 1, y, c, 255);
                        result.getRaster().setSample(x + 1, y, c, 255);
                        result.getRaster().setSample(x, y + 1, c, 255);
                    }

                }
            }
        }

        return result;
    }
}
