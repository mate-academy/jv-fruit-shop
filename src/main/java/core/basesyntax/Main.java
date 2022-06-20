package core.basesyntax;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FruitBuilder;
import core.basesyntax.service.OperationSupplier;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.FruitBuilderImpl;
import core.basesyntax.service.impl.OperationSupplierImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import java.util.List;

public class Main {
    private static final String PATH_OF_INPUT_FILE = "src/main/resources/input.csv";
    private static final String PATH_OF_REPORT_FILE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        FileReader fileReader = new FileReaderImpl();
        List<String> readFromFile = fileReader.readFromFile(PATH_OF_INPUT_FILE);

        FruitBuilder fruitBuilder = new FruitBuilderImpl();
        List<Fruit> fruitList = fruitBuilder.buildFruit(readFromFile);

        OperationSupplier operationSupplier = new OperationSupplierImpl();
        fruitList.forEach(fruit -> operationSupplier.getOperation(fruit).operate(fruit));

        ReportCreator report = new ReportCreatorImpl();
        String resultReport = report.getReport();

        FileWriter writing = new FileWriterImpl();
        writing.writeToFile(PATH_OF_REPORT_FILE, resultReport);
    }
}

