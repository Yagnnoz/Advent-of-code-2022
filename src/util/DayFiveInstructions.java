package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DayFiveInstructions {
    private final Stack[] crateConfig = new Stack[9];
    private final String[] instructions;

    public DayFiveInstructions(){
        for(int i = 0; i<crateConfig.length; i++){
            crateConfig[i] = new Stack();
        }

        String[] fullInstructions = FileUtils.readFileToStringArray("src/day5/Puzzleinput.txt");
        instructions = getInstructionsFromList(fullInstructions);
    }

    private String[] getInstructionsFromList(String[] fullInstructions) {
        int instructionStartIndex = 0;

        List<String> result = new ArrayList<>();

        for(int i = 0; i<fullInstructions.length; i++){
            if(fullInstructions[i].equals("")){
                instructionStartIndex = i;
                break;
            }
        }
        if(instructionStartIndex != 0){
            for(int i = instructionStartIndex; i<fullInstructions.length; i++){
                result.add(fullInstructions[i]);
            }

        }

        setStacks(instructionStartIndex-2, fullInstructions);


        return  result.toArray(new String[0]);


    }

    private void setStacks(int lastIndex, String[] instructions){
        String[] lineToArray;

        for(int i = lastIndex; i>=0; i--){
            lineToArray = instructions[i].split(" ");
            for(int j = 0; j< crateConfig.length; j++){
                crateConfig[i].push(lineToArray[j]);
            }
        }
        System.out.println("First Stack: "+crateConfig[0]);
    }


}
