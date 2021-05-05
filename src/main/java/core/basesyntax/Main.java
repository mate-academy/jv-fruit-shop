package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.service.fileservice.FileService;
import core.basesyntax.service.fileservice.FileServiceImplForCsv;
import core.basesyntax.service.fruitservice.FruitService;
import core.basesyntax.service.fruitservice.FruitServiceImpl;
import core.basesyntax.service.parser.FruitRecordDtoParser;
import core.basesyntax.service.parser.FruitRecordDtoParserImpl;
import java.util.List;

public class Main {
    private static final String fromFile = "src/main/resources/shop_instructions.csv";
    private static final String toFile = "src/main/resources/report.csv";

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();
        FileService fileService = new FileServiceImplForCsv();
        FruitRecordDtoParser parser = new FruitRecordDtoParserImpl();
        FruitService fruitService = new FruitServiceImpl(fruitDao);

        List<FruitRecordDto> dtos = parser.parse(fileService.readAllLinesFromFile(fromFile));
        fruitService.saveData(dtos);
        fileService.write(fruitService.createReport(), toFile);
    }
}
