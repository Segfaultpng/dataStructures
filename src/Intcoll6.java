/**
 * Created by Stephen on 10/16/2016.
 */
public class Intcoll6
{
    private int howmany;
    private btNode c;

    public Intcoll6()
    {
        c = null;
        howmany = 0;
    }

    public Intcoll6(int i)
    {
        c = null;
        howmany = 0;
    }

    private static btNode copytree(btNode t)
    {
        btNode root=null;
        if (t!=null)
        {
            root=new btNode();
            root.info=t.info;
            root.left=copytree(t.left);
            root.right=copytree(t.right);
        }
        return root;
    }

    public void copy(Intcoll6 obj)
    {
        if (this!=obj)
        {
            howmany=obj.howmany;
            c=copytree(obj.c);
        }
    }

    public void insert(int i)
    {
        if (i>0)
        {
            btNode pred=null, p=c;

            while ((p!=null)&&(p.info!=i))
            {
                pred=p;
                if (p.info>i) p=p.left;
                else p=p.right;
            }
            if (p==null)
            {
                howmany++; p=new btNode(i, null, null);
                if (pred!=null)
                {
                    if (pred.info>i) pred.left=p;
                    else pred.right=p;
                }
                else c=p;
            }
        }
    }

    public void omit(int i)
    {

        if (i>0)
        {
            btNode pred=null, tmp=null, p=c;

            while ((p!=null)&&(p.info!=i))
            {
                pred = p;
                if (p.info>i){
                    p=p.left;
                }
                else {
                    p = p.right;
                }
            }
            if(p != null && p.info == i){

                if (p.left != null && p.right !=null){
                    tmp = p;  btNode tmpPred = null;
                    while (tmp.left != null){

                            tmpPred = tmp;

                        //pred = tmp;
                        tmp = tmp.left;
                        if (tmp.right == null){
                            break;
                        }
                        while (tmp.right != null){
                              //pred = tmp;

                                tmpPred = tmp;

                              tmp = tmp.right;
                        } /*
                        if (tmp.right != null){
                            //pred = tmp;
                            tmp = tmp.right;
                        }else {
                            break;
                        }
                        */
                    }
                    if (pred == null){
                        /*
                        c = null;
                        tmp.left = p.left;
                        c = tmp;
                        */
                        p.info = tmp.info;
                        if (tmpPred.right != null && tmpPred.right == tmp){
                            tmpPred.right = null;
                        }
                        else {
                            tmpPred.left = null;
                        }
                        tmp = null;
                        //p = tmp;
                    }else {
                        tmp.right = p.right;

                        if (tmpPred.right !=null && tmpPred.left == null){
                            tmpPred.right = null;
                            tmp.left = p.left;
                        }

                        p = tmp;

                        if (pred.left != null && pred.left.left == p) {
                            pred.left = p;
                        } else {
                            pred.right = p;
                        }
                    }
                   // p.info = tmp.info;
                    //tmp = null;
                    //p=null;
                    //pred.left = null;pred.right = null;
                    howmany--;

                }
                else if(p.right == null && p.left != null){
                    //tmp = p;
                    pred.left = p.left;
                    p = null;
                    howmany--;

                }else if(p.right != null && p.left == null){
                    pred.right = p.right;
                    p = null;
                    howmany--;
                }else  if(p.right == null && p.left == null){
                    if (pred.right != null && pred.right.info == i){
                         pred.right = null;
                    }else {
                        pred.left = null;
                    }
                    p = null;
                    howmany--;
                }
            }

        }

    }

    public boolean belongs(int i)
    {
        btNode p=c;
        while ((p!=null)&&(p.info!=i))
        {
            if (p.info>i) p=p.left;
            else p=p.right;
        }
        return (p!=null);
    }

    public int get_howmany() {return howmany;}

    public void print()
    {
        printtree(c);
    }

    public boolean equals(Intcoll6 obj)
    {
        int j = 0; boolean result  = (howmany==obj.howmany);
        if (result)
        {

            int[] thisarray = new int[howmany];

                toarray(c,thisarray,0);

            int[] objarray = new int[obj.howmany];
                toarray(obj.c,objarray,0);


            for (int x = 0; x<thisarray.length; x++){
                if (thisarray[x] != objarray[x]){
                    return false;
                }
            }

        }
        return result;
    }

    private static void printtree(btNode t)
    {
        if (t!=null)
        {
            printtree(t.left);
            System.out.println(t.info);
            printtree(t.right);
        }
    }

    private static int toarray(btNode t, int[] a, int i)
    {
        int num_nodes=0;
        if (t!=null)
        {
            num_nodes=toarray(t.left, a, i);
            a[num_nodes+i]=t.info;
            num_nodes=num_nodes+1+toarray(t.right, a, num_nodes+i+1);
        }
        return num_nodes;
    }

    private static class btNode
    {
        int info; btNode left; btNode right;

        private btNode(int s, btNode lt, btNode rt)
        {
            info=s; left=lt; right=rt;
        }

        private btNode()
        {
            info=0; left=null; right=null;
        }
    }


    public static void main(String[] args){
        Intcoll6 temp = new Intcoll6();
        Intcoll6 temp1 = new Intcoll6();
        temp.insert(12);
        temp.insert(24);
        temp.insert(23);
        temp.insert(25);
        temp.insert(7);
        temp.insert(6);
        temp.insert(5);
        temp.insert(8);
        temp.insert(9);
        //temp.print();

        temp1.insert(6);
        temp1.insert(7);
        temp1.insert(4);
        temp1.insert(5);
        temp1.insert(9);
        //temp1.print();
        //temp1.insert(5);
        //temp1.insert(6);
        //temp2.copy(temp1);
        System.out.println(temp.equals(temp1));
        temp.omit(24);
        temp.print();
    }
}