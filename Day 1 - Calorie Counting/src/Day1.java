import java.util.Scanner;
import java.nio.file.Paths;

public class Day1 {
    public static void main(String[] args) {
        var classInstance = new Day1();
        int output = classInstance.readMaxCaloriesFromFile();
        System.out.println(output);
    }

    public int readMaxCaloriesFromFile() {
        String fileName = "dataInput.txt";
        int max = 0;
        int calories = 0;

        try (Scanner fileScanner = new Scanner(Paths.get(fileName))) {
            while(fileScanner.hasNextLine()) {
                calories = readCalories(fileScanner);
                if (calories > max) {
                    max = calories;
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return max;
    }

    public int readCalories(Scanner fileScanner) {
        int sum = 0;
        String line = fileScanner.nextLine();
        while (line != "") {
            sum += Integer.valueOf(line);
            line = fileScanner.hasNextLine() ? fileScanner.nextLine() : null;
        }
        return sum;
    }

}

