package core.basesyntax.service.impl;

import core.basesyntax.dao.ArticleDao;
import core.basesyntax.service.Report;
import java.util.ArrayList;
import java.util.List;

public class ReportImpl implements Report {
    private static final String COLUMN_NAMES = "fruit,quantity";
    private static final String ROW_SEPARATOR = ",";
    private static final int STARTED_ROW_LENGTH = 0;
    private ArticleDao articleDao;

    public ReportImpl(ArticleDao fruitTransactionDao) {
        this.articleDao = fruitTransactionDao;
    }

    @Override
    public List<String> create() {
        List<String> report = new ArrayList<>();
        report.add(COLUMN_NAMES);
        StringBuilder newRow = new StringBuilder();
        String article;
        int quantity;
        List<String> articles = articleDao.getArticles();
        for (String articleFromStorage : articles) {
            article = articleFromStorage;
            quantity = articleDao.getQuantity(article);
            newRow.append(article).append(ROW_SEPARATOR).append(quantity);
            report.add(newRow.toString());
            newRow.setLength(STARTED_ROW_LENGTH);
        }
        return report;
    }
}
