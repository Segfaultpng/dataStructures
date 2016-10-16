/**
 * Created by Stephen on 9/12/2016.
 */
public class Intcoll3 {

    private boolean[] c;
    private  int how_many;
    /*
    * Inctcoll1 constructor. creates a collection of type boolean[] with capacity of 500
    * */
    public Intcoll3()
    {
        c = new boolean[501];
        /*
        for (int x = 0; x< c.length; x++){
          c[x] = false;
        }
        */
        how_many = 0;
    }

    /*
    * Inctcoll1 constructor. creates a collection of type boolean[] with capacity of the provided integer.
    * @param i size of the collection we'd like to set.
    * */
    public Intcoll3(int i)
    {
        c = new boolean[i+1];
        how_many = 0;
    }
    /*
    * copy elements in an Intcoll obj into this classes
    * collection
    * @param obj Intcoll3 obj to copy collection elements from
    * */
    public void copy(Intcoll3 obj)
    {
        if (this != obj)
        {
            c = new boolean[obj.c.length];
            how_many = 0;
            int j = 0;
            int found = 0;
            while (found < obj.how_many)
            {
                if (c[j] != obj.c[j]){
                    c[j] = obj.c[j];
                    found++;
                    how_many++;
                }
                j++;
            }
        }
    }

    /*
    * check if the given integer is in the collection or not.
    * @param i the integer that we want to check for in the collection
    * @return true if the integer is in the collection and the integer is not 0
    * */
    public boolean belongs(int i)
    {

        if(c[i] == true){
            return true;
        }
        else {
            return false;
        }
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
            if(i > c.length -1) {

                // Make temp array
                boolean[] temp = new boolean[(i * 2) + 1];

                int x = 0;
                int found = 0;
                // copy items from c into the temp array
                while (found < how_many) {
                    if (temp[x] != c[x]) {
                        temp[x] = c[x];
                        found++;
                    }

                    x++;
                }
                // set the array to the new temp array
                c = temp;

            }
                if (c[i] != true){
                    c[i] = true;
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
            if (c[i] == true){
                c[i] = false;
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
        int j=0, howmany=0;

        while (c[j]!= false) {howmany++; j++;}
        return howmany;
    }
    /*
    *  print the entries in the collection
    * */
    public void print()
    {
        int j = 0;
        int found = 0;
        System.out.println();
        while (found < how_many)
        {
            if (c[j] != false){
                System.out.println(j);
                found++;
            }
            j++;
        }
    }
    /*
    *  checks to see if this classes collection is the same as the provided instance's collection.
    *  Instance of Intcoll3.
    *  @param obj Intcoll3 instance to compare collections with.
    *  @return true if both collections match completely (have the same entries).
    * */
    public boolean equals(Intcoll3 obj)
    {
        if (how_many == obj.how_many){
          int j = 0; boolean result = true;
            while (j < how_many){
                if (c[j] != obj.c[j]){
                    return false;
                }
                j++;
            }

            return result;
        }else {
            return false;
        }

    }

    public static void main(String[] args){

        Intcoll3 testcol = new Intcoll3();
        Intcoll3 testcol2 = new Intcoll3();
        testcol.insert(10);
        testcol.insert(80);
        testcol.insert(100);
        testcol.insert(200);
        testcol.insert(70);
        testcol.print();
        System.out.println("70 belongs in testcol1: " + testcol.belongs(70));
        testcol2.insert(10);
        testcol2.insert(80);
        testcol2.insert(100);
        testcol2.insert(200);
        testcol2.insert(70);
        testcol2.insert(90);
        testcol2.print();
        System.out.println("90 belongs in testcol2: " + testcol2.belongs(90));
        testcol.copy(testcol2);
        testcol.print();
        System.out.println("test1 == test 2: " + testcol.equals(testcol2));


    }
}
