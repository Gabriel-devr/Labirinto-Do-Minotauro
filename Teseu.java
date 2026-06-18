import greenfoot.*;

/**
 * Teseu - Personagem principal controlado pelo jogador
 */
public class Teseu extends Personagem
{
    private int velocidade = 1;
    private boolean tomouDano = false;
    private int contadorDano = 0;
    
    public Teseu() 
    {
        GreenfootImage imagem = getImage();
        imagem.scale(35, 35);
        setImage(imagem);
    }
    
    public void act()
    {
        super.act(); // Chama o método da classe pai para invencibilidade
        checarTeclado();
        verificarTransicaoFase();
        
        if (tomouDano) {
            contadorDano++;
        if (contadorDano > 60) {
            tomouDano = false;
            contadorDano = 0;
        }
}
    }
    
    private void verificarTransicaoFase() {
        World mundo = getWorld();
        
        if (mundo instanceof LabirintoFase1) {
            if (getX() == 19 && getY() == 13) {  
                LabirintoFase1 fase1 = (LabirintoFase1) mundo;
                fase1.avancarParaFase2(this);
            }
        }
        
        else if (mundo instanceof LabirintoFase2) {
            if (getX() == 24 && getY() == 19) {  
                LabirintoFase2 fase2 = (LabirintoFase2) mundo;
                //fase2.avancarParaFase3(this);
            }
        }
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
            
            // Se após o movimento ele tocar numa Parede, volta
            if (isTouching(Parede.class)) {
                setLocation(antigoX, antigoY);
            }
            
            // Se encontrar o Minotauro, perde uma vida
           if (isTouching(Minotauro.class) && !tomouDano) {
                vidas--;
                tomouDano = true;
                
                if (vidas <= 0) {
                    morrer();  // Volta para tela inicial
                } else {
                    voltarInicio();
                    mostrarMensagem("Vidas restantes: " + vidas);
                }
            }
        }
    }
    
    private void voltarInicio() {
        if (getWorld() instanceof LabirintoFase1) {
            setLocation(1, 1);
        } else if (getWorld() instanceof LabirintoFase2) {
            setLocation(1, 1);
        }
    }
    
    @Override
    protected void morrer() {
        
        try {
            Greenfoot.playSound("GameOver.wav");
        } catch(Exception e) {}

        mostrarMensagem("GAME OVER!");
        Greenfoot.delay(80);
        Greenfoot.setWorld(new TelaInicial());
        
        
    }
    
    public int getVidas() {
        return vidas;
    }
    
    private void mostrarMensagem(String texto) {
        Label label = new Label(texto, 30);
        getWorld().addObject(label, getWorld().getWidth() / 2, getWorld().getHeight() / 2);
    }
}