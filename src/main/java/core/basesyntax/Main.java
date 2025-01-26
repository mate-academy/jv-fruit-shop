package core.basesyntax;

import core.basesyntax.Converter.DataConverter;
import core.basesyntax.Converter.DataConverterImpl;
import core.basesyntax.IO.FileReader;
import core.basesyntax.IO.FileReaderImpl;
import core.basesyntax.IO.FileWriter;
import core.basesyntax.IO.FileWriterImpl;
import core.basesyntax.Model.FruitTransaction;
import core.basesyntax.Operation.*;
import core.basesyntax.Service.ShopService;
import core.basesyntax.Service.ShopServiceImpl;
import result.ReportGenerator;
import result.ReportGeneratorImpl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReaderImpl();
            DataConverter dataConverter = new DataConverterImpl();

            Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
            operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
            operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
            operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
            operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());

            OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);
            ShopService shopService = new ShopServiceImpl(operationStrategy);
            ReportGenerator reportGenerator = new ReportGeneratorImpl();
            FileWriter fileWriter = new FileWriterImpl();

            List<String> inputLines = fileReader.read("C:/Users/WeakRitta/IdeaProjects"
                    + "/jv-fruit-shop/src/main/java/result/reportToRead.csv");
            List<FruitTransaction> transactions = dataConverter.convertToTransactions(inputLines);
            Map<String, Integer> finalStorage = shopService.process(transactions);
            String report = reportGenerator.generateReport(finalStorage);
            fileWriter.write(report, "C:/Users/WeakRitta/IdeaProjects/jv-fruit-shop/src"
                    + "/main/java/result/finalReport.csv");

        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid input data: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.err.println("Processing error: " + e.getMessage());
        }
    }
}
