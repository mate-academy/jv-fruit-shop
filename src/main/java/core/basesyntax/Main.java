package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.strategy.impl.BalanceOperation;
import core.basesyntax.strategy.impl.SupplyOperation;
import core.basesyntax.strategy.impl.PurchaseOperation;
import core.basesyntax.strategy.impl.ReturnOperation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileReaderImpl czytnikPliku = new FileReaderImpl();
        List<String> linie = czytnikPliku.read("src/main/resources/input.csv");
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
        HashMap<FruitTransaction.Operation, OperationHandler> obslugiwaczeOperacji = new HashMap<>();
        obslugiwaczeOperacji.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        obslugiwaczeOperacji.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        obslugiwaczeOperacji.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        obslugiwaczeOperacji.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        ShopServiceImpl serwisSklepu = new ShopServiceImpl(obslugiwaczeOperacji);
        serwisSklepu.process(transakcje);
        ReportGeneratorImpl generatorRaportu = new ReportGeneratorImpl();
        List<String> raport = Collections.singletonList(generatorRaportu.getReport(serwisSklepu.getStorage()));
        FileWriterImpl pisarzPliku = new FileWriterImpl();
        pisarzPliku.write(String.valueOf(raport), "src/main/resources/finalReport.csv");
    }
}
