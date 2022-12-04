import java.lang.reflect.Array;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Day4 {
    public static void main(String[] args) {
        var classInstance = new Day4();
        int answer = classInstance.readMatchingAssigmentsFromFile();
        System.out.println(answer);
    }

    public int readMatchingAssigmentsFromFile() {
        String fileName = "data.txt";
        int scoreTotal = 0;
        ArrayList<String> assigments = new ArrayList<>();

        try (Scanner fileScanner = new Scanner(Paths.get(fileName))) {
            while(fileScanner.hasNextLine()) {
                scoreTotal += readMatchingAssigmentsFromFile(fileScanner);
                System.out.println(scoreTotal);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return scoreTotal;
    }

    public int readMatchingAssigmentsFromFile(Scanner fileScanner) {
        String line = fileScanner.nextLine();
        ArrayList<ArrayList<Integer>> assigments = new ArrayList<>();
        assigments = eachElfAssigmentParser(line);
        int matchingAssigments = calculateMatchingAssigments(assigments);
        return matchingAssigments;
    }

    public ArrayList<ArrayList<Integer>> eachElfAssigmentParser(String line) {
        String[] assigmentsLine = line.split(",");
        String firstAssigmentNotParsed = assigmentsLine[0];
        String secondAssigmentNotParsed = assigmentsLine[1];
        String[] firstAssigmentParsed = firstAssigmentNotParsed.split("-");
        String[] secondAssigmentParsed = secondAssigmentNotParsed.split("-");
        String firstAssigmentStart = firstAssigmentParsed[0];
        String firstASsigmentEnd = firstAssigmentParsed[1];
        String secondAssigmentStart = secondAssigmentParsed[0];
        String secondAssigmentEnd = secondAssigmentParsed[1];

        ArrayList<Integer> firstAssigment = new ArrayList<>();
        ArrayList<Integer> secondAssigment = new ArrayList<>();

        for (int i = Integer.valueOf(firstAssigmentStart); i < Integer.valueOf(firstASsigmentEnd) + 1; i++) {
            firstAssigment.add(i);
        }

        for (int i = Integer.valueOf(secondAssigmentStart); i < Integer.valueOf(secondAssigmentEnd) + 1; i++) {
            secondAssigment.add(i);
        }
        ArrayList<ArrayList<Integer>> assigments = new ArrayList<>();
        assigments.add(firstAssigment);
        assigments.add(secondAssigment);
        System.out.println(assigments);
        return assigments;
    }

    //Day4PartOne
    /*public int calculateMatchingAssigments(ArrayList<ArrayList<Integer>> assigments) {
        int matching = 0;
        if (assigments.get(0).containsAll(assigments.get(1))) {
            matching ++;
            System.out.println("first contains second");
        } else if (assigments.get(1).containsAll(assigments.get(0))) {
            matching ++;
            System.out.println("second contains first");
        }
        return matching;
    }*/

    //Day4PartTwo
    public int calculateMatchingAssigments(ArrayList<ArrayList<Integer>> assigments) {
        int matching = 0;
        for (Integer value : assigments.get(1)) {
            if (assigments.get(0).contains(value)) {
                matching ++;
                break;
            }
        }

        return matching;
    }

}
