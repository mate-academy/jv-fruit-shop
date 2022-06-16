package core.basesyntax;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.FileReading;
import core.basesyntax.service.FileWriting;
import core.basesyntax.service.FruitBuilder;
import core.basesyntax.service.OperationSupplier;
import core.basesyntax.service.Report;
import core.basesyntax.service.impl.FileReadingImpl;
import core.basesyntax.service.impl.FileWritingImpl;
import core.basesyntax.service.impl.FruitBuilderImpl;
import core.basesyntax.service.impl.OperationSupplierImpl;
import core.basesyntax.service.impl.ReportImpl;
import java.util.List;

public class Main {
    private static final String PATH_OF_INPUT_FILE = "src/main/resources/input.csv";
    private static final String PATH_OF_REPORT_FILE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        FileReading fileReading = new FileReadingImpl();
        List<String> readFromFile = fileReading.readFromFile(PATH_OF_INPUT_FILE);

        FruitBuilder fruitBuilder = new FruitBuilderImpl();
        List<Fruit> fruitList = fruitBuilder.buildFruit(readFromFile);

        OperationSupplier operationSupplier = new OperationSupplierImpl();
        fruitList.forEach(fruit -> operationSupplier.getOperation(fruit).operate(fruit));

        Report report = new ReportImpl();
        String resultReport = report.getReport();

        FileWriting writing = new FileWritingImpl();
        writing.writeToFile(PATH_OF_REPORT_FILE, resultReport);
    }
}

