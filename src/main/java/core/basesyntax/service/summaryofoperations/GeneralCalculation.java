package core.basesyntax.service.summaryofoperations;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.Operation;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GeneralCalculation {
    private final Calculation sumCalculation = new CalculationByOperationImpl();
    private final StorageDao fruitList = new StorageDaoImpl();

    public List<String> calculateTotalAmount(Map<Operation, Map<String, List<Integer>>> storage) {
        List<String> listFruits = fruitList.getListOfFruits(storage);
        List<String> generalAmountList = new ArrayList<>();
        for (String typeOfFruit : listFruits) {
            int totalAmount = 0;
            totalAmount += sumCalculation.getSumByOperationDependsOnFruit(storage,
                    Operation.BALANCE, typeOfFruit);
            totalAmount += sumCalculation.getSumByOperationDependsOnFruit(storage,
                    Operation.SUPPLY, typeOfFruit);
            totalAmount += sumCalculation.getSumByOperationDependsOnFruit(storage,
                    Operation.RETURN, typeOfFruit);
            totalAmount -= sumCalculation.getSumByOperationDependsOnFruit(storage,
                    Operation.PURCHASE, typeOfFruit);
            generalAmountList.add(typeOfFruit + "," + totalAmount);
        }
        return generalAmountList;
    }
}
