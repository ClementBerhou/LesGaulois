package personnages;

public class Romain {
	private String nom;
	private int force;
	private int force1;
	private int force2;
	private Equipement[] equipement = new Equipement[2];
	private int nbEquipement=0;
	
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert(this.force>=0):"Invalider user force";
		this.nbEquipement = 0;
		this.equipement = new Equipement[2];
	}
	
	public void sEquiper(Equipement armure) {
		switch(this.nbEquipement) {
		case 2:
			System.out.println("Le soldat " + this.nom + " est déjà bien protégé !");
			break;
		case 1:
			if (armure == this.equipement[0]) {
				System.out.println("Le soldat " + this.nom + " possède déjà un "+ armure.toString() );
				break;}
			
		
		default:
			System.out.println("Le soldat " + this.nom + " s'équipe avec un "+ armure.toString() );
			this.equipement[nbEquipement] = armure;
			this.nbEquipement++;
			break;
			}
		
		}
		
			
			
		
		
		
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		assert(this.force>0):"invalide force entry";
		force1 = force;
		force -= forceCoup;
		force2 = force;
		assert(force1>force2):"post-condition";
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
	}
	
	public static void main(String[] args) {
		
		Romain minus = new Romain("Minus", 6);
		System.out.println(minus.prendreParole());
		minus.parler("Je suis Minus !");
		minus.recevoirCoup(9);
		Equipement casque = Equipement.CASQUE;
		minus.sEquiper(casque);
		Equipement casque2 = Equipement.CASQUE;
		minus.sEquiper(casque2);
		Equipement bouclier = Equipement.BOUCLIER;
		minus.sEquiper(bouclier);
		Equipement bouclier2 = Equipement.BOUCLIER;
		minus.sEquiper(bouclier2);
	
		
		
		
		}

}
