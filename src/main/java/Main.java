import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        File inputData = new File("src/main/resources/inputData.csv");
        try {
            inputData.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Can’t create file", e);
        }

        List<String> list = new ArrayList<>();
        list.add("b,banana,20");
        list.add("b,apple,100");
        list.add("s,banana,100");
        list.add("p,banana,13");
        list.add("r,apple,10");
        list.add("p,apple,20");
        list.add("p,banana,5");
        list.add("s,banana,50");

        for (String line : list) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(inputData, true))) {
                bufferedWriter.write(line + System.lineSeparator());
            } catch (IOException e) {
                throw new RuntimeException();
            }
        }
    }
}
