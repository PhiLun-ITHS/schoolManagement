package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Course implements Serializable { 

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer classId;

    @Basic
    private String name;

    @Basic
    private double credits;

    @ManyToOne(targetEntity = Department.class)
    private Department department;

    @OneToMany(targetEntity = Enrollment.class,mappedBy = "course")
    private List<Enrollment> enrollments;

    @ManyToMany(targetEntity = Teacher.class,mappedBy = "courses")
    private List<Teacher> teachers;

    public Course() {
    }

    public Course(Integer classId, String name, double credits) {
        this.classId = classId;
        this.name = name;
        this.credits = credits;
    }

    public Integer getClassId() {
        return this.classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCredits() {
        return this.credits;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }

    public Department getDepartment() {
        return this.department;
    }

    public void setDepartment(Department department) {
        if (this.department != null) {
            this.department.internalRemoveCourse(this);
        }
        this.department = department;
        if (department != null) {
            department.internalAddCourse(this);
        }
    }

    public List<Enrollment> getEnrollments() {
        return this.enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    public void addEnrollment(Enrollment enrollment) {
        enrollment.setCourse(this);
    }

    public void removeEnrollment(Enrollment enrollment) {
        enrollment.setCourse(null);
    }

    public void internalAddEnrollment(Enrollment enrollment) {
        enrollments.add(enrollment);
    }

    public void internalRemoveEnrollment(Enrollment enrollment) {
        enrollments.remove(enrollment);
    }

    public List<Teacher> getTeachers() {
        return this.teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public void addTeacher(Teacher teacher) {
        teacher.addCourse(this);
    }

    public void removeTeacher(Teacher teacher) {
        teacher.removeCourse(this);
    }

    public void internalAddTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void internalRemoveTeacher(Teacher teacher) {
        teachers.remove(teacher);
    }

}
