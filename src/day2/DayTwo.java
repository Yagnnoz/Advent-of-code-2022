package day2;

import util.FileUtils;

public class DayTwo {
    private final int ROCK = 1;
    private final int PAPER = 2;
    private final int SCISSOR =3;
    private final int WIN = 6;
    private final int DRAW = 3;
    private final int LOSS = 0;

    private int getOutcomePuzzle1(String opponentSelected, String youSelected) {
        switch (opponentSelected) {
            case "A" -> {
                switch (youSelected) {
                    case "X" -> {
                        //draw
                        return ROCK + DRAW;
                    }
                    case "Y" -> {
                        //win
                        return PAPER + WIN;
                    }
                    case "Z" -> {
                        //lost
                        return SCISSOR + LOSS;
                    }
                    default -> {
                        //shouldn't happen
                        System.err.println("YOU DONE FUCKED UP. Opponent selected " + opponentSelected + " AND YOU GOT " + youSelected);
                        System.exit(-1);
                        return -1;
                    }
                }
            }
            case "B" -> {
                switch (youSelected) {
                    case "X" -> {
                        //lost
                        return ROCK + LOSS;
                    }
                    case "Y" -> {
                        //draw
                        return PAPER + DRAW;
                    }
                    case "Z" -> {
                        //win
                        return SCISSOR + WIN;
                    }
                    default -> {
                        //shouldn't happen
                        System.err.println("YOU DONE FUCKED UP. Opponent selected " + opponentSelected + " AND YOU GOT " + youSelected);
                        System.exit(-1);
                        return -1;
                    }
                }
            }
            case "C" -> {
                switch (youSelected) {
                    case "X" -> {
                        //win
                        return ROCK + WIN;
                    }
                    case "Y" -> {
                        //lost
                        return PAPER + LOSS;
                    }
                    case "Z" -> {
                        //draw
                        return SCISSOR + DRAW;
                    }
                    default -> {
                        //shouldn't happen
                        System.err.println("YOU DONE FUCKED UP. Opponent selected " + opponentSelected + " AND YOU GOT " + youSelected);
                        System.exit(-1);
                        return -1;
                    }
                }
            }
        }
        return -1;
    }

    private int getOutcomePuzzle2(String opponentSelected, String youSelected) {
        switch (opponentSelected) {
            case "A" -> {
                switch (youSelected) {
                    case "X" -> {
                        return SCISSOR + LOSS;
                    }
                    case "Y" -> {
                        return ROCK + DRAW;
                    }
                    case "Z" -> {
                        return PAPER + WIN;
                    }
                    default -> {
                        //shouldn't happen
                        System.err.println("YOU DONE FUCKED UP. Opponent selected " + opponentSelected + " AND YOU GOT " + youSelected);
                        System.exit(-1);
                        return -1;
                    }
                }
            }
            case "B" -> {
                switch (youSelected) {
                    case "X" -> {
                        return ROCK + LOSS;
                    }
                    case "Y" -> {
                        return PAPER + DRAW;
                    }
                    case "Z" -> {
                        return SCISSOR + WIN;
                    }
                    default -> {
                        //shouldn't happen
                        System.err.println("YOU DONE FUCKED UP. Opponent selected " + opponentSelected + " AND YOU GOT " + youSelected);
                        System.exit(-1);
                        return -1;
                    }
                }
            }
            case "C" -> {
                switch (youSelected) {
                    case "X" -> {
                        return PAPER + LOSS;
                    }
                    case "Y" -> {
                        return SCISSOR + DRAW;
                    }
                    case "Z" -> {
                        return ROCK + WIN;
                    }
                    default -> {
                        //shouldn't happen
                        System.err.println("YOU DONE FUCKED UP. Opponent selected " + opponentSelected + " AND YOU GOT " + youSelected);
                        System.exit(-1);
                        return -1;
                    }
                }
            }
            default -> {
                return -1;
            }
        }
    }

    public void solvePuzzleOne() {
        String[] input = FileUtils.readFileToStringArray("src/day2/Puzzleinput.txt");

        int sumOfScorePuzzle1 = 0;
        int sumOfScorePuzzle2 = 0;

        for (String s : input) {
            sumOfScorePuzzle1 += getOutcomePuzzle1(s.split(" ")[0], s.split(" ")[1]);
        }
        System.out.println("Score Puzzle 1: " + sumOfScorePuzzle1);

        for (String s : input) {
            sumOfScorePuzzle2 += getOutcomePuzzle2(s.split(" ")[0], s.split(" ")[1]);
        }
        System.out.println("Score Puzzle 2: " + sumOfScorePuzzle2);
    }
}
