package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Voiture {

	@Id
	@GeneratedValue
	long id_voiture;
	int nb_places_dispos;

	@ManyToOne
	Personne proprietaire; 
	
	public long getId_voiture() {
		return id_voiture;
	}

	public void setId_voiture(long id_voiture) {
		this.id_voiture = id_voiture;
	}

	public int getNb_places_dispos() {
		return nb_places_dispos;
	}

	public void setNb_places_dispos(int nb_places_dispos) {
		this.nb_places_dispos = nb_places_dispos;
	}

	public Personne getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Personne proprietaire) {
		this.proprietaire = proprietaire;
	}



	public Voiture(){
		nb_places_dispos = 0;
	}

	public Voiture(int nb, Personne prop){
		nb_places_dispos = nb;
		proprietaire = prop;
	}
}
