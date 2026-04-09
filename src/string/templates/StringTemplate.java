package string.templates;


/**
 * This is a preview feature
 * ------------------------------------------------------------------
 * Simplifies String expressions
 *and improves code maintainability
 */
public class StringTemplate {

    static void main() {
        String  name =  "Java";
        String version = "21";

        int a = 100;
        int b = 300;


        ///Before Java 21
        System.out.println("Hello, " + name + " " + version + "!");
        var message = String.format("Hello, %s %s!", name, version);
        System.out.println(message);

        /// With String templates, STR
        var messages = STR."Hello, \{name} \{version}!";
        System.out.print("String Templates: ");
        System.out.println(messages);

        var messageFromMethod = STR."Hello, \{getName()} \{version}";
        System.out.println(messageFromMethod);

        var result = STR."The sum of \{a} and  \{b} is \{a + b}";
        System.out.println(result);

        var currentDate = STR."Current date is  \{new java.util.Date()}";
        System.out.println(currentDate);
    }

    public static String getName() {
        return "Java";
    }
}