package Programme;


public class Facture {
    /*
     * Pour chaque tableau, la première dimension correspond à la facture et la deuxième à la ligne. Pour obtenir
     * la 5eme ligne de la premiere facture par exemple nous utiliserons
     * console.log (proTab[0][4]+" "+qteTab[0][4]);
     * */
    static int[][] proTab = new int[0][];
    static int[][] qteTab = new int[0][];
    /*
     * Question 4.1 : D�finir un facturier (voir sujet)
     */

    public static void main(String[] args) {


    }

    public static int nouvelleFacture() {
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("NOUVELLE FACTURE");
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println(" ");
        System.out.println("--------------------");
        System.out.println("Facture " + (proTab.length + 1));
        System.out.println("--------------------");
        System.out.println(" ");
        int temPro[][] = new int[proTab.length + 1][];
        int tempQte[][] = new int[qteTab.length + 1][];
        temPro[temPro.length - 1] = new int[0];
        for (int i = 0; i < proTab.length; i++) {

            temPro[i] = proTab[i];
            tempQte[i] = qteTab[i];


        }
        temPro[temPro.length - 1] = new int[0];
        tempQte[tempQte.length - 1] = new int[0];
        proTab = temPro;
        qteTab = tempQte;


        return proTab.length;

    }

    public static int accesFactures() {


        String fmt = "%-10s %-25s %-10s%n";

        int qteArticle = 0;
        double total = 0;
        System.out.println("-----------------------------------------------");
        System.out.printf(Menu.Couleurs.G_BLANC+fmt+Menu.Couleurs.RESET, "N° Facture ", "Nombre d'articles", "Total");
        System.out.println("-----------------------------------------------");

        for (int i = 0; i < proTab.length; i++) {
            for (int e = 0; e < qteTab[i].length; e++) {
                qteArticle += qteTab[i][e];
                double prix = Catalogue.tabPrix[proTab[i][e]];
                double articleTotal = prix * qteTab[i][e];
                total += articleTotal;


            }

            if (i % 2 == 0) {
                System.out.printf(fmt, (i + 1), qteArticle, total);

            } else {
                System.out.printf(Menu.Couleurs.CYAN + fmt + Menu.Couleurs.RESET, (i + 1), qteArticle, total);

            }
            qteArticle = 0;
            total = 0;

        }
        return proTab.length;


    }

    ;

    public static void ajouterProduit(int facture, int produit,
                                      int qte) {
        int temPro[] = new int[proTab[facture].length + 1];
        int tempQte[] = new int[qteTab[qteTab.length - 1].length + 1];


        for (int i = 0; i < proTab[facture].length; i++) {
            temPro[i] = proTab[facture][i];
            tempQte[i] = qteTab[facture][i];
        }
        temPro[temPro.length - 1] = produit;
        tempQte[tempQte.length - 1] = qte;
        proTab[facture] = temPro;
        qteTab[facture] = tempQte;
        System.out.println(Menu.Couleurs.G_VERT + "Produit ajouté" + Menu.Couleurs.RESET);
        System.out.println(" ");

        System.out.println("Souhaitez vous ajouter un autre produit à cette facture ?(O/N)");
        String rep = Terminal.lireString();
        if (rep.equals("O") || rep.equals("o")) {
            System.out.println("Veuillez entrer l'id du produit à ajouter");
            int prod = Terminal.lireInt();
            if (prod > Catalogue.tabNoms.length - 1) {
                System.out.println(" ");
                System.out.println(Menu.Couleurs.G_ROUGE + "CE PRODUIT N'EXISTE PAS" + Menu.Couleurs.RESET);
                Menu.retourMenu();
            }
            System.out.println("Veuillez entrer la quantité");
            int quanta = Terminal.lireInt();
            Programme.Facture.ajouterProduit(facture, prod, quanta);


        } else {
            Programme.Menu.retourMenu();
        }
        Programme.Menu.retourMenu();
    }


    /**
     * Affiche une facture avec son num�ro, la liste des produits (nom du
     * produit, quantit�, prix unitaire et prix total de la ligne), et le total
     * de la facture.
     *
     * @param numFacture num�ro de la facture
     */
    public static void afficherFacture(int numFacture) {
        double total = 0.0;

        try {

            System.out.println("_______________");
            System.out.println("Facture " + numFacture);
            System.out.println("_______________");
            System.out.println(" ");

            String fmt = "%-30s %-10s %-10s %-10s%n";
            System.out.println("---------------------------------------------------------------");
            System.out.printf(Menu.Couleurs.G_BLANC + fmt + Menu.Couleurs.RESET, "Article ", "Quantité", "Prix unit.", "Total art.");
            System.out.println("---------------------------------------------------------------");

            for (int i = 0; i < proTab[numFacture - 1].length; i++) {
                String produit = Catalogue.tabNoms[proTab[numFacture - 1][i]];
                int qte = qteTab[numFacture - 1][i];
                double prix = Catalogue.tabPrix[proTab[numFacture - 1][i]];
                double articleTotal = prix * qte;

                total += articleTotal;

                if (i % 2 == 0) {
                    System.out.printf(fmt, produit, qte, prix, articleTotal);

                } else {
                    System.out.printf(Menu.Couleurs.CYAN + fmt + Menu.Couleurs.RESET, produit, qte, prix, articleTotal);

                }


            }
            System.out.println("---------------------------------------------------------------");
            System.out.printf(Menu.Couleurs.G_JAUNE + fmt + Menu.Couleurs.RESET, " ", " ", "TOTAL : ", total + " Euros.");
            Programme.Menu.retourMenu();


        } catch (Exception e) {
            if (numFacture > proTab.length) {
                System.out.println(" ");
                System.out.println(Menu.Couleurs.G_ROUGE + "ERREUR : Cette facture n'existe pas " + Menu.Couleurs.RESET);
                Programme.Menu.retourMenu();

            } else {
                System.out.println("Une erreur s'est produite ");
                System.out.println(e);
                Programme.Menu.retourMenu();

            }

        }
    }

    public static void ajouterProduitPeupler(int facture, int produit,
                                             int qte) {

        int temPro[] = new int[proTab[facture].length + 1];
        int tempQte[] = new int[qteTab[qteTab.length - 1].length + 1];


        for (int i = 0; i < proTab[facture].length; i++) {
            temPro[i] = proTab[facture][i];
            tempQte[i] = qteTab[facture][i];
        }
        temPro[temPro.length - 1] = produit;
        tempQte[tempQte.length - 1] = qte;
        proTab[facture] = temPro;
        qteTab[facture] = tempQte;


    }



}


