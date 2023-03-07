package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private int nbVillageois = 0;
	private Gaulois[] villageois;
	private int nbVillageoisMaximum;
	
	

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		this.nbVillageois = 0;
		this.villageois = new Gaulois[nbVillageoisMaximum];
		this.nbVillageoisMaximum = nbVillageoisMaximum;
		
	}
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	public String getNom() {
		return nom;
	}
	
	public void ajouterHabitant(Gaulois habitant) {
		if (this.nbVillageois < this.nbVillageoisMaximum) { 
			this.villageois[nbVillageois] = habitant;
			this.nbVillageois++;			
		}
	}
	public Gaulois trouverHabitant(int numero) {
		return villageois[numero];
		
	}
	
	public static void main(String args[]) {
		Village VdI = new Village("Village des Irréductibles", 30);
		//Gaulois gaulois = VdI.trouverHabitant(30); pas d'habitant donc peut pas fonctionner
		Chef chef = new Chef("Abraracourcix", 6, VdI);
		VdI.setChef(chef);
		Gaulois asterix  = new Gaulois("Asterix", 8);
		VdI.ajouterHabitant(asterix);
		Gaulois gaulois = VdI.trouverHabitant(0);
		System.out.println(gaulois);
		
		
	}
}

