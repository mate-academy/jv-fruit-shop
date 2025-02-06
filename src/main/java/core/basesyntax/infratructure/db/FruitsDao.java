package core.basesyntax.infratructure.db;

import java.util.List;

public interface FruitsDao {
  void setFruits(String fruitName);
  List<String> getFruits(String fruitName);
}
