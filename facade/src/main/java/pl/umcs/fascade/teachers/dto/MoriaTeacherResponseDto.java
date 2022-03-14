package pl.umcs.fascade.teachers.dto;

import lombok.Data;

@Data
public class MoriaTeacherResponseDto {
    private TeacherListResultDto result;
    private String status;
}
