import greenfoot.*;

public class Minotauro extends Personagem
{
    private int velocidade = 1;
    private int direcaoX = 1;
    private int direcaoY = 0;
    private int contadorMovimento = 0;
    private int passo = 0;
    
    public Minotauro() {
        GreenfootImage imagem = getImage();
        imagem.scale(35, 35);
        setImage(imagem);
    }
    
    public void act() {
        passo++;
        if (passo >= 10) {
            mover();
            verificarColisaoParede();
            passo = 0;
        }
    }
    
    public void mover() {  // <-- ESTE MÉTODO ESTÁ DENTRO DA CLASSE?
        contadorMovimento++;
        
        if (contadorMovimento > 30) {
            mudarDirecao();
            contadorMovimento = 0;
        }
        
        setLocation(getX() + (direcaoX * velocidade), getY() + (direcaoY * velocidade));
    }
    
    private void mudarDirecao() {
        int rand = Greenfoot.getRandomNumber(4);
        switch(rand) {
            case 0: direcaoX = 1; direcaoY = 0; break;
            case 1: direcaoX = -1; direcaoY = 0; break;
            case 2: direcaoX = 0; direcaoY = 1; break;
            case 3: direcaoX = 0; direcaoY = -1; break;
        }
    }
    
    private void verificarColisaoParede() {
        if (isTouching(Parede.class)) {
            setLocation(getX() - (direcaoX * velocidade), getY() - (direcaoY * velocidade));
            mudarDirecao();
        }
    }
}