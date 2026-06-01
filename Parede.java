import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Parede here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Parede extends Actor
{
    //COnstrutor da parede, fiz para diminuir o tamanho e não dar problema de colisão
    public Parede() {
        GreenfootImage imagem = getImage();
        imagem.scale(40,40);
        setImage(imagem);
    }
    /**
     * Act - do whatever the Parede wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
