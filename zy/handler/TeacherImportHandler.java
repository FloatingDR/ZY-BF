package cafuc.flyeat.zy.handler;

import cafuc.flyeat.zy.bean.ResponseBean;

import java.io.IOException;

public interface TeacherImportHandler {

    ResponseBean importWTeacher(String filename) throws IOException;
}
