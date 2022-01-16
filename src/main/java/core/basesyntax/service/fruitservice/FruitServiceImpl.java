package core.basesyntax.service.fruitservice;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dto.FruitRecordDto;
import java.util.List;
import java.util.stream.Collectors;

public class FruitServiceImpl implements FruitService {
    private static final String HEADLINE = "fruit,quantity" + System.lineSeparator();
    private final FruitRecordStrategy fruitRecordStrategy;
    private final FruitDao fruitDao;

    public FruitServiceImpl(FruitRecordStrategy fruitRecordStrategy, FruitDao fruitDao) {
        this.fruitRecordStrategy = fruitRecordStrategy;
        this.fruitDao = fruitDao;
    }

    @Override
    public void saveData(List<FruitRecordDto> fruitRecordDto) {
        for (FruitRecordDto recordDto : fruitRecordDto) {
            fruitRecordStrategy.get(recordDto.getOperationType()).applyAction(recordDto);
        }
    }

    @Override
    public String createReport() {
        return HEADLINE + fruitDao.getAll().entrySet()
                .stream()
                .map(currentKey -> currentKey.getKey().getName() + ","
                        + currentKey.getValue() + System.lineSeparator())
                .collect(Collectors.joining());
    }
}
