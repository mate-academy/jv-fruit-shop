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
    private static final String FILE_PATH_FOR_READ = "src\\main\\shopExample.csv";
    private static final String FILE_PATH_FOR_WRITE = "src\\main\\save_Report.csv";

    public static void main(String[] args) {
        // мапа зі стратегіями
        Map<Operation, FruitOperationHandler> strategyMap = new HashMap<>();
        strategyMap.put(Operation.BALANCE, new AddBalanceOperation());
        strategyMap.put(Operation.SUPPLY, new SupplyOperation());
        strategyMap.put(Operation.PURCHASE, new PurchaseOperation());
        strategyMap.put(Operation.RETURN, new ReturnOperation());

        //зчитуємо файл
        ReaderService readerService = new ReaderServiceImpl();
        List<String> linesFromFile = readerService.read(FILE_PATH_FOR_READ);

        // розпарсимо файл
        FruitRecordDtoParser parser = new FruitRecordDtoParserImpl();
        List<FruitRecordDto> fruitRecordDtos = parser.parse(linesFromFile);

        // викликаємо фрутсервіс і заносимо всі дані у базу(storage.fruits)
        FruitService fruitService = new FruitServiceImpl();
        fruitService.save(fruitRecordDtos, strategyMap);

        // створили стрінгу з report
        String report = fruitService.getReport();

        // створимо файл з report
        WriteService writeService = new WriteServiceImpl();
        writeService.write(report, FILE_PATH_FOR_WRITE);
    }
}
