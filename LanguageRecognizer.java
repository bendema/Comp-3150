public class LanguageRecognizer {

    public static String recognizeLanguage(String input) {
        Stack stack = new Stack(input.length());
        int count = 0;

        if(input == ""){
            return "No, input is empty";
        }
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            /*
             * When count == 0, it indicates that no '1' has been encountered yet in the
             * current sequence of characters. This ensures that a '0' is only pushed onto
             * the stack if it's the start of a new sequence.
             * If count != 0, it means that a '1' has already been encountered in the
             * current sequence, so any subsequent '0' should not be pushed onto the stack
             * because it would not be part of the correct pattern (0^n 1^n).
             */
            if (c == '0' && count == 0) {
                stack.push(c);
            }
            // CORRECT: 01, 0011, 000111..
            // WRONG: 0101, 00110011, 000111000111, any string that starts with 1.
            else if (c == '1') {
                count = 1;
                if(stack.isEmpty()){ // If the stack is empty, it means there was no matching '0' for the current '1'.It returns "No"
                    return "No";
                }
                stack.pop(); // If not empty, it means there is a '0' in the stack to match with the current '1'. It performs a pop() operation to remove the '0'.
            }
        }
        if (stack.isEmpty()) {
            return "Yes";
        } else {
            return "No";
        }
    }

    public static void main(String[] args) {
        String input1 = "";
        String input2 = "000111";
        String input3 = "00110011";
        String input4 = "1010";

        System.out.println("Input 1: " + recognizeLanguage(input1));
        System.out.println("Input 2: " + recognizeLanguage(input2));
        System.out.println("Input 3: " + recognizeLanguage(input3));
        System.out.println("Input 4: " + recognizeLanguage(input4));
    }
}
