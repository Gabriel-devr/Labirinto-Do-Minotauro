import greenfoot.*;

public class MyWorld extends World
{
    public MyWorld()
    {
        super(800, 500, 1);

        GreenfootImage fundo = new GreenfootImage("Background1.png");
        fundo.scale(800, 500);
        setBackground(fundo);
    }
}