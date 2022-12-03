package day3;

import util.FileUtils;

import java.util.HashMap;

public class DayThree {

    private final HashMap<Character, Integer> charaterPriorities = new HashMap<>();
    private final String[] inputData;

    public DayThree() {
        inputData = FileUtils.readFileToStringArray("src/day3/Puzzleinput.txt");
        initializeHashmap();
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("----------------------------------- DAY: 3 TASK: 1 --------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------------");
        solvePuzzleOne();
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("----------------------------------- DAY: 3 TASK: 2 --------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------------");
        solvePuzzleTwo();
    }

    private void initializeHashmap() {
        charaterPriorities.put('a', 1);
        charaterPriorities.put('b', 2);
        charaterPriorities.put('c', 3);
        charaterPriorities.put('d', 4);
        charaterPriorities.put('e', 5);
        charaterPriorities.put('f', 6);
        charaterPriorities.put('g', 7);
        charaterPriorities.put('h', 8);
        charaterPriorities.put('i', 9);
        charaterPriorities.put('j', 10);
        charaterPriorities.put('k', 11);
        charaterPriorities.put('l', 12);
        charaterPriorities.put('m', 13);
        charaterPriorities.put('n', 14);
        charaterPriorities.put('o', 15);
        charaterPriorities.put('p', 16);
        charaterPriorities.put('q', 17);
        charaterPriorities.put('r', 18);
        charaterPriorities.put('s', 19);
        charaterPriorities.put('t', 20);
        charaterPriorities.put('u', 21);
        charaterPriorities.put('v', 22);
        charaterPriorities.put('w', 23);
        charaterPriorities.put('x', 24);
        charaterPriorities.put('y', 25);
        charaterPriorities.put('z', 26);
        charaterPriorities.put('A', 27);
        charaterPriorities.put('B', 28);
        charaterPriorities.put('C', 29);
        charaterPriorities.put('D', 30);
        charaterPriorities.put('E', 31);
        charaterPriorities.put('F', 32);
        charaterPriorities.put('G', 33);
        charaterPriorities.put('H', 34);
        charaterPriorities.put('I', 35);
        charaterPriorities.put('J', 36);
        charaterPriorities.put('K', 37);
        charaterPriorities.put('L', 38);
        charaterPriorities.put('M', 39);
        charaterPriorities.put('N', 40);
        charaterPriorities.put('O', 41);
        charaterPriorities.put('P', 42);
        charaterPriorities.put('Q', 43);
        charaterPriorities.put('R', 44);
        charaterPriorities.put('S', 45);
        charaterPriorities.put('T', 46);
        charaterPriorities.put('U', 47);
        charaterPriorities.put('V', 48);
        charaterPriorities.put('W', 49);
        charaterPriorities.put('X', 50);
        charaterPriorities.put('Y', 51);
        charaterPriorities.put('Z', 52);
    }

    private void solvePuzzleOne() {
        int sumOfPriorities = 0;
        for (String s : inputData) {
            sumOfPriorities += puzzleOneSolveOneLine(s);
        }
        System.out.println("Sum of Priorities is: " + sumOfPriorities);

    }

    private int puzzleOneSolveOneLine(String s) {
        System.out.println("Full line is: " + s);
        String firstHalf = s.substring(0, s.length() / 2);
        String secondHalf = s.substring(s.length() / 2);
        System.out.println("first half is: " + firstHalf + "   - length is: " + firstHalf.length());
        System.out.println("second half is: " + secondHalf + "   - length is: " + secondHalf.length());

        for (Character c : firstHalf.toCharArray()) {
            if (secondHalf.contains(c.toString())) {
                System.out.println("Letter '" + c + "' is in both halves. This is worth " + this.charaterPriorities.get(c) + " points");
                return this.charaterPriorities.get(c);
            }
        }

        System.out.println("Something bad happened");
        return -1;
    }

    private void solvePuzzleTwo() {
        int sumOfBadgePriorities = 0;

        for (int i = 0; i < inputData.length; i += 3) {
            sumOfBadgePriorities += puzzleTwoSolveOneGroup(inputData[i], inputData[i + 1], inputData[i + 2]);
        }
        System.out.println("Sum of Badge priorites: " + sumOfBadgePriorities);
    }

    private int puzzleTwoSolveOneGroup(String s1, String s2, String s3) {
        for (Character c : s1.toCharArray()) {
            if (s2.contains(c.toString()) && s3.contains(c.toString())) {
                System.out.println("Character '" + c + "' matches all three strings. Priority of " + this.charaterPriorities.get(c));
                return this.charaterPriorities.get(c);
            }
        }
        System.err.println("Something bad happened in Task 2");
        return 0;

    }
}
