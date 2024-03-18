package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.FruitTransaction.Operation;
import core.basesyntax.readandwriteimpl.CsvReaderImpl;
import core.basesyntax.readandwriteimpl.CsvWriterImpl;
import core.basesyntax.service.FruitTransactionParser;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.serviseimpl.BalanceSupplyReturnStrategy;
import core.basesyntax.serviseimpl.DataProcessorImpl;
import core.basesyntax.serviseimpl.PurchaseStrategy;
import core.basesyntax.serviseimpl.ReportGeneratorImpl;
import java.util.List;
import java.util.Map;

public class HelloWorld {
    public static void main(String[] args) {
        CsvReaderImpl csvReader = new CsvReaderImpl();
        List<String> lines = csvReader.readDataFromDataBase();

        FruitTransactionParser parser = new FruitTransactionParser();
        List<FruitTransaction> transactions = parser.parse(lines);

        Map<Operation, OperationStrategy> operationStrategies = Map.of(
                Operation.BALANCE, new BalanceSupplyReturnStrategy(),
                Operation.SUPPLY, new BalanceSupplyReturnStrategy(),
                Operation.RETURN, new BalanceSupplyReturnStrategy(),
                Operation.PURCHASE, new PurchaseStrategy());

        DataProcessorImpl dataProcessor = new DataProcessorImpl(operationStrategies);
        Map<String, Integer> fruitStore = dataProcessor.processTransactions(transactions);

        ReportGeneratorImpl reportGenerator = new ReportGeneratorImpl();
        List<String> report = reportGenerator.generateReport(fruitStore);

        CsvWriterImpl csvWriter = new CsvWriterImpl();
        csvWriter.writeReportToFile(report, "src/main/resources/output_file.csv");
    }
}
