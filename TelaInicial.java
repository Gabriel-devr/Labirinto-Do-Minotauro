import greenfoot.*;

public class TelaInicial extends World
{
    public TelaInicial()
    {
        super(800, 500, 1);

        GreenfootImage fundo = new GreenfootImage("FundoInicio.png");
        fundo.scale(800, 500);
        setBackground(fundo);

        showText("LABIRINTO DO MINOTAURO", 600, 180);
        showText("Pressione ENTER para jogar", 600, 200);
        
        try {
            Greenfoot.playSound("click.wav");
        } catch(Exception e) {}
    
        
    }

    public void act()
    {
        if (Greenfoot.isKeyDown("enter")) {
            Greenfoot.setWorld(new LabirintoFase1());
        }
        
        

        if (Greenfoot.isKeyDown("enter")) {
            try {
                Greenfoot.playSound("Return.wav");
            } catch(Exception e) {}
            
            Greenfoot.setWorld(new LabirintoFase1());
        
        }
    }
}
