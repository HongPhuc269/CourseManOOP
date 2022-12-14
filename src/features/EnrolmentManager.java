package features;

import model.Enrolment;
import model.Module;
import model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EnrolmentManager {

    List<Enrolment> enrollmentLists = new ArrayList<>();

    public void addEnrolment(Enrolment enrollment) throws EnrolmentException {
        enrollmentLists.add(enrollment);
    }

    public Enrolment getEnrolment(Student student, Module module) throws EnrolmentException {
        return enrollmentLists.stream()
                .filter(enrollment -> enrollment.getModule().getCode().equalsIgnoreCase(module.getCode())
                        && enrollment.getStudent().getId().equalsIgnoreCase(student.getId())).collect(Collectors.toList()).get(0);
    }

    public List<Enrolment> getValidStudentEnrolment(){
        return enrollmentLists.stream().filter(enrolment -> enrolment.getStudent().equals(enrolment))
                .collect(Collectors.toList());
    }

    public void setMarks(Student student, Module module, double internal, double examination) throws EnrolmentException {
        Enrolment enrolment = getEnrolment(student, module);
        if (enrolment != null) {
            enrolment.setInternal(internal);
            enrolment.setExamination(examination);
        } else {
            throw new EnrolmentException("Set marks can not be done");
        }
    }

    public String report() {
        StringBuilder result = new StringBuilder();
        for (Enrolment e : enrollmentLists) {
            result.append(e.report() + '\n');
        }
        return result.toString();
    }

    public String reportAssessment() {
        StringBuilder result = new StringBuilder();
        for (Enrolment e : enrollmentLists) {
            result.append(e.toString() + '\n');
        }
        return result.toString();
    }

    public void sort() {
        enrollmentLists.sort(((e1, e2) -> {
            return Integer.compare(Integer.parseInt(e2.getStudent().getId().substring(1))
                    , Integer.parseInt(e1.getStudent().getId().substring(1)));
        }));
    }

}
