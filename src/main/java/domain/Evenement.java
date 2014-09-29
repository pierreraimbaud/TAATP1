package domain;

import java.util.List;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Evenement {

	@Id
	@GeneratedValue
	long id_evenement;

	Date date;
	String lieu;
	int heure;
	List <Personne> lp;

	public Evenement(){
		date = null;
		lieu = "";
		heure = 0;
		lp = null;
	}

	public List<Personne> getLp() {
		return lp;
	}

	public void setLp(List<Personne> lp) {
		this.lp = lp;
	}

	public Evenement(Date d, String li, int h, List <Personne> l){
		date = d;
		lieu = li;
		heure = h;
		lp = l;
	}

	public long getId_evenement() {
		return id_evenement;
	}
	public void setId_evenement(long id_evenement) {
		this.id_evenement = id_evenement;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public int getHeure() {
		return heure;
	}
	public void setHeure(int heure) {
		this.heure = heure;
	}

	public void covoiturage(){
		int nb_personnes= this.getLp().size();
		int nb_places = 0;
		for(int i = 0; i < nb_personnes; i++){
			Personne p = this.getLp().get(i);

			if (p.vientAvecVoiture){
				nb_places += p.getList_voitures().get(p.getVoitureCourante()).getNb_places_dispos();
			}

		}
		if (nb_places< nb_personnes){
			System.err.println("Il n'y a pas assez de places : " + nb_personnes +" personnes veulent venir et "
					+ nb_places + " disponibles");
		}
	}
}
