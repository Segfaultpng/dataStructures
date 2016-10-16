import java.util.Scanner;

/**
 * Created by Stephen on 9/10/2016.
 */
public class Intcoll1 {

        private int[] c;
        /*
        * Inctcoll1 constructor. creates a collection of type int[] with capacity of 501
        * */
        public Intcoll1()
        {
            c = new int[500+1];
            c[0] = 0;
        }

        /*
        * Inctcoll1 constructor. creates a collection of type int[] with capacity of the provided integer.
        * @param i size of the collection we'd like to set.
        * */
        public Intcoll1(int i)
        {
            c = new int[i+1];
            c[0] = 0;
        }
    /*
    * copy elements in an Intcoll obj into this classes
    * collection
    * @param obj Intcoll1 obj to copy collection elements from
    * */
    public void copy(Intcoll1 obj)
    {
        if (this != obj)
        {
            c = new int[obj.c.length];
            int j = 0;
            while (obj.c[j] != 0)
            {
                c[j] = obj.c[j]; j++;
            }
            c[j] = 0;
        }
    }

    /*
    * check if the given integer is in the collection or not.
    * @param i the integer that we want to check for in the collection
    * @return true if the integer is in the collection and the integer is not 0
    * */
    public boolean belongs(int i)
    {
        int j = 0;
        while ((c[j] != 0)&&(c[j] != i)) j++;
        return ((i>0)&&(c[j] == i));
    }

    /*
    *  insert integer into the collection if it isn't there. If the integer is bigger
    *  then the available space in the collection the collection space
    *  is doubled and the integer is inserted.
    *  @param i integer to be inserted
    * */
    public void insert(int i)
    {
        if (i > 0)
        {
            int j = 0;
            while ((c[j] != 0) && (c[j] != i)) j++;
            if (c[j] == 0)
            {
                if (j == c.length - 1)
                {
                    // Make temp array
                    int[] temp = new int[(c.length*2)+1];

                    int x = 0;
                    // copy items from c into the temp array
                    while (c[x] != 0)
                    {
                        temp[x] = c[x];
                        x++;
                    }
                    // set the array to the new temp array
                    c = temp;


                }
                c[j] = i; c[j + 1] = 0;
            }
        }
    }

    /*
    * find integer in collection and move everything up starting from where the integer is located.
    * if the integer is greater then 0
    * @param the integer that we want to omit
    * */
    public void omit(int i)
    {
        if (i>0)
        {
            int j = 0;
            while ((c[j] != 0)&&(c[j] != i)) j++;
            if (c[j] == i)
            {
                int k = j+1;
                while (c[k] != 0) k++;
                c[j] = c[k-1]; c[k-1]=0;
            }
        }
    }

    /*
    * return how many entries are in the collection.
    * @return the number of entries found in the collection.
    * */
    public int get_howmany()
    {
        int j=0, howmany=0;

        while (c[j]!=0) {howmany++; j++;}
        return howmany;
    }
    /*
    *  print the entries in the collection
    * */
    public void print()
    {
        int j = 0;
        System.out.println();
        while (c[j] != 0)
        {
            System.out.println(c[j]); j++;
        }
    }
    /*
    *  checks to see if this classes collection is the same as the provided instance's collection.
    *  Instance of Incoll1.
    *  @param obj Incoll1 instance to compare collections with.
    *  @return true if both collections match completely (have the same entries).
    * */
    public boolean equals(Intcoll1 obj)
    {
        int j = 0; boolean result = true;
        while ((c[j] != 0)&&result)
        {
            result = obj.belongs(c[j]); j++;
        }
        j = 0;
        while ((obj.c[j] != 0)&&result)
        {
            result = belongs(obj.c[j]); j++;
        }
        return result;
    }

    public static void main(String[] args){

        Intcoll1 testcol = new Intcoll1();
        Intcoll1 testcol2 = new Intcoll1();
        testcol.insert(10);
        testcol.insert(20);
        testcol.insert(80);
        testcol.print();
        testcol2.insert(10);
        testcol2.insert(20);
        testcol2.insert(80);
        testcol2.insert(90);
        testcol2.print();
        testcol.copy(testcol2);
        System.out.println("test1 == test 2: "+ testcol.equals(testcol2));

    }

}