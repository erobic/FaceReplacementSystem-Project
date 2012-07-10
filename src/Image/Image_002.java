/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Image;

import CurveFitting.Interpolable;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
//import CurveFitting.SquarePolynomial_002;
import CurveFitting.SquarePolynomial_003;
import ShrinkingTest.ErosionClass;
import java.awt.Color;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;

/**
 *
 * @author power
 */
public class Image_002 {
    public BufferedImage originalImage=null;
    public BufferedImage clippedImage=null;//face region only
    private BufferedImage EdgeImage=null;//face region only
    private BufferedImage ycbcrBinary=null;
    
    public Rectangle rectangle=null;
    
    public List<Point> estimatedBoundary=null;
    public List<Point> leftLowerBoundary=null;
    public List<Point> rightLowereBoundary=null;
    public List<Point> leftMiddleBoundary=null;
    public List<Point> rightMiddleBoundary=null;
    public List<Point> leftUpBoundary=null;
    public List<Point> rightUpBoundary=null;
    public List<Point> lowBoundary=null;//this is all right
    public List<Point> leftLipToLeftChinEdge=null;//this is all right
    public List<Point> rightLipTorightChinEdge=null;//this is all right

    public Point leftEye=null;
    public Point rightEye=null;
    public Point nose=null;//not needed
    public Point lipCenter=null;
    public Point leftLipCorner=null;//
    public Point rightLipCorner=null;//
    public Point chinPoint=null;
    public Point leftChinEdge=null;
    public Point rightChinEdge=null;
    public Point leftLipEdge=null;
    public Point rightLipEdge=null;
    public Point leftEyeEdge=null;
    public Point rightEyeEdge=null;
    public Point leftLowerEar=null;
    public Point rightLowerEar=null;
    public Point leftUpHead=null;
    public Point rightUpHead=null;
    
    //prints information about the feature points
    public void printReport(){
        System.out.println("####Welcome to the report section###");
        System.out.println("The left Eye point is "+this.leftEye);
        System.out.println("The right Eye point is "+this.rightEye);
        System.out.println("The lip point i s  "+this.lipCenter);
        System.out.println("The chin Point  is "+this.chinPoint);
        System.out.println("The left chin edge is "+this.leftChinEdge);
        System.out.println("The right chin edge is "+this.rightChinEdge);
        System.out.println("####Report section finished######");
        
    }
    public void estimateCurve(){
        SquarePolynomial_003 sq=new SquarePolynomial_003();
        //Point [] p={leftLipEdge,rightLipEdge,chinPoint,leftChinEdge,rightChinEdge};
        Point [] pLL={chinPoint,leftChinEdge,leftLipEdge};
        sq.setPoints(pLL);
        Point [] pl={leftLipEdge,chinPoint};
        this.leftLowerBoundary=sq.getPoints(pl);
        Point[] p11={leftLipEdge,leftChinEdge};
        this.leftLipToLeftChinEdge=sq.getPoints(p11);
        
        Point[] pLR={chinPoint,rightChinEdge,rightLipEdge};
        Point[] p2={chinPoint,rightLipEdge};
        //this.leftLowerBoundary=sq.getPoints(p);
        this.rightLowereBoundary=sq.getPoints(p2);
        Point[]p22={rightChinEdge,rightLipEdge};
        this.rightLipTorightChinEdge=sq.getPoints(p22);
        
        Point[] lower={leftChinEdge,chinPoint,rightChinEdge};
        sq.setPoints(lower);
        Point [] low={leftChinEdge,rightChinEdge};
        this.lowBoundary=sq.getPoints(low);
        return;
        
    }
    public void drawEdgeCurve(Graphics g){
        g.setColor(Color.red);
        Point p;
        for(int i=0;i<this.lowBoundary.size();i++){
            p=lowBoundary.get(i);
            g.drawOval(p.x, p.y, 1, 1);
        }
        for(int i=0;i<this.leftLipToLeftChinEdge.size();i++){
            p=leftLipToLeftChinEdge.get(i);
            g.drawOval(p.x, p.y, 1, 1);
        }
        for(int i=0;i<this.rightLipTorightChinEdge.size();i++){
            p=rightLipTorightChinEdge.get(i);
            g.drawOval(p.x, p.y, 1, 1);
        }
    }
    //calculates if not already, and return the canny edge image

