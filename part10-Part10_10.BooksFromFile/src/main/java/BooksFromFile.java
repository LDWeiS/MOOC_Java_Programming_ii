
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BooksFromFile {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // test your method here

    }
    
    public static List<Book> readBooks(String file){
        List<Book> fileIn = new ArrayList<>();
        
        try {
            Files.lines(Paths.get(file))
                    .map(row -> row.split(","))
                    .filter(data -> data.length >= 4)
                    .map(data -> new Book(data[0], Integer.valueOf(data[1]), Integer.valueOf(data[2]), data[3]))
                    .forEach(book -> fileIn.add(book));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        return fileIn;
    }

}
