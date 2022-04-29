package core.basesyntax.service;

import core.basesyntax.exception.FileValidation;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.OperationType;
import core.basesyntax.model.TransactionDto;
import java.util.List;
import java.util.stream.Collectors;

public class FruitShopDataParserImpl implements FruitShopDataParser {
    private static final String WORDS_IN_TITLE = "type,fruit,quantity";
    private static final int TYPE_INDEX = 0;
    private static final int FRUITS_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private final FileValidation validation = new FileValidation();

    @Override
    public List<TransactionDto> parse(List<String> readFile) {
        readFile.remove(WORDS_IN_TITLE);
        validation.checkFile(readFile);
        return readFile.stream()
                .map(this::getFromCsvRow)
                .collect(Collectors.toList());
    }

    @Override
    public TransactionDto getFromCsvRow(String line) {
        String[] fields = line.split(",");
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setOperationType(OperationType.getOperationType(fields[TYPE_INDEX]));
        transactionDto.setFruitName(new Fruit(fields[FRUITS_NAME_INDEX]));
        transactionDto.setAmount(Integer.parseInt(fields[QUANTITY_INDEX]));
        return transactionDto;
    }
}
