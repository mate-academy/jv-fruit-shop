package core.basesyntax.service;

import com.opencsv.bean.CsvToBeanBuilder;
import core.basesyntax.model.Operation;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class CsvFileReader {

    public static List<Operation> readFile(String filepath) {
        FileReader fileReader;
        try {
            fileReader = new FileReader(filepath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("No such file found");
        }
        return new CsvToBeanBuilder<Operation>(fileReader)
                .withType(Operation.class)
                .build().parse();
    }
}
