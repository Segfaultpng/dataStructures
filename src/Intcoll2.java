/**
 * Created by Stephen on 9/11/2016.
 */
public class Intcoll2 {

    private int[] c;
    private  int how_many;
    /*
    * Intcoll2 constructor. creates a collection of type int[] with capacity of 500
    * initializes how_many at zero since the array is empty
    * */
    public Intcoll2()
    {
        c = new int[500];
        how_many = 0;
    }

    /*
    * Intcoll2 constructor. creates a collection of type int[] with capacity of the provided integer.
    * @param i size of the collection we'd like to set.
    * initializes how_many at zero since the array is empty
    * */
    public Intcoll2(int i)
    {
        c = new int[i];
        how_many = 0;
    }
    /*
    * copy elements in an Intcoll2 obj into this classes
    * collection
    * @param obj Intcoll2 obj to copy collection elements from
    * */
    public void copy(Intcoll2 obj)
    {
        if (this != obj)
        {
            c = new int[obj.c.length];
            how_many = 0;
            int j = 0;
            //int found = 0;
            while (j < obj.how_many)
            {

                c[j] = obj.c[j];
                j++;
                how_many++;
            }
            //c[j] = 0;
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
        while ((j < how_many)&&(c[j] != i)) j++;
        return (c[j] == i);
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
            while ((j < how_many) && (c[j] != i)) j++;
            if (j == how_many)
            {
                if (how_many == c.length)
                {
                    // Make temp array
                    int[] temp = new int[(c.length*2)+1];

                    int x = 0;
                    // copy items from c into the temp array
                    while (x < how_many)
                    {
                        temp[x] = c[x];
                        x++;
                    }
                    // set the array to the new temp array
                    c = temp;


                }
                c[j] = i;
                how_many++;
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
            while ((j < how_many)&&(c[j] != i)) j++;
            if (c[j] == i)
            {
                int k = j+1;
                while (c[k] != 0) k++;
                c[j] = c[k-1]; c[k-1]=0;
                how_many--;
            }
        }
    }

    /*
    * return how many entries are in the collection.
    * @return the number of entries found in the collection.
    * */
    public int get_howmany()
    {
        return how_many;
    }
    /*
    *  print the entries in the collection
    * */
    public void print()
    {
        int j = 0;
        System.out.println();
        while (j < how_many)
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
    public boolean equals(Intcoll2 obj)
    {
        int j = 0; boolean result = true;

        if(how_many == obj.how_many){

            while ((j < how_many)&&result)
            {
                result = obj.belongs(c[j]); j++;
            }
            j = 0;
            while ((obj.how_many < obj.how_many)&&result)
            {
                result = belongs(obj.c[j]); j++;
            }

        }else {
            return false;
        }

        return result;
    }

    public static void main(String[] args){

        Intcoll2 testcol = new Intcoll2();
        Intcoll2 testcol2 = new Intcoll2();
        testcol.insert(10);
        testcol.insert(80);
        testcol.insert(100);
        testcol.insert(200);
        testcol.insert(70);
        testcol.omit(70);
        testcol.print();
        testcol2.insert(10);
        testcol2.insert(80);
        testcol2.insert(100);
        testcol2.insert(200);
        testcol2.insert(70);
        testcol2.insert(90);
        testcol2.print();
        testcol.copy(testcol2);
        testcol.print();
        System.out.println("test1 == test 2: "+ testcol.equals(testcol2));

    }
}