package processor;

import dao.DataDao;
import dao.impl.DataDaoImpl;
import exception.ReportException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Operation;
import model.OperationUnit;
import processor.operation.BalanceHandler;
import processor.operation.OperationHandler;
import processor.operation.PurchaseHandler;
import processor.operation.ReturnHandler;
import processor.operation.SupplyHandler;

public class ProcessorImpl implements Processor {
    private static final String CORRECT_DATA_REGEX = "[bspr],\\w++,\\d++";
    private static final String DATA_SEPARATOR = ",";
    private static final int LEGEND_INDEX = 0;
    private static final int OPERATION_INDEX = 0;
    private static final int NAME_INDEX = 1;
    private static final int VALUE_INDEX = 2;
    private final Map<Operation, OperationHandler> transactionMap = new HashMap<>();
    private final DataDao storageService = new DataDaoImpl();
    private List<String> input;

    public ProcessorImpl(List<String> input) {
        this.input = input;
        transactionMap.put(Operation.BALANCE, new BalanceHandler());
        transactionMap.put(Operation.SUPPLY, new SupplyHandler());
        transactionMap.put(Operation.PURCHASE, new PurchaseHandler());
        transactionMap.put(Operation.RETURN, new ReturnHandler());
    }

    @Override
    public void makeTransactions() {
        if (!input.isEmpty() && !input.get(LEGEND_INDEX).matches(CORRECT_DATA_REGEX)) {
            input.remove(LEGEND_INDEX);
        }
        for (String line: input) {
            if (!line.matches(CORRECT_DATA_REGEX)) {
                throw new ReportException("Incorrect data met at line: " + line);
            }
            String[] values = line.split(DATA_SEPARATOR);
            OperationUnit operationUnit = new OperationUnit(
                    values[NAME_INDEX],
                    Integer.valueOf(values[VALUE_INDEX]),
                    storageService.getValue(values[NAME_INDEX]));
            transactionMap
                     .get(Operation.getByLabel(values[OPERATION_INDEX]))
                     .handleOperation(operationUnit);
        }
    }
}
