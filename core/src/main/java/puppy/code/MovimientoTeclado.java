/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package puppy.code;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class MovimientoTeclado implements EstrategiaMovimiento {

    @Override
    public void mover(Tarro tarro, float velocidad, float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            tarro.moverIzquierda(velocidad * delta);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            tarro.moverDerecha(velocidad * delta);
        }
    }
}
