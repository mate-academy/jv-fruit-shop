package core.basesyntax;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CSVDataImporter implements DataImporter {
    private final String inputFilePath = "src/main/resources/input_b.csv";

    @Override
    public void importData() {
        try {
            CSVReader csvReader = new CSVReaderBuilder(Files.newBufferedReader(Paths.get(inputFilePath)))
                    .withSkipLines(1)
                    .build();
            List<String[]> data = csvReader.readAll();
            Validator.validateInput(data);
            //TODO validate each operation referring to Warehouse
            for (String[] row : data) {
                new OperationFactory()
                        .get(OperationSet.valueOf(row[0].toUpperCase()))
                        .execute(row[1], Integer.valueOf(row[2]));
            }
            csvReader.close();
        } catch (IOException e) {
            throw new RuntimeException("Could not read from file", e);
        }
    }
}

