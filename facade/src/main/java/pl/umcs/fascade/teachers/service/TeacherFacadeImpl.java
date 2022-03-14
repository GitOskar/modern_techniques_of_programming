package pl.umcs.fascade.teachers.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.umcs.fascade.teachers.dto.MoriaTeacherResponseDto;
import pl.umcs.fascade.teachers.dto.TeacherDto;

import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

@Service
public class TeacherFacadeImpl implements TeacherFacade {

    private static final String MORIA_TEACHER_URL = "http://moria.umcs.lublin.pl/api/teacher_list";
    private static final List<Integer> IT_DEPARTMENTS = asList(3, 6, 7, 46, 29, 56, 36, 39, 45);

    @Override
    public List<TeacherDto> downloadAndFilterItTeachers() {

        return downloadAllTeachers().stream()
                .filter(teacherDto -> IT_DEPARTMENTS.contains(teacherDto.getDepartment_id()))
                .collect(toList());
    }

    @Override
    public List<TeacherDto> downloadAndFilterRandomThreeItTeachers() {
        List<TeacherDto> teacherDtos = downloadAndFilterItTeachers();

        if (teacherDtos.size() < 3) {
            throw new UnsupportedOperationException("Teacher number is less than 3");
        }

        int randomPos = new Random().nextInt(teacherDtos.size() - 3);

        return teacherDtos.subList(randomPos, randomPos + 3);
    }

    private List<TeacherDto> downloadAllTeachers() {
        RestTemplate restTemplate = new RestTemplate();

        MoriaTeacherResponseDto moriaTeacherResponseDto = restTemplate.getForObject(MORIA_TEACHER_URL, MoriaTeacherResponseDto.class);

        return moriaTeacherResponseDto.getResult().getArray();
    }
}
