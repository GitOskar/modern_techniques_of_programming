package pl.umcs.builder;

public interface AudioBuilder {
    String buildHeader();
    String buildTags();
    String buildBody(int[] values);
}