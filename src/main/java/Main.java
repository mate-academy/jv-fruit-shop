import core.basesyntax.model.FruitService;
import core.basesyntax.model.FruitServiceImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.WriteReportToFile;
import core.basesyntax.service.impl.WriteReportToFileImpl;
import core.basesyntax.service.strategy.OperationStrategy;
import java.io.IOException;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String inputFileName = "src/main/resources/input_file.csv";
        String outputFileName = "src/main/resources/output_file.csv";
        Map<String, OperationStrategy> operationStrategies
                = FruitTransaction.createOperationStrategies();
        FruitService fruitService = new FruitServiceImpl(operationStrategies);
        WriteReportToFile writeReportToFile = new WriteReportToFileImpl();

        try {
            Map<String, Integer> fruitReport = fruitService.processFruitTransactions(inputFileName);
            writeReportToFile.writeReportToFile(fruitReport, outputFileName);
            System.out.println("Report generated successfully");
        } catch (IOException e) {
            throw new RuntimeException("An error occured");
        }
    }
}
