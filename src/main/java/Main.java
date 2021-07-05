import core.basesyntax.service.FileCsvReader;
import core.basesyntax.service.FileCsvWriter;
import core.basesyntax.service.FruitReport;
import core.basesyntax.service.Parser;
import core.basesyntax.service.ParserCsv;
import core.basesyntax.service.Reader;
import core.basesyntax.service.Validator;
import core.basesyntax.service.ValidatorCsv;
import core.basesyntax.service.Writer;
import core.basesyntax.srategy.BalanceHandler;
import core.basesyntax.srategy.OperationHandler;
import core.basesyntax.srategy.PurchaseHandler;
import core.basesyntax.srategy.ReturnHandler;
import core.basesyntax.srategy.SupplyHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String STORAGE_PATH = "src/main/resources/storage.csv";
    private static final String PATH_OUTPUT_FILE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("b", new BalanceHandler());
        operationHandlerMap.put("p", new PurchaseHandler());
        operationHandlerMap.put("s", new SupplyHandler());
        operationHandlerMap.put("r", new ReturnHandler());

        Reader reader = new FileCsvReader();
        List<String> infoFromFile = reader.readFromFile(STORAGE_PATH);

        Validator validator = new ValidatorCsv();
        Parser parser = new ParserCsv(validator);

        infoFromFile.stream()
                .map(parser::parseToFruitDto)
                .forEach(fruitDto -> operationHandlerMap
                    .get(fruitDto.getOperation())
                    .apply(fruitDto)
                );
        FruitReport report = new FruitReport();
        Writer writer = new FileCsvWriter();
        writer.writeToFile(report.getReport(), PATH_OUTPUT_FILE);
    }
}
