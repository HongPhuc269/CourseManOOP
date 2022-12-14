package features;



import model.CompulsoryModule;
import model.ElectiveModule;
import model.Enrolment;
import model.Module;
import model.Student;

import java.time.LocalDate;

public class CourseManProg {
    public static void main(String[] args) throws EnrolmentException {
        Student[] students = new Student[6];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student("Phuc", LocalDate.of(2001, 9, 26), "Ha Noi", "phucng@gmail.com");
        }

        Module[] modules = new model.Module[6];
        modules[0] = new ElectiveModule("Mobile Programming", 2, 3, "IT");
        modules[1] = new ElectiveModule("Multimedia", 2, 3, "IT");
        modules[2] = new CompulsoryModule("Special Subject 1", 1, 3);
        modules[3] = new CompulsoryModule("SRM", 1, 2);
        modules[4] = new CompulsoryModule("Software Project Management", 1, 3);
        modules[5] = new ElectiveModule("Image Processing Recognition", 1, 3, "IT");

        EnrolmentManager em = new EnrolmentManager();
        for (int i = 0; i < 6; i++) {
            Enrolment enrolment = new Enrolment(students[i], modules[i]);
            em.addEnrolment(enrolment);
        }
        
        System.out.println("Initial report:");
        System.out.println(em.report());

        System.out.println("");
        System.out.println("After sorting: ");
        em.sort();
        System.out.println(em.report());

        System.out.println("");
//        for (int i = 0; i < students.length; i++) {
//            Enrolment enrolment = em.getValidStudentEnrolment().get(i);
//        }
        for (int i = 0; i < 6; i++) {
            em.setMarks(students[i], modules[i], 5.4, 8.6);
        }
        System.out.println("Full report assessment after setting new marks: ");
        System.out.println(em.reportAssessment());

    }
}
