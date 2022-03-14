package pl.umcs.fascade.subject.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.umcs.fascade.subject.dto.MoriaSubjectResponseDto;
import pl.umcs.fascade.subject.dto.SubjectDto;

import java.util.List;
import java.util.Random;

@Service
public class SubjectFacadeImpl implements SubjectFacade {

    private static final String MORIA_SUBJECT_URL = "http://moria.umcs.lublin.pl/api/students_list";

    @Override
    public List<SubjectDto> downloadSubjects() {

        RestTemplate restTemplate = new RestTemplate();

        MoriaSubjectResponseDto moriaTeacherResponseDto = restTemplate.getForObject(MORIA_SUBJECT_URL, MoriaSubjectResponseDto.class);

        return moriaTeacherResponseDto.getResult().getArray();
    }

    @Override
    public List<SubjectDto> downloadAndGetRandomThreeSubjects() {
        List<SubjectDto> subjectDtos = downloadSubjects();

        if (subjectDtos.size() < 3) {
            throw new UnsupportedOperationException("Teacher number is less than 3");
        }

        int randomPos = new Random().nextInt(subjectDtos.size() - 3);

        return subjectDtos.subList(randomPos, randomPos + 3);
    }
}
