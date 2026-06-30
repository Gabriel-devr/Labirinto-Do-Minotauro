import greenfoot.*;

//Classe Narrativa organiza a narrativa introdutória do jogo.

public class TelaInicial extends World{
    
    GreenfootImage fundo = new GreenfootImage("FundoInicio.png");
    GreenfootSound backgroundMusic = new GreenfootSound("MenuInicial.wav");    
    
    public TelaInicial()
    {
        super(800, 500, 1);

        fundo.scale(800, 500);
        setBackground(fundo);
        
        
        showText("LABIRINTO DO MINOTAURO", 600, 180);
        showText("Pressione ENTER para jogar", 600, 200);
        
    }

    public void act()
    {
        backgroundMusic.playLoop();
        
        if (Greenfoot.isKeyDown("enter")) {
            try {
                backgroundMusic.stop();
                Greenfoot.playSound("Return.wav");
            } catch(Exception e) {}
            
            Greenfoot.setWorld(new Narrativa());
        
        }
    }
}
