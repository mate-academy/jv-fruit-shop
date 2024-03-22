package core.basesyntax;

import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.service.DataParser;
import core.basesyntax.service.FruitDataParser;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.filereader.FruitDataReaderServiceImpl;
import core.basesyntax.service.filewriter.FileWriterImpl;
import core.basesyntax.service.operations.BalanceOperationHandler;
import core.basesyntax.service.operations.OperationHandler;
import core.basesyntax.service.operations.PurchaseOperationHandler;
import core.basesyntax.service.operations.ReturnOperationHandler;
import core.basesyntax.service.operations.SupplyOperationHandler;
import core.basesyntax.service.reportgenerator.ReportGeneratorImpl;
import java.io.IOException;
import java.util.List;

public class FruitShop {
    private static final String INPUT_PATH = "src/main/input.csv";
    private static final String OUTPUT_PATH = "src/main/output.csv";

    public static void main(String[] args) throws IOException {
        BalanceOperationHandler balanceHandler = new BalanceOperationHandler();
        PurchaseOperationHandler purchaseHandler = new PurchaseOperationHandler();
        ReturnOperationHandler returnHandler = new ReturnOperationHandler();
        SupplyOperationHandler supplyHandler = new SupplyOperationHandler();
        List<OperationHandler> handlers = List.of(balanceHandler, purchaseHandler,
                returnHandler, supplyHandler);
        OperationStrategy operationStrategy = new OperationStrategy(handlers);

        DataParser<FruitTransactionDto> fruitDataParser = new FruitDataParser();
        var readerService = new FruitDataReaderServiceImpl(fruitDataParser);
        List<FruitTransactionDto> dtos = readerService.readData(INPUT_PATH);
        for (var dto : dtos) {
            operationStrategy.getHandlers(dto).forEach(oh -> oh.apply(dto));
        }

        ReportGeneratorImpl reportGenerator = new ReportGeneratorImpl();
        FileWriterImpl fileWriter = new FileWriterImpl();
        fileWriter.writeToFile(reportGenerator.getReport(), OUTPUT_PATH);
    }
}
