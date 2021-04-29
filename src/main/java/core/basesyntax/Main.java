package core.basesyntax;

import core.basesyntax.model.dto.FruitDataDto;
import core.basesyntax.service.DataParserService;
import core.basesyntax.service.OperationService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.DataParserServiceImpl;
import core.basesyntax.service.impl.OperationServiceBalanceImpl;
import core.basesyntax.service.impl.OperationServicePurchaseImpl;
import core.basesyntax.service.impl.OperationServiceReturnImpl;
import core.basesyntax.service.impl.OperationServiceSupplyImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_DIRECTION = "src/main/resources/InputFile";
    private static final String OUTPUT_FILE_DIRECTION = "src/main/resources/OutputFile";

    public static void main(String[] args) {
        Map<FruitDataDto.Operations, OperationService> operationsStrategy = new HashMap<>();
        operationsStrategy.put(FruitDataDto.Operations.b,
                new OperationServiceBalanceImpl());
        operationsStrategy.put(FruitDataDto.Operations.s,
                new OperationServiceSupplyImpl());
        operationsStrategy.put(FruitDataDto.Operations.p,
                new OperationServicePurchaseImpl());
        operationsStrategy.put(FruitDataDto.Operations.r,
                new OperationServiceReturnImpl());

        ReaderService readerService = new ReaderServiceImpl();
        DataParserService dataParserService = new DataParserServiceImpl();
        List<FruitDataDto> fruitDataDtoList = dataParserService
                .parseDataFromInputFile(readerService.readDataFromInputFile(INPUT_FILE_DIRECTION));

        for (FruitDataDto fruitDataDto : fruitDataDtoList) {
            operationsStrategy.get(fruitDataDto.getOperationType()).doOperation(fruitDataDto);
        }

        ReportService reportService = new ReportServiceImpl();
        WriterService writerService = new WriterServiceImpl();
        writerService.createReportFromData(OUTPUT_FILE_DIRECTION,
                reportService.getReportDataFromDB());
    }

}
