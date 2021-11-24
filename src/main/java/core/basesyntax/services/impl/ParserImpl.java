package core.basesyntax.services.impl;

import core.basesyntax.model.TransactionDto;
import core.basesyntax.services.Parser;
import core.basesyntax.services.Validator;
import java.util.ArrayList;
import java.util.List;

public class ParserImpl implements Parser<TransactionDto> {
    private static final String INPUT_TITLE = "type,fruit,quantity";
    private static final String COMA_SEPARATOR = ",";
    private static final int INDEX_OF_OPERATION = 0;
    private static final int INDEX_OF_PRODUCT = 1;
    private static final int INDEX_OF_QUANTITY = 2;
    private final Validator validator;

    public ParserImpl(Validator validator) {
        this.validator = validator;
    }

    @Override
    public List<TransactionDto> parseLine(List<String> inputData) {
        validator.validate(inputData);
        List<TransactionDto> transactions = new ArrayList<>();
        inputData.stream()
                .filter(e -> !e.equals(INPUT_TITLE))
                .map(e -> e.split(COMA_SEPARATOR))
                .forEach(e -> transactions.add(new TransactionDto(e[INDEX_OF_OPERATION],
                        e[INDEX_OF_PRODUCT], Integer.parseInt(e[INDEX_OF_QUANTITY]))));
        return transactions;
    }
}

