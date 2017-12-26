package Thread;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Testes {
	static int i = 0;
    public static void main(String[] args) {
    	
    	Thread th = new Thread(new Runnable() { //cria uma thread
            public void run() {
                while(true) { //roda indefinidamente
                    Date date = Calendar.getInstance().getTime(); //pega a hora do sistema
                    DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
                    String today = formatter.format(date);      
                    System.out.println(today);
                    try {
                        Thread.sleep(1000); //espera 1 segundo para fazer a nova evolução
                    } catch(InterruptedException ex){
                        //é algo terrível a se fazer mas pelo jeito a API medonha do Java exige
                    }
                    
                }
            }
        });
        th.start();
    	
    	
    	/*new Thread(t1).start();
        new Thread(t2).start();
        
        Date date = new Date();
    	DateFormat formato = new SimpleDateFormat("HH:mm:ss");
    	String formattedDate = formato.format(date);
    	System.out.println(formattedDate);*/
    }

    private static void countMe(String name){
        i++;
        System.out.println(name);
    }

    private static Runnable t1 = new Runnable() {
        public void run() {
            try{
                for(int i=0; i<5; i++){
                    countMe("Thread 1");
                }
            } catch (Exception e){}

        }
    };

    private static Runnable t2 = new Runnable() {
        public void run() {
            try{
                for(int i=0; i<5; i++){
                    countMe("Thread 2");
                }
            } catch (Exception e){}
       }
    };
}
