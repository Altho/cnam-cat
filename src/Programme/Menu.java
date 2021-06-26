package Programme;

public class Menu {
    public static void main(String[] args) {
        lanceMenu();
    }


    public static void nom() {
        System.out.println("Veuillez entrer l'id de l'article à afficher");
        int id = Terminal.lireInt();
        String result = Programme.Catalogue.getNom(id);
        System.out.println("L'ID : " + id + " " + "Correspond à : " + result);
        retourMenu();

    }


    public static void menu() {
        boolean quitter = false;
        do {

            String fmt = "%-40s %-1s  %-10s%n";
            System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            System.out.println("MENU PRINCIPAL");
            System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            System.out.println(" ");
            System.out.println("---------------------------------------------------------------------------------");

            System.out.printf(Menu.Couleurs.G_BLANC + fmt + Menu.Couleurs.RESET, "Catalogue ", "|", "Facturier");

            System.out.println("---------------------------------------------------------------------------------");
            System.out.printf(fmt, "1. Consulter le catalogue ", "|", "6. Créer une nouvelle facturer");
            System.out.printf(fmt, "2. Ajouter un article au catalogue", "|", "7. Liste des facturesr");
            System.out.printf(fmt, "3. Chercher prix par ID ", "|", "8. Ajouter produit à une facture");
            System.out.printf(fmt, "4. Chercher prix par ID ", "|", "9. Consulter une facture");
            System.out.printf(fmt, "5. Chercher par nom d'articleu ", "|", " ");
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println(Couleurs.BB_BLEU + "11. EXPERIMENTAL : PEUPLER FACTURES (A FAIRE SUR FACTURIER VIDE) " + Couleurs.RESET);
            System.out.println("0. Quitter le programme ");
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println(" ");
            System.out.println(Couleurs.G_BLANC + "Veuillez entrer votre choic : " + Couleurs.RESET);
            System.out.println(" ");


            int choix = Terminal.lireInt();

            switch (choix) {
                case 1:
                    Programme.Catalogue.afficher();
                    break;
                case 2:
                    ajout();
                    break;
                case 3:
                    nom();
                    break;
                case 4:
                    prix();
                    break;
                case 5:
                    recherche();
                    break;
                case 6:
                    creerFacture();
                    break;
                case 7:
                    afficherFactures();
                    break;
                case 8:
                    ajouterLigne();
                    break;
                case 9:
                    montrerFacture();
                    break;
                case 11:
                    peupler();
                    break;
                case 0:
                    quitter = true;
                    break;


            }


        } while (quitter = false);
    }

    public static void ajouterLigne() {
        System.out.println("Veuillez entrer le numéro de facture");
        int facture = Terminal.lireInt();
        if (facture > Facture.proTab.length) {
            System.out.println(" ");
            System.out.println(Couleurs.G_ROUGE + "CETTE FACTURE N'EXISTE PAS" + Couleurs.RESET);
            retourMenu();
        }
        System.out.println("Veuillez entrer l'id du produit à ajouter");
        int produit = Terminal.lireInt();
        if (produit > Catalogue.tabNoms.length - 1) {
            System.out.println(" ");
            System.out.println(Couleurs.G_ROUGE + "CE PRODUIT N'EXISTE PAS" + Couleurs.RESET);
            retourMenu();
        }
        System.out.println("Veuillez entrer la quantité");
        int qte = Terminal.lireInt();
        Programme.Facture.ajouterProduit(facture - 1, produit, qte);

    }

    public static void afficherFactures() {
        System.out.println("---------------------");
        System.out.println("Facturier");
        System.out.println("---------------------");
        System.out.println(" ");
        Programme.Facture.accesFactures();
        retourMenu();
    }

    public static void creerFacture() {
        int factNum = Programme.Facture.nouvelleFacture();
        System.out.println(Couleurs.G_VERT + "Facture " + factNum + " créée" + Couleurs.RESET);
        retourMenu();
    }

    public static void montrerFacture() {
        System.out.println("Veuillez entrer le numéro de facture");
        int num = Terminal.lireInt();
        Programme.Facture.afficherFacture(num);
    }

