package sequenced.collection;

import java.util.LinkedHashSet;

public class SequencedSet {

    static void main() {
        //SequencedSet SequencedSet
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(40);
        set.add(50);
        set.add(60);
        set.add(70);
        set.add(80);
        set.add(90);
        set.add(100);


        System.out.println(STR."Set: \{set}");   //Set: [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]


        set.remove(10);
        System.out.println(STR."Set: \{set}"); //Set: [20, 30, 40, 50, 60, 70, 80, 90, 100]

        set.remove(100);
        System.out.println(STR."Set: \{set}");//Set: [20, 30, 40, 50, 60, 70, 80, 90]

        System.out.println(STR."Set reversed: " + set.reversed()); //Set reversed: [90, 80, 70, 60, 50, 40, 30, 20]

        System.out.println(STR."Set getFirst: \{set.getFirst()}");   // 20
        System.out.println(STR."Set getLast: \{set.getLast()}");    // 90
    }
}
