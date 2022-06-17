package core.basesyntax.service.impl;

import core.basesyntax.model.Model;
import core.basesyntax.service.ParceData;
import java.util.ArrayList;
import java.util.List;

public class ParceDataImpl implements ParceData {
    private static final int HEAD_OF_FILE = 0;

    @Override
    public List<Model> getFruitsMoving(List<String> list) {
        list.remove(HEAD_OF_FILE);
        List<Model> listFruitsMoving = new ArrayList<>();
        String[] fields;
        for (String line : list) {
            fields = line.split(";");
            listFruitsMoving
                    .add(new Model(fields[0].trim(), fields[1]
                            .trim(), Integer.parseInt(fields[2])));
        }
        return listFruitsMoving;
    }
}
