
import java.util.logging.Level;
import java.util.logging.Logger;


public class testhilo {


	public static void main(String[] args) 
	{
		Contador cont = new Contador();
		int i;
		for(i=0;i<100;i++)
		{
			cont.setCont(i,0);
		}
		
		System.out.println("Los primos entre 2 y 100 son :");
		
		Hilocont hc1  = new Hilocont("primoone", cont, 2, 50);
		Hilocont hc2  = new Hilocont("primotwo", cont, 51, 99);
		
		hc1.start();
		
		hc2.start();
        try {
            Thread.sleep(2500);
        } catch (InterruptedException ex) {
            Logger.getLogger(testhilo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(i=0;i<100;i++)
        {    if(cont.getCont(i)==2)    
            {
                    System.out.print(i+" ");
            }
        }
	}

}
