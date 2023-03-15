package service.impl;

import java.util.List;
import java.util.stream.Collectors;
import model.FruitTransaction;
import service.TransactionParserService;

public class TransactionParserServiceImpl implements TransactionParserService {
    private static final String SEPARATOR = ",";
    private static final int INDEX_OF_OPERATION = 0;
    private static final int INDEX_OF_FRUIT = 1;
    private static final int INDEX_OF_QUANTITY = 2;

    @Override
    public List<FruitTransaction> parseFileInformation(List<String> lines) {
        return lines.stream()
                .map(line -> line.split(SEPARATOR))
                .filter(this::checkBeforeParse)
                .map(partsOfLine -> new FruitTransaction(FruitTransaction.Operation
                        .getOperationByCommand(partsOfLine[INDEX_OF_OPERATION]),
                        partsOfLine[INDEX_OF_FRUIT],
                        Integer.parseInt(partsOfLine[INDEX_OF_QUANTITY])))
                .collect(Collectors.toList());
    }

    public boolean checkBeforeParse(String[] lines) {
        return lines != null && lines.length == 3;
    }
}
