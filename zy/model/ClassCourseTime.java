package cafuc.flyeat.zy.model;

import lombok.Data;

@Data
public class ClassCourseTime {
    private Integer id;

    private Integer classCourseId;

    private String weekDay;

    private String classTime;

    private String classRoom;

    private ClassCourseLink classCourseLink;
}