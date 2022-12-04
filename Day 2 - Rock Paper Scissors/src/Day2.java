import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) {
        var classInstance = new Day2();
        int output = classInstance.readMaxScoreFromFile();
        System.out.println(output);
    }

    public int readMaxScoreFromFile() {
        String fileName = "data.txt";
        int scoreTotal = 0;

        try (Scanner fileScanner = new Scanner(Paths.get(fileName))) {
            while(fileScanner.hasNextLine()) {
                scoreTotal += readScore(fileScanner);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return scoreTotal;
    }

    public int readScore(Scanner fileScanner) {
        String line = fileScanner.nextLine();
        char firstHand = line.charAt(0);
        char secondHand = line.charAt(2);
        int score = switch (firstHand) {
            case 'A':
                if (secondHand == 'X') {
                    yield 3 + 1;
                } else if (secondHand == 'Y') {
                    yield 6 + 2;
                } else if (secondHand == 'Z') {
                    yield 0 + 3;
                }
            case 'B':
                if (secondHand == 'X') {
                    yield 0 + 1;
                } else if (secondHand == 'Y') {
                    yield 3 + 2;
                } else if (secondHand == 'Z') {
                    yield 6 + 3;
                }
            case 'C':
                if (secondHand == 'X') {
                    yield 6 + 1;
                } else if (secondHand == 'Y') {
                    yield 0 + 2;
                } else if (secondHand == 'Z') {
                    yield 3 + 3;
                }
            default:
                System.out.println(firstHand);
                yield 0;
        };
        //System.out.println(score);
        return score;
    }

}
