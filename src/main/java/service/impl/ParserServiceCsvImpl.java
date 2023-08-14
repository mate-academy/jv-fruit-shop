package service.impl;

import java.util.List;
import java.util.stream.Collectors;
import model.FruitTransaction;
import service.ParserService;

public class ParserServiceCsvImpl implements ParserService {
    private String header;

    @Override
    public List<FruitTransaction> parseData(List<String> data) {
        header = data.stream().limit(1).collect(Collectors.joining());
        return data.stream()
                .skip(1)
                .map(this::getFromCsvRow)
                .collect(Collectors.toList());
    }

    private FruitTransaction getFromCsvRow(String row) {
        String[] lineFields = row.split(",");
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(FruitTransaction.Operation.getByCode(lineFields[0]));
        fruitTransaction.setFruitName(lineFields[1]);
        fruitTransaction.setFruitQuantity(Integer.parseInt(lineFields[2]));
        return fruitTransaction;
    }

    @Override
    public String getHeader() {
        return this.header;
    }
}
