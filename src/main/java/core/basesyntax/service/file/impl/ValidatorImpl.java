package core.basesyntax.service.file.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.model.ParsedCsvLine;
import core.basesyntax.service.file.Validator;
import java.util.List;

public class ValidatorImpl implements Validator {
    @Override
    public void checkFileData(List<ParsedCsvLine> dataFromFile) {
        int count = 0;

        for (int i = 0; i < dataFromFile.size(); ) {
            ParsedCsvLine dataLine = dataFromFile.get(i);
            if (!dataLine.getAction().isEmpty()
                    && Operation.contains(dataLine.getAction())
                    && !dataLine.getFruitName().isEmpty()
                    && dataLine.getFruitName().replaceAll("[a-z[^\\W+_]]", "")
                    .length() == 0
                    && !dataLine.getNumber().isEmpty()
                    && dataLine.getNumber().replaceAll("[\\d[^A-z\\W+]]", "")
                    .length() == 0) {
                count++;
            }
            if (count != ++i) {
                throw new RuntimeException("Invalid data in file at line: " + (count + 2));
            }
        }
    }
}
