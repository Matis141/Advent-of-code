import java.nio.file.Paths;
import java.util.Scanner;

public class Day3 {
    public static void main(String[] args) {
        var classInstance = new Day3();
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
        String rucksack = fileScanner.nextLine();
        String firstCompartment = rucksack.substring(0,rucksack.length()/2);
        String secondCompartment = rucksack.substring(rucksack.length()/2, rucksack.length());
        char matchingLetter = findMatchingLetter(firstCompartment, secondCompartment);
        System.out.println(matchingLetter);
        int priority = calculatePriority(matchingLetter);
        return priority;
    }

    public char findMatchingLetter(String firstCompartment, String secondCompartment) {
        char matchingLetter = 'a';
        for (char letter : firstCompartment.toCharArray()) {
            for (char letterSecond : secondCompartment.toCharArray()) {
                if (letter == letterSecond) {
                    matchingLetter = letter;
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
