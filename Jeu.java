package org.example;
import java.util.Scanner;

public class Jeu {
    public int nombreCoups;
    public int score;
    public int nombreCoupsMax;

    Grille grille = new Grille();
    Vaisseau vaisseau = new Vaisseau();

    public Jeu(int nombreCoupsMax) {
        this.nombreCoups = 0;
        this.nombreCoupsMax = nombreCoupsMax;
        this.score = 0;

        grille.setVaisseau(vaisseau);
    }

    public void lancer() {
        Scanner sc = new Scanner(System.in);

        while (this.nombreCoups < this.nombreCoupsMax) {
            System.out.println(grille);
            System.out.println("score: " + score);
            System.out.print("Coups" + nombreCoups + "/ " + nombreCoupsMax);

            String choix = sc.next().toLowerCase();
            boolean deplacementValide = false;

            switch (choix) {
                case "u":
                    if (vaisseau.y > 0) {
                        vaisseau.setDirection(Vaisseau.Direction.U);
                        vaisseau.move();
                        deplacementValide = true;
                    }
                    break;
                case "d":
                    if (vaisseau.y < grille.longueur - 1) {
                        vaisseau.setDirection(Vaisseau.Direction.D);
                        vaisseau.move();
                        deplacementValide = true;
                    }
                    break;
                case "r":
                    if (vaisseau.x < grille.largeur - 1) {
                        vaisseau.setDirection(Vaisseau.Direction.R);
                        vaisseau.move();
                        deplacementValide = true;
                    }
                    break;
                case "l":
                    if (vaisseau.x > 0) {
                        vaisseau.setDirection(Vaisseau.Direction.L);
                        vaisseau.move();
                        deplacementValide = true;
                    }
                    break;
                default:
                    System.out.println("Commande invalide. Utilise u/d/l/r.");
            }

            if (deplacementValide) {
                this.nombreCoups++;

                // Vérifie si le joueur ramasse un objet
                if (grille.ramasserSiPresent(vaisseau.getX(), vaisseau.getY())) {
                    score++;
                    System.out.println("✅ Tu as ramassé un objet !");
                }

                // Victoire ?
                if (grille.getObjetsJ().isEmpty()) {
                    System.out.println("🎉 Félicitations ! Tu as tout ramassé en " + nombreCoups + " coups !");
                    return;
                }
            }

            System.out.println();
        }

        System.out.println("💀 Partie terminée. Tu as utilisé tous tes coups.");
        System.out.println("score : " + grille.getObjetsJ().size());
    }
}
