package core.basesyntax.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.List;

public class PivotDaoCsvImpl implements PivotDao {
    private static final String PIVOT_FILE_NAME = "src/main/resources/pivot.csv";

    @Override
    public void writePivotFile(List<String> stringList) {
        Path filePath = Path.of(PIVOT_FILE_NAME);
        String header = "product,quantity";
        try (FileWriter fileWriter = new FileWriter(filePath.toFile());
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.printf(header + System.lineSeparator());
            for (String str : stringList) {
                printWriter.printf(str + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + PIVOT_FILE_NAME, e);
        }

    }
}
