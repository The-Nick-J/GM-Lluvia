/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package puppy.code;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class MovimientoTactil implements EstrategiaMovimiento {

    private final OrthographicCamera camera;

    public MovimientoTactil(OrthographicCamera camera) {
        this.camera = camera;
    }

    @Override
    public void mover(Rectangle area, float velocidad, float delta) {
        if (Gdx.input.isTouched()) {
            Vector3 posicion = new Vector3(
                    Gdx.input.getX(),
                    Gdx.input.getY(),
                    0
            );

            camera.unproject(posicion);
            area.x = posicion.x - area.width / 2;
        }
    }
}
