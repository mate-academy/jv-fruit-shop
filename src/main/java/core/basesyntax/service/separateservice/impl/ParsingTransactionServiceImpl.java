package core.basesyntax.service.separateservice.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.separateservice.ParsingTransactionService;
import java.util.List;

public class ParsingTransactionServiceImpl implements ParsingTransactionService {
    public void parsingTransaction(List<FruitTransaction> dataFromFile, String value) {
        String[] valueArray = value.split(",");
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(FruitTransaction.Operation
                .getValueByCode(valueArray[0].trim()));
        fruitTransaction.setFruit(valueArray[1]);
        fruitTransaction.setQuantity(Integer.parseInt(valueArray[2]));
        dataFromFile.add(fruitTransaction);
    }
}
