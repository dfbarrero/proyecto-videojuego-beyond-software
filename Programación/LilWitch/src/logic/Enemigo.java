/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import org.newdawn.slick.geom.Rectangle;
/**
 *
 * @author alvar
 */
abstract class Enemigo implements IColisionable {
    private SpriteAnimado sprite;
    private Rectangle hitbox;
    private boolean up, down, r, l, stop;
    private int vida, ataque;

    public Enemigo(SpriteAnimado sprite, Rectangle hitbox, int vida, int ataque) {
        this.sprite = sprite;
        this.hitbox = hitbox;
        this.up = false;
        this.down = false;
        this.r = false;
        this.l = false;
        this.stop = false;
        this.vida = vida;
        this.ataque = ataque;
    }

    @Override
    public Rectangle getHitbox() {
        return hitbox;
    }
    
    public void update() {
        avanzar();
        sincronizarArea();
    }
    abstract void atacar(Jugador j);
    abstract void avanzar();

    @Override
    public void alColisionar(IColisionable colision) {
        if(!colision.isGate()) {
            if(up) {
                sprite.moverY(1f);
            }
            if(down) {
                sprite.moverY(-1f);
            }
            if(r) {
                sprite.moverX(-1f);
            }
            if(l) {
                sprite.moverX(1f);
            }
        }
    }

    public SpriteAnimado getSprite() {
        return sprite;
    }

    public void setSprite(SpriteAnimado sprite) {
        this.sprite = sprite;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }
    
    @Override
    public void sincronizarArea() {
        hitbox.setX(sprite.getPosicion().getX());
        hitbox.setY(sprite.getPosicion().getY());
    }

    @Override
    public boolean isHostile() {
        return true;
    }

    @Override
    public boolean isGate() {
        return false;
    }
    
    @Override
    public boolean isPlayer() {
        return false;
    }
    
    @Override
    public int getDir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public int getSalaDestino() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
