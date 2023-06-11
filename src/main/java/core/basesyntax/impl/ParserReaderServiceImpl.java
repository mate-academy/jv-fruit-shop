package core.basesyntax.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserReaderService;
import core.basesyntax.util.Operation;
import java.util.List;

public class ParserReaderServiceImpl implements ParserReaderService {
    private static final String REGEX_COMMA = ",";
    private static final int INDEX_ZERO = 0;
    private static final int INDEX_ONE = 1;
    private static final int INDEX_TWO = 2;
    private static final int HEADERS_IN_FILE = 1;

    @Override
    public List<FruitTransaction> parse(List<String> listStringsFromFile) {
        return listStringsFromFile.stream()
                .skip(HEADERS_IN_FILE)
                .map(line -> {
                    String[] parts = line.split(REGEX_COMMA);
                    Operation operation = Operation.valueOf(
                            Operation.getCode(parts[INDEX_ZERO].trim()));
                    return new FruitTransaction(
                            operation,
                            parts[INDEX_ONE].trim(),
                            Integer.parseInt(parts[INDEX_TWO].trim())
                    );
                })
                .toList();
    }
}
