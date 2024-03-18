package core.basesyntax.service.impl;

import core.basesyntax.exception.NoFileToReadException;
import core.basesyntax.service.FruitFileReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FruitFileReaderImpl implements FruitFileReader {
    @Override
    public String readFile(String fromFileName) {
        String readString;
        File incomingFile = new File(fromFileName);
        StringBuilder readerBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(incomingFile))) {
            String fileLine = reader.readLine();
            while (fileLine != null) {
                readerBuilder.append(fileLine).append(",");
                fileLine = reader.readLine();
            }
            readString = readerBuilder.toString().replace(" ","");
            readerBuilder.setLength(0);
            return readString;
        } catch (IOException e) {
            throw new NoFileToReadException("Cannot read from file" + e.getMessage());
        }
    }
}
