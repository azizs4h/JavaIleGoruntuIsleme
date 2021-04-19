package on_islem_menusu;

import java.awt.Color;
import java.awt.Graphics2D;
import tools.Tools;
import java.awt.image.BufferedImage;

public class CropImage {

    public BufferedImage crop(int x1, int y1, int x2, int y2, BufferedImage originalImage) {
         BufferedImage cropedImage = Tools.deepCopy(originalImage);
        BufferedImage bi = new BufferedImage(x2-x1+1, y2-y1+1, cropedImage.getType());
        Graphics2D graphics = bi.createGraphics();

        graphics.setPaint(new Color(255, 255, 255));// Beyaz Rengş ayarladık
        graphics.fillRect(0, 0, bi.getWidth() - 1, bi.getHeight() - 1);
        
//        int h = cropedImage.getHeight();
//        int w = cropedImage.getWidth();

        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                int p = cropedImage.getRGB(i, j);
                bi.setRGB(i-x1, j-y1,p );
            }
        }
        return bi;
///////////////////////////////////////////

//        BufferedImage cropedImage = Tools.deepCopy(originalImage);
////        BufferedImage newImage = 
//        int W = x2-x1;
//        int H = y2-y1;
//        int newPixel;
//        int x11 = x1;
//        int y11 = y1;
//        BufferedImage result = new BufferedImage(W+1, H+1, cropedImage.getType());
//        for (int c = 0; c < cropedImage.getRaster().getNumBands(); c++) // for all the channels/bands
//        {
//            for (x1=x11; x1 <= x2; x1++) // For all the image
//            {
//                for (y1=y11; y1 <= y2; y1++) {
//                    newPixel = cropedImage.getRaster().getSample(x1, y1, c);
//                    result.getRaster().setSample(x1-x11, y1-y11, c, newPixel);
//                }
//            }
//        }
//
//        return result;

//        return cropedImage.getSubimage(x1, y1, x2, y2);
    }
}
