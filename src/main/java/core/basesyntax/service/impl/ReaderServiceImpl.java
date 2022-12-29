package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReaderServiceImpl implements ReaderService {
    private static final String COMMA_DELIMITER = ",";

    @Override
    public String readFromFile(File fromFileName) {
        String lines;
        StringBuilder linesBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fromFileName));) {
            lines = bufferedReader.readLine();
            while (lines != null) {
                linesBuilder.append(lines).append("\n");
                lines = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find file " + fromFileName, e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from the file " + fromFileName, e);
        }
        System.out.println(linesBuilder);
        return linesBuilder.toString();
    }
}
