
package hilos;

import java.util.logging.Level;
import java.util.logging.Logger;

public class sumalista extends Thread
{
    public static int suma=0, comienzo, fin;
    private static int matris[]=new int[20];
    
    
    sumalista(int p,int u,String name)
    {
        super(name);
        comienzo = p;
        fin=u;     
    }
    
    
    public void run()
    {
        int i;

         for(i=comienzo;i<=fin;i++)
        {
               synchronized(matris)
               {
                suma=suma+matris[i];
                System.out.println(getName()+ "  pone el contador a :"+suma);
               }
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(sumalista.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
    }
    
    public static void main(String[] args)
    {
        int i=0;
        while(i<20)
        {
            matris[i]=1;
            i++;
        }
        new sumalista(0,9,"hilo1").start();
        new sumalista(10,19,"hilo2").start();
        

    }
    
}