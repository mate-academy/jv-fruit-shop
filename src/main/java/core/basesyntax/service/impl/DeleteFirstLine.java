package core.basesyntax.service.impl;

import java.util.ArrayList;
import java.util.List;

public class DeleteFirstLine {

    public List<String> delete(List<String> list) {
        List<String> newList = new ArrayList<>();
        int index = 1;
        for (int i = 0; i < list.size() - 1; i++) {
            newList.add(list.get(index));
            index++;
        }
        return newList;
    }
}
