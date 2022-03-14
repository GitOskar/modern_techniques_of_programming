package pl.umcs.fascade.teachers.service;

import pl.umcs.fascade.teachers.dto.TeacherDto;

import java.util.List;

public interface TeacherFacade {
    List<TeacherDto> downloadAndFilterItTeachers();
    List<TeacherDto> downloadAndFilterRandomThreeItTeachers();
}
