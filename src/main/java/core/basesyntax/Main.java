package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.TransactionDto;
import service.OperationStrategy;
import service.ParserOperation;
import service.ReaderService;
import service.WriteService;
import service.impl.OperationStrategyImpl;
import service.impl.ParserOperationImpl;
import service.impl.ReaderServiceImpl;
import service.impl.ReportServiceImpl;
import service.impl.WriteServiceImpl;
import strategy.StrategyOperation;
import strategy.impl.BalanceOperation;
import strategy.impl.PurchaseOperation;
import strategy.impl.ReturnOperation;
import strategy.impl.SupplyOperation;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    private static final String INPUT_FILE_PATH = "src\\main\\resources\\input.csv";
    private static final String OUTPUT_FILE_PATH = "src\\main\\resources\\output.csv";
    private static final Map<TransactionDto.Operation, StrategyOperation> map = new HashMap<>();

    static {
        map.put(TransactionDto.Operation.BALANCE, new BalanceOperation());
        map.put(TransactionDto.Operation.RETURN, new ReturnOperation());
        map.put(TransactionDto.Operation.SUPPLY, new SupplyOperation());
        map.put(TransactionDto.Operation.PURCHASE, new PurchaseOperation());
    }

    public static void main(String[] args) {
        OperationStrategy operationStrategy = new OperationStrategyImpl(map);
        ReaderService readerService = new ReaderServiceImpl();
        ParserOperation parserOperation = new ParserOperationImpl();
        List<String> strings = readerService.readFromFile(INPUT_FILE_PATH);
        List<TransactionDto> transactionDtoList = parserOperation.parserOperation(strings);
        for (int i = 1; i < strings.size(); i++) {
            for (TransactionDto fruits : transactionDtoList) {
                StrategyOperation strategyOperation = operationStrategy.get(fruits.getOperation());
                strategyOperation.apply(fruits);
            }
            WriteService writeService = new WriteServiceImpl();
            String report = new ReportServiceImpl().generateReport();
            writeService.writeToFile(OUTPUT_FILE_PATH, report);
        }
    }
}
