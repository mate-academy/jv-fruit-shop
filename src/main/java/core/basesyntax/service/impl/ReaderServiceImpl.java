package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    public List<String> readFromFile(String fileName) {
        List<String> lines = new ArrayList<>();
        try  {
            return Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8) ;

        } catch (IOException e) {
            throw new RuntimeException("file " + fileName + " could not be read", e);
        }
    }
}

