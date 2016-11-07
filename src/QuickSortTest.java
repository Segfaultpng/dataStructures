import java.util.Random;

/**
 * Created by Stephen on 11/7/2016.
 */
public class QuickSortTest {


    public static void main(String[] args)
    {
        Random gen=new Random(); int[] a=new int[32];
        int i; for (i=0; i<a.length; i++) a[i]=gen.nextInt(5000)+1;
        System.out.println("Initial array:");
        for (i=0; i<a.length; i++) System.out.println(a[i] + " ");
        System.out.println();
        quicksort(a, 0, a.length-1);
        System.out.println("Sorted array:");
        for (i=0; i<a.length; i++) System.out.println(a[i] + " ");
        System.out.println("Done!");
        //System.out.println(" numcalls "+numcalls);
        System.out.println(" count "+qcount);
    }

    static int qcount = 0;


    /* Rearranges the entries in array
        data between positions indexed by
        i and j and returns an array index
        which guarantees that all entries
        above it are larger than the entry
        it indexes, and all entries below
        it are smaller.
        */
    public static int partition (int[] data, int i, int j)
    {
        int upper, lower, save;

        upper = i; lower = j; save=data[i];
        while(upper != lower)
        {

            while((upper < lower) && (save >=data[lower])) lower--;
            if(upper != lower){
                data[upper]=data[lower];
                qcount++;
            }
            while((upper < lower) && (save <= data[upper]))
                upper++;
            if(upper != lower){
                data[lower]=data[upper];
                qcount++;
            }
        }
        data[upper]=save;
        return(upper);
    }

    /* Sorts the array data between positions
    indexed by i and j in descending order.
    */
    public static void quicksort (int[] data, int i, int j)
    {
        int p;
        if(i < j)
        {
            p = partition (data,i,j);
            quicksort (data,i,p-1);
            quicksort (data,p+1,j);
        }
    }



}
