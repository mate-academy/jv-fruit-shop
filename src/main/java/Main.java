import core.basesyntax.dto.FruitDto;
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
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    private static final String STORAGE_PATH = "src/main/resources/storage.csv";
    private static final String PATH_OUTPUT_FILE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<String, OperationHandler> handlerOperations = new HashMap<>();
        handlerOperations.put("b", new BalanceHandler());
        handlerOperations.put("p", new PurchaseHandler());
        handlerOperations.put("s", new SupplyHandler());
        handlerOperations.put("r", new ReturnHandler());

        Reader reader = new FileCsvReader();
        List<String> infoFromFile = reader.read(STORAGE_PATH);

        Validator validator = new ValidatorCsv();
        Parser parser = new ParserCsv(validator);
        List<FruitDto> fruitDtos = infoFromFile.stream()
                .map(parser::parse)
                .collect(Collectors.toList());
        OperationHandler handler;
        for (FruitDto fruitDto : fruitDtos) {
            handler = handlerOperations.get(fruitDto.getOperation());
            handler.apply(fruitDto);
        }
        FruitReport report = new FruitReport();
        Writer writer = new FileCsvWriter();
        writer.write(report.getReport(), PATH_OUTPUT_FILE);
    }
}
