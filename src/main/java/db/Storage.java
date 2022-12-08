package db;

import java.util.List;

public interface Storage {
    List<String> getData();

    boolean addData(String stringFruitTransaction);
}
