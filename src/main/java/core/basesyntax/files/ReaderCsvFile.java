package core.basesyntax.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReaderCsvFile {
    public ArrayList<String> getLinesFromCsv(String fileName) {
        ArrayList<String> output = new ArrayList<>();
        File file = new File(fileName);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String value = reader.readLine();

            while (value != null) {
                output.add(value + System.lineSeparator());
                value = reader.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException("Can't read file, ", e);
        }

        output.remove(0);
        return output;
    }
}
