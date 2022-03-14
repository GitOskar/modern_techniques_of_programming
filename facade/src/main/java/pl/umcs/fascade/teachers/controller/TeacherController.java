package pl.umcs.fascade.teachers.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.umcs.fascade.teachers.dto.TeacherDto;
import pl.umcs.fascade.teachers.service.TeacherFacade;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherFacade service;

    @GetMapping("/it-institute")
    public List<TeacherDto> itInstituteTeachers() {
        return service.downloadAndFilterItTeachers();
    }

    @GetMapping("/it-institute/random")
    public List<TeacherDto> threeRandomItInstituteTeachers() {
        return service.downloadAndFilterRandomThreeItTeachers();
    }
}
