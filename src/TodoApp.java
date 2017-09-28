import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class TodoApp {
    List<String> content = new ArrayList<>();

    //puts opening statement into a txt
    public void makeOpener() {

        this.content = new ArrayList<>();

        content.add("Command Line Todo application\n" +
                "=============================\n" +
                "\n" +
                "Command line arguments:\n" +
                "-l   Lists all the tasks\n" +
                "-a   Adds a new task\n" +
                "-r   Removes a task\n" +
                "-c   Completes a task");
        try {
            Path filepath = Paths.get("C:/greenfox/pkrisz0-todo-app/src/print_usage.txt");
            Files.write(filepath, content);
        } catch (IOException e) {
            System.out.println("Unable to write file: print_usage");
        }
    }

    //prints opening statement
    public void printOpener() {
        try {
            Path filepath = Paths.get("C:/greenfox/pkrisz0-todo-app/src/print_usage.txt");
            List<String> lines = Files.readAllLines(filepath);
            for (int i = 0; i < lines.size(); i++) {
                System.out.println(lines.get(i));
            }
        } catch (IOException e) {
            System.out.println("Unable to write file: print_usage");
        }

    }

    public static void main(String[] args) {
        boolean run = true;
        TodoApp one = new TodoApp();
        one.makeOpener();
        one.printOpener();

        ListOf listOne = new ListOf();

        listOne.add("Walk the dog");
        listOne.add("Buy milk");
        listOne.add("Do homework");

        while(run) {
            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.nextLine();

            if (userInput.equals("")) {
                one.printOpener();
            } else if (userInput.substring(0, 2).equals("-a") && userInput.length() > 3) {
                listOne.add(userInput.substring(3));
            } else if (userInput.substring(0, 2).equals("-a") && userInput.length() < 3) {
                System.out.println("Unable to add: no task provided");
            } else if (userInput.substring(0, 2).equals("-l") && listOne.checkSize() != 0) {
                listOne.printList();
            } else if (userInput.substring(0, 2).equals("-l") && listOne.checkSize() == 0) {
                System.out.println("No todos for today! :)");
            } else if (userInput.substring(0, 2).equals("-r") && listOne.checkSize() >= (parseInt(userInput.substring(3,4)))) {
                listOne.removeIt(parseInt(userInput.substring(3,4)));
            }
        }
    }
}
