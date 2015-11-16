/*
 * To change this template, choose Tools | Templates
 * and open the template in.
 */
package matriz;

import java.util.logging.Level;
import java.util.logging.Logger;




public class matriz extends Thread
{
    public int fila;
    private static int matris[][]=new int[2][2];
    private static int matris2[][]=new int[2][2];
    private static int matris3[][]=new int[2][2];
    
    matriz(int p, String name)
    {
        super(name);
        this.fila = p;
    }
    
    
    @Override
    public void run()
    {
        int i,j,s;   
        for(i=0;i<2;i++)
        {
           synchronized(matris3)
           {
               s=0;
               for(j=0;j<2;j++)
               {
                   matris3[fila][i]=matris3[fila][i]+(matris[fila][j]*matris2[j][i]);
               }
               System.out.println("el hilo: "+getName()+" pone la s a: " +matris3[fila][i]);
           }
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(matriz.class.getName()).log(Level.SEVERE, null, ex);
            }
       }  
    }
    
    public static void main(String[] args) throws InterruptedException
    {
        int i,j=0;
        //MATRIZ 1//
        for (i=0;i<2;i++)
        {
          for (j=0;j<2;j++)
          {
              matris[i][j]=i+j;
              System.out.println(matris[i][j]);
          }		
        }

        System.out.println(" ");
        //MATRIZ 2//
       for (i=0;i<2;i++)
        {
          for (j=0;j<2;j++)
          {
            matris2[i][j]=i+j;
            System.out.println(matris2[i][j]);
          }		
        }
       
       
       
       
       
        for (i=0;i<2;i++)
        {
          for (j=0;j<2;j++)
          {
            matris3[i][j]=0;
          }		
        }

        System.out.println(" ");
        
        new matriz(0,"hilo1").start();
        new matriz(1,"hilo2").start();
        sleep(500);

        for(i=0;i<2;i++)
        {
            for(j=0;j<2;j++)
            {
                System.out.println(matris3[i][j]);
            }
        }
    }
}
