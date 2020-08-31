package core.basesyntax.service;

import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CsvFileReader {

    public static List<FruitDto> readFromFile(String inputFile) {
        try (FileReader fileReader = new FileReader(inputFile)) {
            return new CsvToBeanBuilder<FruitDto>(fileReader)
                    .withType(FruitDto.class)
                    .build()
                    .parse();

        } catch (IOException e) {
            throw new RuntimeException("Can't read file!", e);
        }
    }
}
