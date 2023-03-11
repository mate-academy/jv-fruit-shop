package processor;

import java.util.List;
import model.Operation;
import service.impl.DataStorageServiceImpl;

public class DataProcessorImpl implements DataProcessor {
    private static final String DATA_SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int NAME_INDEX = 1;
    private static final int VALUE_INDEX = 2;
    private final DataStorageServiceImpl storageService = new DataStorageServiceImpl();

    public void makeProcessedData(List<String> input) {
        for (String line: input) {
            String[] values = line.split(DATA_SEPARATOR);
            Operation operation = Operation.getByLabel(values[OPERATION_INDEX]);
            if (operation == null) {
                continue;
            }
            switch (operation) {
                case BALANCE: setBalance(values);
                    break;
                case SUPPLY: supplyOrReturn(values);
                    break;
                    // can't leave this case empty because of maven checks
                case RETURN: supplyOrReturn(values);
                    break;
                case PURCHASE: purchase(values);
                    break;
                default:
                    System.out.println("Problem occurred while processing line: " + line);
            }
        }
    }

    private void setBalance(String[] values) {
        storageService.putValue(values[NAME_INDEX], Integer.valueOf(values[2]));
    }

    private void supplyOrReturn(String[] values) {
        storageService.putValue(values[NAME_INDEX], storageService.getValue(values[NAME_INDEX])
                    + Integer.valueOf(values[VALUE_INDEX]));
    }

    private void purchase(String[] values) {
        storageService.putValue(values[NAME_INDEX], storageService.getValue(values[NAME_INDEX])
                    - Integer.valueOf(values[VALUE_INDEX]));
    }
}

