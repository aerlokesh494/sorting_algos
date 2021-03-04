import java.util.HashMap;
import java.util.Map;

public class Hash {
    public static void main(String[] args) {
        Map<String,Integer> m=new HashMap<>();

        m.put("lokesh",1);
        m.put("jyoti",2);
        m.put("himani",3);
        System.out.println(m.keySet());
        System.out.println(m.entrySet());
        for(String s:m.keySet()){
            System.out.println(s+" -> "+m.get(s));
        }


    }
}
