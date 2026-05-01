package foreign.memory.segments;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;

/**
 * Preview API
 */
public class MemorySegmentDemo {

    static void main() {
        /**
         * Creates a zero-length native segment from the given address value. The returned segment is associated with a scope that is always alive, and is accessible from any thread.
         */
//        MemorySegment functionPointer = MemorySegment.ofAddress();


        String s = "My string";
        try (Arena arena = Arena.ofConfined()) {

            // Allocate off-heap memory
            MemorySegment nativeText = arena.allocateUtf8String(s);

            // Access off-heap memory
//            That memory is off-heap because it is native memory, not a normal Java object.
            for (int i = 0; i < s.length(); i++ ) {
                System.out.print((char)nativeText.get(ValueLayout.JAVA_BYTE, i));
            }
        } // Off-heap memory is deallocated
    }
}
