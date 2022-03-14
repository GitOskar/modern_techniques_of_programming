package pl.umcs.fascade.teachers.dto;

import lombok.Data;

import java.util.List;

@Data
public class TeacherListResultDto {
    public List<TeacherDto> array;
    public int count;
}
