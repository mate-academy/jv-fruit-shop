import core.basesyntax.service.CsvFileReader;
import core.basesyntax.service.CsvFileWriter;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FruitReportService;
import core.basesyntax.service.Parser;
import core.basesyntax.service.ParserImpl;
import core.basesyntax.service.Validator;
import core.basesyntax.service.ValidatorCsv;
import core.basesyntax.srategy.AdditionHandler;
import core.basesyntax.srategy.BalanceHandler;
import core.basesyntax.srategy.OperationHandler;
import core.basesyntax.srategy.PurchaseHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String PATH_INPUT_FILE = "src/main/resources/storage.csv";
    private static final String PATH_OUTPUT_FILE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("b", new BalanceHandler());
        operationHandlerMap.put("p", new PurchaseHandler());
        operationHandlerMap.put("s", new AdditionHandler());
        operationHandlerMap.put("r", new AdditionHandler());

        FileReader fileReader = new CsvFileReader();
        List<String> infoFromFile = fileReader.readFromFile(PATH_INPUT_FILE);

        Validator validator = new ValidatorCsv();
        Parser parser = new ParserImpl(validator);

        infoFromFile.stream()
                .map(parser::parseToFruitDto)
                .forEach(fruitDto -> operationHandlerMap
                    .get(fruitDto.getOperation())
                    .apply(fruitDto)
                );
        FruitReportService report = new FruitReportService();
        FileWriter fileWriter = new CsvFileWriter();
        fileWriter.writeToFile(report.getReport(), PATH_OUTPUT_FILE);
    }
}
