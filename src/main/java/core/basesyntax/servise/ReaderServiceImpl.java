package core.basesyntax.servise;

import core.basesyntax.files.Reader;
import core.basesyntax.model.FruitRecordDto;
import core.basesyntax.validation.Validator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    private static final String SEPARATOR = ",";
    private static final int TYPE = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;
    private final Reader reader;
    private final Validator titleValidator;
    private final Validator lineValidator;
    private FruitRecordDto fruitRecordDto;

    public ReaderServiceImpl(Reader reader, Validator titleValidator, Validator lineValidator) {
        this.reader = reader;
        this.titleValidator = titleValidator;
        this.lineValidator = lineValidator;
    }

    @Override
    public List<FruitRecordDto> readData() {
        List<FruitRecordDto> resultList = new ArrayList<>();
        List<String> lines = reader.read();
        for (int i = 0; i < lines.size(); i++) {
            fruitRecordDto = new FruitRecordDto();
            List<String> parsedLine = Arrays.asList(lines.get(i).strip().split(SEPARATOR));
            if (i == 0) {
                titleValidator.validate(parsedLine);
                continue;
            }
            lineValidator.validate(parsedLine);
            fruitRecordDto.setTypeOperation(parsedLine.get(TYPE));
            fruitRecordDto.setFruit(parsedLine.get(FRUIT));
            fruitRecordDto.setQuantity(parsedLine.get(QUANTITY));
            resultList.add(fruitRecordDto);
        }
        return resultList;
    }
}
