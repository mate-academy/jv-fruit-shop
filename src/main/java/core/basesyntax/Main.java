package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Storage;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.impl.DataConverterImpl;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.OperationStrategyImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.service.strategy.BalanceOperation;
import core.basesyntax.service.strategy.PurchaseOperation;
import core.basesyntax.service.strategy.ReturnOperation;
import core.basesyntax.service.strategy.SupplyOperation;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] arg) throws IOException {

        Storage storage = new Storage();
        // 1. Czytanie danych z pliku CSV
        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read("src/main/resources/reportToRead.csv");

        // 2. Konwersja linii tekstu na obiekty FruitTransaction
        DataConverter dataConverter = new DataConverterImpl();

        // 3. Tworzenie mapy z handlerami dla każdej operacji
        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation(storage));
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation(storage));
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation(storage));
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation(storage));
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        // 4. Przetwarzanie transakcji — aktualizacja magazynu
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        // 5. Generowanie raportu ze stanu magazynu
        ReportGenerator reportGenerator = new ReportGeneratorImpl(storage);
        String resultingReport = reportGenerator.getReport();

        // 6. Zapis raportu do pliku CSV
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(resultingReport, "finalReport.csv");
    }
}
