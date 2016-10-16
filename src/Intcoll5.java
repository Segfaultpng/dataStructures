import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by Stephen on 10/2/2016.
 */
public class Intcoll5 {

    private LinkedList<Integer> c;
    private  int how_many;

    /*
   * Inctcoll4 constructor. sets c equal to null and how_many = 0
   * */
    public Intcoll5(){
        c = new LinkedList<Integer>();
        how_many = 0;
    }

    /*
    * Inctcoll4 constructor. sets c equal to null and how_many = 0.
    * @param i size of the collection we'd like to set in the previous versions.
    * */
    public Intcoll5(int i){
        c = new LinkedList<Integer>();;
        how_many = 0;
    }

    /*
    * Check if integer i is in the linked list. return true if it's there false if it isn't
    * @param i integer to search for.
    * */
    public boolean belongs(int i)
    {
        Integer I=new Integer(i);
        return c.contains(I);

    }

    /*
    * create new link list entry with the integer provided. if i isn't present in the linked list
    * @param i integer to add.
    * */
    public void insert(int i)
    {

        Integer I=new Integer(i);
        if ((I>0)&&(!c.contains(I)))
        {
            c.addFirst(I);
            how_many++;
        }

    }

    /*
    * delete link list entry with the integer provided and mend the list back together. if i is present in the linked list
    * @param i integer to delete.
    * */
    public void omit(int i){

        Integer I = new Integer(i);
        if (c.contains(I)){
            c.remove(I);
            how_many--;
        }

    }

    /*
    * return how many entries are in the linked list.
    * @return the number of entries found in the linked list.
    * */
    public int get_howmany()
    {
        return how_many;
    }

    /*
    *  print the entries in the linked list
    * */
    public void print()
    {

        ListIterator<Integer> I=c.listIterator();
        while (I.hasNext())
        {
            Integer n = I.next();
            System.out.println(n.intValue());
        }
    }

    /*
    * copy Intcoll obj linked list into this classes
    * collection
    * @param obj Intcoll3 obj to copy collection elements from
    * */
    public void copy(Intcoll5 obj)
    {
        if (this != obj)
        {

            c = new LinkedList<Integer>();
            ListIterator<Integer> I=obj.c.listIterator();
            while (I.hasNext())
            {
                Integer n = I.next();
                c.add(n);
            }
            how_many = obj.how_many;

        }
    }

    /*
    *  checks to see if this classes linkedList is the same as the provided instance's linkedList.
    *  @param obj Intcoll5 instance to compare list with.
    *  @return true if both collections match completely (have the same entries).
    * */
    public boolean equals(Intcoll5 obj)
    {
        if (how_many == obj.how_many){
            boolean result = true;

            ListIterator<Integer> I=obj.c.listIterator();
            while (I.hasNext())
            {
                Integer n = I.next();
                if (c.contains(n) == false){
                    return false;
                }
            }

            return result;
        }else {
            return false;
        }

    }


    public static void main(String[] args){
        Intcoll5 temp = new Intcoll5();
        Intcoll5 temp1 = new Intcoll5();
        Intcoll5 temp2 = new Intcoll5();
        temp.insert(5);
        temp.insert(6);
        temp.print();
        temp1.insert(5);
        temp1.insert(6);
        temp2.copy(temp1);
        temp.omit(6);
        System.out.println(temp.equals(temp1));
        temp2.print();
    }
}
