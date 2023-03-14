package core.basesyntax.impl;

import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public String readFrom(String path) {
        if (path == null) {
            throw new RuntimeException("Path is null");
        }
        File file = new File(path);
        StringBuilder result = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String value = br.readLine();
            while (value != null) {
                result.append(value).append(System.lineSeparator());
                value = br.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find file " + path, e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + path, e);
        }
        return result.toString().trim();
    }
}
