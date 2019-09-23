package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Create by Allen
 * Date: 2019/9/23
 * Time: 15:53
 */
public class FileUtil {

    /**
     * 读取文件中的内容
     * @param fileName
     * @return
     */
    public static List<String> getStrListFormList(String fileName){
        List<String> result = new ArrayList<>();
        File file = new File(fileName);
        if(!file.exists()) return null;
        String str;
        try {
            BufferedReader r = new BufferedReader(new FileReader(file));
            while ((str = r.readLine())!=null)
                result.add(str);
            r.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("读入文件失败");
        }
        return result;
    }

    /**
     * 获取指定文件夹下所有的文件名字
     */
    public static List<File> getAllFile(File dirFile){
        List<File> fileList = new ArrayList<>();
        File[] files = dirFile.listFiles();
        if(files != null){
            for(File f : files){
                if(f.isDirectory()){
                    fileList.addAll(getAllFile(f));
                }else{
                    fileList.add(f);
                }
            }
        }
        return fileList;
    }
}
