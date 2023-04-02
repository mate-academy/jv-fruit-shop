package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.Parser;
import core.basesyntax.strategy.Operation;

import java.util.List;
import java.util.stream.Collectors;

public class ParserImplCSV implements Parser<Transaction> {
    private static final String BALANCE_OPERATION_MARK = "b";
    private static final String SUPPLY_OPERATION_MARK = "s";
    private static final String PURCHASE_OPERATION_MARK = "p";
    private static final String RETURN_OPERATION_MARK = "r";
    private static final String DEFAULT_DELIMITER = " ";
    private String delimiter;

    public ParserImplCSV() {
        this.delimiter = DEFAULT_DELIMITER;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public ParserImplCSV setDelimiter(String delimiter) {
        this.delimiter = delimiter;
        return this;
    }

    private Operation getOperation(String operationMark) {
        switch (operationMark) {
            case BALANCE_OPERATION_MARK:
                return Operation.BALANCE;
            case SUPPLY_OPERATION_MARK:
                return Operation.SUPPLY;
            case PURCHASE_OPERATION_MARK:
                return Operation.PURCHASE;
            case RETURN_OPERATION_MARK:
                return Operation.RETURN;
            default:
                throw new RuntimeException("No such operation marked as " + operationMark);
        }
    }

    @Override
    public List<Transaction> parse(List<String> stringList) {
        return stringList.stream()
                .map(s -> s.split(delimiter))
                .skip(1)
                .map(s -> new Transaction(getOperation(s[0]), Fruit.of(s[1]), Integer.parseInt(s[2])))
                .collect(Collectors.toList());
    }
}
