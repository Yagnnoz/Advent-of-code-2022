package day6;

import util.FileUtils;
import util.FunUtils;

public class DaySix {

    String input;

    public DaySix() {
        loadString();
    }

    private void loadString() {
        input = FileUtils.readFileToSingleString("src/day6/Puzzleinput.txt");
    }

    private boolean areCharactersDistinct(String in) {
      //we need to check if all four characters are different from one another.

        char[] fmlArray = in.toCharArray();
        for(int i = 0; i< fmlArray.length; i++){
            for(int j = 0; j< fmlArray.length; j++){
                if(i == j){
                    continue;
                }else{
                    if(fmlArray[i] == fmlArray[j]){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void solveTaskOne() {

        int charactersSkipped = 0;
        //iterate through the line
        for(int i = 0; i<input.length()-4; i++){
            String lineToCheck = input.substring(i, i+4);
            if(!areCharactersDistinct(lineToCheck)){
                charactersSkipped+=1;
            }else{
                System.out.println("found first occurrence with i="+i);
                System.out.println("skipped: "+(charactersSkipped+4));
                break;
            }
        }
    }

    public void solveTaskTwo(){
        int charactersSkipped = 0;

        for(int i = 0; i<input.length()-14; i++){
            String lineToCheck = input.substring(i, i+14);
            if(!areCharactersDistinct(lineToCheck)){
                charactersSkipped+=1;
            }else{
                System.out.println("Found message. Start: "+i+"; End: "+(i+14));
                break;
            }
        }
    }


    public static void main(String[] args) {
        DaySix d6 = new DaySix();
        FunUtils.printSeparator(6, 1);
        d6.solveTaskOne();
        FunUtils.printSeparator(6,2);
        d6.solveTaskTwo();
    }

}
