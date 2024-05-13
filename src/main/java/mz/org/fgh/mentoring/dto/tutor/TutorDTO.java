package mz.org.fgh.mentoring.dto.tutor;

import lombok.AllArgsConstructor;
import lombok.Data;
import mz.org.fgh.mentoring.base.BaseEntityDTO;
import mz.org.fgh.mentoring.dto.employee.EmployeeDTO;
import mz.org.fgh.mentoring.dto.tutorProgrammaticArea.TutorProgrammaticAreaDTO;
import mz.org.fgh.mentoring.entity.tutor.Tutor;
import mz.org.fgh.mentoring.entity.tutorprogramaticarea.TutorProgrammaticArea;

import java.util.ArrayList;
import java.util.List;

import io.micronaut.core.annotation.Creator;

@Data
@AllArgsConstructor
public class TutorDTO extends BaseEntityDTO {
    private EmployeeDTO employeeDTO;
    private List<TutorProgrammaticAreaDTO> tutorProgrammaticAreaDTOS;

    @Creator
    public TutorDTO() {}

    public TutorDTO(Tutor tutor) {
        super(tutor);
        this.setEmployeeDTO(new EmployeeDTO(tutor.getEmployee()));
        this.setTutorProgrammaticAreaDTOS(setTutorProgrammaticAreas(tutor.getTutorProgrammaticAreas()));
    }

    private List<TutorProgrammaticAreaDTO> setTutorProgrammaticAreas(List<TutorProgrammaticArea> tutorProgrammaticAreas) {

        List<TutorProgrammaticAreaDTO> tutorProgrammaticAreaDTOList = new ArrayList<>();

        for (TutorProgrammaticArea tutorProgrammaticArea : tutorProgrammaticAreas) {
            tutorProgrammaticAreaDTOList.add(new TutorProgrammaticAreaDTO(tutorProgrammaticArea));
        }
        return tutorProgrammaticAreaDTOList;
    }

    public Tutor toTutor() {
        Tutor tutor = new Tutor();
        tutor.setId(this.getId());
        tutor.setUuid(this.getUuid());
        return tutor;
    }
}