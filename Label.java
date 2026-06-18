import greenfoot.*;

/**
 * Classe simples para mostrar textos na tela
 */
public class Label extends Actor
{
    private int tempoVida;
    
    public Label(String texto, int tamanho) {
        tempoVida = 0;
        GreenfootImage img = new GreenfootImage(texto, tamanho, Color.WHITE, new Color(0, 0, 0, 160));
        setImage(img);
    }
    
    public void act() {
        tempoVida++;
        if (tempoVida > 60) {
            getWorld().removeObject(this);
        }
    }
}