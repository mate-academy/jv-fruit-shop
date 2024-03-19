package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvFileReaderService;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReportBuilder;
import core.basesyntax.service.ReportFileWriter;
import core.basesyntax.service.TransactionManager;
import core.basesyntax.service.impl.CsvFileReaderServiceImpl;
import core.basesyntax.service.impl.CsvFileWriter;
import core.basesyntax.service.impl.ReportBuilderImpl;
import core.basesyntax.service.impl.StringParseService;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.ReturningOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String input_in_norm = "src/main/resources/input.csv";
        String output_to_norm = "src/main/resources/output.csv";
        // operation handlers
        OperationHandler balance = new BalanceOperationHandler();
        OperationHandler supply = new SupplyOperationHandler();
        OperationHandler purchase = new PurchaseOperationHandler();
        OperationHandler returning = new ReturningOperationHandler();
        List<OperationHandler> operationList = List.of(balance, supply, purchase, returning);
        // reader
        CsvFileReaderService csvFileReaderService = new CsvFileReaderServiceImpl();
        List<String> lineList = csvFileReaderService.readFromFile(input_in_norm);
        // parser
        ParserService<String> parserService = new StringParseService();
        List<FruitTransaction> transactionsList = parserService.parse(lineList);
        // transaction manager
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationList);
        TransactionManager transactionManager = new TransactionManager(operationStrategy);
        transactionManager.process(transactionsList);
        // create report
        ReportBuilder reportBuilder = new ReportBuilderImpl();
        String report = reportBuilder.create(Storage.dataBase);
        // write to file
        ReportFileWriter reportFileWriter = new CsvFileWriter();
        reportFileWriter.write(report, output_to_norm);

    }
}
