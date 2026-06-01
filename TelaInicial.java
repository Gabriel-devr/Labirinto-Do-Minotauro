import greenfoot.*;

public class TelaInicial extends World
{
    public TelaInicial()
    {
        super(600, 400, 1);

        GreenfootImage fundo = new GreenfootImage("board.jpg");
        fundo.scale(600, 400);
        setBackground(fundo);

        showText("LABIRINTO DO MINOTAURO", 300, 150);
        showText("Pressione ENTER para jogar", 300, 250);
    }

    public void act()
    {
        if (Greenfoot.isKeyDown("enter")) {
            Greenfoot.setWorld(new LabirintoFase1());
        }
    }
}
