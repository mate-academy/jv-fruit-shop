package db;

import dao.TransactionDao;
import model.FruitTransaction;

import java.util.*;

public class Storage {
    //method synchronized was used to make the list thread safe
    public static final List<FruitTransaction> transactions =
            Collections.synchronizedList(new ArrayList<>());
}
