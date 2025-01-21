package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderSvc {
    public static List<String> readFile(String source) {
        try (FileReader fileReader = new FileReader(source);
                BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            List<String> result = new ArrayList<>();
            String correctLine = bufferedReader.readLine();

            while (correctLine != null) {
                result.add(correctLine);
                correctLine = bufferedReader.readLine();
            }

            return result;

        } catch (IOException e) {
            throw new RuntimeException("Error reading to file: " + source, e);
        }
    }
}
