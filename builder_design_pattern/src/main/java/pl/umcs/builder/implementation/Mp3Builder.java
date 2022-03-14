package pl.umcs.builder.implementation;

import pl.umcs.builder.AudioBuilder;

import java.util.Arrays;

import static pl.umcs.util.Base64Util.convertToBase64;

public class Mp3Builder implements AudioBuilder {
    @Override
    public String buildHeader() {
        return "OggHeader";
    }

    @Override
    public String buildTags() {
        return "OggTags";
    }

    @Override
    public String buildBody(int[] values) {
        return convertToBase64(Arrays.stream(values)
                .map(this::trim)
                .toArray());
    }

    private int trim(int value) {
        return (value > 100 ? 100 : Math.max(value, -100));
    }
}