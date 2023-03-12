package processor;

import java.util.List;
import model.Operation;
import model.ReportException;
import service.general.DataPreparationService;
import service.general.DataStorageService;
import service.impl.DataPreparationServiceImpl;
import service.impl.DataStorageServiceImpl;

public class DataProcessorImpl implements DataProcessor {
    private static final String DATA_SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int NAME_INDEX = 1;
    private static final int VALUE_INDEX = 2;
    private final DataStorageService storageService = new DataStorageServiceImpl();
    private Integer fruitAmount;
    private Integer operationAmount;
    private String fruitName;

    public void makeProcessedData(List<String> input) {
        DataPreparationService preparationService = new DataPreparationServiceImpl();
        preparationService.getDataPrepared();

        for (String line: input) {
            String[] values = line.split(DATA_SEPARATOR);
            fruitAmount = storageService.getValue(values[NAME_INDEX]);
            fruitName = values[NAME_INDEX];
            operationAmount = Integer.valueOf(values[VALUE_INDEX]);
            Operation operation = Operation.getByLabel(values[OPERATION_INDEX]);
            switch (operation) {
                case BALANCE: setBalance();
                    break;
                case SUPPLY: supplyOrReturn();
                    break;
                    // can't leave this case empty because of maven checks
                case RETURN: supplyOrReturn();
                    break;
                case PURCHASE: purchase();
                    break;
                default:
                    System.out.println("Problem occurred while processing line: " + line);
            }
        }
    }

    private void setBalance() {
        storageService.putValue(fruitName, operationAmount);
    }

    private void supplyOrReturn() {
        checkBalance();
        storageService.putValue(fruitName, fruitAmount + operationAmount);
    }

    private void purchase() {
        checkBalance();
        storageService.putValue(fruitName, fruitAmount - operationAmount);
    }

    private void checkBalance() {
        if (fruitAmount == null) {
            throw new ReportException("Balance had not been set for " + fruitName);
        }
    }
}
