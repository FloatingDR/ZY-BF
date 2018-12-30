package cafuc.flyeat.zy.model;

import lombok.Data;

import java.util.List;

@Data
public class Student {
    private Integer studentId;

    private String studentName;

    private String studentNumber;

    private String nation;

    private String pob;

    private String reward;

    private String phone;

    private String status;

    private String computer;

    private String sfzNumber;

    private String email;

    private String schoolRoll;

    private Boolean isChangeMajor;

    private Boolean isUnableFly;

    private Boolean isFromJunior;

    private Boolean isLoan;

    private String elseReward;

    private String secret;

    private String parentPhone1;

    private String parentPhone2;

    private String skill;

    private String birthday;

    private Boolean male;

    private Boolean cpc;

    private String punishment;

    private String dormitory;

    private Integer collegeId;

    private Integer majorId;

    private Integer companyId;

    private Major major;

    private College college;

    private StuClass commonClass;

    private Cet cet;

    private User user;

    private Company company;

    private StudentPaper studentPaper;

    private List<StudentClassLink> studentClassLinks;
}