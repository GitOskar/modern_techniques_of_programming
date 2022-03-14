package pl.umcs.director;

import org.junit.Test;
import pl.umcs.builder.implementation.Mp3Builder;
import pl.umcs.builder.implementation.OggBuilder;
import pl.umcs.builder.implementation.WavBuilder;

import static org.junit.Assert.assertEquals;

public class AudioDirectorTest {

    private static final int[] INT_ARRAY = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    @Test
    public void WavBuilderTest() {
        AudioDirector director = new AudioDirector(new WavBuilder());

        assertEquals(director.generateAudio(INT_ARRAY), getWavBuilderResult());
    }

    @Test
    public void Mp3BuilderTest() {
        AudioDirector director = new AudioDirector(new Mp3Builder());

        assertEquals(director.generateAudio(INT_ARRAY), getMp3BuilderResult());
    }

    @Test
    public void OggBuilderTest() {
        AudioDirector director = new AudioDirector(new OggBuilder());

        assertEquals(director.generateAudio(INT_ARRAY), getOggBuilderResult());
    }

    private String getWavBuilderResult() {
        return "Header: WavHeader\n" +
                "Tags: \n" +
                "Body: 0,1,2,3,4,5,6,7,8,9";
    }

    private String getMp3BuilderResult() {
        return "Header: OggHeader\n" +
                "Tags: OggTags\n" +
                "Body: AAECAwQFBgcICQ==";
    }

    private String getOggBuilderResult() {
        return "Header: Mp3Header\n" +
                "Tags: Mp3Tags\n" +
                "Body: AAECAwQFBgcICQ==";
    }
}