import service.EngineManagerService;

/**
 * Create by Allen
 * Date: 2019/9/23
 * Time: 16:02
 */
public class MAIN {
    /**
     * wc程序的主入口处
     */
    public static void main(String[] args){
        String[] arg = new String[]{};
        EngineManagerService.getEngine(arg).handleRequest(arg);
    }
}
