package core.basesyntax;

import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.WriteService;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.TransactionParserImpl;
import core.basesyntax.service.impl.WriteServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.handler.OperationHandler;
import core.basesyntax.strategy.handler.impl.BalanceOperationHandler;
import core.basesyntax.strategy.handler.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.handler.impl.ReturnOperationHandler;
import core.basesyntax.strategy.handler.impl.SupplyOperationHandler;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/output.csv";
    private static final Map<TransactionDto.Operation, OperationHandler> map = Map.of(
            TransactionDto.Operation.BALANCE, new BalanceOperationHandler(),
            TransactionDto.Operation.RETURN, new ReturnOperationHandler(),
            TransactionDto.Operation.SUPPLY, new SupplyOperationHandler(),
            TransactionDto.Operation.PURCHASE, new PurchaseOperationHandler()
    );
    private static final OperationStrategy operationStrategy = new OperationStrategyImpl(map);
    private static final ReaderService readerService = new ReaderServiceImpl();
    private static final TransactionParser parserOperation = new TransactionParserImpl();

    public static void main(String[] args) {
        List<String> strings = readerService.readFromFile(INPUT_FILE_PATH);
        List<TransactionDto> transactionDtoList = parserOperation
                .parserTransactionOperation(strings);
        for (TransactionDto fruits : transactionDtoList) {
            OperationHandler strategyOperation = operationStrategy.get(fruits.getOperation());
            strategyOperation.apply(fruits);

        }
        WriteService writeService = new WriteServiceImpl();
        String report = new ReportServiceImpl().generateReport();
        writeService.writeToFile(OUTPUT_FILE_PATH, report);
    }
}
