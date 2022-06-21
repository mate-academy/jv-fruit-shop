package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CsvFileReaderImpl implements CsvFileReader {
    @Override
    public String readFile(String filePath) {
        File inputFile = new File(filePath);
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                line = bufferedReader.readLine();
                stringBuilder.append(line).append("\n");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File \"" + inputFile + "\" wasn't found", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file \"" + inputFile + "\"", e);
        }
        return stringBuilder.toString();
    }
}
