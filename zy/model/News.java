package cafuc.flyeat.zy.model;

import lombok.Data;

import java.util.Date;

@Data
public class News {
    private Integer newsId;

    private Boolean newsType;

    private String newsTitle;

    private Date createTime;

    private Integer userId;

    private Boolean top;

    private String newsContent;

    private User user;
}