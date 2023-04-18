package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.Transfer;
import core.basesyntax.strategy.OperationStrategy;

import java.util.Map;

import static core.basesyntax.db.Storage.fruitData;

public class TransferImpl implements Transfer {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final String REPORT_HEADER = "fruit,quantity";

    @Override
    public String report(Map<String,Integer> fruitData) {
        StringBuilder report = new StringBuilder(REPORT_HEADER);
        for (Map.Entry<String,Integer> entry : fruitData.entrySet()) {
            report.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(",").append(entry.getValue());
        }
        return report.toString();
    }

    @Override
    public Fruit splitLine(String line) {
        String[] splitter = line.split(",");
        Fruit fruit = new Fruit();
        fruit.setOperation(Fruit.Operation.getCode(splitter[OPERATION_INDEX]));
        String fruitOperation = splitter[FRUIT_INDEX];
        fruit.setFruit(fruitOperation);
        fruit.setAmount(Integer.parseInt(splitter[AMOUNT_INDEX]));
        return fruit;
    }

    @Override
    public void generateInfo(String[] info, OperationStrategy operationStrategy) {
        for (int i = 1; i < info.length; i++) {
            Fruit fruit = splitLine(info[i]);
            if (fruitData.containsKey(fruit.getFruit())) {
                Integer fruitAmountInfo = fruitData.get(fruit.getFruit());
                fruitAmountInfo += operationStrategy.get(fruit.getOperation())
                        .process(fruit.getAmount());
                //Handling Purchase operation
                if (fruitAmountInfo < 0) {
                    throw new RuntimeException(fruit.getFruit() + " balance can't be negative");
                }
                fruitData.replace(fruit.getFruit(),fruitAmountInfo);
            } else {
                fruitData.put(fruit.getFruit(),fruit.getAmount());
            }
        }
    }
}
