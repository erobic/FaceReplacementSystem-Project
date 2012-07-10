/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Image;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.color.ColorSpace;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageProcessor {
    public static BufferedImage deepCopy(BufferedImage bi) {
        ColorModel cm = bi.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = bi.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }
    public static BufferedImage deepSubCopy(BufferedImage bi){
        int w=bi.getWidth();
        int h=bi.getHeight();
        //BufferedImage bo=new BufferedImage(w,h,bi.getType());
        BufferedImage bo=new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
        Graphics g=bo.getGraphics();
        g.drawImage(bi, 0, 0, null);
        return bo;
        //return null;
    }
    public static BufferedImage createImage(String path) throws IOException{
        File file=new File(path);
        System.out.println("file present "+file.getAbsolutePath());
        BufferedImage input = ImageIO.read(file);
        return input;
    }

    public static BufferedImage getBinary(BufferedImage buffered){
        BufferedImageOp grayscaleConv0 = 
        new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
        BufferedImage grayscaleConv=new BufferedImage
                (buffered.getWidth(),buffered.getHeight(),BufferedImage.TYPE_BYTE_BINARY);
        
        return grayscaleConv0.filter(buffered, grayscaleConv);
    }
    public static float[] getPixelRatio(int[] RGB){
        float[] rgb = new float[3];
        float tot=(float)(RGB[0]+RGB[1]+RGB[2]+1);
        rgb[0]=RGB[0]/tot;
        rgb[1]=RGB[1]/tot;
        rgb[2]=RGB[2]/tot;
        return rgb;
    }
    //experiment codes, not methods
    public static int[] getYCbCr(int[] a){
        int [] b=new int[3];
        int R=a[0],G=a[1], B=a[2];
        int y = (int)( 0.299   * R + 0.587   * G + 0.114   * B);
        int Cb = (int)(-0.16874 * R - 0.33126 * G + 0.50000 *B);
        int Cr = (int)( 0.50000 * R - 0.41869 * G- 0.08131 * B);
        b[0]=y;
        b[1]=Cb;
        b[2]=Cr;
        return b;
}
    public static BufferedImage analyseSkin(BufferedImage b){
        BufferedImage o=deepCopy(b);
        WritableRaster wr=o.getRaster();
        
        
        int width=o.getWidth();
        int height=o.getHeight();
        
        BufferedImage Binary=new BufferedImage(width,height,BufferedImage.TYPE_BYTE_BINARY);
        WritableRaster wrb=Binary.getRaster();
        
        int[] a=null;
        final int [] BLACK={0,0,0};
        final int[] WHITE={255,255,255};
        int[] pixel=new int[3];
        
        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                a=ImageProcessor.getYCbCr(wr.getPixel(i, j, a));
                if(a[0]>120){
                    if(a[1]>-5){//cb>0=>black
                        wr.setPixel(i, j, BLACK);
                        
                    }else{
                        if(a[2]>0){
                            wr.setPixel(i, j, WHITE);
                        }else{
                            wr.setPixel(i, j, BLACK);
                        }
                    }
                }else{
                    wr.setPixel(i, j, BLACK);
                }
            }
        }
        //return o;
        return ImageProcessor.getBinary(o);
    }
    
    public static int[][] findSkinMatrix(BufferedImage b){
        BufferedImage o=deepSubCopy(b);
        WritableRaster wr=o.getRaster();
        int [][] maskMatrix=new int[b.getWidth()][b.getHeight()];
        int width=o.getWidth();
        int height=o.getHeight();
        
        BufferedImage Binary=new BufferedImage(width,height,BufferedImage.TYPE_BYTE_BINARY);
        WritableRaster wrb=Binary.getRaster();
        
        int[] a=null;
        final int [] BLACK={0,0,0};
        final int[] WHITE={255,255,255};
        int[] pixel=new int[3];
        
        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                a=ImageProcessor.getYCbCr(wr.getPixel(i, j, a));
                if(a[0]>120){
                    if(a[1]>-5){//cb>0=>black
                        wr.setPixel(i, j, BLACK);
                        maskMatrix[i][j] = 0;
                    }else{
                        if(a[2]>0){
                            wr.setPixel(i, j, WHITE);
                            maskMatrix[i][j] = 1;
                        }else{
                            wr.setPixel(i, j, BLACK);
                            maskMatrix[i][j] = 0;
                        }
                    }
                }else{
                    wr.setPixel(i, j, BLACK);
                    maskMatrix[i][j] = 0;
                }
            }
        }
        return maskMatrix;
        //return ImageProcessor.getBinary(o);
    }

    
    
}
