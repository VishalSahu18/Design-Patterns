package ChainOfResponsibilityPattern;

public class InfoLogProcessor extends LogProcessor{

   InfoLogProcessor(LogProcessor nexLogProcessor){
       super(nexLogProcessor);
   }

   public void log(int loglevel,String message){

       System.out.println("inside InfologProcessor : ");
       if(loglevel==INFO){
           System.out.println("INFO : " + message);
       }else{
           super.log(loglevel,message);
       }
   }
}
