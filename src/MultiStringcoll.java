/**
 * Created by Stephen on 10/24/2016.
 */
public class MultiStringcoll {
    private int howmany;
    private int total;
    private btNode c;

    public MultiStringcoll()
    {
        c = null;
        howmany = 0;
        total = 0;
    }

    public MultiStringcoll(int i)
    {
        c = null;
        howmany = 0;
        total = 0;
    }

    private static btNode copytree(btNode t)
    {
        btNode root=null;
        if (t!=null)
        {
            root=new btNode();
            root.info=t.info;
            root.count=t.count;
            root.left=copytree(t.left);
            root.right=copytree(t.right);
        }
        return root;
    }

    public void copy(MultiStringcoll obj)
    {
        if (this!=obj)
        {
            howmany=obj.howmany;
            total = obj.total;
            c=copytree(obj.c);
        }
    }

    public void insert(String i)
    {
        if (i.compareTo("")!=0)
        {
            btNode pred=null, p=c;

            while ((p!=null)&&(p.info.compareTo(i)!=0))
            {
                pred=p;
                if (p.info.compareTo(i)>0) p=p.left;
                else p=p.right;
            }
            if (p==null)
            {
                howmany++;total++; p=new btNode(i, null, null);
                if (pred!=null)
                {
                    if (pred.info.compareTo(i)>0) pred.left=p;
                    else pred.right=p;
                }
                else c=p;
            }
            else if (p.info.compareTo(i) == 0){
                p.count += 1;
                total++;
            }
        }
    }

    public void omit(String i)
    {

        if (i != "")
        {
            btNode pred=null, tmp=null, p=c;

            while ((p!=null)&&(p.info.compareTo(i)!=0))
            {
                pred = p;
                if (p.info.compareTo(i)>0){
                    p=p.left;
                }
                else if (p.info.compareTo(i)<0) {
                    p = p.right;
                }

            }
            if(p != null && p.info.compareTo(i) == 0){

                if (p.count > 0){

                    p.count -= 1;
                    howmany--;
                    total--;
                }

                else if (p.left != null && p.right !=null){
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
                    total--;

                }
                else if(p.right == null && p.left != null){
                    if (pred == null){
                        c = p.left;
                    }else {
                        pred.left = p.left;
                        p = null;
                        howmany--;
                        total--;
                    }

                }else if(p.right != null && p.left == null){
                    if (pred == null){
                        c = p.right;
                    }else {
                        pred.right = p.right;
                        p = null;
                        howmany--;
                        total--;
                    }
                }else  if(p.right == null && p.left == null){
                    if (pred != null) {
                        if (pred.right != null && pred.right.info.compareTo(i) == 0) {
                            pred.right = null;
                        } else {
                            pred.left = null;
                        }
                        p = null;
                    }else {
                        p.right = null;
                        p.left = null;
                        p = null;
                        c=p;
                    }
                    howmany--;
                    total--;
                }
            }

        }

    }

    public boolean belongs(String i)
    {
        btNode p=c;
        while ((p!=null)&&(p.info!=i))
        {
            if (p.info.compareTo(i)>0) p=p.left;
            else p=p.right;
        }
        return (p!=null);
    }

    public int get_howmany() {return howmany;}

    public int get_total(){
        //int total = 0;
        //total = get_total_tree(c);
        return total;
    }
    /*
    public int get_total_tree(btNode t){

        int a =0;
        get_total_tree(t.left);
        a+= t.count+1;
        get_total_tree(t.right);

        return a;
    }
    */

    public void print()
    {
        printtree(c);
        System.out.println("There are "+get_total()+" strings in total");
    }

    public boolean equals(MultiStringcoll obj)
    {
        int j = 0; boolean result  = (howmany==obj.howmany) && (total == obj.total);
        if (result)
        {

            String[] thisarray = new String[howmany];

            toarray(c,thisarray,0);

            String[] objarray = new String[obj.howmany];
            toarray(obj.c,objarray,0);


            for (int x = 0; x<thisarray.length; x++){
                if (thisarray[x].compareTo(objarray[x]) != 0){
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
            System.out.println(t.info + "("+(t.count+1)+")");
            printtree(t.right);
        }
    }

    private static int toarray(btNode t, String[] a, int i)
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
        String info; int count; btNode left; btNode right;

        private btNode(String s, btNode lt, btNode rt)
        {
            info=s; left=lt; right=rt; count =0;
        }

        private btNode()
        {
            info=""; left=null; right=null; count=0;
        }
    }

    public static void main(String[] args){
        MultiStringcoll temp = new MultiStringcoll();
        MultiStringcoll temp1 = new MultiStringcoll();
        temp.insert("hello");
        temp.insert("hello");
        temp.insert("hi");

        //temp.print();

        //temp1.insert("d");
        //temp1.insert("f");
        //temp1.insert("g");
        //temp1.print();
        //temp1.insert(5);
        //temp1.insert(6);
        //temp2.copy(temp1);
        //System.out.println(temp.equals(temp1));
        temp.omit("bye");
        temp.print();
    }



}
