package core.basesyntax.dao;

import java.util.List;

public interface ArticleDao {
    void addArticle(String article);

    void updateStorage(String article, int quantity);

    Integer getQuantity(String article);

    List<String> getArticles();

    void removeArticle(String article);
}
