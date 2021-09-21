package core.basesyntax.services.data;

import core.basesyntax.model.TransactionDto;
import java.util.ArrayList;
import java.util.List;

public class ParserCsv implements DataParser<TransactionDto, String> {
    private static final int ITEM_INDEX_INDEX = 0;
    private static final int ITEM_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final String DATA_SPLITTER = ",";

    @Override
    public List<TransactionDto> formatData(List<String> data) {
        DataValidator dataValidator = new DataValidatorImpl();
        List<TransactionDto> transactionDtos = new ArrayList<>();
        for (String rawData : data) {
            String[] rawDataArray = rawData.split(DATA_SPLITTER);
            dataValidator.validate(rawDataArray);
            transactionDtos.add(new TransactionDto(TransactionDto
                    .Type.get(rawDataArray[ITEM_INDEX_INDEX]),
                    rawDataArray[ITEM_INDEX],
                    Integer.parseInt(rawDataArray[AMOUNT_INDEX])));
        }
        return transactionDtos;
    }
}
