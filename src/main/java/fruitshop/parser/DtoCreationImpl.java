package fruitshop.parser;

import fruitshop.model.Fruit;
import fruitshop.model.OperationType;
import fruitshop.model.OperationsDto;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DtoCreationImpl implements DtoCreator {
    private static final int OPERATION_RECORD = 0;
    private static final int FRUIT_TYPE_RECORD = 1;
    private static final int FRUIT_AMOUNT_RECORD = 2;
    private static final String SIGN_TO_SPLIT_WITH = ",";

    public List<OperationsDto> toDtoDataFormatter(List<String> stringsRecords) {
        List<OperationsDto> parsedToDtoData = new ArrayList<>();

        for (String fruitRecordLine : stringsRecords) {
            String standartRecordLine = fruitRecordLine.toLowerCase(Locale.ROOT);
            String [] fruitsRecordPart = standartRecordLine.split(SIGN_TO_SPLIT_WITH);
            if (OperationType.valueOfLabel(fruitsRecordPart[0].trim()) == null) {
                continue;
            }
            OperationsDto fruitRecordLineDto = new OperationsDto();
            fruitRecordLineDto.setOperationType(OperationType
                      .valueOfLabel(fruitsRecordPart[OPERATION_RECORD].trim()));
            fruitRecordLineDto.setFruitType(new Fruit(fruitsRecordPart[FRUIT_TYPE_RECORD]));
            fruitRecordLineDto.setAmount(Integer.parseInt(fruitsRecordPart[FRUIT_AMOUNT_RECORD]));
            parsedToDtoData.add(fruitRecordLineDto);
        }
        return parsedToDtoData;
    }
}
