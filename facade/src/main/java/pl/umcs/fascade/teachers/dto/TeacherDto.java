package pl.umcs.fascade.teachers.dto;

import lombok.Data;

@Data
public class TeacherDto {
    private String degree;
    private int department_id;
    private String first_name;
    private int id;
    private String last_name;
}
