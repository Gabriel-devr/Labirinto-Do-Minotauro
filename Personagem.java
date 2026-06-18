import greenfoot.*;

/**
 * Classe base para personagens do jogo
 */
public class Personagem extends Actor
{
    protected int vidas = 3;
    protected boolean invencivel = false;
    protected int tempoInvencivel = 0;
    
    public void receberDano(int dano) {
        if (!invencivel) {
            vidas -= dano;
            invencivel = true;
            tempoInvencivel = 0;
            
            if (vidas <= 0) {
                morrer();
            } else {
                efeitoDano();
            }
        }
    }
    
    protected void efeitoDano() {
        // Efeito visual de dano (piscar)
        for (int i = 0; i < 6; i++) {
            setImage(new GreenfootImage(35, 35));
            Greenfoot.delay(2);
            GreenfootImage img = getImage();
            img.scale(35, 35);
            setImage(img);
            Greenfoot.delay(2);
        }
    }
    
    protected void morrer() {
        // será sobrescrita
    }
    
    public void act() {
        if (invencivel) {
            tempoInvencivel++;
            if (tempoInvencivel > 60) { // 1 segundo de invencibilidade
                invencivel = false;
            }
        }
    }
}