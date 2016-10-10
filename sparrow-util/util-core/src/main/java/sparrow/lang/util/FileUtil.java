package sparrow.lang.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Desc: sparrow
 * Author: jiangwei
 * Date: 16/10/10 09:47
 * Version:
 */
public class FileUtil {

    public static boolean existFile(String path) {
        File f = new File(path);
        if (!f.isFile()) {
            return false;
        }
        return f.exists();
    }

    public static boolean existDir(String path) {
        File f = new File(path);
        if (!f.isDirectory()) {
            return false;
        }
        return f.exists();
    }


    public static boolean exist(String path) {
        File f = new File(path);
        return f.exists();
    }

    public static String getFileExtension(String name) {
        if (StringUtil.isEmpty(name)) {
            return StringUtil.EMPTY;
        }
        int pos = name.lastIndexOf('.');
        if (pos < 0) {
            return StringUtil.EMPTY;
        }
        return name.substring(pos + 1);
    }

    public static byte[] readContent(File file) throws IOException {
        FileInputStream is = new FileInputStream(file);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        IoUtil.copy(is, bos);
        IoUtil.close(is);
        IoUtil.close(bos);
        return bos.toByteArray();
    }

    public static void writeContent(File file, InputStream is) throws IOException {
        FileOutputStream os = new FileOutputStream(file);
        IoUtil.copy(is, os);
        IoUtil.close(is);
        IoUtil.close(os);
    }

    public static void writeContent(File file, byte[] bytes) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        writeContent(file, bis);
    }

    public static void writeContent(File file, String str, String charset) throws IOException {
        if (str == null) {
            return;
        }
        writeContent(file, str.getBytes(charset));
    }

    public static void writeContent(File file, String str) throws IOException {
        if (str == null) {
            return;
        }
        writeContent(file, str.getBytes());
    }

    public static String readAsString(File file) throws IOException {
        return new String(readContent(file));
    }

    public static String readAsString(File file, String charset) throws IOException {
        return new String(readContent(file), charset);
    }
}
