package core.basesyntax.service;

import com.opencsv.bean.CsvToBeanBuilder;
import core.basesyntax.model.FruitDto;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class CsvFileReader {

    public static List<FruitDto> readFile(String filepath) {
        FileReader fileReader;
        try {
            fileReader = new FileReader(filepath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("No such file found. File path = " + filepath, e);
        }
        return new CsvToBeanBuilder<FruitDto>(fileReader)
                .withType(FruitDto.class)
                .build().parse();
    }
}
