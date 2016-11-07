import java.util.Random;

/**
 * Created by Stephen on 11/7/2016.
 */
public class InsertionSortTest {
    static int icount = 0;

    public static void main(String[] args)
    {
        Random gen=new Random(); int[] a=new int[32];
        int i; for (i=0; i<a.length; i++) a[i]=gen.nextInt(5000)+1;
        System.out.println("Initial array:");
        for (i=0; i<a.length; i++) System.out.println(a[i] + " ");
        System.out.println();
        insertionSort(a);
        System.out.println("Sorted array:");
        for (i=0; i<a.length; i++) System.out.println(a[i] + " ");
        System.out.println("Done!");
        //System.out.println(" numcalls "+numcalls);
        System.out.println(" count "+icount);
    }

    public static void insertionSort(int[] thearray)
    {
        int x; //items sorted so far
        int key; //item to be inserted
        int i;  // tmp place holder

        for (x = 1; x < thearray.length; x++)
        {
            key = thearray[ x ];
            for(i = x - 1; (i >= 0) && (thearray[ i ] < key); i--)
            {
                thearray[ i+1] = thearray[i];
                //Smaller values are moved up
            }
            thearray[ i+1 ] = key;// Put the key in its proper location
            icount++;
        }
    }
}
