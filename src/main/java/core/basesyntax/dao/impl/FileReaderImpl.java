package core.basesyntax.dao.impl;

import core.basesyntax.dao.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {

    @Override
    public List<String> read(String filename) {
        List<String> transactions = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                transactions.add(line);
            }
        } catch (NoSuchFileException e) {
            throw new RuntimeException("File not found: " + filename
                    + ". Please check the file path.", e);
        } catch (AccessDeniedException e) {
            throw new RuntimeException("Access denied to file: "
                    + filename + ". Check file permissions.", e);
        } catch (IOException e) {
            throw new RuntimeException("Error occurred while reading file "
                    + filename + ". Please check file integrity or permissions.", e);
        }
        return transactions;
    }
}
