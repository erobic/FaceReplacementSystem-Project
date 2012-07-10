/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Image;

/**
 *
 * @author power
 */
public class Counter {
    final int window = 128;
    int [] histogram;
    public Counter(){
        histogram = new int[256];
        for(int i=0;i<256;i++){
            histogram[i]=0;
        }
    }
    
    public void add(int a){
        histogram[a]++;
    }
    
    public int getHighestWindow(){
        int index=0;//to store highest window start
        int temp=0;//to store value of window
        int count=0;//to store count;
        for(int i=0;i<255-window;i++){
            count=0;
            for(int j=0;j<window;j++){
                count+=histogram[i+j];
            }
            if(count>temp){
                index=i;
                temp=count;
            }
        }
        System.out.println("returning histogram "+index);
        return index;
    }
    
    public int getWindow(){
        return window;
    }
}
