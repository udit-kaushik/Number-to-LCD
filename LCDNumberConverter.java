import java.util.Scanner;

public class LCDNumberConverter {

    // Method to get the LCD patterns for each digit
    private static String[][] getLCDPatterns() {
        return new String[][] {
            {" _ ", "| |", "|_|"}, // 0
            {"   ", "  |", "  |"}, // 1
            {" _ ", " _|", "|_ "}, // 2
            {" _ ", " _|", " _|"}, // 3
            {"   ", "|_|", "  |"}, // 4
            {" _ ", "|_ ", " _|"}, // 5
            {" _ ", "|_ ", "|_|"}, // 6
            {" _ ", "  |", "  |"}, // 7
            {" _ ", "|_|", "|_|"}, // 8
            {" _ ", "|_|", " _|"}  // 9
        };
    }

    // Method to convert a number to LCD style representation
    private static void convertToLCD(String number) {
        String[][] patterns = getLCDPatterns();
        String[] lines = {"", "", ""};
        
        // Build the LCD representation line by line
        for (char digit : number.toCharArray()) {
            if (Character.isDigit(digit)) {
                int index = digit - '0';
                for (int i = 0; i < 3; i++) {
                    lines[i] += patterns[index][i] + " ";
                }
            }
        }
        
        // Print the LCD representation
        for (String line : lines) {
            System.out.println(line);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        String number = scanner.nextLine();
        scanner.close();
        
        convertToLCD(number);
    }
}
