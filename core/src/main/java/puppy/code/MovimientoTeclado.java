/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package puppy.code;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Rectangle;

public class MovimientoTeclado implements EstrategiaMovimiento {

    @Override
    public void mover(Rectangle area, float velocidad, float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            area.x -= velocidad * delta;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            area.x += velocidad * delta;
        }
    }
}