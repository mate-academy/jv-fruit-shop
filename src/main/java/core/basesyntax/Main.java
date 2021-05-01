package core.basesyntax;

import core.basesyntax.Dto.CustomWriterFileImp;
import core.basesyntax.Imp.CustomFileReadImp;
import core.basesyntax.Imp.FruitAdd;
import core.basesyntax.Imp.FruitMinus;
import core.basesyntax.Imp.FruitParseDtoParseImp;
import core.basesyntax.Model.FruitRecordDto;
import core.basesyntax.Service.FruitOperation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, FruitOperation> map = new HashMap<>();
        map.put("s", new FruitAdd());
        map.put("r", new FruitAdd());
        map.put("b", new FruitAdd());
        map.put("p", new FruitMinus());
        CustomFileReadImp reader = new CustomFileReadImp();
        List<String> list = reader.readFromFile("src/main/resources/InformationAboutFruit.csv");
        FruitParseDtoParseImp parseImp = new FruitParseDtoParseImp();
        List<FruitRecordDto> listParse = parseImp.parse(list);
        for (FruitRecordDto fruitRecordDto : listParse) {
            map.get(fruitRecordDto.getOperation()).operation(fruitRecordDto);
        }
        CustomWriterFileImp writer = new CustomWriterFileImp();
        writer.writeFile("src/main/resources/Report.csv");
    }
}
