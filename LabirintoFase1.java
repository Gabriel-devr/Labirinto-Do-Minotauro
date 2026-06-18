import greenfoot.*;

public class LabirintoFase1 extends World
{
   private int[][] mapa = {
    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
    {1, 2, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
    {1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1},
    {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1},
    {1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1},
    {1, 0, 1, 0, 0, 3, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1},  // Minotauro na área aberta (5,5)
    {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1},
    {1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1},
    {1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1},
    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1},
    {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1},
    {1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1},
    {1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1},
    {1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},  // SAÍDA
    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };
    
    public LabirintoFase1()
    {    
        super(20, 15, 40); 
        gerarCenario();
    }
    
    private void gerarCenario() {
        for (int linha = 0; linha < mapa.length; linha++){
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
    
    public void avancarParaFase2(Teseu teseu) {
        try {
            Greenfoot.playSound("NextFase.wav");
        } catch(Exception e) {}
            
        mostrarMensagem("Fase 1 Completa! Entrando na Fase 2...");
        Greenfoot.delay(60);
        
        LabirintoFase2 fase2 = new LabirintoFase2();
        Greenfoot.setWorld(fase2);
    }
    
    private void mostrarMensagem(String texto) {
        Label label = new Label(texto, 24);
        addObject(label, getWidth() / 2, getHeight() / 2);
    }
}