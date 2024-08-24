package core.basesyntax;

import core.basesyntax.db.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.ReportFileWriter;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.impl.DataConverterImpl;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.strategy.BalanceOperation;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.PurchaseOperation;
import core.basesyntax.strategy.ReturnOperation;
import core.basesyntax.strategy.SupplyOperation;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String REPORT_TO_READ_CSV = "src/main/resources/reportToRead.csv";
    private static final String FINAL_REPORT_CSV = "src/main/resources/finalReport.csv";

    public static void main(String[] arg) {
        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read(REPORT_TO_READ_CSV);
        DataConverter dataConverter = new DataConverterImpl();

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = Map.of(
                FruitTransaction.Operation.BALANCE, new BalanceOperation(),
                FruitTransaction.Operation.PURCHASE, new PurchaseOperation(),
                FruitTransaction.Operation.RETURN, new ReturnOperation(),
                FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);
        ShopServiceImpl shopService = new ShopServiceImpl(operationStrategy, new FruitDaoImpl());
        shopService.proceedAll(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl<>(shopService.getFruitMap());
        String resultingReport = reportGenerator.getReport();

        ReportFileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(resultingReport, FINAL_REPORT_CSV);
    }
}
