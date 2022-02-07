package fruitshop.service.data;

import fruitshop.db.ReportStorage;
import fruitshop.model.FruitTransaction;
import fruitshop.model.Operation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProcessDataImpl implements ProcessDataService {
    private final Map<String, Integer> balancesOfFruits = new HashMap<>();
    private final ReportStorage reportStorage = new ReportStorage();

    @Override
    public void process(List<FruitTransaction> listOfTransactions) {
        updateBalance(listOfTransactions);
        processOperations(listOfTransactions);
        writeDataToStorage();
    }

    private void processOperations(List<FruitTransaction> listOfTransactions) {
        for (FruitTransaction fruitTransaction : listOfTransactions) {
            String currentFruitName = fruitTransaction.getFruit();
            switch (fruitTransaction.getOperation()) {
                case SUPPLY:
                case RETURN: {
                    balancesOfFruits.put(currentFruitName, balancesOfFruits.get(currentFruitName)
                            + fruitTransaction.getQuantity());
                    break;
                }
                case PURCHASE: {
                    balancesOfFruits.put(currentFruitName, balancesOfFruits.get(currentFruitName)
                            - fruitTransaction.getQuantity());
                    break;
                }
                default: {
                    break;
                }
            }
        }
    }

    private void updateBalance(List<FruitTransaction> listOfTransactions) {
        for (FruitTransaction fruitTransaction : listOfTransactions) {
            if (fruitTransaction.getOperation().equals(Operation.BALANCE)) {
                balancesOfFruits.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
            }
        }
    }

    private void writeDataToStorage() {
        for (Map.Entry<String, Integer> entry : balancesOfFruits.entrySet()) {
            reportStorage.add(entry.getKey() + "," + entry.getValue());
        }
    }
}
