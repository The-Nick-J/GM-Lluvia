
package puppy.code;

public class Puntaje {
    private static Puntaje instancia;
    private int higherScoreFacil;
    private int higherScoreDificil;
    
    private Puntaje(){
        this.higherScoreFacil = 0;
        this.higherScoreDificil = 0;
    }
    
    public static Puntaje getInstancia(){
        if (instancia == null){
            instancia = new Puntaje();
        }
        
        return Puntaje.instancia;
    }
    
    public int getHigherScore(boolean modoDificil){
        if (modoDificil) {
            return this.higherScoreDificil;
        }
        return this.higherScoreFacil;
    }
    
    public void registrarPuntaje(int puntos, boolean modoDificil) {
        if (modoDificil) {
            if (puntos > higherScoreDificil) {
                higherScoreDificil = puntos;
            }
        } else {
            if (puntos > higherScoreFacil) {
                higherScoreFacil = puntos;
            }
        }
    }
}
