package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.WriterFile;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.WriterFileImpl;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.impl.BalanceOperationHandler;
import core.basesyntax.service.operation.impl.PurchaseOperationHandler;
import core.basesyntax.service.operation.impl.ReturnOperationHandler;
import core.basesyntax.service.operation.impl.SupplyOperationHandler;
import core.basesyntax.strategy.OperationStategy;
import core.basesyntax.strategy.impl.OperationStategyImpl;
import java.io.File;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    private static final String FILE_PATH = "src/main/resources/file.csv";

    public static void main(String[] args) {
        Storage storage = new Storage();
        FruitService fruitService = new FruitServiceImpl(storage);
        BalanceOperationHandler balanceOperationHandler =
                new BalanceOperationHandler(storage,fruitService);
        PurchaseOperationHandler purchaseOperationHandler =
                new PurchaseOperationHandler(storage,fruitService);
        ReturnOperationHandler returnOperationHandler =
                new ReturnOperationHandler(storage,fruitService);
        SupplyOperationHandler supplyOperationHandler =
                new SupplyOperationHandler(storage,fruitService);
        List<OperationHandler> handlers =
                List.of(balanceOperationHandler,purchaseOperationHandler,
                        returnOperationHandler,supplyOperationHandler);
        OperationStategy operationStategy = new OperationStategyImpl(handlers);

        FileReaderImpl fileReader = new FileReaderImpl();
        List<FruitTransactionDto> dtos = fileReader.readFile(FILE_PATH);
        for (var dto : dtos) {
            operationStategy.get(dto).forEach(oh -> oh.apply(dto));
        }
        ReportGenerator reportGenerator = new ReportGeneratorImpl(storage);
        List<String> report = reportGenerator.generate();
        File outputFile = Paths.get("src/main/resources/report.csv").toFile();
        WriterFile writerFile = new WriterFileImpl();
        writerFile.writeFile(report,outputFile);
    }
}
