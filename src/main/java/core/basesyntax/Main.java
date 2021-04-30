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
    private static final String INPUT_FILE_DIRECTION = "src/main/resources/InputFile";
    private static final String OUTPUT_FILE_DIRECTION = "src/main/resources/OutputFile";

    public static void main(String[] args) {
        ReaderService readerService = new ReaderServiceImpl();
        List<String> dataFromInputFile = readerService.read(INPUT_FILE_DIRECTION);

        DataParserService dataParserService = new DataParserServiceImpl();
        List<FruitDataDto> fruitDataDtoList = dataParserService
                .parseDataFromInputFile(dataFromInputFile);

        Map<Operations, Operation> choseOperation = new HashMap<>();
        choseOperation.put(Operations.BALANCE, new AddOperation());
        choseOperation.put(Operations.PURCHASE, new SubtractOperation());
        choseOperation.put(Operations.RETURN, new AddOperation());
        choseOperation.put(Operations.SUPPLY, new AddOperation());

        FruitService fruitService = new FruitServiceImpl(choseOperation);
        fruitService.applyOperationsOnFruitsDto(fruitDataDtoList);
        String reportFromDB = fruitService.generateReport();

        WriterService writerService = new WriterServiceImpl();
        writerService.write(OUTPUT_FILE_DIRECTION, reportFromDB);
    }
}
