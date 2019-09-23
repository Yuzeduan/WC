package service;

/**
 * Create by Allen
 * Date: 2019/9/23
 * Time: 16:17
 */

import data.WCConstant;
import data.WCDataProvider;
import util.FileUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 命令行模式下的中间逻辑处理类
 */
public class CommandLineService extends BaseService{
    private static volatile BaseService INSTANCE;
    private CommandLineService(){}

    public static BaseService getINSTANCE(){
        if(INSTANCE == null){
            synchronized (CommandLineService.class){
                if (INSTANCE == null){
                    INSTANCE = new CommandLineService();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public void handleRequest(String[] strs) {
        if (strs.length == 2) handleSimpleRequest(strs);
        else if(strs.length == 3) handleComplexRequest(strs);
        else System.out.println("参数输入有误，请检查参数的输入");
    }

    private void handleComplexRequest(String[] strs) {
        String param1 = strs[1];
        String param2 = strs[2];
        param2 = param2.replace("*", ".*").replace("?", ".?");
        List<String> fileName = selectFile(param2);
        for(String str: fileName) {
            System.out.println(str);
            handleSimpleRequest(new String[]{param1, str});
        }
    }

    private List<String> selectFile(String str) {
        //该功能实现的参数目前是当前目录，遍历获取的是当前目录的所有子文件，如果其他文件夹，需要再命令行
        // 传参多个文件夹名字
        List<String> fileName = new ArrayList<>();
        File file = new File(".");
        List<File> files = FileUtil.getAllFile(file);
        for(File file1 : files){
            if(file1.getName().matches(str)) fileName.add(file1.getPath());
        }
        return fileName;
    }

    private void handleSimpleRequest(String[] strs) {
        WCDataProvider provider = new WCDataProvider(FileUtil.getStrListFormList(strs[1]));
        switch (strs[0]){
            case WCConstant.RESULT_CHAR:
                System.out.println("文件字符数:"+provider.getCharNum());
                break;
            case WCConstant.RESULT_WORD:
                System.out.println("文件单词数:"+provider.getWordNum());
                break;
            case WCConstant.RESULT_LINE:
                System.out.println("文件行数:"+provider.getLine());
                break;
            case WCConstant.RESULT_COMPLEX:
                List<Long> list = provider.getCodeFileLine();
                System.out.println("文件代码行:"+list.get(0));
                System.out.println("文件空行:"+list.get(1));
                System.out.println("文件注释行:"+list.get(2));
                break;
            default:System.out.println("参数输入有误，请检查参数的输入");
        }
    }
}
