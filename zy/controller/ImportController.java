package cafuc.flyeat.zy.controller;

import cafuc.flyeat.zy.bean.ResponseBean;
import cafuc.flyeat.zy.handler.ScoreImportHandler;
import cafuc.flyeat.zy.handler.StudentImportHandler;
import cafuc.flyeat.zy.handler.TeacherImportHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@RestController
@RequestMapping("/import")
@CrossOrigin
public class ImportController {

    @Value("${prop.upload-path}")
    String UPLOAD_PATH;

    @Autowired
    TeacherImportHandler teacherImportHandler;

    @Autowired
    StudentImportHandler studentImportHandler;

    @Autowired
    ScoreImportHandler scoreImportHandler;

    @PostMapping("/upload")
    public ResponseBean uploadFile(MultipartFile file) {
        if (Objects.isNull(file) || file.isEmpty()) {
            return new ResponseBean(500, "empty", null);
        }

        try {
            byte[] bytes = file.getBytes();
            String filename = String.valueOf(System.currentTimeMillis()) + ".xlsx";
            Path path = Paths.get(UPLOAD_PATH + filename);
            if (!Files.isWritable(path)) {
                Files.createDirectories(Paths.get(UPLOAD_PATH));
            }
            Files.write(path, bytes);
            return new ResponseBean(200, "success", filename);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseBean(500, "error", null);
        }
    }

    @GetMapping("/wteacher/{filename}")
    public ResponseBean importWTeacher(@PathVariable String filename) throws IOException{
        return teacherImportHandler.importWTeacher(filename);
    }

    @GetMapping("/student/{filename}")
    public ResponseBean importStudent(@PathVariable String filename) throws IOException {
        return studentImportHandler.importStudent(filename);
    }

    @GetMapping("/score/{filename}")
    public ResponseBean importCourseScore(@PathVariable String filename) throws IOException {
        return scoreImportHandler.importCourseScore(filename);
    }
}
