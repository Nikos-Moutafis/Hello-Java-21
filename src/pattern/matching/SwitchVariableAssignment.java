package pattern.matching;

public class SwitchVariableAssignment {

    static void main() {
        String day = "Sunday";
        String result = "";

        /// Assign to result variable
        switch (day) {
            case "Saturday", "Sunday" -> result = "6am";
            case "Monday" -> result = "8am";
            default -> result = "7am";
        }


        // 2nd way to assign to result variable
        // caution: needs  ; at the end of the expression
        result = switch (day) {
            case "Saturday", "Sunday" ->  "6am";
            case "Monday" ->  "8am";
            default ->  "7am";
        };


        ///3rd way, yield keyword along with :
        result = switch (day) {
            case "Saturday", "Sunday" : yield   "6am";
            case "Monday" : yield  "8am";
            default  : yield "7am";
        };

        System.out.println(result);
    }
}
