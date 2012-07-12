/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Image;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.util.List;

/**
 *
 * @author power
 */
public class Helper_Blending {
    public static BufferedImage BlendPoints_Average(BufferedImage b,List<Point> points){
        
        Point []n=new Point[4];
        int size=points.size();
        WritableRaster wr=b.getRaster();
        int[] abc=null;
        
        Point mainPoint;
        for(int i=0;i<size;i++){
            mainPoint=points.get(i);
            n[0]=new Point(mainPoint.x-1,mainPoint.y);//left point
            n[1]=new Point(mainPoint.x+1,mainPoint.y);//right point
            n[2]=new Point(mainPoint.x,mainPoint.y-1);//up point
            n[3]=new Point(mainPoint.x,mainPoint.y+1);//down point
            
            wr.setPixel(mainPoint.x, mainPoint.y, getAveragePixel(wr, mainPoint, n));
        }
        
        return b;
    }
    private static int[] getAveragePixel(WritableRaster wr,Point mainPoint, Point[] fourNeighbours){
        int []ans=new int[3];ans[0]=255;ans[1]=255;ans[2]=255;
        int [] main=wr.getPixel(mainPoint.x, mainPoint.y, ans);
        int [] left=wr.getPixel(fourNeighbours[0].x, fourNeighbours[0].y, ans);
        int [] right=wr.getPixel(fourNeighbours[1].x, fourNeighbours[1].y, ans);
        int [] up=wr.getPixel(fourNeighbours[2].x, fourNeighbours[2].y, ans);
        int [] down=wr.getPixel(fourNeighbours[3].x, fourNeighbours[3].y, ans);
        
        ans[0]=(2*left[0]+2*right[0]+2*up[0]+2*down[0]+4*main[0])/12;
        ans[1]=(2*left[1]+2*right[1]+2*up[1]+2*down[1]+4*main[1])/12;
        ans[2]=(2*left[2]+2*right[2]+2*up[2]+2*down[2]+4*main[2])/12;
        
        return ans;
    }
    
    //just converting a matrix to a BufferedImage
    public static BufferedImage maskToBinary(int[] [] mask,int width, int height){
        int[] white=new int[3];
        white[0]=255;
        white[1]=255;
        white[2]=255;
        BufferedImage b=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        WritableRaster r=b.getRaster();
        for(int i=0;i<width;i++)
            for(int j=0;j<height;j++){
                if(mask[i][j]>0){
                    r.setPixel(i, j, white);
                }
            }
        return b;
    }
}
