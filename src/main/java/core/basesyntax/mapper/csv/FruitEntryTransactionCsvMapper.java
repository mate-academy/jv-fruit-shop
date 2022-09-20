package core.basesyntax.mapper.csv;

import core.basesyntax.fruitentrytransaction.FruitEntryTransaction;
import core.basesyntax.fruitentrytransaction.exception.OperationNotSupportedException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;

// should be generalized with reflection or replaced everywhere with some library, which even better
@RequiredArgsConstructor
public class FruitEntryTransactionCsvMapper {
    private static final int FILE_HEADER_INDEX = 0;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private final String separator;

    public List<FruitEntryTransaction> mapFromCsvFile(Path pathToFile) {
        List<String> csvLines;
        try {
            csvLines = Files.readAllLines(pathToFile);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + pathToFile);
        }

        csvLines.remove(FILE_HEADER_INDEX);
        return csvLines.stream()
                .map(this::mapFromCsvLine)
                .collect(Collectors.toList());
    }

    public FruitEntryTransaction mapFromCsvLine(String line) {
        String[] tokens = line.split(separator);
        String errorMsg = "Can't resolve operation: " + tokens[OPERATION_INDEX];
        return new FruitEntryTransaction(
                FruitEntryTransaction.Operation.findByName(tokens[OPERATION_INDEX])
                        .orElseThrow(() -> new OperationNotSupportedException(errorMsg)),
                tokens[FRUIT_NAME_INDEX],
                Integer.parseInt(tokens[QUANTITY_INDEX]));
    }
}
