package service;

import java.util.List;
import java.util.stream.Collectors;
import model.FruitTransaction;

public class ReportCreatorService {
    private static final String HEADER = "fruit,quantity";

    public String prepearingDataToWrite(List<FruitTransaction> fruitTransactionList) {
        List<String> fruitDataToWrite = fruitTransactionList.stream()
                .map(i -> i.getFruitName() + "," + i.getValue())
                .collect(Collectors.toList());
        fruitDataToWrite.add(0, HEADER);
        return String.join(" ",fruitDataToWrite);
    }
}
