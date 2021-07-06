package core.basesyntax;

import core.basesyntax.dto.FruitDto;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FruitReportService;
import core.basesyntax.service.Parser;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.FruitReportServiceImpl;
import core.basesyntax.service.impl.ParserImpl;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String PATH_TO_INPUT_DATA = "src/main/resources/shop.csv";
    private static final String PATH_TO_OUTPUT_FILE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<String, OperationHandler> handlerOperations = new HashMap<>();
        handlerOperations.put("b", new BalanceOperationHandler());
        handlerOperations.put("p", new PurchaseOperationHandler());
        handlerOperations.put("s", new SupplyOperationHandler());
        handlerOperations.put("r", new SupplyOperationHandler());

        FileReader reader = new FileReaderImpl();
        List<String> infoFromFile = reader.readFromFile(PATH_TO_INPUT_DATA);

        Parser parser = new ParserImpl();
        List<FruitDto> allFruitDto = parser.parseLines(infoFromFile);
        for (FruitDto fruitDto : allFruitDto) {
            OperationHandler handler = handlerOperations.get(fruitDto.getOperation());
            handler.apply(fruitDto);
        }

        FruitReportService report = new FruitReportServiceImpl();
        FileWriter writer = new FileWriterImpl();
        writer.writeToFile(PATH_TO_OUTPUT_FILE, report.getReport());
    }
}
