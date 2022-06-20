package core.basesyntax.service.impl;

import core.basesyntax.modelfruit.ModelFruit;
import core.basesyntax.service.ParceData;
import java.util.ArrayList;
import java.util.List;

public class ParceDataImpl implements ParceData {
    private static final int HEAD_OF_FILE = 0;

    @Override
    public List<ModelFruit> getFruitsMoving(List<String> list) {
        list.remove(HEAD_OF_FILE);
        List<ModelFruit> listFruitsMoving = new ArrayList<>();
        String[] fields;
        for (String line : list) {
            fields = line.split(",");
            listFruitsMoving
                    .add(new ModelFruit(fields[0], fields[1], Integer.parseInt(fields[2])));
        }
        return listFruitsMoving;
    }
}
