package core.basesyntax.service.impl;

import core.basesyntax.model.Grid;
import core.basesyntax.service.GridWriteService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvGridWriteService implements GridWriteService {
    private static final String SEPARATOR = ",";
    private final File file;

    public CsvGridWriteService(File file) {
        this.file = file;
    }

    @Override
    public void writeLines(Grid grid) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
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
            throw new RuntimeException("File " + file.getPath() + " doesn't exist!");
        } catch (IOException e) {
            throw new RuntimeException("Failed to write to" + file.getPath() + " file!");
        }
    }
}
