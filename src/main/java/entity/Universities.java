package entity;

import jakarta.persistence.*;


@Entity
@Table(name = "university-rank")
public class Universities {

    @Id //Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Генерация pk самой бд
    private Long id;
    @Column(name="university_name",nullable = false, unique = true)
    private String university_name;
    @Column(name = "university_age",nullable = true)
    private String age;
    @Column(nullable = true)
    private String how_many_students;
    @Column(nullable = true)
    private String teacher_rating;
    @Column(name = "university_rating",nullable = true)
    private String uni_rating;

    public Universities(){}

    public Universities(String university_name, String age, String how_many_students, String teacher_rating, String uni_rating) {
        this.university_name = university_name;
        this.age = age;
        this.how_many_students = how_many_students;
        this.teacher_rating = teacher_rating;
        this.uni_rating = uni_rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUniversity_name() {
        return university_name;
    }

    public void setUniversity_name(String university_name) {
        this.university_name = university_name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHow_many_students() {
        return how_many_students;
    }

    public void setHow_many_students(String how_many_students) {
        this.how_many_students = how_many_students;
    }

    public String getTeacher_rating() {
        return teacher_rating;
    }

    public void setTeacher_rating(String teacher_rating) {
        this.teacher_rating = teacher_rating;
    }

    public String getUni_rating() {
        return uni_rating;
    }

    public void setUni_rating(String uni_rating) {
        this.uni_rating = uni_rating;
    }

    @Override
    public String toString() {
        return university_name;
    }
}
