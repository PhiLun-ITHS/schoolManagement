package frontend;

import backend.CourseFunctions;
import backend.DepartmentFunctions;
import backend.StudentFunctions;
import backend.TeacherFunctions;
import entity.Course;
import entity.Department;
import entity.Student;
import entity.Teacher;
import main.Input;

public class SearchFunctions {

    public static void searchCourse() {

        System.out.print("Course id: ");
        Integer courseId = Input.inputInt();

        Course course = CourseFunctions.getCourse(courseId);

        if(course != null) {
            PrintFunctions.printCourseHeadSearch(course);
        } else {
            System.out.println("No such course id (" + courseId+")");
        }
    }

    public static void searchStudent() {

        System.out.print("Student social security: ");
        String socialSecurity = Input.inputString();

        Student student = StudentFunctions.getStudent(socialSecurity);

        if(student != null){
            PrintFunctions.printStudentHeadSearch(student);
        } else {
            System.out.println("No such student (" + socialSecurity+")");
        }
    }

    public static void searchTeacher() {

        System.out.print("Teacher social security: ");
        String socialSecurity = Input.inputString();

        Teacher teacher = TeacherFunctions.getTeacher(socialSecurity);

        if(teacher != null){
            PrintFunctions.printTeacherHeadSearch(teacher);
        } else {
            System.out.println("No such teacher (" + socialSecurity+")");
        }
    }

    public static void searchDepartment() {

        System.out.print("Department id: ");
        Integer departmentId = Input.inputInt();

        Department department = DepartmentFunctions.getDepartment(departmentId);

        if(department != null) {
            PrintFunctions.printDepartmentHeadSearch(department);
        } else {
            System.out.println("No such department id (" + departmentId+")");
        }
    }
}
