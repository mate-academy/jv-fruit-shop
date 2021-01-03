package core.basesyntax.shop;

import core.basesyntax.fileservice.CSVFileService;
import core.basesyntax.validation.CSVValidator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitShop implements Shop {
    private static final Map<String, Integer> BALANCE = new HashMap<>();
    private final String sourceFilePath;

    public FruitShop(String sourceFilePath) {
        this.sourceFilePath = sourceFilePath;
        initBalance();
    }

    private void initBalance() {
        CSVFileService csvFileService = new CSVFileService(new CSVValidator(BALANCE));
        List<String[]> data = csvFileService.readFromFile(sourceFilePath);
        for (String[] record : data) {
            Operation type = Operation.getOperation(record[0]);
            String fruit = record[1];
            int quantity = Integer.parseInt(record[2]);
            type.operation(fruit, quantity);
        }
    }

    public Map<String, Integer> getBalance() {
        return BALANCE;
    }

    @Override
    public void generateDailyReport(String destFilePath) {
        CSVFileService csvFileService = new CSVFileService(new CSVValidator(BALANCE));
        csvFileService.writeToFile(BALANCE, destFilePath);
    }

    public enum Operation {
        BALANCE("b") {
            public void operation(String fruit, Integer quantity) {
                FruitShop.BALANCE.put(fruit, quantity);
            }
        },
        SUPPLY("s") {
            public void operation(String fruit, Integer quantity) {
                FruitShop.BALANCE.put(fruit, FruitShop.BALANCE.get(fruit) + quantity);
            }
        },
        PURCHASE("p") {
            public void operation(String fruit, Integer quantity) {
                FruitShop.BALANCE.put(fruit, FruitShop.BALANCE.get(fruit) - quantity);
            }
        },
        RETURN("r") {
            public void operation(String fruit, Integer quantity) {
                FruitShop.BALANCE.put(fruit, FruitShop.BALANCE.get(fruit) + quantity);
            }
        };

        private final String type;

        Operation(String type) {
            this.type = type;
        }

        public static Operation getOperation(String value) {
            for (Operation operation : values()) {
                if (operation.type.equals(value)) {
                    return operation;
                }
            }
            throw new RuntimeException("File haven't type of activity " + value);
        }

        public abstract void operation(String fruit, Integer quantity);
    }
}
