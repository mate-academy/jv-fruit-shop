package core.basesyntax.service;

import core.basesyntax.model.TransactionDto;
import java.util.ArrayList;
import java.util.List;

public class ParserImpl implements Parser {
    private static final int OPERATION = 0;
    private static final int FRUIT = 1;
    private static final int AMOUNT = 2;
    private static final String REGEX_FOR_SPLIT = ",";
    private final List<TransactionDto> parsedInfo = new ArrayList<>();

    @Override
    public List<TransactionDto> parser(List<String> infoFromInputFile) {
        for (String line : infoFromInputFile) {
            String[] splitedLine = line.split(REGEX_FOR_SPLIT);
            parsedInfo.add(new TransactionDto(TransactionDto
                    .OperationTypes
                    .getType(splitedLine[OPERATION]),
                    splitedLine[FRUIT],
                    Integer.parseInt(splitedLine[AMOUNT])));
        }
        return parsedInfo;
    }
}
