package core.basesyntax;

import core.basesyntax.impl.BalanceHandlerImpl;
import core.basesyntax.impl.PurchaseHandlerImpl;
import core.basesyntax.impl.ReturnHandlerImpl;
import core.basesyntax.impl.SupplyHandlerImpl;
import impl.DataConverterImpl;
import impl.DataProcessorImpl;
import impl.ReaderFromFileImpl;
import impl.ReportCreatorImpl;
import impl.WriterToFileImpl;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import model.Operation;
import service.DataConverter;
import service.DataProcessor;
import service.ReaderFromFile;
import service.ReportCreator;
import service.WriterToFile;
import strategy.OperationStrategy;

public class Main {
    private static final String FILE_NAME = "src/main/resources/During the day.csv";
    private static final String REPORT_FILE_NAME = "src/main/resources/Report file.csv";

    public static void main(String[] args) {
        ReaderFromFile readerFromFile = new ReaderFromFileImpl();
        List<String> dataFromFile = readerFromFile.read(FILE_NAME);

        DataConverter dataConverter = new DataConverterImpl();
        List<FruitTransaction> fruitTransactions = dataConverter.parseData(dataFromFile);

        OperationStrategy operationStrategy = new OperationStrategy(Map.of(
                Operation.BALANCE, new BalanceHandlerImpl(),
                Operation.SUPPLY, new SupplyHandlerImpl(),
                Operation.PURCHASE, new PurchaseHandlerImpl(),
                Operation.RETURN, new ReturnHandlerImpl()));

        DataProcessor dataProcessor = new DataProcessorImpl(operationStrategy);
        dataProcessor.process(fruitTransactions);

        ReportCreator reportCreator = new ReportCreatorImpl();
        String report = reportCreator.createReport();

        WriterToFile writerToFile = new WriterToFileImpl();
        writerToFile.writeReportToFile(report, REPORT_FILE_NAME);
    }
}
