package Programme;

public class Menu {
    public static void main(String[] args) {
        Programme.Facture.nouvelleFacture();

    }



    public static void nom(){
        System.out.println("Veuillez entrer l'id de l'article à afficher");
        int id = Terminal.lireInt();
        String result =Programme.Catalogue.getNom(id);
        System.out.println("L'ID : " + id+" "+"Correspond à : "+result);
        menu();

    }

    public static void menu(){
        boolean quitter = false;
        do {
            System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            System.out.println("MENU PRINCIPAL");
            System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            System.out.println(" ");
            System.out.println("Que souhaitez vous faire ?");
            System.out.println("1. Consulter le catalogue");
            System.out.println("2. Ajouter un article au catalogue");
            System.out.println("3. Rechercher nom par ID");
            System.out.println("4. Rechercher prix par ID ");
            System.out.println("5. Rechercher par nom ");
            System.out.println("6. Quitter ");

            int choix = Terminal.lireInt();

            switch (choix){
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
                    quitter = true;
                    break;


            }







        } while(quitter = false);
    }

    public static void prix(){
        System.out.println("Veuillez entrer l'id de l'article");
        int id = Terminal.lireInt();
        double result =Programme.Catalogue.getPrix(id);
        System.out.println("Le prix de l'article id : " + id+"("+Programme.Catalogue.getNom(id)+") "+"est de : "+result);
        menu();
    }

    public static void ajout(){
        System.out.println("Veuillez entrer le nom de l'article à ajouter");
        String nom = Terminal.lireString();
        System.out.println("Veuillez entrer le prix de l'article à ajouter");
        Double prix = Terminal.lireDouble();
        Programme.Catalogue.ajouter(nom, prix);
        menu();
    }

    public static void recherche(){
        System.out.println("Veuillez entrer le nom de l'article à rechercher");
        String result = Terminal.lireString();
        int querry = Programme.Catalogue.chercher(result);
        if(querry == -1){
            System.out.println("Aucun resultat pour : "+ result);
        }
        else {
            System.out.println(result+" trouvé en position "+querry);
            System.out.println(Programme.Catalogue.getNom(querry)+" | "+Programme.Catalogue.getPrix(querry)+" Euros.");
        }
        menu();
    }
}
