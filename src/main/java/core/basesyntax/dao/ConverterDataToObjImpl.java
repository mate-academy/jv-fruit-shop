package core.basesyntax.dao;

import core.basesyntax.FruitTransaction;
import core.basesyntax.db.DataBase;
import java.util.List;

public class ConverterDataToObjImpl implements ConverterDataToObj {
    private static final String SPLITERATOR = ",";
    private static final int OPERATION_SEQUENCE = 0;
    private static final int FRUIT_NAME_SEQUENCE = 1;
    private static final int FRUIT_QUANTITY_SEQUENCE = 2;

    @Override
    public void convertData(String filePath) {
        ReaderDataFromFileImpl readerDataFromFile = new ReaderDataFromFileImpl();

        List<FruitTransaction> list = readerDataFromFile.readFromFile(filePath).stream()
                .map(s -> s.split(SPLITERATOR))
                .map(s -> new FruitTransaction(s[OPERATION_SEQUENCE],
                        s[FRUIT_NAME_SEQUENCE], Integer.parseInt(s[FRUIT_QUANTITY_SEQUENCE])))
                .toList();
        DataBase.fruitDataBase.addAll(list);
    }
}
