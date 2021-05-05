package core.basesyntax.model.dto.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.dto.WriteToFile;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteToFileImpl implements WriteToFile {
    private static final String FIRST_LINE = "fruit,quantity";
    private static final String NEXT_LINE_REGEX = "\n";
    private static final String COMA = ",";
    private static final String FILE_NAME = "Report.csv";

    @Override
    public void writeToFile(Map<Fruit, Integer> map) {
        try (FileWriter fileWriter = new FileWriter("Report.csv", false)) {
            fileWriter.write(FIRST_LINE);
            fileWriter.append(NEXT_LINE_REGEX);
            for (Map.Entry<Fruit, Integer> entry : map.entrySet()) {
                fileWriter.append(entry.getKey().getName())
                        .append(COMA)
                        .append(entry.getValue().toString())
                        .append(NEXT_LINE_REGEX);
            }
        } catch (IOException e) {
            throw new RuntimeException("File not found" + FILE_NAME);
        }
    }
}
