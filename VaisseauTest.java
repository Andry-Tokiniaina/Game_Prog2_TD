```java
package ProgGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VaisseauTest {
    private Vaisseau vaisseau;

    @BeforeEach
    void setUp() {
        vaisseau = new Vaisseau(5, 5, Direction.R); // Vaisseau au centre d'une grille 10x10
    }

    @Test
    void testDefaultConstructor() {
        vaisseau = new Vaisseau();
        assertEquals(0, vaisseau.getX(), "La coordonnée x par défaut devrait être 0");
        assertEquals(0, vaisseau.getY(), "La coordonnée y par défaut devrait être 0");
        assertNull(vaisseau.getDirection(), "La direction par défaut devrait être null");
    }

    @Test
    void testRightMovement() {
        vaisseau.Right();
        assertEquals(6, vaisseau.getX(), "Le vaisseau devrait se déplacer à droite (x+1)");
        assertEquals(5, vaisseau.getY(), "La coordonnée y ne devrait pas changer");
    }

    @Test
    void testRightMovementWrongDirection() {
        vaisseau = new Vaisseau(5, 5, Direction.L);
        vaisseau.Right();
        assertEquals(5, vaisseau.getX(), "Le vaisseau ne devrait pas bouger si la direction est incorrecte");
    }

    @Test
    void testLeftMovement() {
        vaisseau = new Vaisseau(5, 5, Direction.L);
        vaisseau.Left();
        assertEquals(4, vaisseau.getX(), "Le vaisseau devrait se déplacer à gauche (x-1)");
        assertEquals(5, vaisseau.getY(), "La coordonnée y ne devrait pas changer");
    }

    @Test
    void testUpMovement() {
        vaisseau = new Vaisseau(5, 5, Direction.U);
        vaisseau.Up();
        assertEquals(5, vaisseau.getX(), "La coordonnée x ne devrait pas changer");
        assertEquals(4, vaisseau.getY(), "Le vaisseau devrait monter (y-1)");
    }

    @Test
    void testDownMovement() {
        vaisseau = new Vaisseau(5, 5, Direction.D);
        vaisseau.Down();
        assertEquals(5, vaisseau.getX(), "La coordonnée x ne devrait pas changer");
        assertEquals(6, vaisseau.getY(), "Le vaisseau devrait descendre (y+1)");
    }

    @Test
    void testDownMovementInvalidDirection() {
        vaisseau = new Vaisseau(5, 5, Direction.U);
        vaisseau.Down();
        assertEquals(5, vaisseau.getX(), "La coordonnée x ne devrait pas changer");
        assertEquals(5, vaisseau.getY(), "La coordonnée y ne devrait pas changer si la direction est incorrecte");
    }
}
```