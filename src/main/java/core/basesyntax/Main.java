package core.basesyntax;

import core.basesyntax.dto.CustomWriterFile;
import core.basesyntax.dto.CustomWriterFileImp;
import core.basesyntax.imp.CustomFileReadImp;
import core.basesyntax.imp.FruitAdd;
import core.basesyntax.imp.FruitMinus;
import core.basesyntax.imp.FruitParseDtoParseImp;
import core.basesyntax.imp.FruitServiceImp;
import core.basesyntax.imp.ValidatorImp;
import core.basesyntax.model.FruitRecordDto;
import core.basesyntax.service.FruitOperation;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.Validator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_READ = "src/main/resources/InformationAboutFruit.csv";
    private static final String FILE_WRITE = "src/main/resources/Report.csv";

    public static void main(String[] args) {
        Map<String, FruitOperation> map = new HashMap<>();
        Validator validator = new ValidatorImp();
        FruitOperation add = new FruitAdd();
        map.put("s", add);
        map.put("r", add);
        map.put("b", add);
        map.put("p", new FruitMinus(validator));
        CustomFileReadImp reader = new CustomFileReadImp();
        List<String> list = reader.readFromFile(FILE_READ);
        FruitParseDtoParseImp parseImp = new FruitParseDtoParseImp();
        List<FruitRecordDto> listParse = parseImp.parse(list);
        CustomWriterFile writer = new CustomWriterFileImp();
        FruitService fruitService = new FruitServiceImp(map);
        fruitService.saveData(listParse);
        writer.writeFile(FILE_WRITE, fruitService.makeReport());
    }
}
