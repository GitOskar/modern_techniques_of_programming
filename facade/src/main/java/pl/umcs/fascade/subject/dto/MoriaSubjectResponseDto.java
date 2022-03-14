package pl.umcs.fascade.subject.dto;

import lombok.Data;
import pl.umcs.fascade.teachers.dto.TeacherListResultDto;

import javax.security.auth.Subject;

@Data
public class MoriaSubjectResponseDto {
    private SubjectListResultDto result;
    private String status;
}
