package view;

import javax.swing.*;
import java.util.List;

/**
 * Create by Allen
 * Date: 2019/9/23
 * Time: 20:44
 */
public class ShowWindow extends JFrame {

    public ShowWindow(List<Long> result){
        JTextArea txt1=new JTextArea();
        setSize(400,300);
        setTitle("WC程序界面展示");
        txt1.setText("文件的字符数:"+result.get(0));
        txt1.append("\n");
        txt1.append("文件的单词数:"+result.get(1));
        txt1.append("\n");
        txt1.append("文件的行数:"+result.get(2));
        txt1.append("\n");
        txt1.append("文件的代码行数:"+result.get(3));
        txt1.append("\n");
        txt1.append("文件的空行数:"+result.get(4));
        txt1.append("\n");
        txt1.append("文件的注释行数:"+result.get(5));
        add(txt1);
        setLocationRelativeTo(this.getOwner());  // 设置窗口在屏幕中间
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
