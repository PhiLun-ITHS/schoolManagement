/**
 * This file was generated by the JPA Modeler
 */ 

package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author  dator
 */

@Entity
public class Department implements Serializable { 

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int departmentId;

    @Basic
    private String name;

    @OneToMany(targetEntity = Teacher.class,mappedBy = "department")
    private List<Teacher> teachers;

    @OneToMany(targetEntity = Course.class,mappedBy = "department")
    private List<Course> courses;

    @OneToMany(targetEntity = Student.class,mappedBy = "department")
    private List<Student> students;

    public int getDepartmentId() {
        return this.departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Teacher> getTeachers() {
        return this.teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Course> getCourses() {
        return this.courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

}