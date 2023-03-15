package core.basesyntax.service.impl;

import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.TransactionParser;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserImpl implements TransactionParser {
    private static final String SEPARATOR = ",";
    private static final int ACTION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<TransactionDto> parserTransactionOperation(List<String> line) {
        List<TransactionDto> parsedTransaction = new ArrayList<>();
        for (String strings : line) {
            TransactionDto transactionDto = new TransactionDto();
            String[] splited = strings.split(SEPARATOR);
            transactionDto.setOperation(TransactionDto.Operation.getByCode(splited[ACTION_INDEX]));
            transactionDto.setFruitName(splited[FRUIT_INDEX]);
            transactionDto.setQuantity(Integer.parseInt(splited[QUANTITY_INDEX]));
            parsedTransaction.add(transactionDto);
        }
        return parsedTransaction;
    }
}
