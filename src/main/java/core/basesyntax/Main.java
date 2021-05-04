package core.basesyntax;

import core.basesyntax.model.dto.FruitDataDto;
import core.basesyntax.operations.AddOperation;
import core.basesyntax.operations.Operation;
import core.basesyntax.operations.Operations;
import core.basesyntax.operations.SubtractOperation;
import core.basesyntax.service.DataParserService;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.DataParserServiceImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_DIRECTION = "src/main/resources/InputFile.csv";
    private static final String OUTPUT_FILE_DIRECTION = "src/main/resources/OutputFile.csv";

    public static void main(String[] args) {
        Map<Operations, Operation> chooseOperation = new HashMap<>();
        chooseOperation.put(Operations.BALANCE, new AddOperation());
        chooseOperation.put(Operations.PURCHASE, new SubtractOperation());
        chooseOperation.put(Operations.RETURN, new AddOperation());
        chooseOperation.put(Operations.SUPPLY, new AddOperation());

        ReaderService readerService = new ReaderServiceImpl();
        List<String> dataFromInputFile = readerService.read(INPUT_FILE_DIRECTION);

        DataParserService dataParserService = new DataParserServiceImpl();
        List<FruitDataDto> fruitDataDtoList = dataParserService
                .parseDataFromInputFile(dataFromInputFile);

        FruitService fruitService = new FruitServiceImpl(chooseOperation);
        fruitService.applyOperationsOnFruitsDto(fruitDataDtoList);
        String reportFromDB = fruitService.generateReport();

        WriterService writerService = new WriterServiceImpl();
        writerService.write(OUTPUT_FILE_DIRECTION, reportFromDB);
    }
}