    /**
     * returns argb image of SIZE of original image with face region only
     * according to ycbcr mask
     * @return 
     */
    public BufferedImage getFaceRegion(){
        BufferedImage face=null;
        face=new BufferedImage(originalImage.getWidth(),originalImage.getHeight(),BufferedImage.TYPE_INT_ARGB);
        WritableRaster wrFace=face.getAlphaRaster();
        int [] a=new int[4];
        
        Raster wo=originalImage.getRaster();
        int []actual=new int [3];
        
        ycbcrBinary=ImageProcessor.analyseSkin(this.originalImage);
        WritableRaster wrBinary=ycbcrBinary.getRaster();
        int [] b=new int[3];int val;
        
        int[] write=new int[4];
        
        if(this.rectangle!=null){
            for(int i=0;i<rectangle.width;i++){
                for(int j=0;j<rectangle.height;j++){
                    val=wrBinary.getSample(i, j, 0);
                    if(val>0){//if the pixel of ycbcr model is white
                        actual=wo.getPixel(i, j, actual);//get original images pixel
                        write[0]=1;write[1]=actual[0];write[2]=actual[1];write[3]=actual[2];//convert to argb
                        wrFace.setPixel(i, j, actual);//writes to argb image
                    }
                }
            }
        }
        return face;
    }
    
    /**
     * returns the mask/binary_rgb of the image skin color of the same size of original image
     * with lower parts of edge points set to zero or black
     * @param abc
     * @return 
     */
    public BufferedImage getFaceMask(BufferedImage abc){
        BufferedImage face=null;
        face=new BufferedImage(abc.getWidth(),abc.getHeight(),BufferedImage.TYPE_INT_RGB);
        int startx,starty,width,height;
        if(this.rectangle!=null){
            startx=rectangle.x;
            starty=rectangle.y;
            width=rectangle.width+startx;
            height=rectangle.height+starty;
        }else{
            startx=0;starty=0;
            width=abc.getWidth();
            height=abc.getHeight();
        }
        BufferedImage ycbcrMask=ImageProcessor.analyseSkin(abc);
        //ImageProcessor.analyseSkin(HistogramEQ.histogramEqualization(abc));
        int [] a=new int[3];
        int [] white=new int[3];
        white[0]=255;white[1]=255;white[2]=255;
        int [] black=new int[3];
        black[0]=0;black[1]=0;black[2]=0;
        
        a[0]=255;a[1]=255;a[2]=255;
        WritableRaster wrf=face.getRaster();
        Raster ri=ycbcrMask.getRaster();
        Raster w=abc.getRaster();
        for(int i=startx;i<width;i++)
            for(int j=starty;j<height;j++){
                //wrf.setPixel(i, j, a);
                //face.setRGB(i, j, 0xFFFFFFFF);
                a=ri.getPixel(i, j, a);//RASTER of ycbcr
                if(a[0]>0){//ie skin color
                    //wrf.setPixel(i, j, w.getPixel(i, j, a));
                    wrf.setPixel(i, j, white);
                }
            }
        //low boundary=left lip edge to right chin edge
        for(int i=0;i<this.lowBoundary.size();i++){
            int ystart=lowBoundary.get(i).y;
            int x=lowBoundary.get(i).x;
            for(int j=ystart;j<rectangle.y+rectangle.height;j++){
                wrf.setPixel(x, j, black);
            }
        }
        for(int i=0;i<this.leftChinEdge.x;i++){
            for(int j=this.leftChinEdge.y;j<face.getHeight();j++){
                wrf.setPixel(i, j, black);
            }
        }
        for(int i=this.rightChinEdge.x;i<face.getWidth();i++){
            for(int j=rightChinEdge.y;j<face.getHeight();j++){
                wrf.setPixel(i, j, black);
            }
        }
        /*
        for(int i=0;i<this.leftLipToLeftChinEdge.size();i++){
            int ystart=leftLipToLeftChinEdge.get(i).y;
            int x=leftLipToLeftChinEdge.get(i).x;
            for(int j=ystart;j<rectangle.y+rectangle.height;j++){
                wrf.setPixel(x, j, black);
            }
        }
        for(int i=0;i<this.rightLipTorightChinEdge.size();i++){
            int ystart=rightLipTorightChinEdge.get(i).y;
            int x=rightLipTorightChinEdge.get(i).x;
            for(int j=ystart;j<rectangle.y+rectangle.height;j++){
                wrf.setPixel(x, j, black);
            }
        }*/
        return face;
    }
    private boolean isPointLowerThenChinCurve(int x,int y){
        boolean ans= false;
        int i;
        for(i=0;i<this.lowBoundary.size();i++){
            if(lowBoundary.get(i).x==x){
                if(lowBoundary.get(i).y<y)
                    ans=true;
                break;
            }
        }
        
        return ans;
    }
    
