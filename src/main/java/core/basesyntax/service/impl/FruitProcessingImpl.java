package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitProcessing;
import core.basesyntax.service.TransactionHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitProcessingImpl implements FruitProcessing {
    @Override
    public Map<String, Integer> fruitProcessing(List<FruitTransaction> fruitTransactions) {
        TransactionHandler transactionHandler = new TransactionHandler();
        Map<String, Integer> fruits = new HashMap<>();
        for (FruitTransaction fruit : fruitTransactions) {
            fruits.put(fruit.getFruitName(), transactionHandler
                    .getStrategy(fruit.getOperation())
                    .balanceUpdater(fruit.getFruitName(), fruit.getQuantity()));
        }
        return fruits;
    }
}


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /*FileReader fileReader = new FileReaderImpl();
        FileWriter fileWriter = new FileWriterImpl();
        List<String> fruitsForProcessing = fileReader.getDataFromInputFile(fileName);
        StringBuilder report = new StringBuilder("fruit,quantity" + System.lineSeparator());
        while (fruitsForProcessing.size() != 1) {
            String fruitName = Arrays
                    .stream(fruitsForProcessing.get(1).trim().split(DELIMITER_REGEX))
                    .skip(1)
                    .limit(1)
                    .collect(Collectors.joining());
            int balance = 0;
            List<String> oneTypeFruit = fruitsForProcessing.stream()
                    .filter(fr -> fr.contains(fruitName.trim()))
                    .toList();
            for (String fruit : oneTypeFruit) {
                String[] fruitTransQuantData = fruit.split(DELIMITER_REGEX);
                /*balance = new FruitTransaction()
                        .getStrategy(fruitTransQuantData[FRUIT_TRANSACTION_TYPE_INDEX].trim())
                        .balanceUpdater(balance, fruitTransQuantData[FRUIT_QUANTITY_INDEX].trim());
            }
            fruitsForProcessing.removeAll(oneTypeFruit);
            report.append(fruitName).append(",")
                    .append(balance)
                    .append(System.lineSeparator());
        }
        fileWriter.sendResultData(report.toString());
    }
}*/

