package com.mygdx.game.Map;

import static com.mygdx.game.Main.BIT_BULLET;
import static com.mygdx.game.Main.BIT_ENEMY;
import static com.mygdx.game.Main.BIT_PLAYER;
import static com.mygdx.game.Main.BIT_WALL;
import static com.mygdx.game.Main.PPM;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.CircleMapObject;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.objects.PolylineMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.objects.TextureMapObject;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.ChainShape;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;

public class MapLoader{
    private static float scale;


//    public static Array<Body> buildShapes(Map map, float pixels_w, float pixels_h, World world) {
//        ppt_w = pixels_w;
//        ppt_h = pixels_h;
//        MapObjects objects = map.getLayers().get("Obstacles").getObjects();
//
//        Array<Body> bodies = new Array<Body>();
//
//        for(MapObject object : objects) {
//            if (object instanceof TextureMapObject) {
//                continue;
//            }
//            Shape shape;
//
//            if (object instanceof RectangleMapObject) {
//                shape = getRectangle((RectangleMapObject)object);
//            }
//            else if (object instanceof PolygonMapObject) {
//                shape = getPolygon((PolygonMapObject)object);
//            }
//            else if (object instanceof PolylineMapObject) {
//                shape = getPolyline((PolylineMapObject)object);
//            }
//            else if (object instanceof CircleMapObject) {
//                shape = getCircle((CircleMapObject)object);
//            }
//            else {
//                continue;
//            }
//
//            BodyDef bd = new BodyDef();
//            bd.type = BodyDef.BodyType.StaticBody;
//            Body body = world.createBody(bd);
//            body.createFixture(shape, 1);
//
//            bodies.add(body);
//
//            shape.dispose();
//        }
//        return bodies;
//    }
public static void buildShapes(MapObjects objects, World world, float scl) {
    scale = scl;

    for(MapObject object : objects) {
        if (object instanceof TextureMapObject) {
            continue;
        }
        Shape shape;

        if (object instanceof RectangleMapObject) {
            shape = getRectangle((RectangleMapObject)object);
        }
        else if (object instanceof PolygonMapObject) {
            shape = getPolygon((PolygonMapObject)object);
        }
        else if (object instanceof PolylineMapObject) {
            shape = getPolyline((PolylineMapObject)object);
        }
        else if (object instanceof CircleMapObject) {
            shape = getCircle((CircleMapObject)object);
        }
        else {
            continue;
        }

        BodyDef bd = new BodyDef();
        bd.type = BodyDef.BodyType.StaticBody;
        Body body = world.createBody(bd);


        FixtureDef fd = new FixtureDef();
        fd.shape = shape;
        fd.density = 1.0f;
        fd.filter.categoryBits = BIT_WALL;
        fd.filter.maskBits = BIT_BULLET | BIT_PLAYER | BIT_ENEMY;
        fd.filter.groupIndex = -1;
        body.createFixture(fd);
        body.setUserData("wall");
        shape.dispose();
    }
}

    private static PolygonShape getRectangle(RectangleMapObject rectangleObject) {
        Rectangle rectangle = rectangleObject.getRectangle();
        PolygonShape polygon = new PolygonShape();
        Vector2 size = new Vector2((rectangle.x + rectangle.width * 0.5f) / PPM,
                (rectangle.y + rectangle.height * 0.5f ) / PPM);
        polygon.setAsBox((rectangle.width * 0.5f * scale / PPM),
                (rectangle.height * 0.5f * scale / PPM),
                size.scl(scale),
                0.0f);
        return polygon;
    }

    private static CircleShape getCircle(CircleMapObject circleObject) {
        Circle circle = circleObject.getCircle();
        CircleShape circleShape = new CircleShape();
        circleShape.setRadius(circle.radius / PPM);
        circleShape.setPosition(new Vector2(circle.x / PPM, circle.y / PPM));
        return circleShape;
    }

    private static PolygonShape getPolygon(PolygonMapObject polygonObject) {
        PolygonShape polygon = new PolygonShape();
        float[] vertices = polygonObject.getPolygon().getTransformedVertices();

        float[] worldVertices = new float[vertices.length];

        for (int i = 0; i < vertices.length; i++) {
            worldVertices[i] = vertices[i] / PPM;
        }

        polygon.set(worldVertices);
        return polygon;
    }

    private static ChainShape getPolyline(PolylineMapObject polylineObject) {
        float[] vertices = polylineObject.getPolyline().getTransformedVertices();
        Vector2[] worldVertices = new Vector2[vertices.length / 2];

        for (int i = 0; i < vertices.length / 2; i++) {
            worldVertices[i] = new Vector2();
            worldVertices[i].x = vertices[i * 2] / PPM;
            worldVertices[i].y = vertices[i * 2 + 1] / PPM;
        }

        ChainShape chain = new ChainShape();
        chain.createChain(worldVertices);
        return chain;
    }
}