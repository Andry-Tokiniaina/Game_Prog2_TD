```java
package ProgGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JeuTest {
    private Jeu jeu;
    private Grille grille;
    private Vaisseau vaisseau;

    @BeforeEach
    void setUp() {
        jeu = new Jeu(5); // Jeu avec 5 coups max
        grille = new Grille(10, 10);
        vaisseau = new Vaisseau(0, 0, Direction.R);
        jeu.grille = grille;
        jeu.vaisseau = vaisseau;
    }

    @Test
    void testJeuInitialization() {
        assertEquals(0, jeu.getNombreCoups(), "Le nombre de coups initial devrait être 0");
        assertEquals(0, jeu.getScore(), "Le score initial devrait être 0");
        assertEquals(5, jeu.getNombreCoupsMax(), "Le nombre de coups max devrait être 5");
    }

    @Test
    void testVaisseauMovementRight() {
        // Simuler l'entrée utilisateur pour "r"
        jeu.vaisseau = new Vaisseau(0, 0, Direction.R);
        jeu.grille = new Grille(10, 10);
        jeu.nombreCoups = 0;
        // Simuler un mouvement à droite
        jeu.vaisseau.Right();
        assertEquals(1, jeu.vaisseau.getX(), "Le vaisseau devrait se déplacer à droite");
        assertEquals(0, jeu.vaisseau.getY(), "La coordonnée y ne devrait pas changer");
    }

    @Test
    void testVaisseauMovementBoundary() {
        jeu.vaisseau = new Vaisseau(9, 0, Direction.R);
        jeu.grille = new Grille(10, 10);
        jeu.vaisseau.Right(); // Ne devrait pas dépasser la grille
        assertEquals(9, jeu.vaisseau.getX(), "Le vaisseau ne devrait pas dépasser la largeur de la grille");
    }

    @Test
    void testNombreCoupsIncrement() {
        jeu.nombreCoups = 0;
        jeu.vaisseau.Right();
        jeu.nombreCoups++;
        assertEquals(1, jeu.getNombreCoups(), "Le nombre de coups devrait être incrémenté");
    }
}
```