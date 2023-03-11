package core.basesyntax.service.impl;

import core.basesyntax.service.GridReadService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

public class CsvGridReadService implements GridReadService {
    private static final String SEPARATOR = ",";
    private String[] titles;
    private List<String[]> rows;

    public CsvGridReadService(File file) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            titles = bufferedReader.readLine().split(SEPARATOR);
            rows = new ArrayList<>();
            while (bufferedReader.ready()) {
                rows.add(bufferedReader.readLine().split(SEPARATOR));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File " + file.getPath() + " doesn't exist!");
        } catch (IOException e) {
            throw new RuntimeException("Failed to read " + file.getPath() + " file!");
        }
    }

    @Override
    public String[] getTitles() {
        return titles;
    }

    @Override
    public String getValue(int rowIndex, String title) {
        String[] row = rows.get(rowIndex);
        for (int i = 0; i < titles.length; i++) {
            if (titles[i].equals(title)) {
                return row[i];
            }
        }
        throw new NoSuchElementException("Row with title " + title + "doesn't exist!");
    }

    @Override
    public int getRowsCount() {
        return rows.size();
    }

    @Override
    public Stream<String[]> stream() {
        return rows.stream();
    }
}
