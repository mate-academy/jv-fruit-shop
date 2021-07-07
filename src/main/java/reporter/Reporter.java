package reporter;

public interface Reporter<J, D> {

    void makeReportFromTo(J from, J to, D dao);
}
