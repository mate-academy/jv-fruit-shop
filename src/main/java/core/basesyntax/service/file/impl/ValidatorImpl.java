package core.basesyntax.service.file.impl;

import core.basesyntax.model.CsvLineDto;
import core.basesyntax.model.Operation;
import core.basesyntax.service.file.Validator;
import java.util.List;

public class ValidatorImpl implements Validator {
    @Override
    public void checkFileData(List<CsvLineDto> dataFromFile) {
        for (CsvLineDto dataLine : dataFromFile) {
            if (!dataLine.getOperation().isEmpty()
                    && Operation.contains(dataLine.getOperation())
                    && !dataLine.getFruitName().isEmpty()
                    && dataLine.getFruitName().replaceAll("[a-z[^\\W+_]]", "")
                    .length() == 0
                    && !dataLine.getNumber().isEmpty()
                    && dataLine.getNumber().replaceAll("[\\d[^A-z\\W+]]", "")
                    .length() == 0) {
                continue;
            }
            throw new RuntimeException("Invalid data in file");
        }
    }
}
