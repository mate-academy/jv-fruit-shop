package processor;

import dao.DataDao;
import dao.impl.DataDaoImpl;
import java.util.List;
import model.Operation;
import processor.strategy.ProcessingStrategy;
import processor.strategy.ProcessingStrategyImpl;
import processor.strategy.buffer.OperationBufferManager;

public class DataProcessorImpl implements DataProcessor {
    private static final String DATA_SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int NAME_INDEX = 1;
    private static final int VALUE_INDEX = 2;
    private final DataDao storageService = new DataDaoImpl();
    private final ProcessingStrategy processingStrategy = new ProcessingStrategyImpl();

    @Override
    public void makeProcessedData(List<String> input) {
        for (String line: input) {
            String[] values = line.split(DATA_SEPARATOR);
            OperationBufferManager.setOperationAmount(Integer.valueOf(values[VALUE_INDEX]));
            OperationBufferManager.setFruit(values[NAME_INDEX]);
            OperationBufferManager.setStoredAmount(storageService.getValue(values[NAME_INDEX]));
            processingStrategy.makeTransaction(Operation.getByLabel(values[OPERATION_INDEX]));
        }
    }
}
