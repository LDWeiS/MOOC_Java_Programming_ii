
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LiteracyComparison {
    
    public static void main(String[] args) {
        List<String> newFile = read("literacy.csv");
        
        newFile.stream()
                .map(row -> row.split(","))
                .map(row -> new Literacy(row[3], Integer.valueOf(row[4]), row[2].split(" ")[1].trim(), Double.valueOf(row[5])))
                .sorted((row1, row2) -> Double.compare(row1.getPercent(), row2.getPercent()))
                .forEach(row -> System.out.println(row));
    }
    
    public static List<String> read(String file) {
        List<String> fileIn = new ArrayList<>();
        
        try {
            Files.lines(Paths.get(file)).forEach(row -> fileIn.add(row));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        return fileIn;
    }
}
