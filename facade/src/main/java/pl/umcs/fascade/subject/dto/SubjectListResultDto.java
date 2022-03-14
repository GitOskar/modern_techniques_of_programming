package pl.umcs.fascade.subject.dto;

import lombok.Data;
import pl.umcs.fascade.teachers.dto.TeacherDto;

import java.util.List;

@Data
public class SubjectListResultDto {
    public List<SubjectDto> array;
    public int count;
}
