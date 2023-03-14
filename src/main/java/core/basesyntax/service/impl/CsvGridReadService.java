package core.basesyntax.service.impl;

import core.basesyntax.model.Grid;
import core.basesyntax.service.GridReadService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvGridReadService implements GridReadService {
    private static final String SEPARATOR = ",";
    private Grid grid;

    @Override
    public Grid getGrid(String path) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String[] titles = bufferedReader.readLine().split(SEPARATOR);
            List<String[]> rows = new ArrayList<>();
            while (bufferedReader.ready()) {
                rows.add(bufferedReader.readLine().split(SEPARATOR));
            }
            return new Grid(titles, rows);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File " + path + " doesn't exist!");
        } catch (IOException e) {
            throw new RuntimeException("Failed to read " + path + " file!");
        }
    }
}
