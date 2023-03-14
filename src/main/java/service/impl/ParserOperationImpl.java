package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.TransactionDto;
import service.ParserOperation;

public class ParserOperationImpl implements ParserOperation {
    private static final String SEPARATOR = ",";
    private static final int ZERO_INDEX = 0;
    private static final int FIRST_INDEX = 1;
    private static final int SECOND_INDEX = 2;

    @Override
    public List<TransactionDto> parserOperation(List<String> line) {
        List<TransactionDto> parsedTransaction = new ArrayList<>();
        for (String strings : line) {
            TransactionDto transactionDto = new TransactionDto();
            String[] splited = strings.split(SEPARATOR);
            transactionDto.setOperation(TransactionDto.Operation.getByCode(splited[ZERO_INDEX]));
            transactionDto.setFruitName(splited[FIRST_INDEX]);
            transactionDto.setQuantity(Integer.parseInt(splited[SECOND_INDEX]));
            parsedTransaction.add(transactionDto);
        }
        return parsedTransaction;
    }
}
