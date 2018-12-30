package cafuc.flyeat.zy.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseBean {
    private int code;
    private String msg;
    private Object data;                //响应体包括状态码code,msg,data
}
