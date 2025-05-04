package ChainOfResponsibilityPattern;

public abstract class LogProcessor {
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    LogProcessor nextLoggerProcessor;

    LogProcessor(LogProcessor loggerProcessor){
        this.nextLoggerProcessor = loggerProcessor;
    }

    public void log(int loglevel,String message){
        System.out.println("inside logProcessor log with : " + loglevel + " " + message);
        if(nextLoggerProcessor!=null){
            nextLoggerProcessor.log(loglevel,message);
        }
    }
}
