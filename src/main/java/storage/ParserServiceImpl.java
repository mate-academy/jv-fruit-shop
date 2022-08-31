package storage;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import service.FileReaderService;
import service.OperationType;

public class ParserServiceImpl implements ParserService {
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int FRUIT_COUNT_INDEX = 2;
    private static final int INDEX_HEADER = 0;
    private final FileReaderService fileReaderServiceImpl;

    public ParserServiceImpl(FileReaderService fileReaderServiceImpl) {
        this.fileReaderServiceImpl = fileReaderServiceImpl;
    }

    @Override
    public List<FruitTransaction> getFruitsFromFile(List<String> info) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        info.remove(INDEX_HEADER);
        for (String infoFromFile : info) {
            String[] elementOfParsedInfoFromFile = infoFromFile.split(",");
            fruitTransactionList.add(new FruitTransaction(
                    OperationType.findOperationType(
                            elementOfParsedInfoFromFile[OPERATION_TYPE_INDEX]),
                    elementOfParsedInfoFromFile[FRUIT_NAME_INDEX],
                    Integer.parseInt(elementOfParsedInfoFromFile[FRUIT_COUNT_INDEX])));
        }
        return fruitTransactionList;
    }
}