    /**
     * 
     * @return the face argb Image according to the face mask
     * of the size of face rectangle
     */
    public BufferedImage getFaceImageAccordingToYCbCr(){
        BufferedImage face;
        face=new BufferedImage(rectangle.width,rectangle.height,BufferedImage.TYPE_INT_ARGB);
        WritableRaster wr=face.getRaster();
        
        Raster or=originalImage.getRaster();
        BufferedImage mask=this.getFaceMask(originalImage);//if rectangle present then size=rectangle else full image
        //
        Raster mr=mask.getRaster();
        int [] a=new int[3];
        int [] argb=new int[4];
        for(int i=0;i<rectangle.width;i++){
            for(int j=0;j<rectangle.height;j++){
                a=mr.getPixel(rectangle.x+i, rectangle.y+j, a);
                if(a[0]>10){
                   argb[0]=0;argb[1]=a[0];argb[2]=a[1];argb[3]=a[2];
                    wr.setPixel(i, j, or.getPixel(rectangle.x+i, rectangle.y+j, argb));
                }
            }
        }
        
        return face;
    }
    /**
     * for the target image the face will be replaced by the face passed to it
     * @param face
     * @return face mask , black or white
     */
    public BufferedImage maskFaceImage(BufferedImage face){
        //draws the face in the original Image face rectangle and return another image
        BufferedImage mi=ImageProcessor.deepCopy(originalImage);
        Graphics g=mi.getGraphics();
        //g.drawImage(face, rectangle.x, rectangle.y, null);
        g.drawImage(face, rectangle.x, rectangle.y, rectangle.width, rectangle.height, null);
        return mi;
        
    }
    
