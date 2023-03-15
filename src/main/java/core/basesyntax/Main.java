package core.basesyntax;

import core.basesyntax.dao.Reader;
import core.basesyntax.dao.Writer;
import core.basesyntax.dao.impl.ReaderImpl;
import core.basesyntax.dao.impl.WriterImpl;
import core.basesyntax.db.CalculationStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataParser;
import core.basesyntax.service.FruitCalculator;
import core.basesyntax.service.ReportMaker;
import core.basesyntax.service.impl.DataParserImpl;
import core.basesyntax.service.impl.FruitCalculatorImpl;
import core.basesyntax.service.impl.ReportMakerImpl;
import java.io.File;
import java.util.List;

public class Main {
    public static final String INPUT_FILE_NAME = "input.csv";
    public static final String TO_FILE_NAME = "report.csv";

    public static void main(String[] args) {
        Reader reader = new ReaderImpl();
        Writer writer = new WriterImpl();
        FruitCalculator fruitCalculator = new FruitCalculatorImpl();
        DataParser dataParser = new DataParserImpl();
        ReportMaker reportMaker = new ReportMakerImpl();
        File file = new File(INPUT_FILE_NAME);
        List<String> dataFromFile = reader.readDataFromFile(file);
        List<FruitTransaction> parsedDataFromFile = dataParser
                .parseDataToFruitTransaction(dataFromFile);
        fruitCalculator
                .calculateTotalQuantity(parsedDataFromFile);
        String report = reportMaker.generateReport(CalculationStorage.CALCULATION_STORAGE);
        writer.writeDataToFile(report, TO_FILE_NAME);
    }
}
