package core.basesyntax.service.impl;

import com.opencsv.bean.CsvToBeanBuilder;
import core.basesyntax.model.FruitTransactionDto;
import core.basesyntax.service.FileReaderService;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class CsvFileReaderServiceImpl implements FileReaderService {
    private static final int HEADER_LINE_INDEX = 1;

    @Override
    public List<FruitTransactionDto> readDataFile(String fileName) {
        try {
            return new CsvToBeanBuilder(new FileReader(fileName))
                    .withType(FruitTransactionDto.class)
                    .withSkipLines(HEADER_LINE_INDEX)
                    .build()
                    .parse();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't read file " + fileName, e);
        }
    }
}
