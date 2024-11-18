package core.basesyntax.converter;

import core.basesyntax.dao.FruitDao;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class StringToFruitDaoConverter implements Function<String, FruitDao> {

    @Override
    public FruitDao apply(String s) {
        String[] arr = s.split(",");
        if (arr.length != 3) {
            throw new RuntimeException("Cannot convert string [" + s + "] to fruitDao");
        }
        return new FruitDao(arr[1], Integer.parseInt(arr[2]));
    }

    public List<FruitDao> applyList(List<String> list) {
        List<FruitDao> resultList = new ArrayList<>();
        for (String s : list) {
            resultList.add(apply(s));
        }
        return resultList;
    }
}
