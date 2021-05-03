package core.basesyntax.dto;

import core.basesyntax.model.Operation;

import java.util.ArrayList;
import java.util.List;

public class FruitRecordDtoParserImpl implements FruitRecordDtoParser{
    @Override
    public List<FruitRecordDto> parse(List<String> lines) {
        List<FruitRecordDto> recordDtos = new ArrayList<>(lines.size());
        for (String line : lines ) {
            if(line.equals(lines.get(0))) {
                continue;
            }

            String[] parseLine = line.split(",");
            String operationType = parseLine[0];

            Operation operationTypeCorrect = Operation.getOperationByShortName(operationType);

            String fruitName = parseLine[1];
            Integer quantity = Integer.parseInt(parseLine[2]);

            FruitRecordDto dto = new FruitRecordDto(operationTypeCorrect, fruitName, quantity);
            recordDtos.add(dto);
        }
        return recordDtos;
    }
}
