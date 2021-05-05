package core.basesyntax.imp;

import core.basesyntax.model.FruitRecordDto;
import core.basesyntax.service.FruitParse;
import java.util.ArrayList;
import java.util.List;

public class FruitParseDtoParseImp implements FruitParse {
    private static final String SPLIT_SYMBOL = ",";
    private static final int PLACE_OPERATION = 0;
    private static final int PLACE_NAME_FRUIT = 1;
    private static final int PLACE_AMOUNT = 2;

    @Override
    public List<FruitRecordDto> parse(List<String> line) {
        List<FruitRecordDto> listFruit = new ArrayList<>(line.size());
        FruitRecordDto fruitRecordDto;
        String[] arraySting;
        for (String currentLine : line) {
            arraySting = currentLine.split(SPLIT_SYMBOL);
            fruitRecordDto = new FruitRecordDto(arraySting[PLACE_OPERATION].trim(),
                    arraySting[PLACE_NAME_FRUIT].trim(),
                    Integer.parseInt(arraySting[PLACE_AMOUNT].trim()));
            listFruit.add(fruitRecordDto);
        }
        return listFruit;
    }
}
