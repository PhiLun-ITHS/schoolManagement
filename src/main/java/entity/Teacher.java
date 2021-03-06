package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Teacher implements Serializable { 

    @Id
    private String socialSecurity;

    @Basic
    private String name;

    @Basic
    private String gender;

    @ManyToOne(targetEntity = Department.class)
    private Department department;

    @ManyToMany(targetEntity = Course.class)
    private List<Course> courses;

    public Teacher() {
    }

    public Teacher(String socialSecurity, String name, String gender) {
        this.socialSecurity = socialSecurity;
        this.name = name;
        this.gender = gender;
    }

    public String getSocialSecurity() {
        return this.socialSecurity;
    }

    public void setSocialSecurity(String socialSecurity) {
        this.socialSecurity = socialSecurity;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Department getDepartment() {
        return this.department;
    }

    public void setDepartment(Department department) {
        if (this.department != null) {
            this.department.internalRemoveTeacher(this);
        }
        this.department = department;
        if (department != null) {
            department.internalAddTeacher(this);
        }
    }

    public List<Course> getCourses() {
        if (this.courses == null) {
            this.courses = new ArrayList<>();
        }
        return this.courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void addCourse(Course course){
        if (this.courses == null) {
            this.courses = new ArrayList<>();
        }
        if (!this.courses.contains(course)) {
            this.courses.add(course);
        }
        if (course != null) {
            course.internalAddTeacher(this);
        }
    }

    public void removeCourse(Course course) {
        getCourses().remove(course);
    }

    @Override
    public String toString() {
        return
                socialSecurity + " " +
                        name + " " +
                        gender + " " +
                        courses + " " +
                        department;
    }

    public boolean equals(Object o) {
        if (this == o ) {
            return true;
        }
        if (o instanceof Teacher) {
            if (((Teacher) o).getSocialSecurity().equals(this.socialSecurity)){
                return true;
            }
            else return false;
        }
        return false;
    }
}