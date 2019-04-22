/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.ArrayList;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;

/**
 *
 * @author alvar
 */
public class Sala {
    private ArrayList<Wall> paredes;
    private ArrayList<Puerta> puertas;
    private GestorColision gestor;
    private Image imagen;
    private Jugador player;

    public Sala(Image imagen, ArrayList<Wall> paredes, ArrayList<Puerta> puertas, Jugador jugador) {
        this.paredes = paredes;
        this.puertas = puertas;
        this.imagen = imagen;
        this.player = jugador;
        gestor = new GestorColision();
        gestor.registrarCuerpo(jugador);
        for (int i = 0; i < paredes.size(); i++) {
            gestor.registrarCuerpo(paredes.get(i));
            
        }
        for (int j = 0; j < puertas.size(); j++) {
            gestor.registrarCuerpo(puertas.get(j));
            
        }
    }
    
    public void draw(Graphics g, Input entrada) {
        imagen.draw(0, 0);
        player.draw(entrada);
        gestor.drawHitboxes(g);
    }
    
    public int update(Input entrada) {
        player.update(entrada);
        return gestor.comprobarColisiones();
    }

    public ArrayList<Wall> getParedes() {
        return paredes;
    }

    public void setParedes(ArrayList<Wall> paredes) {
        this.paredes = paredes;
    }

    public ArrayList<Puerta> getPuertas() {
        return puertas;
    }

    public void setPuertas(ArrayList<Puerta> puertas) {
        this.puertas = puertas;
    }

    public GestorColision getGestor() {
        return gestor;
    }

    public void setGestor(GestorColision gestor) {
        this.gestor = gestor;
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    public Jugador getPlayer() {
        return player;
    }

    public void setPlayer(Jugador player) {
        this.player = player;
    }
    
}
