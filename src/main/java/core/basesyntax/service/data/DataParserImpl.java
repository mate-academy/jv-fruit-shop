package core.basesyntax.service.data;

import core.basesyntax.model.FruitRecordDto;
import java.util.ArrayList;
import java.util.List;

public class DataParserImpl implements DataParser<FruitRecordDto, String> {
    private static final int TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final String DATA_SPLITTER = ",";
    private static final int FIRST_LINE_OF_CSV = 0;
    private DataValidator dataValidator = new DataValidatorImpl();

    public DataParserImpl(DataValidator dataValidator) {
        this.dataValidator = dataValidator;
    }

    public DataParserImpl() {
    }

    @Override
    public List<FruitRecordDto> formatData(List<String> data) {

        //DataValidator dataValidator = new DataValidatorImpl();
        List<FruitRecordDto> fruitRecordDtos = new ArrayList<>();
        data.remove(FIRST_LINE_OF_CSV);
        for (String proper : data) {
            String[] properArray = proper.split(DATA_SPLITTER);
            dataValidator.validate(properArray);
            fruitRecordDtos.add(new FruitRecordDto(FruitRecordDto.Type.get(properArray[TYPE_INDEX]),
                    properArray[FRUIT_INDEX],
                    Integer.parseInt(properArray[AMOUNT_INDEX])));
        }
        return fruitRecordDtos;
    }
}
