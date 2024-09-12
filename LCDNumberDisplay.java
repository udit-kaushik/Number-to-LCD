
import java.util.Arrays;
import java.util.List;

public class LCDNumberDisplay {

    // The pattern representation of each digit in a 7-segment style
    private static final String[][] DIGIT_PATTERNS = {
        {" - ", "| |", "   ", "| |", " - "}, // 0
        {"   ", "  |", "   ", "  |", "   "}, // 1
        {" - ", "  |", " - ", "|  ", " - "}, // 2
        {" - ", "  |", " - ", "  |", " - "}, // 3
        {"   ", "| |", " - ", "  |", "   "}, // 4
        {" - ", "|  ", " - ", "  |", " - "}, // 5
        {" - ", "|  ", " - ", "| |", " - "}, // 6
        {" - ", "  |", "   ", "  |", "   "}, // 7
        {" - ", "| |", " - ", "| |", " - "}, // 8
        {" - ", "| |", " - ", "  |", " - "}  // 9
    };

    // Method to print the number in LCD style with variable width and height
    public static void printLCD(String number, int width, int height) {
        // Top, middle, and bottom rows of LCD
        for (int row = 0; row < 5; row++) {
            for (int i = 0; i < number.length(); i++) {
                int digit = number.charAt(i) - '0';
                String pattern = DIGIT_PATTERNS[digit][row];
                
                if (row % 2 == 0) {
                    // Print horizontal parts (top and bottom)
                    System.out.print(pattern.charAt(0)); // Start of the segment
                    for (int w = 0; w < width; w++) {
                        System.out.print(pattern.charAt(1)); // Horizontal segment
                    }
                    System.out.print(pattern.charAt(2)); // End of the segment
                } else {
                    // Print vertical parts (sides)
                    for (int h = 0; h < height; h++) {
                        System.out.print(pattern.charAt(0)); // Left side
                        for (int w = 0; w < width; w++) {
                            System.out.print(" "); // Space between vertical segments
                        }
                        System.out.print(pattern.charAt(2)); // Right side
                        System.out.println(); // Newline after each vertical row
                    }
                }

                if (i < number.length() - 1 && row % 2 != 0) {
                    System.out.print(" "); // Space between digits
                }
            }
            if (row % 2 == 0) {
                System.out.println(); // Move to the next row
            }
        }
    }

    public static void main(String[] args) {
        String number = "ss";  // Number to display
        int width = 3;        // Width of segments
        int height = 2;       // Height of segments
        List<String> nums = Arrays.asList(number.split(""));
        for(String num : nums){
            try {
                Integer.valueOf(num);
                printLCD(num, width, height);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                break;
            }
        }
    }
}
