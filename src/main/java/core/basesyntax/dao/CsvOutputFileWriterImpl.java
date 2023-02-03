package core.basesyntax.dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

public class CsvOutputFileWriterImpl implements CsvOutputFileWriter {
    private static final String FILEPATH_OUTPUT =
            "src/main/resources/OutputFile.csv";

    @Override
    public void createCscWithTitle() {
        String title = "fruit,quantity";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILEPATH_OUTPUT));
            writer.write(title);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file", e);
        }
    }

    @Override
    public void saveResultsToCsv(Map<String, Integer> fruits) {
        String mapAsString = fruits.keySet().stream()
                .map(key -> key + "," + fruits.get(key))
                .collect(Collectors.joining(System.lineSeparator()));
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(FILEPATH_OUTPUT, true));
            writer.append(System.lineSeparator());
            writer.append(mapAsString);

            writer.close();
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file",e);
        }



    }
}
