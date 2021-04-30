package core.basesyntax;

import core.basesyntax.FileServise.ReaderService;
import core.basesyntax.FileServise.ReaderServiceImpl;
import core.basesyntax.FileServise.WriteService;
import core.basesyntax.FileServise.WriteServiceImpl;
import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.dto.FruitRecordDtoParser;
import core.basesyntax.dto.FruitRecordDtoParserImpl;
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
    public static void main(String[] args) {
        //зчитуємо файл
        ReaderService readerService = new ReaderServiceImpl();
        List<String> linesFromFile = readerService.readFromFile("src\\main\\shopExample.csv");

        // розпарсимо файл
        FruitRecordDtoParser parser = new FruitRecordDtoParserImpl();
        List<FruitRecordDto> fruitRecordDtos = parser.parse(linesFromFile);

        // мапа зі стратегіями
        Map<Operation, FruitOperationHandler> operationStrategyMap = new HashMap<>(); // мапа з операціями(енам)
        operationStrategyMap.put(Operation.BALANCE, new AddBalanceOperation());
        operationStrategyMap.put(Operation.SUPPLY, new SupplyOperation());
        operationStrategyMap.put(Operation.PURCHASE, new PurchaseOperation());
        operationStrategyMap.put(Operation.RETURN, new ReturnOperation());

        // викликаємо фрутсервіс і заносимо всі дані у базу(storage.fruits)
        FruitService fruitService = new FruitServiceImpl();
        fruitService.save(fruitRecordDtos, operationStrategyMap);
        // створили стрінгу з report
        String report = fruitService.getReport();
        // створимо файл з report
        WriteService writeService = new WriteServiceImpl();
        writeService.write(report, "src\\main\\save_Report.csv");

    }
}
