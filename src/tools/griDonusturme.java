package tools;
import java.awt.image.BufferedImage;

public class griDonusturme {

    public static BufferedImage convertToGray(BufferedImage originalImage){
        BufferedImage grayImage = Tools.deepCopy(originalImage);
        int h = grayImage.getHeight();
        int w = grayImage.getWidth();
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                int p = grayImage.getRGB(i, j);
                int a = (p >> 24) & 0xff;
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = p & 0xff;
                int avg = (r + g + b) / 3;
                p = (a << 24) | (avg << 16) | (avg << 8) | avg;
                grayImage.setRGB(i, j, p);
            }
        }
        return grayImage;
    }
}
