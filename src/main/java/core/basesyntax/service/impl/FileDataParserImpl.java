package core.basesyntax.service.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.FileDataParser;
import java.util.List;
import java.util.stream.Collectors;

public class FileDataParserImpl implements FileDataParser {
    @Override
    public List<Transaction> parse(List<String> data) {
        return data.stream()
                .skip(1)
                .map(this::parseTransaction)
                .collect(Collectors.toList());
    }

    private Transaction parseTransaction(String data) {
        String[] dataArray = data.split(",");
        if (dataArray.length != 3) {
            throw new IllegalArgumentException("Invalid transaction data format");
        }

        String operation = dataArray[0];
        String name = dataArray[1];
        int quantity = Integer.parseInt(dataArray[2]);
        return new Transaction(operation, name, quantity);
    }
}
