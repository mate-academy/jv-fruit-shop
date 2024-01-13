package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.ArrayList;
import java.util.List;

public class ArticleDaoImpl implements ArticleDao {
    private static final int DEFAULT_FRUIT_QUANTITY = 0;

    @Override
    public void addArticle(String article) {
        Storage.storage.put(article, DEFAULT_FRUIT_QUANTITY);
        System.out.println("Article '" + article + "' was added to the storage");
    }

    @Override
    public void updateStorage(String article, int quantity) {
        Storage.storage.put(article, quantity);
    }

    @Override
    public Integer getQuantity(String article) {
        return Storage.storage.get(article);
    }

    @Override
    public List<String> getArticles() {
        return new ArrayList<>(Storage.storage.keySet());
    }

    @Override
    public void removeArticle(String article) {
        if (Storage.storage.get(article) == null) {
            System.out.println("Storage doesn't contain article '" + article + "'");
        } else {
            Storage.storage.remove(article);
            System.out.println("Article '" + article + "' was removed from the storage");
        }
    }
}
