import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ListOf {
    java.util.List<String> list = new ArrayList<>();
    public void makeList() {
       this.list = new ArrayList<>();
       this.list.add("");
       try {
            Path filepath = Paths.get("C:/greenfox/pkrisz0-todo-app/src/list.txt");
            Files.write(filepath, this.list);
       } catch (IOException e) {
            System.out.println("Unable to write file: list");
       }
    }
   // add elements
   public void add(String input) {
       this.list.add(input);
       try {
           Path filepath = Paths.get("C:/greenfox/pkrisz0-todo-app/src/list.txt");
           Files.write(filepath, this.list);
       } catch (IOException e) {
           System.out.println("Unable to write file: list");
       }
   }

    // remove elements
    public void remove(String input) {
        this.list.remove(input);
        try {
            Path filepath = Paths.get("C:/greenfox/pkrisz0-todo-app/src/list.txt");
            Files.write(filepath, this.list);
        } catch (IOException e) {
            System.out.println("Unable to write file: list");
        }
    }

   //print list
    public void printList() {
        try {
            Path filepath = Paths.get("C:/greenfox/pkrisz0-todo-app/src/list.txt");
            List<String> list = Files.readAllLines(filepath);
            int count = 0;
            for (int i = 0; i < list.size(); i++) {
                count++;
                System.out.println(count + " - " + list.get(i));
            }
        } catch (IOException e) {
            System.out.println("Unable to write the list");
        }
    }

    //check size
    public int checkSize(){
       return this.list.size();
    }
}
