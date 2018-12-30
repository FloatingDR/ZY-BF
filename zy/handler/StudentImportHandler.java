package cafuc.flyeat.zy.handler;

import cafuc.flyeat.zy.bean.ResponseBean;

import java.io.IOException;

public interface StudentImportHandler {

    ResponseBean importStudent(String filename) throws IOException;
}
