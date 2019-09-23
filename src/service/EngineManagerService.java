package service;

/**
 * Create by Allen
 * Date: 2019/9/23
 * Time: 16:16
 */
public class EngineManagerService {

    public static BaseService getEngine(String[] args){
        if(args.length == 1) return ViewService.getINSTANCE();
        return CommandLineService.getINSTANCE();
    }
}
