package cafuc.flyeat.zy.handler;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.springframework.beans.factory.annotation.Value;

public class BaseImportHandler {
    @Value("${prop.upload-path}")
    public String UPLOAD_PATH;

    public String getCellString(XSSFRow row, int num) {
        XSSFCell cell = row.getCell(num);
        if(cell == null) {
            return null;
        }
        cell.setCellType(CellType.STRING);
        System.out.println(num);
        System.out.println(cell.getStringCellValue());
        return cell.getStringCellValue();
    }
}
