package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operators.BalanceOperationHandler;
import core.basesyntax.operators.OperationHandler;
import core.basesyntax.operators.PurchaseOperationHandler;
import core.basesyntax.operators.ReturnOperationHandler;
import core.basesyntax.operators.SupplyOperationHandler;
import core.basesyntax.service.DataParser;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.impl.CsvFileReaderImpl;
import core.basesyntax.service.impl.CsvFileWriterImpl;
import core.basesyntax.service.impl.DataParserImpl;
import core.basesyntax.service.impl.FruitTransactionServiceImpl;
import core.basesyntax.service.impl.OperatorStrategyImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String inputFileName = "src/main/resources/inputFile.scv";
    private static final String reportFileName = "src/main/resources/reportFile.csv";
    private static final Map<FruitTransaction.Operation, OperationHandler> operationToHandlerMap
            = Map.of(
            FruitTransaction.Operation.BALANCE, new BalanceOperationHandler(),
            FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler(),
            FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler(),
            FruitTransaction.Operation.RETURN, new ReturnOperationHandler());

    public static void main(String[] args) {
        FileReader fileReader = new CsvFileReaderImpl();
        List<String> lines = fileReader.readFromFile(inputFileName);
        DataParser dataParser = new DataParserImpl();
        List<FruitTransaction> fruitTransactions = dataParser.parseData(lines);
        FruitTransactionService fruitTransactionService
                = new FruitTransactionServiceImpl(new OperatorStrategyImpl(operationToHandlerMap));
        fruitTransactionService.process(fruitTransactions);
        ReportCreator reportCreator = new ReportCreatorImpl();
        String report = reportCreator.createReport();
        FileWriter fileWriter = new CsvFileWriterImpl();
        fileWriter.writeToFile(report, reportFileName);
    }
}
