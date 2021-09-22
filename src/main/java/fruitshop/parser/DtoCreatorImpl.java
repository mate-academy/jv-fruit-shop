package fruitshop.parser;

import fruitshop.model.Fruit;
import fruitshop.model.OperationType;
import fruitshop.model.RecordDto;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DtoCreatorImpl implements DtoCreator {
    private static final int OPERATION_RECORD_OR_HEADER = 0;
    private static final int FRUIT_TYPE_RECORD = 1;
    private static final int FRUIT_AMOUNT_RECORD = 2;
    private static final String SIGN_TO_SPLIT_WITH = ",";
    private static final String HEADER = "fruit,quantity";

    public List<RecordDto> toDtoDataFormatter(List<String> stringsRecords) {
        List<RecordDto> parsedToDtoData = new ArrayList<>();
        if (stringsRecords.get(OPERATION_RECORD_OR_HEADER).contains(HEADER)) {
            stringsRecords.remove(OPERATION_RECORD_OR_HEADER);
        }
        for (String fruitRecordLine : stringsRecords) {
            String standartRecordLine = fruitRecordLine.toLowerCase(Locale.ROOT);
            String [] fruitsRecordPart = standartRecordLine.split(SIGN_TO_SPLIT_WITH);
            RecordDto fruitRecordLineDto = new RecordDto();
            fruitRecordLineDto.setOperationType(OperationType
                      .valueOfLabel(fruitsRecordPart[OPERATION_RECORD_OR_HEADER].trim()));
            fruitRecordLineDto.setFruitType(new Fruit(fruitsRecordPart[FRUIT_TYPE_RECORD]));
            fruitRecordLineDto.setAmount(Integer.parseInt(fruitsRecordPart[FRUIT_AMOUNT_RECORD]));
            parsedToDtoData.add(fruitRecordLineDto);
        }
        return parsedToDtoData;
    }
}
