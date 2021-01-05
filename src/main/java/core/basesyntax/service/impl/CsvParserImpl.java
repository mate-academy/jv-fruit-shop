package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.CsvParser;
import java.util.ArrayList;
import java.util.List;

public class CsvParserImpl implements CsvParser {
    @Override
    public List<TransactionDto> convert(List<String> stringsTransaction) {
        List<core.basesyntax.model.TransactionDto> transactionDtos = new ArrayList<>();
        for (String strings: stringsTransaction) {
            String[] transaction = strings.split(",");
            if (transaction[0].equals("type")) {
                continue;
            }
            TransactionDto transactionDto = new TransactionDto();
            Fruit fruit = new Fruit();
            fruit.setName(transaction[1]);
            transactionDto.setFruit(fruit);
            transactionDto.setOperation(Operation.fromString(transaction[0]));
            transactionDto.setQuantity(chekInteger(transaction[2]));
            transactionDtos.add(transactionDto);
        }
        return transactionDtos;
    }

    private Integer chekInteger(String string) {
        if (!string.matches("[-+]?\\d+")) {
            throw new RuntimeException("Incorrect quantity");
        }
        if (Integer.valueOf(string) <= 0) {
            throw new RuntimeException("Quantity cannot be <= 0");
        }
        return Integer.valueOf(string);
    }
}
