package core.basesyntax.dao;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileDaoCsvImpl implements FileDaoCsv {
    @Override
    public List<String> getData(String fileName) {
        List<String> operations = new ArrayList<>();
        try {
            operations = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from file" + fileName);
        }
        return operations;
    }
}
