import greenfoot.*;

//Teseu - Personagem principal controlado pelo jogador

public class Teseu extends Actor
{
    private static int vidas = 3; 
    private int velocidade = 1;
    
    public Teseu() //Personaliza Teseu
    {
        GreenfootImage imagem = new GreenfootImage("Teseu.png");
        imagem.scale(35, 35);
        setImage(imagem);
    }
    
    public void act()
    {
        checarTeclado(); 
        verificarTransicaoFase(); 
        verificarColisao(); 
    }
    
    private void verificarColisao(){ //Implementa sistema de vidas monitorando colisões de Teseu com o Minotauro
        if (isTouching(Minotauro.class)){
                vidas--;
            try {
            Greenfoot.playSound("Damage.wav");
            } catch(Exception e) {}

            if (vidas <= 0) {
                this.morrer();  
            } else {
                voltarInicio(); 
                mostrarMensagem("Vidas restantes: " + vidas);
                }
        };
    
    };   
        
    private void verificarTransicaoFase() { // Monitora a transicão de fases
        World mundo = getWorld();
        
        if (mundo instanceof Labirinto1) {
            if (getX() == 19 && getY() == 13) {  
                Labirinto1 fase1 = (Labirinto1) mundo;
                fase1.avancarParaFase2(this);
            }
        }
        
        else if (mundo instanceof Labirinto2) {
            if (getX() == 24 && getY() == 18) {  
                Labirinto2 fase2 = (Labirinto2) mundo;
                fase2.avancarParaFase3(this);
            }
        }
        else if (mundo instanceof Labirinto3){
            if(getX() == 24 && getY() == 18){
                Labirinto3 fase3 = (Labirinto3) mundo;
                fase3.vencerJogo(this);
            }
        }
    }
    
    private void checarTeclado() { // Verifica o teclado para movimentar Teseu
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
           
        }
    }
    
    private void voltarInicio() { //Posiciona o jogador na coordenada inicial dos labirintos (1,1)
        setLocation(1, 1);
    }
    
    public static void resetarVidas() { //Reseta as vidas do jogador para 3
        vidas = 3;
    }
    
    private void morrer() { //Oraniza a lógica para quando o jogador morrer no jogo: informa na tela, reseta as vidas, retoma pra tela incial
        World mundoAtual = getWorld();
        
        if (mundoAtual instanceof FasesBase) {
            ((FasesBase) mundoAtual).pararMusica();
        }
        
        try {
            Greenfoot.playSound("GameOver.wav");
        } catch(Exception e) {}

        mostrarMensagem("GAME OVER!");
        Greenfoot.delay(80);
        resetarVidas();
        Greenfoot.setWorld(new TelaInicial());
    }
    
    private void mostrarMensagem(String texto) {
        Label label = new Label(texto, 30);
        getWorld().addObject(label, getWorld().getWidth() / 2, getWorld().getHeight() / 2);
    }
}