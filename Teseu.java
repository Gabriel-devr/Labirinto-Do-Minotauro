import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Teseu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Teseu extends Personagem
{
    private int velocidade = 1;
    
    public Teseu() 
    {
        GreenfootImage imagem = getImage();
        imagem.scale(30, 30); // Aqui eu alterei o tamanho do Teseu
        setImage(imagem);
    }

    public void act()
    {
        checarTeclado();
    }
    
    private void checarTeclado() {
        
        String tecla = Greenfoot.getKey();
        
        if (tecla != null) {
            int antigoX = getX();
            int antigoY = getY();
        
            if (Greenfoot.isKeyDown("up")) {
                setLocation(getX(), getY() - velocidade);   
            }
            else if (Greenfoot.isKeyDown("down")) {
                setLocation(getX(), getY() + velocidade);   
            }
            else if (Greenfoot.isKeyDown("left")) {
                setLocation(getX() - velocidade, getY());
            }
            else if (Greenfoot.isKeyDown("right")) {
                setLocation(getX() + velocidade, getY());
            }
            
            // Se após o movimento ele tocar numa Parede ele volta
            if (isTouching(Parede.class)) {
                setLocation(antigoX, antigoY);
            }
        }
    }
}
