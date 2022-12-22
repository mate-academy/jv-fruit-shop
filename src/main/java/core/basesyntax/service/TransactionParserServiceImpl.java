package core.basesyntax.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TransactionParserServiceImpl implements TransactionParserService {
    private String rowTitle = "type,fruit,quantity";

    @Override
    public List<FruitTransaction> parse(List<String> lines) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();

        for (String line : lines) {
            String[] transactionArr = line.split(",");
            FruitTransaction fruitTransaction = new FruitTransaction();
            Optional<FruitTransaction.Operation> operation = parseOperation(transactionArr[0]);
            if (operation.isPresent()) {
                fruitTransaction.setOperation(operation.get());
                fruitTransaction.setFruit(transactionArr[1]);
                fruitTransaction.setQuantity(Integer.parseInt(transactionArr[2]));
                fruitTransactionList.add(fruitTransaction);
            }
        }
        return fruitTransactionList;
    }

    private Optional<FruitTransaction.Operation> parseOperation(String value) {
        for (FruitTransaction.Operation operation : FruitTransaction.Operation.values()) {
            if (operation.getOperation().equals(value)) {
                return Optional.of(operation);
            } else if (rowTitle.contains(value)) {
                return Optional.ofNullable(null);
            }
        }
        throw new RuntimeException(value + " - operation is not exist in enum");
    }
}
