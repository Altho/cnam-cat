package Programme;


public class Catalogue {
    static String[] tabNoms = {"Stylo bleu", "Stylo rouge",
            "Cahier petit format", "Cahier grand format", "Gomme", "Regle", "Agrafeuse", "Imprimante", "Papier A4", "Edriseur"};
    static double[] tabPrix = {1.2, 1.25, 2.00, 3.00, 1.25, 2.50, 8, 129.99, 4.50, 999};

    public static void main(String[] args) {

    }

    /**
     * retourne le nom du produit de num�ro numProduit.
     *
     * @param numProduit le num�ro du produit
     * @return le nom du produit
     */
    public static String getNom(int numProduit) {

        return tabNoms[numProduit];
    }

    /**
     * retourne le prix du produit de num�ro numProduit.
     *
     * @param numProduit le num�ro du produit
     * @return le prix du produit
     */
    public static double getPrix(int numProduit) {

        return tabPrix[numProduit];
    }

    /**
     * affiche le catalogue � l'�cran.
     */
    public static void afficher() {
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("Catalogue :");
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("----------");
        String fmt = "%-30s %-10s %-10s%n";
        System.out.println("---------------------------------------------");

        System.out.printf(Menu.Couleurs.G_BLANC + fmt, "Article ", "Prix", "ID." + Menu.Couleurs.RESET);
        System.out.println("---------------------------------------------");


        for (int i = 0; i < tabNoms.length; i++) {

            String nom = getNom(i);
            Double prix = getPrix(i);
            System.out.printf(fmt, nom, prix, i);


        }
        System.out.println("---------------------------------------------");
        Programme.Menu.retourMenu();
        ;
    }

    /**
     * La m�thode <code>ajouter(String nom, double prix)</code> doit permettre
     * d'ajouter un nouveau produit � la structure de donn�es. Il faudra cr�er
     * deux tableaux, un pour les noms et un pour les prix avec une case de plus
     * que tabNoms et tabPrix. Puis, recopier le contenu de tabNoms et tabPrix
     * dans les nouveaux tableaux. Ensuite, il faudra ajouter le nom et le prix
     * du produit dans les derni�res cases des deux nouveaux tableaux. Enfin, il
     * faudra que tabNoms et tabPrix d�signent ces nouveaux tableaux.
     *
     * @param nom  le nom du nouveau produit
     * @param prix le prix du nouveau produit
     */
    public static void ajouter(String nom, double prix) {

        String[] nomTemp = new String[tabNoms.length + 1];
        double[] prixTemp = new double[tabPrix.length + 1];
        for (int i = 0; i < tabNoms.length; i++) {
            nomTemp[i] = tabNoms[i];
            prixTemp[i] = tabPrix[i];

        }
        nomTemp[tabNoms.length] = nom;
        prixTemp[tabNoms.length] = prix;
        tabNoms = nomTemp;
        tabPrix = prixTemp;

        System.out.println(Menu.Couleurs.G_VERT + "Article ajouté avec succès. " + Menu.Couleurs.RESET);


    }

    /**
     * cherche dans le catalogue le produit dont le nom est pass� en param�tre
     * et retourne son num�ro. Si le produit n'est pas trouv�, la m�thode
     * retournera -1.
     * <p>
     * Pour savoir si le nom du produit num�ro i est �gal au nom cherch�,
     * n'utilisez pas == mais, plut�t, l'expression nom.equals(tabNoms[i]) qui
     * retourne true si les deux textes sont identiques ou false dans le cas
     * contraire.
     *
     * @param nom le nom du produit cherch�
     * @return le num�ro du produit dans le catalogue si le produit est pr�sent
     * sinon -1.
     */
    public static int chercher(String nom) {
        for (int i = 0; i < tabNoms.length; i++) {
            if (nom.equals(tabNoms[i].toUpperCase())) {
                return i;
            }


        }
        return -1;
    }
}
