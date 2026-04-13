package record.patterns;

public class Deconstructors {

    static void main(String[] args) {
        record Customer(String name, int age){}
        var customer = new Customer("John", 30);

        //direct cast to Customer
        if (customer instanceof Customer c) {
            System.out.println(c.name);
            System.out.println(c.age);
        }

        // Record to deconstruct data directly
        if (customer instanceof Customer(String name, int age)) {
            System.out.println(name + " is " + age + " years old");
        }

        // Component Matching
        record Name(String firstname, String lastname, int age) {}
        Name name = new Name("John ", " Doe", 30);

        if (name instanceof  Name(var firstname, var  surname, var a)) {
            System.out.println(firstname + surname + " is " + a + " years old");
        }

        // Nested Patterns
        record Address(String street, String city, String state, String zip) {}
        record Person(Name name, Address address){}

        Person person = new Person(name, new Address("baker", "london" , "uk" , "1211"));

        //deconstruct of variables
        if (person instanceof Person(Name (var first, var surname, var ageInYears), Address(String street, String city, String state, String zip))){
            System.out.println(first + surname + " is " + ageInYears + " years old and lives at  " + street + "  " + city + "  " + state + "  " + zip );
        }


        // Record patterns in Switch
        Name name2 = new Name("John", "doe", 30);
        switch (name2) {
            case Name(var firstname, var surname, var age) -> {
                System.out.println(firstname + surname + " is " + age + " years old");
            }
        }
    }
}
