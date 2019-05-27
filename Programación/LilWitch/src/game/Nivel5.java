package game;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import logic.*;
import org.newdawn.slick.geom.*;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;


/**
 *
 * @author alvar
 */
public class Nivel5 extends BasicGameState{
    private Input entrada;
    private Jugador player;
    private SpriteSheet mapa;
    private ArrayList<Sala> salas;
    private int salaActual = 1;
    private ControladorProyectiles proyectiles;
    private String[] options = new String[] {"Volver al juego","Volver al inicio"};
    private int selected;
    private boolean paused = false;
    private Image image;
    
    @Override
    public int getID() {
        return 7;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        proyectiles = new ControladorProyectiles();
        salas = new ArrayList<>();
        entrada = container.getInput();
        player = new Jugador(proyectiles);
        mapa = new SpriteSheet("resources/niveles/Nivel 5_v1.png", 1920, 1080);
        image = new Image("resources/intro/fondo_5.png");
        Wall limites_1 = new Wall(new float[]{100, 100, 100, 860, 840, 860, 840, 960, 1080, 960, 1080, 860, 1820, 860, 1820, 600, 1920, 600, 1920, 360, 1820, 360, 1820, 100});
        Wall limites_2 = new Wall(new float[]{100, 100, 100, 360, 0, 360, 0, 600, 100, 600, 100, 860, 1820, 860, 1820, 600, 1920, 600, 1920, 360, 1820, 360, 1820, 100, 1080, 100, 1080, 0, 840, 0, 840, 100});
        Wall limites_3 = new Wall(new float[]{100, 100, 100, 360, 0, 360, 0, 600, 100, 600, 100, 860, 1820, 860, 1820, 100});
        Wall limites_4 = new Wall(new float[]{100, 100, 100, 860, 840, 860, 840, 960, 1080, 960, 1080, 860, 1820, 860, 1820, 100});
        Wall oscuridad1_1 = new Wall(new float[]{360, 100, 360, 240, 240, 240, 240, 360, 100, 360});
        Wall oscuridad1_2 = new Wall(new float[]{100, 600, 240, 600, 240, 720, 360, 720, 360, 860, 100, 860});
        Wall oscuridad1_3 = new Wall(new float[]{1560, 860, 1560, 720, 1680, 720, 1680, 600, 1820, 600, 1820, 860});
        Wall oscuridad1_4 = new Wall(new float[]{1560, 100, 1560, 240, 1680, 240, 1680, 360, 1820, 360, 1820, 100});
        Wall oscuridad2_1 = new Wall(new float[]{360, 100, 360, 240, 240, 240, 240, 360, 100, 360});
        Wall oscuridad2_2 = new Wall(new float[]{100, 600, 240, 600, 240, 720, 360, 720, 360, 860, 100, 860});
        Wall oscuridad2_3 = new Wall(new float[]{1560, 860, 1560, 720, 1680, 720, 1680, 600, 1820, 600, 1820, 860});
        Wall oscuridad2_4 = new Wall(new float[]{1560, 100, 1560, 240, 1680, 240, 1680, 360, 1820, 360, 1820, 100});
        Wall oscuridad2_5 = new Wall(new float[]{840, 360, 840, 480, 720, 480, 720, 600, 840, 600, 840, 720, 1080, 720, 1080, 600, 1200, 600, 1200, 480, 1080, 480, 1080, 360});
        Wall oscuridad3_1 = new Wall(new float[]{100, 600, 240, 600, 240, 720, 360, 720, 360, 840});
        Wall oscuridad3_2 = new Wall(new float[]{600, 240, 600, 360, 480, 360, 480, 480, 600, 480, 600, 600, 720, 600, 720, 480, 840, 480, 840, 360, 720, 360, 720, 240});
        Wall oscuridad3_3 = new Wall(new float[]{1320, 100, 1320, 240, 1560, 240, 1560, 360, 1680, 360, 1680, 480, 1820, 480, 1820, 100 });
        Wall oscuridad3_4 = new Wall(new float[]{1200, 840,1200, 720, 1080, 720, 1080, 600, 1200, 600, 1200, 480, 1320, 480, 1320, 600, 1440, 600, 1440, 720, 1320, 720, 1320, 840});
        Wall oscuridad4_1 = new Wall(new float[]{840, 360, 840, 600, 1080, 600, 1080, 360});
        //Wall oscuridad4_2 = new Wall(new float[]{});
        //Wall oscuridad4_3 = new Wall(new float[]{});
        //Wall oscuridad4_4 = new Wall(new float[]{});
        //Wall oscuridad4_5 = new Wall(new float[]{});
        Puerta p11 = new Puerta(1915, 360, 5, 240, 1, 2, 0);
        Puerta p21 = new Puerta(1915, 360, 5, 240, 1, 3, 0);
        Puerta p22 = new Puerta(0, 360, 5, 240, 3, 1, 0);
        Puerta p31 = new Puerta(0, 360, 5, 240, 3, 2, 0);
        Puerta p23 = new Puerta(840, 0, 240, 5, 0, 4, 0);
        
        
        ArrayList<Wall> walls1 = new ArrayList<>();
        walls1.add(limites_1);
        walls1.add(oscuridad1_1);
        walls1.add(oscuridad1_2);
        walls1.add(oscuridad1_3);
        walls1.add(oscuridad1_4);
        ArrayList<Puerta> puertas1 = new ArrayList<>();
        puertas1.add(p11);
        
        ArrayList<Wall> walls2 = new ArrayList<>();
        walls2.add(limites_2);
        walls2.add(oscuridad2_1);
        walls2.add(oscuridad2_2);
        walls2.add(oscuridad2_3);
        walls2.add(oscuridad2_4);
        walls2.add(oscuridad2_5);
        ArrayList<Puerta> puertas2 = new ArrayList<>();
        puertas2.add(p21);
        puertas2.add(p22);
        puertas2.add(p23);
        
        ArrayList<Wall> walls3 = new ArrayList<>();
        walls3.add(limites_3);
        walls3.add(oscuridad3_1);
        walls3.add(oscuridad3_2);
        walls3.add(oscuridad3_3);
        walls3.add(oscuridad3_4);
        ArrayList<Puerta> puertas3 = new ArrayList();
        puertas3.add(p31);
        
        ArrayList<Wall> walls4 = new ArrayList<>();
        walls4.add(limites_4);
        walls4.add(oscuridad4_1);
        //walls4.add(oscuridad4_2);
        //walls4.add(oscuridad4_3);
        //walls4.add(oscuridad4_4);
        //walls4.add(oscuridad4_5);
        
        ArrayList<Puerta> puertas4 = new ArrayList(); 
        
        Sala sala1 = new Sala(mapa.getSubImage(0, 1), walls1, puertas1, null, player, proyectiles);
        Sala sala2 = new Sala(mapa.getSubImage(1, 1), walls2, puertas2, null, player, proyectiles);
        Sala sala3 = new Sala(mapa.getSubImage(2, 1), walls3, puertas3, null, player, proyectiles);
        Sala sala4 = new Sala(mapa.getSubImage(1, 0), walls4, puertas4, null, player, proyectiles);
        salas.add(sala1);
        salas.add(sala2);
        salas.add(sala3);
        salas.add(sala4);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {   
        if(container.isPaused())
        {
            g.setBackground(Color.black);
            g.drawImage(image, 0, 0);
            g.setColor(Color.white);
            g.drawString("PAUSA", 955, 400);
            g.setColor(Color.white);
            
            
            for (int i=0;i<options.length;i++) {
			g.drawString(options[i], 920, 475+(i*50));
			if (selected == i) {
				g.drawRect(890, 470+(i*50),200,30);
			}
		}
        }else{
        salas.get(salaActual-1).draw(g, entrada);
        }
        
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        int n = salas.get(salaActual-1).update(entrada, delta);
        System.out.println(n);
        if(n!=0) salaActual = n;
        if(container.getInput().isKeyPressed(Input.KEY_ESCAPE))
        {
            container.setPaused(!container.isPaused());
            paused=!paused;
            }
         if(container.isPaused())
        {
            if(container.getInput().isKeyPressed(Input.KEY_ENTER)){
            switch(selected) {
                case 0:
                    container.setPaused(!container.isPaused());
                    paused=!paused;
                    break;
                case 1:
                    game.enterState(2);
                    break;
                }
            }   
        }
    }
    @Override
    public void keyReleased(int key, char c) {
        if(paused)
        {
		if (key == Input.KEY_DOWN) {
			selected++;
			if (selected >= options.length) {
				selected = 0;
			}
		}
		if (key == Input.KEY_UP) {
			selected--;
			if (selected < 0) {
				selected = options.length - 1;
			}
		}
        }
	} 
    
    
}
