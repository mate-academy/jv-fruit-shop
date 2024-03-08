package service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import service.FileReader;

public class FileReaderImpl implements FileReader {
    @Override
    public String readFile(String fromFileName) {
        File file = new File(fromFileName);
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line).append(" ");
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + fromFileName, e);
        }

        return builder.toString();
    }
}
