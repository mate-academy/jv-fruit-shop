package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import java.util.List;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    private static final String FILE_NAME_INPUT_DATA = "src/main/resources/inputData.csv";
    private static final String FILE_NAME_PROCESSED_DATA = "src/main/resources/outputData.csv";

    @Override
    public List<String> get() {
        ReaderService readerService = new ReaderServiceImpl();
        return readerService.readFromFile(FILE_NAME_INPUT_DATA);
    }

    @Override
    public void saveData(Map<String, Integer> processedData) {
        WriterService writerService = new WriterServiceImpl();
        writerService.writeToFile(FILE_NAME_PROCESSED_DATA, Storage.storage);
    }
}

