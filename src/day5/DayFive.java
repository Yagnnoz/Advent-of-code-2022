package day5;

import util.DayFiveInstructions;
import util.FileUtils;
import util.FunUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DayFive {

    //here is the configuration of the crates
    private Stack[] crates = new Stack[9];
    private List<String> instructions = new ArrayList<>();

    public DayFive() {
        initTasks();
      //  solveTaskOne();
    }

    private void initTasks() {
        String[] taskLines = FileUtils.readFileToStringArray("src/day5/Puzzleinput.txt");
        //we do not want the numbers under the stacks, so only count from 8 to 0
        // WE NEED TO GO BACKWARDS AS THE STACKS ARE NOT DANGLING FROM THE CEILING
        for (int i = 7; i >= 0; i--) {
            addLineToStacks(taskLines[i]);
        }

        for (int i = 10; i < taskLines.length; i++) {
            addLineToInstructions(taskLines[i]);
        }
    }

    private void addLineToStacks(String line) {
        //need to make the string longer if the last box(es) are missing
        while (line.length() < 36) {
            line += " ";
        }

        int oldIndex = 0;
        for (int i = 0; i < crates.length; i++) {
            //initialize stack if not already happened
            if (crates[i] == null) {
                crates[i] = new Stack();
            }

            if (!line.substring(oldIndex, oldIndex + 3).equals("   ")) {
                crates[i].push(line.substring(oldIndex, oldIndex + 3));
            }
            oldIndex += 4;
        }
    }

    private void addLineToInstructions(String line) {
        line = line.replace("move ", "");
        line = line.replace(" from ", ",");
        line = line.replace(" to ", ",");

        instructions.add(line);
    }

    private void moveCratesT1(String line) {
        int howMany = Integer.parseInt(line.substring(0, line.indexOf(",")));
        // not good. dont do this at home
        line = line.substring(line.indexOf(",") + 1);
        int from = Integer.parseInt(line.substring(0, line.indexOf(",")));
        line = line.substring(line.indexOf(",") + 1);
        int to = Integer.parseInt(line);

        String tmpObj = "";

        for (int i = 0; i < howMany; i++) {
            tmpObj = (String) crates[from - 1].peek();
            crates[from - 1].pop();
            crates[to - 1].add(tmpObj);
        }
    }

    private void moveCratesT2(String line){
        int howMany = Integer.parseInt(line.substring(0, line.indexOf(",")));
        // not good. dont do this at home
        line = line.substring(line.indexOf(",") + 1);
        int from = Integer.parseInt(line.substring(0, line.indexOf(",")));
        line = line.substring(line.indexOf(",") + 1);
        int to = Integer.parseInt(line);

        Stack tmpStack = new Stack();
        //first add things to our stack (these are in the reversed order)
        for(int i = 0; i<howMany; i++){
            tmpStack.push(crates[from-1].peek());
            crates[from-1].pop();
        }

        //now transfer from tmpStack to new target
        for (int i = tmpStack.size(); i>0; i--){
            crates[to-1].push(tmpStack.peek());
            tmpStack.pop();
        }
    }

    private void solveTaskOne() {
        for (String s : instructions) {
            moveCratesT1(s);
        }

        // print last entry of each stack

        for (Stack s : crates) {
            System.out.println((String) s.peek());
        }
    }

    public void solveTaskTwo(){
        for (String s : instructions) {
            moveCratesT2(s);
        }

        // print last entry of each stack

        for (Stack s : crates) {
            System.out.println((String) s.peek());
        }
    }

    public static void main(String[] args) {
        DayFive d = new DayFive();
        FunUtils.printSeparator(5, 1);
        FunUtils.printSeparator(5, 2);
        d.solveTaskTwo();

        DayFiveInstructions f5I = new DayFiveInstructions();
    }
}
