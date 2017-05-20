package djj.util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by mesmers on 2017/4/18.
 */
public class FileReadUtil {

    public static String getFileContent(File file){
        FileReader r  = null;
        try {
            r = new FileReader(file);
            String l = "";
            char[] data = new char[1024];
            int len;
            while ((len=r.read(data))!=-1){
                l+=new String(data,0,len);
            }
            return l;
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (r!=null)
                try {
                    r.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return "";
    }

}
