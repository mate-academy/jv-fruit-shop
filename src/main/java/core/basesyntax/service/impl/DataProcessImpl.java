package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataProcess;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DataProcessImpl implements DataProcess {
    private FruitDao fruitDao;

    public DataProcessImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public List<FruitTransaction> dataProcessing(List<String> fileData) {
        List<FruitTransaction> collect = IntStream.range(0, fileData.size())
                .filter(i -> i != 0)
                .mapToObj(i -> fileData.get(i).split(","))
                .map(this::createObj)
                .collect(Collectors.toList());
        fruitDao.addAll(collect);
        return collect;
    }

    private FruitTransaction createObj(String[] stringsArray) {
        FruitTransaction fruitTransaction = new FruitTransaction(stringsArray[1],
                Integer.parseInt(stringsArray[2]));
        fruitTransaction.setOperationByIndex(stringsArray[0]);
        return fruitTransaction;
    }
}
