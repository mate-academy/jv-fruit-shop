package core.basesyntax.services;

import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class DataFileReader {

    public List<FruitDto> readDataFromFile(String inputFilePath) {
        try (FileReader fileReader = new FileReader(inputFilePath)) {
            return new CsvToBeanBuilder<FruitDto>(fileReader)
                    .withType(FruitDto.class).build().parse();
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file, check path is correct");
        }
    }
}
