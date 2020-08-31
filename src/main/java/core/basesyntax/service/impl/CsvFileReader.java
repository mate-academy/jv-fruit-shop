package core.basesyntax.service.impl;

import com.opencsv.bean.CsvToBeanBuilder;
import core.basesyntax.model.FruitDto;
import core.basesyntax.service.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class CsvFileReader implements FileReader {

    @Override
    public List<FruitDto> readData(String fileName) {
        try (java.io.FileReader fileReader = new java.io.FileReader(fileName)) {
            return new CsvToBeanBuilder<FruitDto>(fileReader)
                    .withType(FruitDto.class).build().parse();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
    }
}
