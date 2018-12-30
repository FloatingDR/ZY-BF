package cafuc.flyeat.zy.model;

import lombok.Data;

import java.util.Date;

@Data
public class File {
    private Integer fileId;

    private Integer userId;

    private String fileName;

    private Date uploadTime;

    private String addr;

    private User user;
}