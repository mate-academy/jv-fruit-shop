package core.basesyntax.service;

import core.basesyntax.AbstractTransaction;
import core.basesyntax.FruitBatch;
import core.basesyntax.FruitStorage;
import java.util.List;
import java.util.Map;

public class UpdateFruitStorageService {

    public void updateStock(List<AbstractTransaction> transactions) {
        Map<FruitBatch, Integer> fruits = FruitStorage.getFruits();
        for (AbstractTransaction transaction : transactions) {
            FruitBatch fruit = new FruitBatch(transaction.getFruitType(),
                    transaction.getDate());
            if (transaction.getTransactionType().equals(TransactionLogService.SUPPLY)
                    || transaction.getTransactionType().equals(TransactionLogService.RETURN)) {
                if (fruits.containsKey(fruit)) {
                    fruits.put(fruit,
                            fruits.get(fruit) + transaction.getQuantity());
                } else {
                    fruits.put(fruit, transaction.getQuantity());
                }
            }
            if (transaction.getTransactionType().equals(TransactionLogService.BUY)) {
                for (Map.Entry<FruitBatch, Integer> entry :
                        fruits.entrySet()) {
                    if (entry.getKey().getFruitType().equals(fruit.getFruitType())) {
                        if (entry.getKey().getExpiryDate().isAfter(transaction.getDate())) {
                            if (entry.getValue() < transaction.getQuantity()) {
                                throw new RuntimeException("Arithmetic "
                                        + "error. There wasn't"
                                        + " enough fruit in the store to "
                                        + "make the purchase.");
                            }
                            entry.setValue(entry.getValue() - transaction.getQuantity());
                        }
                    }
                }
            }
        }
    }
}

//public class UpdateFruitStorageService implements UpdateStorageService {
//public void updateStock(List<String[]> lines) {
//    public void updateStock(String filePath) {
//        FileReaderService reader = new CsvFileReaderService();
//        List<String[]> lines = reader.getTransactions(filePath);

// MAKE THIS A PARSER

//        for (String[] line : lines) {
//            //DO PARSER
//            String transaction = line[0];
//            String fruitType = line[1];
//            int quantity = Integer.parseInt(line[2]);
//            LocalDate date = LocalDate.parse(line[3],
//                    DateTimeFormatter.ISO_LOCAL_DATE);

// ITERATE OVER TRANSACTIONSLOG & DO ADD OR REMOVE

//ADD TO STOCK
// FruitBatch fruit = new FruitBatch(fruitType, date);


//            if (transaction.equals(FruitStorage.SUPPLY) || transaction
//            .equals(FruitStorage.RETURN)) {
//                //ReplenishService replenishService = new ReplenishService();
//                //replenishService.addToStock(fruit, quantity);
//                addToStock(fruit, quantity);
//            } else if (transaction.equals(FruitStorage.BUY)) {
//               // BuyService buyService = new BuyService();
//                //buyService.buy(fruit, date, quantity);
//                removeFromStock(fruit, date, quantity);
//            }
//        }
//    }
//
//    @Override
//    public void addToStock(FruitBatch fruit, int quantity) {
//        Map<FruitBatch, Integer> fruits = FruitStorage.getFruits();
//        if (fruits.containsKey(fruit)) {
//            fruits.put(fruit, fruits.get(fruit) + quantity);
//        } else {
//            fruits.put(fruit, quantity);
//        }
//    }

//    @Override
//    public void removeFromStock(FruitBatch fruit, LocalDate purchaseDate,
//    int quantity) {
//        Map<FruitBatch, Integer> fruits = FruitStorage.getFruits();
//        for (Map.Entry<FruitBatch, Integer> entry : fruits.entrySet()) {
//            if (entry.getKey().getFruitType().equals(fruit.getFruitType())) {
//                if (entry.getKey().getExpiryDate().isAfter(purchaseDate)) {
//                    if (entry.getValue() < quantity) {
//                        throw new RuntimeException("Arithmetic error. There
//                        wasn't"
//                                + " enough fruit in the store to make the
//                                purchase.");
//                    }
//                    entry.setValue(entry.getValue() - quantity);
//                }
//            }
//        }
//    }
//}
