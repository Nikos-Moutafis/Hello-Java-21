package pattern.matching;

public class Pattern {

    public static void main(String[] args) {
        System.out.println(asStringValue(1));
        System.out.println(asStringValue("Hello"));
        System.out.println(asStringValue(1L));
        System.out.println(asStringValue(1.0));
    }


    ///Before JDK 21
    public static void oldImplementation() {
        Object obj = "hello";

        if (obj instanceof  String) {
            String s = (String)  obj;
            System.out.println(s.toLowerCase());
        } else if (obj instanceof  Integer) {
            Integer i = (Integer) obj;
            System.out.println(i + 1);
        }
    }

    /**
     * Pattern Matching
     * -------------------------------------------------------------------------------
     * Simplify coding Patterns ->  reduce verbosity and complexity
     * -------------------------------------------------------------------------------
     * Data - oriented queries in a more straightforward way
     * -------------------------------------------------------------------------------
     * Improve safety: Automatic handling of type casting and reducing the risk of runtime erros
     *
     */
    public  static String asStringValue(Object anyValue) {
        return switch (anyValue) {
            case Integer i -> "int: " + i;
            case String s -> "String: " + s;
            case Long l -> "long: " + l;
            case Double d -> "double: " + d;
            default -> "unknown";
        };
    }


    public static void patternMatching() {
        Object obj = "hello from pattern";

        switch (obj) {
            case String s -> System.out.println(s.toLowerCase());
            case Integer i -> System.out.println(i + 1);
            default -> System.out.println("unsupported type");
        }
    }
}
