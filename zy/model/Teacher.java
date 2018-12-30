package cafuc.flyeat.zy.model;

import lombok.Data;

import java.util.Date;

@Data
public class Teacher {
    private Integer teacherId;

    private String teacherName;

    private Integer collegeId;

    private Integer staffId;

    private String nation;

    private Date arrivalDate;

    private Date birthday;

    private Boolean cpc;

    private String eduBg;

    private String reward;

    private Integer teacherType;

    private String sfzNumber;

    private String graduateSchool;

    private String graduateMajor;

    private String title;

    private String phone;

    private String email;

    private String projects;

    private String company;


    private College college;

    private Staff staff;


}