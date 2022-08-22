import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Node {
    String data;
    Node prev;
    Node next;

    Node(String d) {
        data = d;
        prev = null;
        next = null;
    }
}

public class DoubleLinkedList {
    Node head;

    public void readFile(String fileName) {
        try {
            File file = new File(fileName);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                append(data);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void writeDataToFile(String fileName) {
        try {
            File file = new File(fileName);
            FileWriter writer = new FileWriter(file);

            if (head == null) {
                return;
            }

            Node last = head;
            while (last.next != null) {
                writer.write(last.data + "\n");
                last = last.next;
            }
            writer.write(last.data);

            writer.close();
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
    }

    public void append(String data) {

        Node node = new Node(data);

        Node current = head;

        if (head == null) {
            head = node;
            return;
        }

        while (current.next != null)
            current = current.next;

        current.next = node;

        node.prev = current;
    }

    public void appendAtGivenPosition(int numLine, String data) {

        if (numLine < 0)
            return;

        Node node = new Node(data);

        Node current = head;

        if (head == null) {
            head = node;
            return;
        } else if (numLine == 0) {
            node.next = head;
            head = node;
            return;
        }

        int i = 0;
        while (current.next != null && i < numLine) {
            current = current.next;
            i++;
        }
        node.next = current;

        node.prev = current.prev;

        if (current.prev != null)
            current.prev.next = node;

        current.prev = node;
    }

    public void deleteAtGivenPosition(int n) {
        if (head == null || n < 0)
            return;

        Node del = head;

        for (int i = 0; del != null && i < n; i++)
            del = del.next;

        if (del == null)
            return;

        if (head == del)
            head = del.next;

        if (del.next != null)
            del.next.prev = del.prev;

        if (del.prev != null)
            del.prev.next = del.next;
    }

    public void showLengthOfLineAtGivenPosition(int n) {
        if (head == null || n < 0)
            return;

        Node current = head;

        for (int i = 0; current != null && i < n; i++)
            current = current.next;

        if (current == null)
            return;

        System.out.println("length: " + current.data.length());
    }

    public void printList() {
        Node current = head;
        System.out.println("----------------------------------------------------");
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println("----------------------------------------------------");
    }

    public void replaceLineAtGivenPosition(int n, String data) {
        if (head == null || n < 0)
            return;

        Node current = head;

        for (int i = 0; current != null && i < n; i++)
            current = current.next;

        if (current == null)
            return;

        current.data = data;
    }

}
