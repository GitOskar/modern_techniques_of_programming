package pl.umcs.builder.implementation;

import pl.umcs.builder.AudioBuilder;
import pl.umcs.util.Base64Util;

public class OggBuilder implements AudioBuilder {
    @Override
    public String buildHeader() {
        return "Mp3Header";
    }

    @Override
    public String buildTags() {
        return "Mp3Tags";
    }

    @Override
    public String buildBody(int[] values) {
        return Base64Util.convertToBase64(values);
    }
}
