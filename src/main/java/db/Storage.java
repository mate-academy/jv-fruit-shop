package db;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.FruitTransaction;

public class Storage {
    //method synchronized was used to make the list thread safe
    public static final List<FruitTransaction> transactions =
            Collections.synchronizedList(new ArrayList<>());
}
