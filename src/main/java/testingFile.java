import java.util.IdentityHashMap;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by sruthipotluri on 12/13/17.
 */
public class testingFile {
    public static void main(String args[]){
        TreeMap<Integer,Integer> s1 = new TreeMap<>();
        TreeMap<Integer,Integer> s2 = new TreeMap<>();

        for(int i = 1; i < 5 ; i++)
         s1.put(i,i*3);

        for(int i = 3; i < 7 ; i++)
            s2.put(i,i*3);

        System.out.println(s1);

        System.out.println(s2);

      //  TreeSet<Integer> s1k = new TreeSet<>(s1.keySet());
      //  TreeSet<Integer> s2k  = new TreeSet<>(s2.keySet());

        Set<Integer> s1k = s1.keySet();
        Set<Integer> s2k  = s2.keySet();


        s2k.retainAll(s1k);

        System.out.println(s2k);

        System.out.println(s1);

        System.out.println(s2);

        System.out.println();
    }





}

