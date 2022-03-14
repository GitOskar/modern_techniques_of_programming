package pl.umcs.director;

import pl.umcs.builder.AudioBuilder;

public class AudioDirector {

    private final AudioBuilder audioBuilder;

    public AudioDirector(AudioBuilder audioBuilder) {
        this.audioBuilder = audioBuilder;
    }

    public String generateAudio(int[] values) {
        return "Header: " + audioBuilder.buildHeader() +
                "\nTags: " + audioBuilder.buildTags() +
                "\nBody: " + audioBuilder.buildBody(values);
    }

    @Override
    public String toString() {
        return "AudioDirector{" +
                "audioBuilder=" + audioBuilder +
                '}';
    }
}
