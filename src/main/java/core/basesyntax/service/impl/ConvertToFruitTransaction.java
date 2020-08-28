package core.basesyntax.service.impl;

import core.basesyntax.FruitTransaction;
import core.basesyntax.service.Convertable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ConvertToFruitTransaction implements Convertable<FruitTransaction, String[]> {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter
                            .ofPattern("yyyy-MM-dd", Locale.ENGLISH);
    private static final int TYPE = 0;
    private static final int NAME = 1;
    private static final int QUANTITY = 2;
    private static final int DATE = 3;

    @Override
    public FruitTransaction convert(String[] row) {
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setType(row[TYPE]);
        fruitTransaction.setFruit(row[NAME]);
        fruitTransaction.setQuantity(Integer.parseInt(row[QUANTITY]));
        fruitTransaction.setDate(LocalDate.parse(row[DATE], FORMATTER));
        return fruitTransaction;
    }

    public List<FruitTransaction> fileDataToList(List<String[]> fileData) {
        List<FruitTransaction> transactionList = new ArrayList<>();
        for (int i = 0; i < fileData.size(); i++) {
            String[] row = fileData.get(i);
            if (i == 0 && row[0].toLowerCase().equals("type")) {
                continue;
            }
            transactionList.add(convert(row));
        }
        return transactionList;
    }
}
