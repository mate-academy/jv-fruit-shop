package core.basesyntax.imp;

import core.basesyntax.model.FruitRecordDto;
import core.basesyntax.service.FruitRecordDtoParse;
import java.util.ArrayList;
import java.util.List;

public class FruitParseDtoParseImp implements FruitRecordDtoParse {
    @Override
    public List<FruitRecordDto> parse(List<String> line) {
        List<FruitRecordDto> listFruit = new ArrayList<>(line.size());
        FruitRecordDto fruitRecordDto;
        String[] arraySting;
        for (String currentLine : line) {
            arraySting = currentLine.split(",");
            fruitRecordDto = new FruitRecordDto(arraySting[0].trim(), arraySting[1].trim(),
                    Integer.parseInt(arraySting[2].trim()));
            listFruit.add(fruitRecordDto);
        }
        return listFruit;
    }
}
