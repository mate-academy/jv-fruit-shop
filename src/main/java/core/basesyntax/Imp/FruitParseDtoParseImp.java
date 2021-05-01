package core.basesyntax.Imp;

import core.basesyntax.Model.FruitRecordDto;
import core.basesyntax.Service.FruitRecordDtoParse;

import java.util.ArrayList;
import java.util.List;

public class FruitParseDtoParseImp implements FruitRecordDtoParse {
    @Override
    public List<FruitRecordDto> parse(List<String> lines) {
        List<FruitRecordDto> listFruit = new ArrayList<>(lines.size());
        FruitRecordDto fruitRecordDto;
        String[] arraySting;
        for (int i = 0; i < lines.size(); i++) {
            arraySting = lines.get(i).split(",");
            fruitRecordDto = new FruitRecordDto(arraySting[0].trim(), arraySting[1].trim()
                    , Integer.parseInt(arraySting[2].trim()));
            listFruit.add(fruitRecordDto);
        }
        return listFruit;
    }
}
