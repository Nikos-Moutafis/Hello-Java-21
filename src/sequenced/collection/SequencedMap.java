package sequenced.collection;

import java.util.LinkedHashMap;
import java.util.Map;

public class SequencedMap {


    static void main() {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        System.out.println(map);     // {a=1, b=2, c=3}

        map.put("a", 4);
        map.put("d", 5);
        System.out.println(map);  //   {a=4, b=2, c=3, d=5}

        System.out.println(map.entrySet().iterator().next());  //  a = 4

        Map.Entry<String, Integer> lastEntry = null;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            lastEntry = entry;
        }

        System.out.println(lastEntry);  // d = 5

        // Less verbose, more clean way with new methods
        System.out.println(map.firstEntry());    //  a = 4
        System.out.println(map.lastEntry());    // d = 5

        System.out.println(map.pollFirstEntry());  // a = 4
        System.out.println(map.pollLastEntry()); //  d = 5
        System.out.println(map);  //   {b=2, c=3}
    }
}
