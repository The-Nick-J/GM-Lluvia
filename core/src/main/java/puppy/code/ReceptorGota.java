package puppy.code;

import com.badlogic.gdx.math.Rectangle;

public interface ReceptorGota {
    boolean colisionaCon(Rectangle area);
    void sumarPuntos(int puntos);
    void dañar();
}