import java.nio.file.Paths;
import java.util.Scanner;

public class Day3PartTwo {
    public static void main(String[] args) {
        var classInstance = new Day3PartTwo();
        int output = classInstance.readAllPrioritiesFromFile();
        System.out.println(output);
    }

    public int readAllPrioritiesFromFile() {
        String fileName = "data.txt";
        int scoreTotal = 0;

        try (Scanner fileScanner = new Scanner(Paths.get(fileName))) {
            while(fileScanner.hasNextLine()) {
                scoreTotal += readPriority(fileScanner);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return scoreTotal;
    }

    public int readPriority(Scanner fileScanner) {
        String firstRucksack = fileScanner.nextLine();
        String secondRucksack = fileScanner.nextLine();
        String thirdRucksack = fileScanner.nextLine();
        char matchingLetter = findMatchingLetter(firstRucksack, secondRucksack, thirdRucksack);
        System.out.println(matchingLetter);
        int priority = calculatePriority(matchingLetter);
        return priority;
    }

    public char findMatchingLetter(String firstRucksack, String secondRucksack, String thirdRucksack) {
        char matchingLetter = 'a';
        for (char letter : firstRucksack.toCharArray()) {
            for (char letterSecond : secondRucksack.toCharArray()) {
                for (char letterThird : thirdRucksack.toCharArray()) {
                    if (letter == letterSecond && letter == letterThird) {
                        matchingLetter = letter;
                    }
                }
            }
        }
        return matchingLetter;
    }

    public int calculatePriority(char matchingLetter) {
        int priority = 0;
        if (Character.isUpperCase(matchingLetter)) {
            priority = ((int) matchingLetter) - 38;
        } else {
            priority = ((int) matchingLetter) - 96;
        }
        System.out.println(priority);
        return priority;
    }

}
