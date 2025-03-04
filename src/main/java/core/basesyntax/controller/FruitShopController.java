package core.basesyntax.controller;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.BalanceOperation;
import core.basesyntax.strategy.impl.PurchaseOperation;
import core.basesyntax.strategy.impl.ReturnOperation;
import core.basesyntax.strategy.impl.SupplyOperation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitShopController {
    public void run() {
        FileReader fileReader = new FileReaderImpl();
        List<String> linie = fileReader.read("src/main/resources/input.csv");
        List<FruitTransaction> transakcje = parseTransactions(linie);
        Map<FruitTransaction.Operation, OperationHandler> obslugiwacze = initOperationHandlers();
        ShopService shopService = new ShopServiceImpl(obslugiwacze);
        shopService.process(transakcje);
        ReportGenerator generator = new ReportGeneratorImpl();
        List<String> raport = generator.getReport(shopService.getStorage());
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(raport, "src/main/resources/finalReport.csv");
    }

    private List<FruitTransaction> parseTransactions(List<String> linie) {
        List<FruitTransaction> transakcje = new ArrayList<>();
        for (String linia : linie) {
            String[] czesci = linia.split(",");
            FruitTransaction transakcja = new FruitTransaction(
                    FruitTransaction.Operation.valueOf(czesci[0].toUpperCase()),
                    czesci[1],
                    Integer.parseInt(czesci[2])
            );
            transakcje.add(transakcja);
        }
        return transakcje;
    }

    private Map<FruitTransaction.Operation, OperationHandler> initOperationHandlers() {
        Map<FruitTransaction.Operation, OperationHandler> obslugiwacze = new HashMap<>();
        obslugiwacze.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        obslugiwacze.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        obslugiwacze.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        obslugiwacze.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        return obslugiwacze;
    }
}
