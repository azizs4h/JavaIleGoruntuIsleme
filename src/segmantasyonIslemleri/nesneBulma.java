package segmantasyonIslemleri;

import java.awt.image.BufferedImage;
import java.util.Map;
import tools.griDonusturme;
import tools.siyahBeyazDonusturme;

public class nesneBulma {

    public static BufferedImage siyahBeyazNesneBul(BufferedImage img, int x, int y, int index) {

        if (index == 0) {
            img = siyahBeyazDonusturme.convertToSiyahBeyaz(img);
        }
        if(index == 1){
            img = griDonusturme.convertToGray(img);
        }
        CCL ccl = new CCL();
        try {
            int bgColor = 0xFFFFFF; // white default background color

            // TODO: Obtain background color.
            // An attempt to obtain bg color automatically: Center of image.
            System.out.println("image bg color: " + img.getRGB(img.getWidth() / 2, img.getHeight() / 2));
            System.out.println(String.format("0x%08X", img.getRGB(x, y)));
            bgColor = img.getRGB(x, y);
            Map<Integer, BufferedImage> components = ccl.Process(img, bgColor);
            for (Integer c : components.keySet()) {
                //ImageIO.write(components.get(c), format, new File(getBaseFileName(args[0]) + "-component-" + c + "."  + format));
            }
            //ImageIO.write(ccl.getProcessedImage(), format, new File(getBaseFileName(args[0]) + "-processed" + "." + format));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return ccl.getProcessedImage();
    }
}
