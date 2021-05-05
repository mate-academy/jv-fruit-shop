package core.basesyntax;

import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.DatabaseOperation;
import core.basesyntax.service.DtoParser;
import core.basesyntax.service.impls.AddFruitOperation;
import core.basesyntax.service.impls.DtoParseImpl;
import core.basesyntax.service.impls.FileLinesReaderImpl;
import core.basesyntax.service.impls.RemoveFruitOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    private static final String INPUT_FILE = "src/main/resources/input.csv";

    public void initialize() {
        Map<String, DatabaseOperation> fruitOperationsStrategy = new HashMap<>();
        fruitOperationsStrategy.put("b", new AddFruitOperation());
        fruitOperationsStrategy.put("s", new AddFruitOperation());
        fruitOperationsStrategy.put("r", new AddFruitOperation());
        fruitOperationsStrategy.put("p", new RemoveFruitOperation());

        FileLinesReaderImpl reader = new FileLinesReaderImpl();
        DtoParser dto = new DtoParseImpl();
        List<FruitRecordDto> dtosList = dto.parse(reader.dataFromFile(INPUT_FILE));

        for (FruitRecordDto fruitRecordDto : dtosList) {
            fruitOperationsStrategy.get(fruitRecordDto.getOperation()).apply(fruitRecordDto);
        }
    }
}
