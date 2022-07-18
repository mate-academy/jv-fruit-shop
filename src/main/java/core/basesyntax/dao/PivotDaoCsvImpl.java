package core.basesyntax.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.List;

public class PivotDaoCsvImpl implements PivotDao {

    @Override
    public void writePivotFile(String fileName, List<String> stringList) {
        Path filePath = Path.of(fileName);
        String header = "product,quantity";
        try (FileWriter fileWriter = new FileWriter(filePath.toFile());
                PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.printf(header + System.lineSeparator());
            for (String str : stringList) {
                printWriter.printf(str + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + fileName, e);
        }

    }
}
