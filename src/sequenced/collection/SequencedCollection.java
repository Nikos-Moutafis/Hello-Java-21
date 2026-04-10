package sequenced.collection;


import java.util.ArrayList;
import java.util.LinkedHashSet;

/**
 *  Collections from now on contains Sequenced Interfaces
 * Helps with manipulate Collections in cases where the
 * order of the items in the collection matters
 *-------------------------------------------------------------------------------------
 * New interfaces:
 * SequencedCollection
 * SequencedSet
 * SequencedMap
 *
 *
 */
public class SequencedCollection {


    static void main() {
        /// new classes and methods help with manipulation of data structures like List
        manipulateList();
    }

    private static void manipulateList() {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(10);
        list.addFirst(0);
        list.addLast(20);
        System.out.println(STR."list: \{list}");                  // 0, 10, 20
        System.out.println(list.getFirst());               //  0
        System.out.println(list.getLast());                //  20
        System.out.println(list.reversed());             //  21,10,0
        System.out.println(list.removeFirst());      // 0
        System.out.println(list);                                 // 10, 20
        System.out.println(list.removeLast());      // 20
        System.out.println(list);                                // 10
    }
}