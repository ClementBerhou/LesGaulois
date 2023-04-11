package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement=0;

	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert(this.force>=0):"Invalider user force";
		this.nbEquipement = 0;
		this.equipements = new Equipement[2];
		
	}
	
	public void sEquiper(Equipement armure) {
		String soldat = "Le soldat";
		switch(this.nbEquipement) {
		case 2:
			System.out.println(soldat +" "+ this.nom + " est déjà bien protégé !");
			break;
		case 1:
			if (armure == this.equipements[0]) {
				System.out.println(soldat +" "+ this.nom + " possède déjà un "+ armure.toString() );}
			break;
			
		
		default:
			System.out.println(soldat +" "+ this.nom + " s'équipe avec un "+ armure.toString() );
			this.equipements[nbEquipement] = armure;
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
	
//	public void recevoirCoup(int forceCoup) {
//		assert(this.force>0):"invalide force entry";
//		force1 = force;
//		force -= forceCoup;
//		force2 = force;
//		assert(force1>force2):"post-condition";
//		if (force > 0) {
//			parler("Aïe");
//		} else {
//			parler("J'abandonne...");
//		}
//	}
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		// if (force > 0) {
		// parler("Aïe");
		// } else {
		// equipementEjecte = ejecterEquipement();
		// parler("J'abandonne...");
		// }
		if (force == 0) {
			parler("Aïe");}
		else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");}
			
				
				
			
			// post condition la force a diminuée
			assert force < oldForce;
			return equipementEjecte;
	}
	
	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de" + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force a diminué de ";
			for (int i = 0; i < nbEquipement;i++) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
		} else {
		System.out.println("Equipement casque");
		resistanceEquipement += 5;
		}
		
		}
		texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
		}
		private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
	
		System.out.println("L'équipement de " + nom + "s'envole sous la force du coup.");

		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] == null) {
				} else {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
				}
				}
				return equipementEjecte;
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
