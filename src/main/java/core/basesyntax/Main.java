package core.basesyntax;

import core.basesyntax.infratructure.persistence.FruitRepository;
import core.basesyntax.infratructure.persistence.FruitRepositoryImpl;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.FruitServiceImpl;
import core.basesyntax.service.usecases.FruitUseService;

import java.util.HashMap;

public class Main {
    public static void main(String[] arg) {
        // 1. Read the data from the input CSV file


        // 2. Convert the incoming data into FruitTransactions list
        FruitRepository fruitRepository = new FruitRepositoryImpl(new HashMap<>());

        // 3. Create and feel the map with all OperationHandler implementations
        FruitService fruitService = new FruitServiceImpl(fruitRepository);

        // 4. Process the incoming transactions with applicable OperationHandler implementations

        shopService.process(transactions);

        // 5.Generate report based on the current Storage state
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport();

        // 6. Write the received report into the destination file
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(resultingReport, "finalReport.csv");
    }
}
