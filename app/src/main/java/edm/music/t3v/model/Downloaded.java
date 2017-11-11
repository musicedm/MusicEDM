package edm.music.t3v.model;

/**
 * Created by Hoàng Thông on 7/11/2017.
 */
public class Downloaded {
    public String FileName;
    public Downloaded() {
    }
    public Downloaded(String fileName) {
        FileName = fileName;
    }

    public String getFileName() {
        return FileName;
    }

    public void setFileName(String fileName) {
        FileName = fileName;
    }
}
