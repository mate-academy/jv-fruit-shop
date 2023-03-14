package core.basesyntax.service.impl;

import core.basesyntax.model.Grid;
import core.basesyntax.service.GridWriteService;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class CsvGridWriteService implements GridWriteService {
    private static final String SEPARATOR = ",";

    @Override
    public void write(String path, Grid grid) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path));
            for (int i = 0; i < grid.getTitles().length; i++) {
                bufferedWriter.write(grid.getTitles()[i]
                        + (i == grid.getTitles().length - 1 ? "" : SEPARATOR));
            }
            bufferedWriter.write(System.lineSeparator());
            for (int i = 0; i < grid.getRows().size(); i++) {
                StringBuilder builder = new StringBuilder();
                String[] values = grid.getRows().get(i);
                for (int j = 0; j < values.length; j++) {
                    builder.append(values[j])
                            .append(j == values.length - 1 ? "" : SEPARATOR);
                }
                builder.append(System.lineSeparator());
                bufferedWriter.write(builder.toString());
            }
            bufferedWriter.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File " + path + " doesn't exist!");
        } catch (IOException e) {
            throw new RuntimeException("Failed to write to" + path + " file!");
        }
    }
}
