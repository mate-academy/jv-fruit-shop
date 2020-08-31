package app;

import app.model.SupplyFruitBatch;
import app.service.FileReadService;
import app.service.FileWriterService;
import app.service.Operation;
import app.service.impl.FileReadServiceImplementation;
import app.service.impl.FileWriterServiceImplementation;
import app.service.impl.FruitParserImplementation;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    private static FruitOperationStrategy fruitOperationStrategy;
    private static int OPERATION_INDEX = 0;

    public static void main(String[] args) {
        getStart();
    }

    private static void getStart() {
        fruitOperationStrategy = new FruitOperationStrategy();
        FileReadService fileReadService = new FileReadServiceImplementation();
        System.out.println("Input path to read file");
        Scanner inputPath = new Scanner(System.in);
        List<List<String>> allData = fileReadService.readFile(inputPath.nextLine());
        for (List<String> line : allData) {
            Operation operation = fruitOperationStrategy.getOperation(line.get(OPERATION_INDEX));
            SupplyFruitBatch currentBatch = new FruitParserImplementation().parse(line);
            operation.execute(currentBatch);
        }
        FileWriterService fileWriterServiceImplements = new FileWriterServiceImplementation();
        System.out.println("Input path to write data file");
        Scanner outputPath = new Scanner(System.in);
        fileWriterServiceImplements.writeData(FruitStorage.SUPPLY_FRUIT_BATCHES,
                outputPath.nextLine());
    }
}
