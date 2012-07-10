/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DilationTest;

import ShrinkingTest.Filter;
import ShrinkingTest.ImagingUtility;
import java.awt.image.BufferedImage;
/**
 *
 * @author Mubin
 */
public class Dilation extends Filter{
    int radius;
        
        public Dilation(int radius) {
                this.radius = radius;
        }
        
        private int maxAround(BufferedImage image, int row, int col) {
                int maxR = 0;
                int maxG = 0;
                int maxB = 0;
                int radius2 = radius * radius;
                for (int dRow = -radius; dRow <= radius; dRow++) {
                        for (int dCol = -radius; dCol <= radius; dCol++) {
                                if (dRow * dRow + dCol * dCol <= radius2) {
                                        int c = ImagingUtility.getRGBExtended(image, row + dRow, col + dCol);
                                        maxR = Math.max(maxR, (c >> 16) & 0xFF);
                                        maxG = Math.max(maxG, (c >> 8) & 0xFF);
                                        maxB = Math.max(maxB, c & 0xFF);
                                }
                        }
                }
                return (maxR << 16) | (maxG << 8) | maxB;
        }

        @Override
        public BufferedImage apply(BufferedImage image) {
                
                int width = image.getWidth();
                int height = image.getHeight();
                
                BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
                
                for (int row = 0; row < height && cancelFlag == false; row++) {
                        progress = 100 * row / height;
                        for (int col = 0; col < width && cancelFlag == false; col++) {
                                img.setRGB(col, row, maxAround(image, row, col));
                        }
                }
                
                return img;
        }


}
