package service;

import data.WCDataProvider;
import util.FileUtil;
import view.ShowWindow;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Create by Allen
 * Date: 2019/9/23
 * Time: 16:16
 */
public class ViewService extends BaseService{
    private static volatile BaseService INSTANCE;
    private ViewService(){}

    public static BaseService getINSTANCE(){
        if(INSTANCE == null){
            synchronized (CommandLineService.class){
                if (INSTANCE == null){
                    INSTANCE = new ViewService();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public void handleRequest(String[] strs) {
        JFileChooser jfc=new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );
        jfc.showDialog(new JLabel(), "选择");
        File file = jfc.getSelectedFile();

        if(!file.isDirectory()){
            WCDataProvider provider = new WCDataProvider(FileUtil.getStrListFormList(file.getAbsolutePath()));
            List<Long> result = new ArrayList<>();
            result.add(provider.getCharNum());
            result.add(provider.getWordNum());
            result.add(provider.getLine());
            result.addAll(provider.getCodeFileLine());
            new ShowWindow(result);
        }
    }
}
