package br.grupointegrado.ads.flappybird;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import  com.badlogic.gdx.physics.box2d.Shape;

/**
 * Created by Joao Paulo on 05/10/2015.
 */
public class Util {

    public static  final  float ESCALA = 2;
    public static  final  float PIXEL_METRO = 32; // cada metro tem 32 pixel...
    public static final float ALTURA_CHAO = 80 /PIXEL_METRO; //altura do chao em metros, poderia ter colocado 2.5f = 80/32.



    /**
     * Cria um corpo dentro do mundo
     * @param mundo
     * @param tipo
     * @param x
     * @param y
     * @return
     */
    public static Body criarCorpo(World mundo, BodyDef.BodyType tipo, float x, float y){

        BodyDef definicao = new BodyDef();

        definicao.type = tipo;
        definicao.position.set(x, y);
        definicao.fixedRotation = true;

        Body corpo = mundo.createBody(definicao);
        return corpo;

    }

    /**
     * cria uma forma para o corpo
     *
     * @param corpo
     * @param shape Forma geometrica do corpo
     * @param nome nome utilizado para identificar na colisao
     * @return
     */
    public  static Fixture criarForma(Body corpo, Shape shape, String nome){
        FixtureDef definicao = new FixtureDef();
        definicao.density = 1; // densidade do corpo
        definicao.friction = 0.06f; //fricçao/atrito entre um corpo e outro
        definicao.restitution = 0.3f; //elasticidade do corpo
        definicao.shape = shape;

        Fixture forma = corpo.createFixture(definicao);
        forma.setUserData(nome);// identificação da forma

        return forma;

    }
}
