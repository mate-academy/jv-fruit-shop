package core.basesyntax.model;

import java.util.List;

public class Grid {
    private String[] titles;
    private List<String[]> rows;

    public Grid(String[] titles, List<String[]> rows) {
        this.titles = titles;
        this.rows = rows;
    }

    public String[] getTitles() {
        return titles;
    }

    public List<String[]> getRows() {
        return rows;
    }
}
