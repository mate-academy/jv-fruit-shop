package core.basesyntax.service.impl;

import com.opencsv.bean.CsvToBeanBuilder;
import core.basesyntax.FruitTransaction;
import core.basesyntax.service.FileService;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileServiceImpl implements FileService {

    private static final String FILE_HEADER = "fruit,quantity\n";

    @Override
    public List<FruitTransaction> readFile(String filePath) {
        FileReader fileReader;
        try {
            fileReader = new FileReader(filePath);
        } catch (IOException e) {
            throw new RuntimeException("Error occured", e);
        }
        return new CsvToBeanBuilder<FruitTransaction>(fileReader)
                .withType(FruitTransaction.class)
                .build()
                .parse();
    }

    @Override
    public void writeFile(String filePath, List<String> output) {
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(FILE_HEADER);
            for (String line : output) {
                fileWriter.write(line);
                fileWriter.write("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("Check if the file path is correct", e);
        }
    }
}
