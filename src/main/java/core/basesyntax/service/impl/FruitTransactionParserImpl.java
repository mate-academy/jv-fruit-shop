package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileParser;
import core.basesyntax.service.FruitTransactionParser;

import java.util.List;
import java.util.stream.Collectors;

public class FruitTransactionParserImpl implements FruitTransactionParser {

    private static final String INPUT_HEADER = "type,fruit,quantity";
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private FileParser fileParser;

    public FruitTransactionParserImpl(FileParser fileParser) {
        this.fileParser = fileParser;
    }

    @Override
    public List<FruitTransaction> parse(List<String> data) {
        return data.stream()
                .filter(line -> !line.equals(INPUT_HEADER))
                .map(fileParser::parse)
                .map(line -> new FruitTransaction(
                        FruitTransaction.Operation.fromCode(line[OPERATION_TYPE_INDEX]),
                        line[FRUIT_NAME_INDEX],
                        Integer.parseInt(line[QUANTITY_INDEX])
                ))
                .collect(Collectors.toList());
    }
}