    public int[][] getMaskMatrix(){
        BufferedImage b=this.getFaceImageAccordingToYCbCr();//size of rectangle argb image
//        ErosionClass c=new ErosionClass(10);
//        BufferedImage b=c.apply(
//                (originalImage.getSubimage(rectangle.x, rectangle.y, rectangle.width, rectangle.height)));
//        b=ImageProcessor.analyseSkin(b);
        int [][] mask = new int[b.getWidth()][b.getHeight()];
        int width=b.getWidth();
        int height=b.getHeight();
        int [] argb=new int [4];
        Raster r=b.getAlphaRaster();
        
        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                argb=r.getPixel(i, j, argb);
                if(argb[0]==0){
                    mask[i][j]=0;
                }else{
                    mask[i][j]=1;
                }
            }
        }
        return mask;
    }
    
    /**
     * 
     * @param a of the size of face rectangle
     * @return image according to mask
     */
    public BufferedImage convertMaskToFace(int[][] a){//size = rectangle
        BufferedImage b;
        b=new BufferedImage(rectangle.width,rectangle.height,BufferedImage.TYPE_INT_ARGB);
        //face only ,,size rectangle ARGB
        System.out.println("working finer");
        
        int width=b.getWidth()-1;
        int height=b.getHeight()-1;
        
        int [] argb=new int [4];
        int [] rgb=new int[3];
        
        Raster wro=originalImage.getRaster();
        WritableRaster argbRaster=b.getRaster();
        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                if(a[i][j]>0){
                    b.setRGB(i, j,originalImage.getRGB(rectangle.x+i, rectangle.y+j));
                    // b.setData(originalImage.getAlphaRaster());
                    //rgb=wro.getPixel(rectangle.x+i, rectangle.y+j, rgb);
                    //argb[0]=255;argb[1]=255;argb[2]=255;argb[3]=255;
                    //argbRaster.setPixel(i, j, wro.getPixel(rectangle.x+i, rectangle.y+j, argb));
                }
                else{
                    Color c = new Color(255,0,0,0);
                    b.setRGB(i,j,c.getRGB());
                }
            }
        }
        return b;
    }
    /**
     * It finds out the boundary of a binary image, expressed in the form of a 
     * 2D matrix. The value boundary[y][0] gives the left boundary pixel.
     * The value boundary[y][1] gives the right boundary pixel.
     * If the boundary point is not found, then its value is -1.
     */

    public int[][] findBoundary2(int[][] binaryMatrix, int w, int h) {
//        int width=w-1;
//        int height=h-1;
        int[][] boundary = new int[2][h];
        System.out.println("the width is "+w+" the height is "+h);
        if(binaryMatrix==null){
            System.out.println("the binary matrix passed to findBoundary is null");
            
        }else
        for (int y = 0; y < h; y++) {
            boundary[0][y] = -1;
            boundary[1][y] = -1;
            int xMin=0,xMax=w-1;
            for (xMin = 0;  xMin < w ; xMin++) {
                //boundary[0][y] = xMin;
                if(binaryMatrix[xMin][y] > 0 && xMin<w/4){
                    boundary[0][y]=xMin;break;
                }
            }

            for (xMax = w-1; xMax >= 0  ; xMax--) {
                //boundary[1][y] = xMax;
                if(binaryMatrix[xMax][y] >0 && xMax>w/2){
                    boundary[1][y]=xMax;
                    break;
                }
            }
            //System.out.println("xMin = "+xMin+" xMax = "+xMax);
        }
            
        
        return boundary;
    }
    
    public void drawBoundary(int [][] b, Graphics g, int width, int height){
        g.setColor(Color.red);
        //System.out.println("hello");
        System.out.println("Inside drawBoundary , the width is "+width+" the height is "+height);
        for(int y=0;y<height;y++)
        {
            for(int x=0;x<width;x++){
                if(b[x][y]>0)
                    g.drawOval(b[0][y],y,1,1);
                if(b[x][y]>0)
                g.drawOval(b[1][y],y,1,1);
            }
//            else
//                g.drawOval(0,y,1,1);
            
//            else
//                g.drawOval(0,y,1,1);
        }
     
    }   
    public void drawBoundary2(int [][] b, Graphics g, int width, int height){
        g.setColor(Color.red);
        //System.out.println("hello");
        //System.out.println("Inside drawBoundary , the width is "+width+" the height is "+height);
        for(int y=0;y<height;y++)
        {
            for(int x=0;x<width;x++){
                if(b[x][y]>0)
                    g.drawOval(x,y,1,1);
            }

        }
     
    }   
    public void drawBoundary3(int [][] b, Graphics g, int width, int height){
        g.setColor(Color.red);
        //System.out.println("hello");
        //System.out.println("Inside drawBoundary , the width is "+width+" the height is "+height);
        for(int y=0;y<height;y++)
        {
            if(b[0][y]>-1)
            for(int x=b[0][y];x<b[1][y];x++){
                g.drawOval(x, y, 1, 1);
            }
        }
    }   
    
    public int[][] holeFillAccordingToBoundary(int [][] mask1,int w, int h ){
        int [][] mask=mask1;//unfilled
        int [][] b=findBoundary2(mask, w, h);
        for(int y=0;y<h;y++)
        {
            if(b[0][y]>-1){
                for(int x=b[0][y];x<b[1][y];x++){
                    mask[x][y]=1;
                }
            }
        }
        return mask;
    }
    public int[][] holeFillAccordingToBoundary2(int [][] mask1,int w, int h ){
        int [][] mask=mask1;//unfilled
        int [][] b=findBoundary2(mask, w, h);
        for(int y=0;y<h;y++)
        {
            if(b[0][y]>-1){
                if(b[1][y]-b[0][y]<w/2){
                    for(int x=b[0][y];x<b[1][y];x++){
                     mask[x][y]=1;
                    }
                }else{
                    for(int x=b[0][y];x<b[1][y];x++){
                        mask[x][y]=1;
                    }
                }
            }
        }
        return mask;
    }
    
    public int [][] invertMatrix(int [][] mask,int width, int height){
        int[][] inverse=new int [height][width];
        for(int i=0;i<width;i++)
            for(int j=0;j<height;j++){
                try{
                inverse[j][i]=mask[i][j];
                }catch(Exception e){
                    System.out.println("exception at x="+i+" y="+j);
                }
                
            }
        return inverse;
    }
    
    public BufferedImage getFaceAccordingToSkinColorAndBoundaryFilling(){
        int width=rectangle.width;
        int height=rectangle.height;
        int [][] matrix=getMaskMatrix();//this is working fine
        int [][] boundary=findBoundary2(matrix, width-1, height-1);
        int [][] fineMatrix=holeFillAccordingToBoundary(matrix,width,height);
        int [][] inverseMatrix=invertMatrix(fineMatrix, width, height);
        int [][] finerMatrix=holeFillAccordingToBoundary(inverseMatrix,height,width);
        int [][] erectMatrix=invertMatrix(finerMatrix, height, width);
        return convertMaskToFace(holeFillAccordingToBoundary(erectMatrix,width,height));
    }
    
    
    
    //getters and setters
    public void setSource(String path) throws IOException{
        this.originalImage=ImageProcessor.createImage(path);
        if(path.equals("C:\\Users\\power\\Documents\\analysis images\\5213_101478120770_574905770_2616753_3748943_n.jpg")){
            System.out.println("Source set to \n"+path+"\n"+"5213_101478120770_574905770_2616753_3748943_n.jpg");
            this.rectangle=new Rectangle();
            rectangle.x=110;rectangle.y=164;rectangle.width=217;rectangle.height=267;
            this.leftEye=new Point(178,285);//.x=178;this.leftEye.y=285;
            this.rightEye=new Point(248,282);//.x=248;this.rightEye.y=282;
            this.lipCenter=new Point(223,361);//.x=223;this.lipCenter.y=361;
            this.chinPoint=new Point(225,425);//.x=225;this.chinPoint.y=425;
            this.leftChinEdge=new Point(185,417);//.x=185;this.leftChinEdge.y=417;
            this.leftLipEdge=new Point(149,382);//.x=149;this.leftChinEdge.y=382;
            this.rightChinEdge=new Point(271,405);//.x=271;this.rightChinEdge.y=405;
            this.rightLipEdge=new Point(304,371);//.x=304;this.rightLipEdge.y=371;
            estimateCurve(); 
            System.out.println("The curve is estimated");
        }else{
            System.out.println("the path is "+path);
        }
        
    }
    public void setRectangle(Rectangle rect){
        rectangle=rect;
        System.out.println("rectangle is "+rect.x+","+rect.y+" w="+rect.width+" h="+rect.height);
        clippedImage=ImageProcessor.deepSubCopy
                (originalImage.getSubimage(rect.x, rect.y, rect.width, rect.height));
        //clippedImage=originalImage.getSubimage(rect.x, rect.y, rect.width, rect.height);
    }
    public BufferedImage getImage(){
        if(clippedImage==null){
            return originalImage;
        }else{
            System.out.println("printing clippedImage");
            return clippedImage;
        }
    }
    public Point[] getLocalFeaturePointArray(){
        
        Point[] point=new Point[8];
        Rectangle r=this.rectangle;
        point[0]=new Point(leftEye.x-r.x,leftEye.y-r.y);
        point[1]=new Point(rightEye.x-r.x,rightEye.y-r.y);
        point[2]=new Point(chinPoint.x-r.x,chinPoint.y-r.y);
        point[3]=new Point(lipCenter.x-r.x,lipCenter.y-r.y);
        point[4]=new Point(leftChinEdge.x-r.x,leftChinEdge.y-r.y);
        point[5]=new Point(rightChinEdge.x-r.x,rightChinEdge.y-r.y);
        point[6]=new Point(leftLipEdge.x-r.x,leftLipEdge.y-r.y);
        point[7]=new Point(rightLipEdge.x-r.x,rightLipEdge.y-r.y);
       // point[0]=new Point(leftEye.x-r.x,leftEye.y-r.y);
        return point;
    }
}