    public static void prix() {
        System.out.println("Veuillez entrer l'id de l'article");
        int id = Terminal.lireInt();
        double result = Programme.Catalogue.getPrix(id);
        System.out.println("Le prix de l'article id : " + id + "(" + Programme.Catalogue.getNom(id) + ") " + "est de : " + result);
        retourMenu();
    }

    public static void retourMenu() {
        System.out.println(" ");

        System.out.println("Souhaitez vous revenir au menu ? (O/N)");
        String rep = Terminal.lireString();
        if (rep.equals("O") || rep.equals("o")) {
            menu();
        } else if (rep.equals("n") || rep.equals("N")) {
            return;
        } else {
            System.out.println(Couleurs.G_ROUGE + "Saisie non valide." + Couleurs.RESET);
            retourMenu();
        }

    }

    public static void ajout() {
        System.out.println("Nom de l'article à ajouter.");

        String nom = Terminal.lireString();
        String resultUC = nom.toUpperCase();
        int querry = Programme.Catalogue.chercher(resultUC);


        if (querry != -1) {
            System.out.println("Cet article existe déja");
            System.out.println("Saisir un autre article ?(O/N)");
            String rep = Terminal.lireString();
            if (rep.equals("O") || rep.equals("o")) {
                Menu.ajout();
                return;


            } else {
                Programme.Menu.retourMenu();
            }

        } else {
            System.out.println("Veuillez entrer le prix de l'article à ajouter");
            Double prix = Terminal.lireDouble();
            Programme.Catalogue.ajouter(nom, prix);
            retourMenu();
        }
    }

    public static void lanceMenu() {

        try {
            menu();
        } catch (Exception e) {
            System.out.println(Couleurs.G_ROUGE + "Entrée non valide" + Couleurs.RESET);
            Terminal.ecrireException(e);
            System.out.println(Couleurs.G_BLANC + "Nouvelle saisie ?(O pour valider, autre touche pour annuler)" + Couleurs.RESET);
            String rep = Terminal.lireString();
            if (rep.equals("O") || rep.equals("o")) {
                lanceMenu();
            } else {
                return;
            }

        }

    }


    public static void recherche() {
        String fmt = "%-10s %-20s %-10s%n";

        System.out.println("Veuillez entrer le nom de l'article à rechercher");
        String result = Terminal.lireString();
        String resultUC = result.toUpperCase();
        int querry = Programme.Catalogue.chercher(resultUC);
        if (querry == -1) {
            System.out.println("Aucun resultat pour : " + result);
        } else {
            System.out.println(" ");
            System.out.println(Couleurs.G_VERT + "Article trouvé ! " + result + Couleurs.RESET);
            System.out.println(" ");

            System.out.printf(Menu.Couleurs.G_BLANC + fmt + Menu.Couleurs.RESET, "ID ", "Article", "Prix");
            System.out.println("----------------------------------------");

            System.out.printf(fmt, querry, Programme.Catalogue.getNom(querry), Programme.Catalogue.getPrix(querry) + " Euros.");


        }
        retourMenu();
    }

    public static void peupler() {
        try {
            int max1 = Catalogue.tabNoms.length - 1;
            int max2 = 250;
            int min = 0;
            int minObj = 1;
            int range1 = max1 - min + 1;
            int range2 = max2 - min + 1;
            int rangeObj = max1 - minObj + 1;


            for (int i = 1; i < 24; i++) {
                int nbrObj = (int) Math.floor(Math.random() * rangeObj) + minObj;

                Facture.nouvelleFacture();
                for (int e = 0; e < nbrObj; e++) {
                    int qte = (int) Math.floor(Math.random() * range2) + min;
                    int id = (int) Math.floor(Math.random() * range1) + min;
                    Facture.ajouterProduitPeupler((i - 1), id, qte);

                }
            }
            System.out.println(Couleurs.G_VERT + "Facturier peuplé." + Couleurs.RESET);
            lanceMenu();
        } catch (Exception e) {
            e.printStackTrace(System.err);

        }


    }

    public class Couleurs {

        public static final String RESET = "\033[0m";

        public static final String CYAN = "\033[0;96m";

        public static final String G_ROUGE = "\033[1;31m";
        public static final String G_VERT = "\033[1;32m";
        public static final String G_JAUNE = "\033[1;33m";
        public static final String G_BLANC = "\033[1;97m";
        public static final String BB_BLEU = "\033[0;107m";
        ;


    }
}
