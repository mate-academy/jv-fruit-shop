package core.basesyntax.filework;

import core.basesyntax.dao.FruitRecordDto;
import core.basesyntax.exceptions.ReadFromFileException;
import core.basesyntax.model.OperationType;
import core.basesyntax.service.validator.Validator;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReaderImpl implements FileReader {
    public static final List<FruitRecordDto> fruitStore = new ArrayList<>();
    private static final String COMA = ",";

    public void read(String path) {
        String line;

        try (BufferedReader br = new BufferedReader(new java.io.FileReader(path))) {
            while (true) {
                if ((line = br.readLine()) == null) {
                    break;
                }
                if (Validator.isValidLine(line.split(COMA))) {
                    FruitRecordDto fruit = parseTransaction(line.split(COMA));
                    fruitStore.add(fruit);
                } else {
                    continue;
                }
            }
        } catch (IOException e) {
            throw new ReadFromFileException("Can't rad from file");
        }
    }

    private FruitRecordDto parseTransaction(String[] line) {
        return new FruitRecordDto(OperationType.getType(line[0]),
                line[1], Integer.parseInt(line[2]));
    }
}
