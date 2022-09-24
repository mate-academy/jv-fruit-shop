package core.basesyntax.service;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionParseServiceImpl implements TransactionParseService{
    private static final int OPERATOR = 0;
    private static final int FRUIT = 1;
    private static final int FRUIT_COUNT = 2;
    @Override
    public List<FruitTransaction> transactionParse(List<String> dailyTransactionList) {
        return dailyTransactionList.stream()
                .skip(1)
                .map(this::parsingLine).collect(Collectors.toList());
    }
    private FruitTransaction parsingLine(String line) {
        String[] splitLines = line.split(",");
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(fruitTransaction.setOperation(splitLines[OPERATOR]));
        fruitTransaction.setFruit(splitLines[FRUIT]);
        fruitTransaction.setQuantity(Integer.parseInt(splitLines[FRUIT_COUNT]));
        return fruitTransaction;
    }
}
