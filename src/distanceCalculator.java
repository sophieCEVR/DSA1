
import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import java.util.Random;
/**
 *
 * @author 100021268
 */
public class distanceCalculator {

    public static void main(String[] args) {
        long t1 = System.nanoTime();
        String output=distanceCalculator();
        long t2 = System.nanoTime() - t1;
        //System.out.print("Time Taken : " + t2/1000000000.0 + " seconds \n");
        System.out.print(output);
    }
    
    public static int[] generateQuery(int k) {
        int[] q = new int[k];
        Random r = new Random();
        for (int i = 0; i < k; i++) {
            q[i] = abs(r.nextInt() % 1000);
        }
        return q;
    }
    
    public static int[][] generateDataSet(int n) {
        int[][] data = new int[n][n];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                data[i][j] = abs(r.nextInt() % 1000);
            }
        }
        return data;
    }
    
    public static String distanceCalculator(){
        int k=5;
        int n=10;
        double m;
        int[][] T=generateDataSet(n);
        int[] S=generateQuery(k); 
        int sequenceLength=0;
        if(n>k){ //if k and n are set to the same 
            sequenceLength = S.length; 
        }
        double distance = 0; 
        String result="";
        for(int i=0; i<n; i++){
            for(int j=0; j<(n-sequenceLength); j++){
                    m=(Math.pow((T[i][j]-S[j%k]),2));//mod allows me to use one
                    //loop here as opposed to 2
                    double sqrtNum=sqrt(m);
                    if (i==0 && j==1){//for the first element in the 2D array
                        distance=sqrtNum;
                        result=" T[" + i + "][" + j + "] \n";
                    }
                    else if(sqrtNum<distance){//if any future elements have a 
                        //smaller distance 
                        distance=sqrtNum;
                        result=" T [" + i + "][" + j + "] \n" ;
                    } 
                    else if(sqrtNum==distance){ //for any elements with the 
                        //same distance as the previously stored distance
                        result=result + " T [" + i + "][" + j + "] \n" ;
                    }
            }
        }
        return result;
    }
}
