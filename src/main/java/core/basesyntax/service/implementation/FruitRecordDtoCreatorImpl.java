package core.basesyntax.service.implementation;

import core.basesyntax.model.FruitRecordDto;
import core.basesyntax.service.FruitRecordDtoCreator;
import core.basesyntax.service.FruitRecordDtoParser;
import java.util.ArrayList;
import java.util.List;

public class FruitRecordDtoCreatorImpl implements FruitRecordDtoCreator {
    private final FruitRecordDtoParser fruitRecordDtoParser;

    public FruitRecordDtoCreatorImpl(FruitRecordDtoParser fruitRecordDtoParser) {
        this.fruitRecordDtoParser = fruitRecordDtoParser;
    }

    @Override
    public List<FruitRecordDto> createRecords(List<String> records) {
        List<FruitRecordDto> fruitRecordDtos = new ArrayList<>();
        for (String record : records) {
            FruitRecordDto fruitRecordDto = fruitRecordDtoParser.parseRecord(record);
            fruitRecordDtos.add(fruitRecordDto);
        }
        return fruitRecordDtos;
    }
}
