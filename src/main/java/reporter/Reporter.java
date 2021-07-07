package reporter;

public interface AutoReporter<J, D> {

    void makeReportFromTo(J from, J to, D dao);
}
