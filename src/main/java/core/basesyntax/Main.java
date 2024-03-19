package core.basesyntax;


import core.basesyntax.db.Storage;
import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.service.impl.FruitRawStringParserImpl;
import core.basesyntax.service.impl.FruitReportCreateImpl;
import core.basesyntax.service.interfaces.FruitFileReader;
import core.basesyntax.service.impl.FruitFileReaderImpl;
import core.basesyntax.service.interfaces.FruitReportCreate;
import core.basesyntax.service.strategy.OperationHandler;
import core.basesyntax.service.strategy.OperationStrategy;
import core.basesyntax.service.strategy.impl.BalanceOperationHandler;
import core.basesyntax.service.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.service.strategy.impl.ReturnOperationHandler;
import core.basesyntax.service.strategy.impl.SupplyOperationHandler;

import java.util.List;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    public static void main(String[] args) {
        FruitFileReader reader = new FruitFileReaderImpl();
        List<String> fileString = reader.readFile("src/main/resources/fruitts.csv");
//        System.out.println(fileString);
        FruitRawStringParserImpl parser = new FruitRawStringParserImpl();
        var readerService = parser.parsedFruitData(fileString);
//        System.out.println(readerService);
        var balance = new BalanceOperationHandler();
        var supply = new SupplyOperationHandler();
        var returns = new ReturnOperationHandler();
        var purchase = new PurchaseOperationHandler();
        List<OperationHandler> handlers = List.of(balance,returns,purchase,supply);
        OperationStrategy strategy = new OperationStrategy(handlers);
        List<FruitTransactionDto> dtos = readerService;
        for (var dto : dtos) {
            strategy.getHandlers(dto).forEach(oh -> oh.apply(dto));
        }
        System.out.println(Storage.fruitsQuantity);
        FruitReportCreate report = new FruitReportCreateImpl();
        System.out.println(report.createReport(Storage.fruitsQuantity));



//        FruitOperationProcessor processor = new FruitOperationProcessor();
//        processor.processOperations(fileString);


        /* FileFruitReader (exception no file)  return string
        Class fruit.of(name, quantity)
        Parse (string) - return HashMap <operation, fruit> : Exeption quantity< 0 invalid data
        db -> HashMap(Hashmap)
        getBalance (Hashmap.quantity) -> fruit + quantity -> return Hashmap -> db
        save to db?
        getSupply (Hashmap.quantity) - > fruit + quantity + ->  return Hashmap
        getPurchase (Hashmap.quantity) - > fruit + quantity - ->  return Hashmap
        getRefunds (Hashmap.quantity) - > fruit + quantity + ->  return Hashmap
        CalculationFruitCheck (Hashmap) - > if fruit, quantity <0 -> throw Exception
        createReport(hashmap) -> string
//        FileSaver(string)  -> File.cvs or exeption cannot save]

    } */
        // HINT: In the `public static void main(String[] args)` it is better to create instances of your classes,

    }
}
