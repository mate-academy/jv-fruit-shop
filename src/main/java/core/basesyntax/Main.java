package core.basesyntax;

import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.dto.FruitRecordDtoParser;
import core.basesyntax.dto.FruitRecordDtoParserImpl;
import core.basesyntax.fileservise.ReaderService;
import core.basesyntax.fileservise.ReaderServiceImpl;
import core.basesyntax.fileservise.WriteService;
import core.basesyntax.fileservise.WriteServiceImpl;
import core.basesyntax.model.FruitService;
import core.basesyntax.model.FruitServiceImpl;
import core.basesyntax.model.Operation;
import core.basesyntax.strategy.AddBalanceOperation;
import core.basesyntax.strategy.FruitOperationHandler;
import core.basesyntax.strategy.PurchaseOperation;
import core.basesyntax.strategy.ReturnOperation;
import core.basesyntax.strategy.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_PATH_FOR_READ = "src\\main\\java\\resources\\input_Date.csv";
    private static final String FILE_PATH_FOR_WRITE = "src\\main\\java\\resources\\save_Report.csv";

    public static void main(String[] args) {
        Map<Operation, FruitOperationHandler> strategyMap = new HashMap<>();
        strategyMap.put(Operation.BALANCE, new AddBalanceOperation());
        strategyMap.put(Operation.SUPPLY, new SupplyOperation());
        strategyMap.put(Operation.PURCHASE, new PurchaseOperation());
        strategyMap.put(Operation.RETURN, new ReturnOperation());

        ReaderService readerService = new ReaderServiceImpl();
        List<String> linesFromFile = readerService.read(FILE_PATH_FOR_READ);

        FruitRecordDtoParser parser = new FruitRecordDtoParserImpl();
        List<FruitRecordDto> fruitRecordDtos = parser.parse(linesFromFile);

        FruitService fruitService = new FruitServiceImpl(strategyMap);
        fruitService.save(fruitRecordDtos);

        String report = fruitService.getReport();

        WriteService writeService = new WriteServiceImpl();
        writeService.write(report, FILE_PATH_FOR_WRITE);
    }
}
