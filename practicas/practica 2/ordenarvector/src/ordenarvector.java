
import java.util.logging.Level;
import java.util.logging.Logger;


public class ordenarvector extends Thread
{
    private static int vector[]=new int[10];
    private int inicio,fin;

    ordenarvector(int inicio,int fin , String name)
    {
        super(name);
        this.inicio = inicio;
        this.fin=fin;
    }
   
    public void run()
    {
        int i,x,j;
        System.out.println(getName());
         for (i= inicio;i<=fin-1;i++)
         {
              for (j=inicio;j<=fin-1-i;j++)
              {
                   if (vector[j]>vector[j+1] )
                   {
                        x=vector[j];
                        vector[j]=vector [j+1];
                        vector[j+1]=x;
                   }
                   synchronized(vector)
                   {
                  for (int m=0;m<=9;m++)
                  {
                       System.out.print(vector[m]+" ");
                  }
                  System.out.println(getName());
                   }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ordenarvector.class.getName()).log(Level.SEVERE, null, ex);
                }
              }
          }
    }
    
    public static void main(String[] args) throws InterruptedException
    {
        int i,j=0;
        //MATRIZ 1//
        j=9;
        for (i=0;i<=9;i++)
        {
            vector[i]=j;
            j--;
        }

      for (int m=0;m<=9;m++)
      {
           System.out.print(vector[m]+" ");
      }
      System.out.println("");
        
      
      ordenarvector hilo1,hilo2;
        hilo1=new ordenarvector(0,4,"hilo1");
        hilo2=new ordenarvector(5,9,"hilo2");
        
        hilo1.start();
        sleep(500);
        hilo2.start();
       

        sleep(10000);
        int s,t,y;

        for (s=2;s<=10;s++)
        {
            for (t=0;t<=10-s;t++)
            {
                if (vector[t]>vector[t+1])
                {
                    y=vector[t];
                    vector[t]=vector [t+1];
                    vector[t+1]=y;
                }
            }
        }

        
      
      System.out.println("vector ordenado:");
      for (i=0;i<=9;i++)
      {
           System.out.print(vector[i]+" ");
      }

        
    }
}
