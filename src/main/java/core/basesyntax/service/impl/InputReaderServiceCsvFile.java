package core.basesyntax.service.impl;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.exceptionhandler.ExceptionHandlerThrow;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.InputReaderService;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class InputReaderServiceCsvFile implements InputReaderService {
    private static final String CAN_T_READ_DATA_FROM_THE_FILE = "Can't read data from the file ";

    @Override
    public List<FruitTransaction> readInput(final String csvFileName) {
        return readCsvFile(csvFileName);
    }

    private List<FruitTransaction> readCsvFile(final String fileName) {
        try (FileReader fileReader = new FileReader(fileName)) {
            CsvToBean<FruitTransaction> csvToBean
                    = new CsvToBeanBuilder<FruitTransaction>(fileReader)
                    .withType(FruitTransaction.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withIgnoreEmptyLine(true)
                    .withExceptionHandler(new ExceptionHandlerThrow())
                    .build();
            return csvToBean.parse();
        } catch (IOException e) {
            throw new RuntimeException(CAN_T_READ_DATA_FROM_THE_FILE + fileName, e);
        }
    }
}
