package pl.umcs.fascade.subject.service;

import pl.umcs.fascade.subject.dto.SubjectDto;

import java.util.List;

public interface SubjectFacade {
    List<SubjectDto> downloadSubjects();

    List<SubjectDto> downloadAndGetRandomThreeSubjects();
}