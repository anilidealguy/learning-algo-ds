package asked.sn2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Q2 {
    public static void main(String[] args) {
        List<Integer> list1= new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);

        Iterator<Integer> it = list1.iterator();
        while(it.hasNext()){
            Integer value = it.next();
            System.out.println("ListValue:"+value);
            if(value.equals(3))
            {
                list1.remove(value);
            }

        }
    }
}
