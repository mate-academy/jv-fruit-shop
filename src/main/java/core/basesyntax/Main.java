package core.basesyntax;

import core.basesyntax.dao.DataConverter;
import core.basesyntax.dao.FileReader;
import core.basesyntax.dao.FruitFileWriter;
import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.dao.impl.DataConverterImpl;
import core.basesyntax.dao.impl.FileReaderImpl;
import core.basesyntax.dao.impl.FileWriterImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.OperationStrategyImpl;

import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public class Main {
        public static void main(String[] arg) {
            // 1. Read the data from the input CSV file
            FileReader fileReader = new FileReaderImpl();
            List<String> inputReport = fileReader.read("reportToRead.csv");

            // 2. Convert the incoming data into FruitTransactions list
            DataConverter dataConverter = new DataConverterImpl();
            List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);

            // 3. Create and feel the map with all OperationHandler implementations
            OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

            // 4. Process the incoming transactions with applicable OperationHandler implementations
            ShopService shopService = new ShopServiceImpl(operationStrategy);
            shopService.process(transactions);

            // 5.Generate report based on the current Storage state
            ReportGenerator reportGenerator = new ReportGeneratorImpl();
            String resultingReport = reportGenerator.getReport();

            // 6. Write the received report into the destination file
            FruitFileWriter fileWriter = new FileWriterImpl();
            fileWriter.write(resultingReport, "finalReport.csv");
        }
    }
}
