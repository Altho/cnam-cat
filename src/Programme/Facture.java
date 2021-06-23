package Programme;

public class Facture {
	/*
	* Pour chaque tableau, la première dimension correspond à la facture et la deuxième à la ligne. Pour obtenir
	* la 5eme ligne de la premiere facture par exemple nous utiliserons
	* console.log (proTab[0][4]+" "+qteTab[0][4]);
	* */
	private static int[][] proTab = new int[1][1];
	private static int[][] qteTab = new int[1][1];
	/*
	 * Question 4.1 : D�finir un facturier (voir sujet)
	 */

	public static void main(String[] args) {
		int numFacture = nouvelleFacture();
		ajouterProduit(numFacture, 0, 10);
		ajouterProduit(numFacture, 3, 2);
		afficherFacture(numFacture);

		numFacture = nouvelleFacture();
		ajouterProduit(numFacture, 1, 1);
		ajouterProduit(numFacture, 0, 5);
		ajouterProduit(numFacture, 2, 5);
		afficherFacture(numFacture);

		afficher();

	}

	public static int nouvelleFacture() {
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("NOUVELLE FACTURE");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println(" ");
		System.out.println("--------------------");
		System.out.println("Facture "+ proTab.length);
		System.out.println("--------------------");
		System.out.println(" ");
		int temPro[][] = new int[proTab.length+1][proTab[0].length+1];
		int tempQte[][] = new int[qteTab.length+1][qteTab[0].length+1];
		for(int i = 0; i<proTab.length; i++){
			for(int e =0; e<proTab[0].length; e++){
				temPro[i][e]=proTab[i][e];
				tempQte[i][e]=qteTab[i][e];
			}


		}
		proTab=temPro;
		qteTab=tempQte;


	return proTab.length;

	}

	public static int accesFactures() {
		for(int i = 1; i< proTab.length; i++){
		System.out.println("Facture "+ i);
		System.out.println("Contient "+ proTab[i-1].length+ " produits uniques");}
		System.out.println(" ");

		return proTab.length;
	};

	public static void ajouterProduit(int numFacture, int numProduit,
			int quantite) {
		int facture = numFacture;
		int produit = numProduit;
		int qte = quantite;

		proTab[facture][proTab.length-1] = produit;
		qteTab[facture][proTab.length-1] = qte;

		System.out.println(qte + " "+ Catalogue.tabNoms[produit]+" ajouté à la facture : "+ facture);

		int temPro[][] = new int[proTab.length+1][proTab[0].length+1];
		int tempQte[][] = new int[qteTab.length+1][qteTab[0].length+1];
		for(int i = 0; i<proTab.length; i++){
			for(int e =0; e<proTab[0].length; e++){
				temPro[i][e]=proTab[i][e];
				tempQte[i][e]=qteTab[i][e];
			}


		}
		proTab=temPro;
		qteTab=tempQte;
		Programme.Menu.menu();
	}



	/**
	 * Affiche une facture avec son num�ro, la liste des produits (nom du
	 * produit, quantit�, prix unitaire et prix total de la ligne), et le total
	 * de la facture.
	 * 
	 * @param numFacture
	 *            num�ro de la facture
	 */
	public static void afficherFacture(int numFacture) {
		double total = 0.0;
		System.out.println("_______________");
		System.out.println("|             |");
		System.out.println("|  Facture " +numFacture+"   |");
		System.out.println("|             |");
		System.out.println("_______________");
		System.out.println(" ");


		for (int i = 0; i< proTab.length; i++){
			String produit = Catalogue.tabNoms[proTab[numFacture][i]];
			int qte = qteTab[numFacture][i];
			double prix = Catalogue.tabPrix[proTab[numFacture][i]];
			double articleTotal =prix*qte;

			total += articleTotal;

			System.out.println(produit);
			System.out.println("Quantité : "+ qte);
			System.out.println("Prix unitaire : "+ prix);
			System.out.println("Total : "+ articleTotal+" Euros");

			System.out.println("_______________");
			System.out.println(" ");
		}
		System.out.println(" ");
		System.out.println("TOTAL : "+total+" Euros.");
	}

	/**
	 * affiche toutes les factures.
	 */
	public static void afficher() {
		// TODO Question 4.5

	}

}


