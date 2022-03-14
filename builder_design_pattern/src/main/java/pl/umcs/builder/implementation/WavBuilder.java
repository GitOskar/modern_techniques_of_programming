package pl.umcs.builder.implementation;

import pl.umcs.builder.AudioBuilder;

import java.util.Arrays;
import java.util.stream.Collectors;

public class WavBuilder implements AudioBuilder {

    @Override
    public String buildHeader() {
        return "WavHeader";
    }

    @Override
    public String buildTags() {
        return "";
    }

    @Override
    public String buildBody(int[] values) {
        return Arrays.stream(values)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(","));
    }
}
