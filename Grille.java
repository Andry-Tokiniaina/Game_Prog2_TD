package org.example;

import java.util.*;

public class Grille {
    public int largeur;
    public int longueur;
    private Vaisseau vaisseau;

    private Set<String> objetsJ; // Positions des objets J sous forme "x:y"

    public Grille() {
        this.largeur = 5;
        this.longueur = 5;
        this.objetsJ = new HashSet<>();
        genererObjetsJ(5); // Génère 5 objets par défaut
    }

    public void setVaisseau(Vaisseau vaisseau) {
        this.vaisseau = vaisseau;
    }

    public Set<String> getObjetsJ() {
        return objetsJ;
    }

    public boolean ramasserSiPresent(int x, int y) {
        String pos = x + ":" + y;
        if (objetsJ.contains(pos)) {
            objetsJ.remove(pos);
            return true;
        }
        return false;
    }

    private void genererObjetsJ(int nombre) {
        Random rand = new Random();
        while (objetsJ.size() < nombre) {
            int x = rand.nextInt(largeur);
            int y = rand.nextInt(longueur);
            if (!(x == 0 && y == 0)) { // Évite la position initiale du vaisseau
                objetsJ.add(x + ":" + y);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < longueur; y++) {
            for (int x = 0; x < largeur; x++) {
                String pos = x + ":" + y;
                if (vaisseau != null && vaisseau.getX() == x && vaisseau.getY() == y) {
                    sb.append("V ");
                } else if (objetsJ.contains(pos)) {
                    sb.append("J ");
                } else {
                    sb.append(". ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
