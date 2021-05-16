package Programme;

public class Facture {
	/*
	* Pour chaque tableau, la première dimension correspond à la facture et la deuxième à la ligne. Pour obtenir
	* la 5eme ligne de la premiere facture par exemple nous utiliserons
	* console.log (proTab[0][4]+" "+qteTab[0][4]);
	* */
	private static int[][] proTab = new int[0][0];
	private static int[][] qteTab = new int[0][0];
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


	return 0;

	}

	private static void ajouterProduit(int numFacture, int numProduit,
			int quantite) {


	}

	/**
	 * Affiche une facture avec son num�ro, la liste des produits (nom du
	 * produit, quantit�, prix unitaire et prix total de la ligne), et le total
	 * de la facture.
	 * 
	 * @param numFacture
	 *            num�ro de la facture
	 */
	private static void afficherFacture(int numFacture) {
		// TODO Question 4.4

	}

	/**
	 * affiche toutes les factures.
	 */
	public static void afficher() {
		// TODO Question 4.5

	}

}


