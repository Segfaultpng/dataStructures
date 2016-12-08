import java.util.Random;

/**
 * Created by Stephen on 11/14/2016.
 */
public class TheSortsFour {

    public static void main(String[] args)
    {
        int arraysize = 2048;
        QuickSortTest q = new QuickSortTest();
        InsertionSortTest inser = new InsertionSortTest();
        MergeSortTest merg = new MergeSortTest();
        int countP = 0;
        int[] counts = new int[4];
        while (arraysize < 16385){
            Random gen=new Random(); int[] a=new int[arraysize];
            int i; for (i=0; i<a.length; i++) a[i]=gen.nextInt(5000)+1;
            merg.mergesort(a, 0, a.length-1);
            counts[countP] = merg.m;
            countP++;
            System.out.println("Merge Sorted array Size: " + arraysize);
            //System.out.println("Done!");

            arraysize *=2;
        }
        merg.mergesort(counts,0,counts.length-1);
        int mavg = 0;
        for (int i=0; i<counts.length; i++){
                  mavg += counts[i];
        }
        System.out.println("Max: "+counts[0]);
        System.out.println("Min: "+counts[3]);
        System.out.println("Merge Avg: "+mavg/4);
        //Random gen=new Random(); int[] a=new int[32];
        //int i; for (i=0; i<a.length; i++) a[i]=gen.nextInt(5000)+1;
        /*
        System.out.println("Initial array:");
        for (i=0; i<a.length; i++) System.out.println(a[i] + " ");
        System.out.println();
        mergesort(a, 0, a.length-1);
        System.out.println("Sorted array:");
        for (i=0; i<a.length; i++) System.out.println(a[i] + " ");
        System.out.println("Done!");
        System.out.println("numcalls "+numcalls);
        System.out.println("count "+count+" m "+m);
        */
    }
}
