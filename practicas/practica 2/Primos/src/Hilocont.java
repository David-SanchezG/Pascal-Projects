
public class Hilocont extends Thread {
	Contador contador;
	int comienzo, fin;

	public Hilocont(String arg0, Contador contador, int comienzo, int fin) {
		super(arg0);
		this.contador = contador;
		this.comienzo=comienzo;
		this.fin=fin;
	}
	
    public void run()
    {
        int a, x, y;
        boolean enco=false;
        for(a=comienzo;a<=fin;a++)
        {
            if(contador.getCont(a)==0)
            {
                    x=2;
                    enco=true;
                    do{
                            if((a % x)==0)
                            {
                                    enco=false;
                            }
                            x++;
                    }while((enco==true)&&(x!=a));
                    if(x>=a)
                    {
                            try {
                            	Thread.sleep(100);
                            } catch (InterruptedException e) {
                                    // TODO Auto-generated catch block
                            	e.printStackTrace();
                            }
                            System.out.println(a);
                            contador.setCont(a, 2);
                            y=2;
                            while((a*y)<=fin)
                            {
                                    contador.setCont(a*y, 1);
                                    y++;
                            }
                    }
            }
        }
    }
	
}
