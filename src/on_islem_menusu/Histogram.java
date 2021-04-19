package on_islem_menusu;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Histogram {

    private static int luminance(int rgb, int color) {
        int r = (rgb >> 16) & 0xFF;
        int g = (rgb >> 8) & 0xFF;
        int b = rgb & 0xFF;

        switch (color) {
            //RED
            case 0:
                return r;
            //GREEN
            case 1:
                return g;
            //BLUE
            case 2:
                return b;
            default:
                return (r + b + g) / 3;
        }
    }

    public static int calc_range(int color_count, int pixcount, int min, int max) {
        float normalized_data = (float)(color_count-min)/(max-min);
//        normalize edilmiş data 0-1 aralığında değer verir. 
        int ranged_data = (int)((float)255*normalized_data);
        return 255-ranged_data;
        //GRAFİK TAKLA ATMASIN DİYE
    }

    public static BufferedImage computeHistogram(BufferedImage img) {
        int width = img.getWidth();
        int height = img.getHeight();
        
        BufferedImage histogramImage = new BufferedImage(256, 256, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = histogramImage.createGraphics();
        
        graphics.setPaint(new Color(255, 255, 255));// Beyaz Rengş ayarladık
        graphics.fillRect(0, 0, histogramImage.getWidth() - 1, histogramImage.getHeight() - 1);

        int pixcount = img.getHeight() * img.getWidth();
        int RED = 16711680;
        int GREEN = 65280;
        int BLUE = 255;
        int[] histo_r = new int[256];
        int[] histo_g = new int[256];
        int[] histo_b = new int[256];
        
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                histo_r[luminance(img.getRGB(x, y), 0)]++;
                histo_g[luminance(img.getRGB(x, y), 1)]++;
                histo_b[luminance(img.getRGB(x, y), 2)]++;
            }
        }//hangi renkten kaç tane var onu sayıyıoruz
        int min_r = getMin(histo_r);
        int max_r = getMax(histo_r);
        int min_g = getMin(histo_g);
        int max_g = getMax(histo_g);
        int min_b = getMin(histo_b);
        int max_b = getMax(histo_b);
        //https://datascience.stackexchange.com/questions/5885/how-to-scale-an-array-of-signed-integers-to-range-from-0-to-1
        
        for (int y = 0; y < histogramImage.getWidth() - 1; y++) {
            histogramImage.setRGB(y, calc_range(histo_r[y], pixcount, min_r, max_r), RED);
            histogramImage.setRGB(y + 1, calc_range(histo_r[y], pixcount, min_r, max_r), RED);

            histogramImage.setRGB(y, calc_range(histo_g[y], pixcount, min_g, max_g), GREEN);
            histogramImage.setRGB(y + 1, calc_range(histo_g[y], pixcount, min_g, max_g), GREEN);

            histogramImage.setRGB(y, calc_range(histo_b[y], pixcount, min_b, max_b), BLUE);
            histogramImage.setRGB(y + 1, calc_range(histo_b[y], pixcount, min_b, max_b), BLUE);
        }
        return histogramImage;
    }
    
      // Method for getting the maximum value
  public static int getMax(int[] inputArray){ 
    int maxValue = inputArray[0]; 
    for(int i=1;i < inputArray.length;i++){ 
      if(inputArray[i] > maxValue){ 
         maxValue = inputArray[i]; 
      } 
    } 
    return maxValue; 
  }
 
  // Method for getting the minimum value
  public static int getMin(int[] inputArray){ 
    int minValue = inputArray[0]; 
    for(int i=1;i<inputArray.length;i++){ 
      if(inputArray[i] < minValue){ 
        minValue = inputArray[i]; 
      } 
    } 
    return minValue; 
  } 

}
