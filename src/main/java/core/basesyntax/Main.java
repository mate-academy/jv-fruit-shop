package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import model.Operation;
import service.DataConverter;
import service.ReaderService;
import service.ReportGenerator;
import service.ShopService;
import service.WriterService;
import service.impl.DataConverterImpl;
import service.impl.ReaderServiceImpl;
import service.impl.ReportGeneratorImpl;
import service.impl.ShopServiceImpl;
import service.impl.WriterServiceImpl;
import strategy.OperationHandler;
import strategy.OperationStrategy;
import strategy.impl.BalanceOperationImpl;
import strategy.impl.OperationStrategyImpl;
import strategy.impl.PurchaseOperationImpl;
import strategy.impl.ReturnOperationImpl;
import strategy.impl.SupplyOperationImpl;

public class Main {
    private static final String READ_FILE_PATH = "src/main/resources/ReportToRead.csv";
    private static final String WRITE_FILE_PATH = "src/main/resources/FinalReport.csv";

    public static void main(String[] args) {
        ReaderService fileReader = new ReaderServiceImpl();
        List<String> inputReport = fileReader.read(READ_FILE_PATH);

        Map<Operation, OperationHandler> operationHandlers = Map.of(
                Operation.BALANCE, new BalanceOperationImpl(),
                Operation.PURCHASE, new PurchaseOperationImpl(),
                Operation.RETURN, new ReturnOperationImpl(),
                Operation.SUPPLY, new SupplyOperationImpl()
        );
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        DataConverter dataConverter = new DataConverterImpl();
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);

        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String finalReport = reportGenerator.getReport();

        WriterService fileWriter = new WriterServiceImpl();
        fileWriter.write(finalReport, WRITE_FILE_PATH);
    }
}
