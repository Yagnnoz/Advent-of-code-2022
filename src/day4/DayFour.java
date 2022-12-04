package day4;

import util.FileUtils;
import util.FunUtils;

public class DayFour {

    private final String[] inputData;

    public DayFour() {
        inputData = FileUtils.readFileToStringArray("src/day4/Puzzleinput.txt");
    }

    /**
     * Takes the input String (single line of the puzzle) and returns an array with the four numbers within.
     *
     * @param line - The line to get the numbers from (format: "1-5,3-7")
     * @return returns an array the four numbers found in the string.
     */
    private int[] parseNumberFromString(String line) {
        int[] result = new int[4];
        String[] sets = line.split(",");
        result[0] = Integer.parseInt(sets[0].substring(0, sets[0].indexOf("-")));
        result[1] = Integer.parseInt(sets[0].substring(sets[0].indexOf("-") + 1));
        result[2] = Integer.parseInt(sets[1].substring(0, sets[1].indexOf("-")));
        result[3] = Integer.parseInt(sets[1].substring(sets[1].indexOf("-") + 1));
        return result;
    }

    /**
     * Returns whether either the first two numbers are completely within the second two numbers or vice versa.
     * e.g. an array of [1,2,3,4] would return false as the numbers 1 and 2 are not in the range of 3-4
     * and the numbers 3 and 4 are not in the range of 1-2.
     * an arraay of [1,10,5,7] would return true as the set [5,6,7] is wholly contained in the set [1-10]
     *
     * @param input the array to check
     * @return returns true if the second half is completely within the first and vice versa. Otherwise, false.
     */
    private boolean doesOneSetContainTheOther(int[] input) {
        //Errorhandling, we don't do arrays with more than 4 numbers in it
        if (input.length != 4) {
            System.err.println("ERROR in 'doesOneSetContainTheOther'. Given array has length != 4");
            System.exit(-1);
            return false;
        } else {
            int setOneStart = input[0];
            int setOneEnd = input[1];
            int setTwoStart = input[2];
            int setTwoEnd = input[3];
            return (setOneStart <= setTwoStart && setOneEnd >= setTwoEnd) ||
                    (setTwoStart <= setOneStart && setTwoEnd >= setOneEnd);
        }
    }

    /**
     * Solves the first task and prints the number of fully overlapping sets to the console.
     */
    private void solvePuzzleOne() {
        int amountOfSets = 0;
        for (String s : inputData) {
            if (doesOneSetContainTheOther(parseNumberFromString(s))) {
                amountOfSets += 1;
            }
        }
        System.out.println(amountOfSets);
    }

    /**
     * Returns whether the given two sets partially overlap each other.
     * e.g. set 1 contains the numbers 4-7, set 2 contains the numbers 6-10. This would result in true as part of the
     * second set (6 and 7) are contained within the first set.
     * If there is no overlap between the two sets false is returned
     * @param input - the integer array to check for partial overlap MUST BE EXACTLY 4 NUMBERS otherwise an error will be printed.
     * @return returns true if one set partially overlaps with the other set or false if not.
     */
    private boolean doesOneSetOverlapTheOther(int[] input) {
        if (input.length != 4) {
            System.err.println("ERROR in 'doesOneSetContainTheOther'. Given array has length != 4");
            System.exit(-1);
            return false;
        } else {
            int setOneStart = input[0];
            int setOneEnd = input[1];
            int setTwoStart = input[2];
            int setTwoEnd = input[3];

            return (
                    (setTwoStart >= setOneStart && setTwoStart <= setOneEnd) ||
                            (setTwoEnd >= setOneStart && setTwoEnd <= setOneEnd) ||
                            (setOneStart >= setTwoStart && setOneStart <= setTwoEnd) ||
                            (setOneEnd >= setTwoStart && setOneEnd <= setTwoEnd));

        }
    }

    /**
     * Solves the second task for the entire input file and prints the number of partially overlapping sets to the console.
     */
    private void solvePuzzleTwo() {
        int amountOfOverlap = 0;
        for (String s : inputData) {
            if (doesOneSetOverlapTheOther(parseNumberFromString(s))) {
                amountOfOverlap += 1;
            }
        }
        System.out.println(amountOfOverlap);
    }

    public static void main(String[] args) {
        DayFour d = new DayFour();
        FunUtils.printSeparator(4, 1);
        System.out.print("Amount of completely overlapping pairs: ");
        d.solvePuzzleOne();
        FunUtils.printSeparator(4, 2);
        System.out.print("Amount of partially overlapping pairs: ");
        d.solvePuzzleTwo();
    }

}
