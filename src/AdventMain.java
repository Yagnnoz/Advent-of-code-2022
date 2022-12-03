import day1.DayOne;
import day2.DayTwo;
import day3.DayThree;

public class AdventMain {
    public static void main(String[] args) {
        DayOne d1 = new DayOne();
        DayTwo d2 = new DayTwo();
        d1.printSums("src/day1/Puzzleinput.txt");
        d1.printTopThreeElves("src/day1/Puzzleinput.txt");

        d2.solvePuzzleOne();

        DayThree d3 = new DayThree();
    }
}
