package day1;

import util.FileUtils;

import java.util.Objects;

public class DayOne {
    public void printSums(String path) {
        int currentSum = 0;
        int highestSum = 0;
        int elfID = 1;
        String[] inputData = FileUtils.readFileToStringArray(path);
        for (String inputDatum : inputData) {
            if (!Objects.equals(inputDatum, "")) {
                currentSum += Integer.parseInt(inputDatum);
            } else {
                if (currentSum > highestSum) {
                    highestSum = currentSum;
                }
                System.out.println("Elf #" + elfID + ": " + currentSum);
                currentSum = 0;
                elfID++;
            }
        }
        System.out.println("Highest sum: " + highestSum);
    }

    public void printTopThreeElves(String path) {
        int currentSum = 0;
        int firstPlace = 0;
        int secondPlace = 0;
        int thirdPlace = 0;

        String[] inputData = FileUtils.readFileToStringArray(path);

        for (String inputDatum : inputData) {
            if (!Objects.equals(inputDatum, "")) {
                currentSum += Integer.parseInt(inputDatum);
            } else {
                //current sum is higher than everything else
                // so we need to delete third place, move everything down one and add current sum as first place
                if (currentSum > firstPlace) {
                    thirdPlace = secondPlace;
                    secondPlace = firstPlace;
                    firstPlace = currentSum;
                }
                //current is the new second place
                //we need to move the old second to third and set current to second
                else if (currentSum > secondPlace && currentSum < firstPlace) {
                    thirdPlace = secondPlace;
                    secondPlace = currentSum;
                }
                //current is the new third place, so just replace
                else if (currentSum > thirdPlace && currentSum < secondPlace) {
                    thirdPlace = currentSum;
                }
                currentSum = 0;
            }
        }
        System.out.println("THE RESULTS ARE IN");
        System.out.println("First Place: " + firstPlace + " calories");
        System.out.println("Second Place: " + secondPlace + " calories");
        System.out.println("Third Place: " + thirdPlace + " calories");
        int sumOfTopThree = firstPlace + secondPlace + thirdPlace;
        System.out.println("Total: " + sumOfTopThree + " calories");
    }
}
