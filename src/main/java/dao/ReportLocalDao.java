package dao;

import java.util.List;
import model.Fruit;

public interface ReportLocalDao {
    List<Fruit> getListRemainder();

    void setFruit(Fruit fruit);
}
