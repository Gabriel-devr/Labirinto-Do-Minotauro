import greenfoot.*;

//Classe mãe das fases do jogo. Define os métodos e atributos que serão utilizados em todas as fases do jogo.
 
public class FasesBase extends World 
{
    protected GreenfootSound backgroundMusic;

    public FasesBase(int largura, int altura, int tamanhoCelula, String imagemFundo, String arquivoMusica) 
    {
        
        super(largura, altura, tamanhoCelula); 
        GreenfootImage fundo = new GreenfootImage(imagemFundo);
        fundo.scale(largura * tamanhoCelula, altura * tamanhoCelula);
        setBackground(fundo);
        
        if (arquivoMusica != null) {
            backgroundMusic = new GreenfootSound(arquivoMusica);
        }
    }
    
    public void act() 
    {
        if (backgroundMusic != null && !backgroundMusic.isPlaying()) {
            backgroundMusic.playLoop();    
        }
    }
    
    protected void gerarCenario(int[][] mapa) //Constrói o cenário baseado na matriz mapa. 
    {
        for (int linha = 0; linha < mapa.length; linha++) {
            for (int coluna = 0; coluna < mapa[linha].length; coluna++) { 
                int bloco = mapa[linha][coluna];
                
                if (bloco == 1) {
                    addObject(new Parede(), coluna, linha);
                }
                else if (bloco == 2) {
                    addObject(new Teseu(), coluna, linha);
                }
                else if (bloco == 3) {
                    addObject(new Minotauro(), coluna, linha);
                }
            }
        }
    }
    
    public void pararMusica()//Para a música do fundo. 
    {
        if (backgroundMusic != null) {
            backgroundMusic.stop();
        }
    }
    
    public void avancarParaProximaFase(World proximaFase, String textoMensagem, String arquivoSomTransicao) //Organiza a lógica para avancar de fase.
    {
        try {
            pararMusica();
            if (arquivoSomTransicao != null) {
                Greenfoot.playSound(arquivoSomTransicao);
            }
        } catch(Exception e) {}
            
        mostrarMensagem(textoMensagem);
        Greenfoot.delay(60);
        
        Greenfoot.setWorld(proximaFase);
    }
    
    protected void mostrarMensagem(String texto) //Apresenta na tela a mensagem referente status do jogo.
    {
        Label label = new Label(texto, 24);
        addObject(label, getWidth() / 2, getHeight() / 2);
    }
}