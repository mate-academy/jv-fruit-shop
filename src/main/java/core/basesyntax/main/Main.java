package core.basesyntax.main;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.BalanceOperation;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.operation.PurchaseOperation;
import core.basesyntax.operation.ReturnOperation;
import core.basesyntax.operation.SupplyOperation;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.DataReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.ProcessService;
import core.basesyntax.service.ReportService;
import core.basesyntax.serviceimpl.DataConverterImpl;
import core.basesyntax.serviceimpl.DataReaderImpl;
import core.basesyntax.serviceimpl.FileWriterImpl;
import core.basesyntax.serviceimpl.ProcessServiceImpl;
import core.basesyntax.serviceimpl.ReportServiceImpl;
import core.basesyntax.strategy.Strategy;
import core.basesyntax.strategy.StrategyImpl;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_FROM = "src/main/resources/input.csv";
    private static final String FILE_TO = "src/main/resources/output.csv";
    private static final Map<FruitTransaction.Operation, OperationHandler> operationMap = Map.of(
            FruitTransaction.Operation.BALANCE, new BalanceOperation(),
            FruitTransaction.Operation.RETURN, new ReturnOperation(),
            FruitTransaction.Operation.PURCHASE, new PurchaseOperation(),
            FruitTransaction.Operation.SUPPLY, new SupplyOperation()
    );

    public static void main(String[] args) {
        DataReader dataReader = new DataReaderImpl();
        List<String> dataFromFile = dataReader.read(FILE_FROM);

        DataConverter dataConverter = new DataConverterImpl();
        List<FruitTransaction> transactions = dataConverter.convert(dataFromFile);

        Strategy strategy = new StrategyImpl(operationMap);

        ProcessService processService = new ProcessServiceImpl(strategy);
        processService.process(transactions);

        ReportService reportService = new ReportServiceImpl();
        String report = reportService.createReport();

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeFile(FILE_TO, report);
    }
}
