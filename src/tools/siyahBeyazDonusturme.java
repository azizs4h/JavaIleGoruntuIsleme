package tools;

import java.awt.image.BufferedImage;

public class siyahBeyazDonusturme {

    public static BufferedImage convertToSiyahBeyaz(BufferedImage img) {
        img = griDonusturme.convertToGray(img);
        BufferedImage result = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());

        final int H = img.getHeight() - 1;
        final int W = img.getWidth() - 1;
        int currentPixel = 0;
        for (int c = 0; c < img.getRaster().getNumBands(); c++) // for all the channels/bands
        {
            for (int x = 1; x < W; x++) // For all the image
            {
                for (int y = 1; y < H; y++) {
                    currentPixel = img.getRaster().getSample(x, y, c);
                    if (currentPixel > 128) {
                        result.getRaster().setSample(x, y, c, 255);
                    } else {
                        result.getRaster().setSample(x, y, c, 0);
                    }
                }
            }
        }
        return result;
    }
}
