package core.basesyntax;

import core.basesyntax.converter.impl.DataConverter;
import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.impl.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.report.ReportGenerator;
import core.basesyntax.report.impl.ReportGeneratorImpl;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.impl.BalanceOperation;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.OperationStrategyImpl;
import core.basesyntax.service.impl.PurchaseOperation;
import core.basesyntax.service.impl.ReturnOperation;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.service.impl.SupplyOperation;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String PATH_TO_REPORT_READ = "src/main/resources/reportToRead.csv";
    private static final String PATH_TO_FINAL_REPORT = "src/main/resources/finalReport.csv";

    public static void main(String[] args) {
        FileReaderService fileReader = new FileReaderServiceImpl();
        List<List<String>> inputReport = fileReader.read(PATH_TO_REPORT_READ);

        FruitDao fruitDao = new FruitDaoImpl();
        DataConverter dataConverter = new DataConverter();
        final List<FruitTransaction> dataFromTransaction =
                dataConverter.convertToTransaction(inputReport);
        ShopService shopService = getShopService(fruitDao);
        shopService.process(dataFromTransaction);
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport();

        FileWriterService fileWriter = new FileWriterServiceImpl();
        fileWriter.writeIntoFile(resultingReport, PATH_TO_FINAL_REPORT);
    }

    private static ShopService getShopService(FruitDao fruitDao) {
        Map<FruitTransaction.Operation, OperationStrategy> operationHandlers =
                Map.of(FruitTransaction.Operation.BALANCE, new BalanceOperation(fruitDao),
                        FruitTransaction.Operation.PURCHASE, new PurchaseOperation(fruitDao),
                        FruitTransaction.Operation.RETURN, new ReturnOperation(fruitDao),
                        FruitTransaction.Operation.SUPPLY, new SupplyOperation(fruitDao));
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);
        return new ShopServiceImpl(operationStrategy);
    }
}
