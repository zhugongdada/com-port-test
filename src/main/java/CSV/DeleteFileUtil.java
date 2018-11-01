package CSV;

import java.io.File;


public class DeleteFileUtil {
    public static boolean delete(File dirfile) {
        if (!dirfile.exists()) {
            return false;
        }
        if (dirfile.isFile()) {
            return dirfile.delete();
        } else {
            for (File file : dirfile.listFiles()) {
                delete(file);
            }
        }
        return dirfile.delete();
    }

    public static boolean deleteFile(String filename) {
        File file = new File(filename);
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                System.out.print("删除文件" + filename);
                return true;
            } else {
                System.out.print("删除文件失败" + filename);
                return false;
            }
        } else {
            System.out.print("删除文件不存在" + filename);
            return false;
        }
    }

}
