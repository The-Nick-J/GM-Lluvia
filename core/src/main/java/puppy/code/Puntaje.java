
package puppy.code;

public class Puntaje {
    private static Puntaje instancia;
    private int higherScore;
    
    private Puntaje(){
        this.higherScore = 0;
    }
    
    public static Puntaje getInstancia(){
        if (instancia == null){
            instancia = new Puntaje();
        }
        
        return Puntaje.instancia;
    }
    
    public int getHigherScore(){
        return this.higherScore;
    }
    
    public void registrarPuntaje(int puntos) {
    if (puntos > higherScore) {
        higherScore = puntos;
    }
}
}
