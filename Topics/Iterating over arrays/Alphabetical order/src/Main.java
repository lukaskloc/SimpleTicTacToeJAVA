import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split(" ");
        boolean inOrder = false;

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i].compareTo(array[i + 1]) > 0) {
                inOrder = false;
                break;
            } else {
                inOrder = true;
            }
        }
        if (inOrder) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }


    }
}