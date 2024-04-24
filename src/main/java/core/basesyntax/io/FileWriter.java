package core.basesyntax.io;

import core.basesyntax.model.FruitReport;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileWriter {
    private static final String PATH = "src/main/resources/db/report.csv";
    private static final String SEPARATOR = ",";
    private static final Path filePath = Path.of(PATH);

    public void writeToFile(List<FruitReport> reports) {
        List<String> stringList = createReport(reports);
        try {
            Files.write(filePath, stringList,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file: "
                    + filePath, e);
        }
    }

    public List<String> createReport(List<FruitReport> reports) {
        List<String> lines = new ArrayList<>();
        lines.add("fruit" + SEPARATOR + "quantity");
        for (FruitReport report : reports) {
            String line = report.getFruit() + SEPARATOR
                    + report.getQuantity();
            lines.add(line);
        }
        return lines;
    }
}
