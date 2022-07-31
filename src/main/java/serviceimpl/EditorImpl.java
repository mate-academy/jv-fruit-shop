package serviceimpl;

import dao.StorageDao;
import java.util.List;
import model.Fruit;
import service.Editor;

public class EditorImpl implements Editor {
    private final StorageDao storageDao;

    public EditorImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public String edit() {
        List<Fruit> fruitList = storageDao.getAll();
        StringBuilder editor = new StringBuilder();
        for (Fruit fruit : fruitList) {
            editor.append(System.lineSeparator()).append(fruit.getName())
                    .append(",").append(fruit.getQuantity());
        }
        return "fruits, quantity" + editor.toString();
    }
}
