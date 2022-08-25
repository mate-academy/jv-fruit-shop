package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> readFile(String inputFileName) {
        try (BufferedReader transactionReader =
                     new BufferedReader(new java.io.FileReader(inputFileName))) {
            List<String> records = new ArrayList<>();
            String currentLine = transactionReader.readLine();
            while (currentLine != null) {
                records.add(currentLine);
                currentLine = transactionReader.readLine();
            }
            return records;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File " + inputFileName + " not fount", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file: " + inputFileName, e);
        }
    }
}
