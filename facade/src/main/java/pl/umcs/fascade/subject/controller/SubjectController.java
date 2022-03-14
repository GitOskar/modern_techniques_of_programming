package pl.umcs.fascade.subject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.umcs.fascade.subject.dto.SubjectDto;
import pl.umcs.fascade.subject.service.SubjectFacade;

import java.util.List;

@RequestMapping("/subject")
@RestController
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectFacade subjectFacade;

    @GetMapping
    public List<SubjectDto> itInstituteTeachers() {
        return subjectFacade.downloadSubjects();
    }

    @GetMapping("/random")
    public List<SubjectDto> threeRandomItInstituteTeachers() {
        return subjectFacade.downloadAndGetRandomThreeSubjects();
    }
}
