package core.basesyntax;

import core.basesyntax.model.dto.FruitDataDto;
import core.basesyntax.service.DataParserService;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.DataParserServiceImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import java.util.List;

public class Main {
    private static final String INPUT_FILE_DIRECTION = "src/main/resources/InputFile";
    private static final String OUTPUT_FILE_DIRECTION = "src/main/resources/OutputFile";

    public static void main(String[] args) {
        ReaderService readerService = new ReaderServiceImpl();
        List<String> dataFromInputFile = readerService.readDataFromInputFile(INPUT_FILE_DIRECTION);

        DataParserService dataParserService = new DataParserServiceImpl();
        List<FruitDataDto> fruitDataDtoList = dataParserService
                .parseDataFromInputFile(dataFromInputFile);

        FruitService fruitService = new FruitServiceImpl();
        fruitService.applyCorrectOperationImpl(fruitDataDtoList);
        String reportFromDB = fruitService.getReportFromDB();

        WriterService writerService = new WriterServiceImpl();
        writerService.write(OUTPUT_FILE_DIRECTION, reportFromDB);
    }
}
