/**
 * Created by Stephen on 9/18/2016.
 */
public class Intcoll4 {

    private ListNode c;
    private  int how_many;

    /*
   * Inctcoll4 constructor. sets c equal to null and how_many = 0
   * */
    public Intcoll4(){
        c = null;
        how_many = 0;
    }

    /*
    * Inctcoll4 constructor. sets c equal to null and how_many = 0.
    * @param i size of the collection we'd like to set in the previous versions.
    * */
    public Intcoll4(int i){
        c = null;
        how_many = 0;
    }

    /*
    * Check if integer i is in the linked list. return true if it's there false if it isn't
    * @param i integer to search for.
    * */
    public boolean belongs(int i)
    {
        ListNode p;
        p = c;
        while((p != null) && (p.info != i)){
            p = p.link;
        }
        return (p!=null);
    }

    /*
    * create new link list entry with the integer provided. if i isn't present in the linked list
    * @param i integer to add.
    * */
    public void insert(int i)
    {
        ListNode p;
        p = c;
        while((p != null) && (p.info != i)){
            p = p.link;
        }
        if (p == null){
            how_many++;
            p = new ListNode(i,c);
            c= p;
            int[] temp;
            temp = new int[20];
        }

    }

    /*
    * delete link list entry with the integer provided and mend the list back together. if i is present in the linked list
    * @param i integer to delete.
    * */
    public void omit(int i){
        ListNode p,pred;
        p = c;
        pred = null;
        while((p != null) && (p.info != i)){
            pred = p;
            p = p.link;
        }
        if(p != null){
            if (pred !=null){
                pred.link = p.link;
                how_many--;
            } else {
                p = p.link;
                how_many--;
                c = p;
                return;
            }

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
        ListNode p;
        p = c;
        while((p != null)){
            System.out.println(p.info);
            p = p.link;
        }
    }

    /*
    * copy Intcoll obj linked list into this classes
    * collection
    * @param obj Intcoll3 obj to copy collection elements from
    * */
    public void copy(Intcoll4 obj)
    {
        if (this != obj)
        {

            c = obj.c;
            how_many = obj.how_many;

        }
    }

    /*
    *  checks to see if this classes linkedList is the same as the provided instance's linkedList.
    *  @param obj Intcoll4 instance to compare list with.
    *  @return true if both collections match completely (have the same entries).
    * */
    public boolean equals(Intcoll4 obj)
    {
        if (how_many == obj.how_many){
            boolean result = true;
            ListNode p;
            p = c;
            while((p != null)){
                ListNode q;
                q = obj.c;
                while((q != null)){
                    if (p.info != q.info){
                        result = false;
                    }
                    else {
                        result = true;
                        break;
                    }
                    q = q.link;
                }
                if (result == false){
                    return false;
                }
                p = p.link;
            }

            return result;
        }else {
            return false;
        }

    }


    public static void main(String[] args){
        Intcoll4 temp = new Intcoll4();
        Intcoll4 temp1 = new Intcoll4();
        temp.insert(5);
        temp.insert(6);
        temp.print();
        temp1.insert(5);
        temp1.insert(6);
        temp.omit(6);
        System.out.println(temp.equals(temp1));
    }

    private class ListNode{

        private int info;
        private  ListNode link;

        /*
        * ListNode constructor. sets info equal to 0 and link = null.
        * @param i size of the collection we'd like to set in the previous versions.
        * */
        public ListNode(){
            info = 0;
            link = null;
        }

        /*
        * ListNode constructor. sets info equal to i and link = p.
        * @param i info of the listNode obj.
        * @param p link of the listNode obj.
        * */
        public ListNode(int i,ListNode p){
            info = i;
            link = p;
        }
    }
}
