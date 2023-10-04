package core.basesyntax.fileserve;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileServiceImpl implements FileService {
    @Override
    public String getFruitData(String fromFile) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader((fromFile)))) {
            StringBuilder builder = new StringBuilder();
            String lineFromFile = fileReader.readLine();
            while (lineFromFile != null) {
                builder.append(lineFromFile).append(System.lineSeparator());
                lineFromFile = fileReader.readLine();
            }
            return builder.toString();
        } catch (IOException ex) {
            throw new RuntimeException("Can't read the file: " + fromFile, ex);
        }
    }

    @Override
    public void writeToFile(String fruitReport, String toFile) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(toFile))) {
            bufferedWriter.write(fruitReport);
        } catch (IOException ex) {
            throw new RuntimeException("Can't write to file: " + toFile, ex);
        }
    }
}
