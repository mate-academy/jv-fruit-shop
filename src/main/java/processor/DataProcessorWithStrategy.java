package processor;

import java.util.List;
import model.Operation;
import processor.strategy.ProcessingStrategy;
import processor.strategy.ProcessingStrategyImpl;
import service.DataStorageService;
import service.impl.DataStorageServiceImpl;
import storage.OperationalStorage;

public class DataProcessorWithStrategy implements DataProcessor {
    private static final String DATA_SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int NAME_INDEX = 1;
    private static final int VALUE_INDEX = 2;
    private final DataStorageService storageService = new DataStorageServiceImpl();
    private final ProcessingStrategy processingStrategy = new ProcessingStrategyImpl();

    @Override
    public void makeProcessedData(List<String> input) {
        for (String line: input) {
            String[] values = line.split(DATA_SEPARATOR);
            OperationalStorage.setOperationAmount(Integer.valueOf(values[VALUE_INDEX]));
            OperationalStorage.setFruit(values[NAME_INDEX]);
            OperationalStorage.setStoredAmount(storageService.getValue(values[NAME_INDEX]));
            processingStrategy.makeTransaction(Operation.getByLabel(values[OPERATION_INDEX]));
        }
    }
}
