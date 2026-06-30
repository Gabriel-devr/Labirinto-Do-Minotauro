import greenfoot.*; 

//Classe Narrativa organiza a narrativa introdutória do jogo.

public class Narrativa extends World {
    private String[] frames = {
        "frame1.png", 
        "frame2.png", 
        "frame3.png"
    };
    
    private int frameAtual = 0;

    GreenfootSound backgroundMusicNarrativa = new GreenfootSound("Narrativa.wav");
    
    public Narrativa() {    
        super(800, 500, 1); 
        
        atualizarImagemDoFundo();
    }

    public void act() {
        backgroundMusicNarrativa.playLoop();
        checarAvanco();
    }

    private void checarAvanco() {//Monitora teclado atualizando os frames e quando iniciar o jogo
        String tecla = Greenfoot.getKey();
        
        if ("right".equals(tecla)) {
            frameAtual++; 
            Greenfoot.playSound("Return.wav");
            
            if (frameAtual < frames.length) {
                atualizarImagemDoFundo();
            } else {
                backgroundMusicNarrativa.stop();
                Greenfoot.setWorld(new Labirinto1());
            }
        }
    }
    
    private void atualizarImagemDoFundo() {//Seleciona a imagem da lista frames de acorda com o número do frame atual
        GreenfootImage fundo = new GreenfootImage(frames[frameAtual]);
        fundo.scale(800, 500);
        setBackground(fundo);
    }
}