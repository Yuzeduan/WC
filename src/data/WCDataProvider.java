package data;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Create by Allen
 * Date: 2019/9/23
 * Time: 16:51
 */
public class WCDataProvider {
    private List<String> resultList;

    public WCDataProvider(List<String> resultList){
        this.resultList = resultList;
    }

    public long getCharNum(){
        long result = 0;
        Pattern pattern = Pattern.compile("(\\w+)");
        Matcher matcher;
        for(String str: resultList){
            matcher = pattern.matcher(str);
            while (matcher.find()){
                result=matcher.group().length()+result;
            }
        }
        return result;
    }

    public long getWordNum(){
        long result = 0;
        for(String str: resultList){
            String[] splits = str.split(" ");
            for(String s : splits){
                if(s.matches(".*[0-9a-zA-Z]+.*"))
                    result++;
            }
        }
        return result;
    }

    public long getLine(){
        return resultList.size();
    }


    public List<Long> getCodeFileLine(){
        long codeLineResult = 0;
        long nullLineResult = 0;
        long annLineResult = 0;

        List<Long> result = new ArrayList<>();
        for (String str : resultList){
            if(str.startsWith("//")) annLineResult++;
            else if(str.matches(".*[0-9a-zA-Z]+.*")) codeLineResult++;
            else nullLineResult++;
        }
        result.add(codeLineResult);
        result.add(nullLineResult);
        result.add(annLineResult);
        return result;
    }
}
