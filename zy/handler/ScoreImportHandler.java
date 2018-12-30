package cafuc.flyeat.zy.handler;

import cafuc.flyeat.zy.bean.ResponseBean;

import java.io.IOException;

public interface ScoreImportHandler {
    ResponseBean importCourseScore(String filename) throws IOException;
}
