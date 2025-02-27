package core.basesyntax;

import dao.CsvReaderImpl;
import dao.CsvWriterImpl;
import dao.CustomFileReader;
import dao.CustomFileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import model.OperationsList;
import service.DataConverter;
import service.Operation;
import service.OperationHandler;
import service.ReportCreator;
import service.impl.BalanceCalculatorImpl;
import service.impl.BalanceHandler;
import service.impl.DataFruitConverterImpl;
import service.impl.FileFormaterForCsvReader;
import service.impl.PurchaseHandler;
import service.impl.ReportGeneratorImpl;
import service.impl.ReturnHandler;
import service.impl.SupplyHandler;
import strategy.OperationStrategy;

public class Main {
    public static final String INPUT_FILE_NAME = "src/main/resources/reportToRead.csv";
    public static final String OUTPUT_FILE_NAME = "src/main/resources/reportToWrite.csv";

    public static void main(String[] args) {
        CustomFileReader fileReader = new CsvReaderImpl();
        FileFormaterForCsvReader fileFormater = new FileFormaterForCsvReader(fileReader);

        DataConverter dataConverter = new DataFruitConverterImpl();
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(
                fileFormater.parseCsv(INPUT_FILE_NAME));

        Map<OperationsList, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(OperationsList.BALANCE, new BalanceHandler());
        operationHandlers.put(OperationsList.PURCHASE, new PurchaseHandler());
        operationHandlers.put(OperationsList.RETURN, new ReturnHandler());
        operationHandlers.put(OperationsList.SUPPLY, new SupplyHandler());
        OperationStrategy operationStrategy = new OperationStrategy(operationHandlers);

        Operation operation = new BalanceCalculatorImpl(operationStrategy);
        ReportCreator reportCreator = new ReportGeneratorImpl();
        List<String[]> finalReport = reportCreator
                .createReport(operation.update(transactions));
        CustomFileWriter fileWriter = new CsvWriterImpl();
        fileWriter.writeFile(OUTPUT_FILE_NAME, finalReport);
    }
}
