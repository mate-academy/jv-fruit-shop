package core.basesyntax.service.impl;

import com.opencsv.bean.CsvToBeanBuilder;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReaderService;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class CsvFileReaderServiceImpl implements FileReaderService {
    private static final int HEADER_LINE_INDEX = 1;

    @Override
    public List<FruitTransaction> readFromFile(String pathToFile) {
        try {
            return new CsvToBeanBuilder(new FileReader(pathToFile))
                    .withType(FruitTransaction.class)
                    .withSkipLines(HEADER_LINE_INDEX)
                    .build()
                    .parse();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't read file " + pathToFile, e);
        }
    }
}
