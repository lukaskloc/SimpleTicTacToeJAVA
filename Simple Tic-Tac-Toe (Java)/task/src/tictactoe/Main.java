package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        int rows = 5;
        int columns = 9;
        Scanner scanner = new Scanner(System.in);
        char[][] array = new char[rows][columns];
        //String gameState = scanner.nextLine();
        String gameState = "_________";

        fillArray(array, gameState);
        printArray(array);
        //checkGameStatus(array, gameState);
        boolean change = true;
        boolean finished = false;
        while (true) {
            String coordOne = scanner.next();
            if (coordOne.matches("\\d")) {
                String coordTwo = scanner.next();
                if (coordTwo.matches("\\d")) {
                    if (Integer.parseInt(coordOne) > 3 || Integer.parseInt(coordOne) < 1 ||
                            Integer.parseInt(coordTwo) > 3 || Integer.parseInt(coordTwo) < 1) {
                        System.out.println("Coordinates should be from 1 to 3!");
                    } else {
                        int coord1 = Integer.parseInt(coordOne);
                        int coord2 = Integer.parseInt(coordTwo);
                        if (array[coord1][coord2 * 2] != '_') {
                            System.out.println("This cell is occupied! Choose another one!");
                            continue;
                        } else {
                            if (change) {
                                array[coord1][coord2 * 2] = 'X';
                                change = false;
                            } else {
                                array[coord1][coord2 * 2] = 'O';
                                change = true;
                            }
                        }
                        printArray(array);
                        //generateGameState(array, gameState);
                        //System.out.println(gameState);
                        checkGameStatus(array, gameState);
                        if (finished) {
                            break;
                        }
                    }
                } else {
                    System.out.println("You should enter numbers!");
                    scanner.nextLine();
                }
            } else {
                System.out.println("You should enter numbers!");
                scanner.nextLine();
            }
        }


    }
    public static void printArray(char[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }
    public static void fillArray(char[][] array, String gameState) {
        for (int i = 0; i < array[0].length; i++) {
            array[0][i] = '-';
        }
        for (int i = 0; i < array[0].length; i++) {
            array[array.length - 1][i] = '-';
        }
        for (int i = 1; i < array.length - 1; i++) {
            array[i][0] = '|';
            array[i][1] = ' ';
            array[i][3] = ' ';
            array[i][5] = ' ';
            array[i][7] = ' ';
            array[i][8] = '|';
        }
        array[1][2] = gameState.charAt(0);
        array[1][4] = gameState.charAt(1);
        array[1][6] = gameState.charAt(2);
        array[2][2] = gameState.charAt(3);
        array[2][4] = gameState.charAt(4);
        array[2][6] = gameState.charAt(5);
        array[3][2] = gameState.charAt(6);
        array[3][4] = gameState.charAt(7);
        array[3][6] = gameState.charAt(8);
    }

    public static String generateGameState(char[][] array, String gameState) {
        char[] chars = gameState.toCharArray();
        chars[0] = array[1][2];
        chars[1] = array[1][4];
        chars[2] = array[1][6];
        chars[3] = array[2][2];
        chars[4] = array[2][4];
        chars[5] = array[2][6];
        chars[6] = array[3][2];
        chars[7] = array[3][4];
        chars[8] = array[3][6];
        gameState = String.valueOf(chars);
        return gameState;
    }


    public static void checkGameStatus(char[][] array, String gameState) {
        boolean xWins = false;
        if ((array[1][2] == 'X' && array[1][4] == 'X' && array[1][6] == 'X') ||
                (array[2][2] == 'X' && array[2][4] == 'X' && array[2][6] == 'X') ||
                (array[3][2] == 'X' && array[3][4] == 'X' && array[3][6] == 'X') ||
                (array[1][2] == 'X' && array[2][4] == 'X' && array[3][6]== 'X') ||
                (array[1][6] == 'X' && array[2][6] == 'X' && array[3][6] == 'X') ||
                (array[1][4] == 'X' && array[2][4] == 'X' && array[3][4] == 'X') ||
                (array[1][2] == 'X' && array[2][2] == 'X' && array[3][2] == 'X') ||
                (array[1][6] == 'X' && array[2][4] == 'X' && array[3][2] == 'X')) {
            xWins = true;
        }
        boolean oWins = false;
        if ((array[1][2] == 'O' && array[1][4] == 'O' && array[1][6] == 'O') ||
                (array[2][2] == 'O' && array[2][4] == 'O' && array[2][6] == 'O') ||
                (array[3][2] == 'O' && array[3][4] == 'O' && array[3][6] == 'O') ||
                (array[1][2] == 'O' && array[2][4] == 'O' && array[3][6] == 'O') ||
                (array[1][6] == 'O' && array[2][4] == 'O' && array[3][2] == 'O') ||
                (array[1][4] == 'O' && array[2][4] == 'O' && array[3][4] == 'O') ||
                (array[1][2] == 'O' && array[2][2] == 'O' && array[3][2] == 'O') ||
                (array[1][6] == 'O' && array[2][6] == 'O' && array[3][6] == 'O')) {
            oWins = true;
        }
        boolean impossible = false;
        int oCounter = 0;
        int xCounter = 0;
        for (int i = 0; i < gameState.length(); i++) {
            if (gameState.charAt(i) == 'X') {
                xCounter++;
            } else if (gameState.charAt(i) == 'O') {
                oCounter++;
            }
        }
        if (Math.abs(oCounter - xCounter) > 1) {
            impossible = true;
        }

        boolean notFinished = false;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == '_') {
                    notFinished = true;
                }
            }
        }
        /*for (int i = 0; i < gameState.length(); i++) {
            if (gameState.charAt(i) == '_') {
                notFinished = true;
                break;
            }
        }*/

        if (impossible || (xWins && oWins)) {
            //System.out.println("Impossible");
        } else if (!xWins && !oWins && notFinished) {
            //System.out.println("Game not finished");
        } else if (!notFinished && !xWins && !oWins) {
            System.out.println("Draw");
            System.exit(0);
        } else if (xWins) {
            System.out.println("X wins");
            System.exit(0);
        } else if (oWins) {
            System.out.println("O wins");
            System.exit(0);
        }
    }
}


