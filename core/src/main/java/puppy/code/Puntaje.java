
package puppy.code;

import java.util.HashMap;

public class Puntaje {
    private static Puntaje instancia;
    private final HashMap<String, Integer> records = new HashMap<>();
    
    private Puntaje(){
    }
    
    public static Puntaje getInstancia(){
        if (instancia == null){
            instancia = new Puntaje();
        }
        
        return Puntaje.instancia;
    }
    
    public int getHigherScore(String dificultad){
        if (records.containsKey(dificultad)) {
            return records.get(dificultad);
        }
        return 0;
    }
    
    public void registrarPuntaje(int puntos, String dificultad) {
        if (puntos > getHigherScore(dificultad)) {
            records.put(dificultad, puntos);
        }
    }
}
