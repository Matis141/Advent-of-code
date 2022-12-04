import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.Paths;

public class Day1PartTwo {
    public static void main(String[] args) {
        var classInstance = new Day1PartTwo();
        int output = classInstance.readMaxCaloriesFromFile();
        System.out.println(output);
    }

    public int readMaxCaloriesFromFile() {
        String fileName = "dataInput.txt";
        ArrayList<Integer> maxList = new ArrayList<>();
        maxList.add(0);
        maxList.add(0);
        maxList.add(0);
        int calories = 0;
        int max = 0;

        try (Scanner fileScanner = new Scanner(Paths.get(fileName))) {
            while(fileScanner.hasNextLine()) {
                calories = readCalories(fileScanner);
                if (calories > minValue(maxList)) {
                    maxList.set(maxList.indexOf(minValue(maxList)), calories);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        for (Integer maxCalories : maxList) {
            max += maxCalories;
        }
        System.out.println(maxList);
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

    public int minValue(ArrayList<Integer> list) {
        int minValue = list.get(0);
        for (Integer value : list) {
            if (value < minValue) {
                minValue = value;
            }
        }
        return minValue;
    }

}


