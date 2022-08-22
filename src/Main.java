import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        Scanner scanner = new Scanner(System.in);
        String data;
        int input, line;
        boolean flag = true;
        while (flag) {
            System.out.println("1- read from file");
            System.out.println("2- write data to file");
            System.out.println("3- insert new line at specific position");
            System.out.println("4- delete line at specific position");
            System.out.println("5- show length of line at specific position");
            System.out.println("6- show all lines");
            System.out.println("7- replace line at specific position");
            System.out.println("8- exit");
            System.out.println();
            System.out.print("Enter your choice: ");
            input = scanner.nextInt();
            scanner.nextLine();
            switch (input) {
                case 1:
                    System.out.print("Enter name of file: ");
                    data = scanner.nextLine();
                    list.readFile(data);
                    break;
                case 2:
                    System.out.print("Enter name of file: ");
                    data = scanner.nextLine();
                    list.writeDataToFile(data);
                    break;
                case 3:
                    System.out.print("Enter number of line: ");
                    line = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new line: ");
                    data = scanner.nextLine();
                    list.appendAtGivenPosition(line, data);
                    break;
                case 4:
                    System.out.print("Enter number of line: ");
                    line = scanner.nextInt();
                    scanner.nextLine();
                    list.deleteAtGivenPosition(line);
                    break;
                case 5:
                    System.out.print("Enter number of line: ");
                    line = scanner.nextInt();
                    scanner.nextLine();
                    list.showLengthOfLineAtGivenPosition(line);
                    break;
                case 6:
                    list.printList();
                    break;
                case 7:
                    System.out.print("Enter number of line: ");
                    line = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new line: ");
                    data = scanner.nextLine();
                    list.replaceLineAtGivenPosition(line, data);
                    break;
                case 8:
                    flag = false;
                    break;
                default:
                    System.out.println("wrong input");
                    break;
            }
        }
    }
}