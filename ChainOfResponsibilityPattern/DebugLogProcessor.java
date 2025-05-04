package ChainOfResponsibilityPattern;

public class DebugLogProcessor extends LogProcessor{

    DebugLogProcessor(LogProcessor nextLogProcessor){
        super(nextLogProcessor);
    }

    public void log(int loglevel,String message){
        if(loglevel==DEBUG){
            System.out.println("DEBUG : " + message);
        }else{
            super.log(loglevel,message);
        }
    }
}
