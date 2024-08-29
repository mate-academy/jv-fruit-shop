package core.basesyntax.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> readFile(String filePath) {
        List<String> transactionsList = new ArrayList<>();
        try (BufferedReader transactionReader =
                     new BufferedReader(new java.io.FileReader(filePath))) {
            String header = transactionReader.readLine();
            String currentLine;
            while ((currentLine = transactionReader.readLine()) != null) {
                transactionsList.add(currentLine);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can not read the file (" + filePath + ")" + e);
        }
        return transactionsList;
    }
}
