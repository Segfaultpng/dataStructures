import java.util.Scanner;

/**
 * Created by Stephen on 10/24/2016.
 */
public class MultiStringcollclient {
    public static final String SENTINEL = "###";

    public static void main(String[] args)
    {
        String value; Scanner keyboard=new Scanner(System.in);
        MultiStringcoll P=new MultiStringcoll(), N=new MultiStringcoll(), L= new MultiStringcoll();

        System.out.println("Enter an integer to be inserted or ### to quit:");
        value=keyboard.nextLine();
        while(value.compareTo(SENTINEL) != 0)
        {
            if (value.substring(0,1).equals("+")) {P.insert(value.substring(1,value.length())); L.insert(value.substring(1,value.length()));}
            else {N.insert(value.substring(1,value.length())); L.omit(value.substring(1,value.length()));}
            System.out.println("Enter next integer to be inserted or ### to quit:");
            value=keyboard.nextLine();
        }
        System.out.println("\nThe values in collection P are:");
        P.print();
        System.out.println("\nThe values in collection N are:");
        N.print();
        System.out.println("\nThe values in collection L are:");
        L.print();
        if (P.equals(N)) System.out.println("\nP and N are equal.");
        else System.out.println("\nP and N are NOT equal.");
        MultiStringcoll A=new MultiStringcoll(); A.copy(L);
        System.out.println("\nThe values in the copy of L are:\n");
        A.print();
    }
}
