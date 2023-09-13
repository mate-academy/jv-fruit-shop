package core.basesyntax.serviceimpl;

import core.basesyntax.service.ReaderService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> readOperations(Path pathToFile) {
        List<String> result;
        try (BufferedReader fileReader = new BufferedReader(
                new FileReader(
                        new File(
                                pathToFile.toUri())))) {
            result = fileReader.lines().skip(1).toList();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found on path " + pathToFile);
        } catch (IOException e) {
            throw new RuntimeException("Error occurred while reading from file" + pathToFile, e);
        }
        return result;
    }
}
