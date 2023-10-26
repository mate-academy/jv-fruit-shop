package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.CreateReportService;
import core.basesyntax.service.DataConvertService;
import core.basesyntax.service.DataProcessService;
import core.basesyntax.service.ReadFromCsvFileService;
import core.basesyntax.service.WriteToCsvFileService;
import core.basesyntax.service.impl.CreateReportServiceImpl;
import core.basesyntax.service.impl.DataConvertServiceImpl;
import core.basesyntax.service.impl.DataProcessServiceImpl;
import core.basesyntax.service.impl.ReadFromCsvFileServiceImpl;
import core.basesyntax.service.impl.WriteToCsvFileServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.BalanceOperationHandlerImpl;
import core.basesyntax.strategy.impl.PurchaseOperationHandlerImpl;
import core.basesyntax.strategy.impl.ReturnOperationHandlerImpl;
import core.basesyntax.strategy.impl.SupplyOperationHandlerImpl;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String THIRD_TEST_CSV = "fruits3.csv";
    private static final String REPORT_FILENAME = "report.csv";
    private static final Map<Operation, OperationHandler> operationPicker =
            Map.of(Operation.BALANCE, new BalanceOperationHandlerImpl(),
            Operation.PURCHASE, new PurchaseOperationHandlerImpl(),
            Operation.RETURN, new ReturnOperationHandlerImpl(),
            Operation.SUPPLY, new SupplyOperationHandlerImpl());

    public static void main(String[] args) {
        ReadFromCsvFileService reader = new ReadFromCsvFileServiceImpl();
        DataConvertService convertor = new DataConvertServiceImpl();
        DataProcessService processor = new DataProcessServiceImpl(operationPicker);
        CreateReportService reportCreator = new CreateReportServiceImpl();
        WriteToCsvFileService writer = new WriteToCsvFileServiceImpl(REPORT_FILENAME);

        List<FruitTransaction> convertedFruitsFromFile =
                convertor.convert(reader.readFile(THIRD_TEST_CSV));

        processor.processFruits(convertedFruitsFromFile);

        writer.write(reportCreator.createReport());
    }
}
