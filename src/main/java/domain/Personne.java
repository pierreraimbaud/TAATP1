package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Personne {

	@Id
	@GeneratedValue
	long id_personne;

	String name;
	String firstname;
	boolean vientAvecVoiture;
	int voitureCourante;
	@OneToMany(mappedBy="proprietaire")
	List <Voiture> list_voitures;

	
	public boolean isVientAvecVoiture() {
		return vientAvecVoiture;
	}

	public void setVientAvecVoiture(boolean vientAvecVoiture) {
		this.vientAvecVoiture = vientAvecVoiture;
	}

	public List<Voiture> getList_voitures() {
		return list_voitures;
	}

	public void setList_voitures(List<Voiture> list_voitures) {
		this.list_voitures = list_voitures;
	}

	
	public Personne() {
		this.name = null;
		this.firstname = null;
	}

	public Personne(String name, String firstname, ArrayList <Voiture> voit) {
		this.name = name;
		this.firstname = firstname;
		this.list_voitures = voit;
	}

	public long getId_personne() {
		return id_personne;
	}
	public void setId_personne(long id_personne) {
		this.id_personne = id_personne;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void participe (Evenement e, boolean chauffeur, int num_voiture){
		List <Personne> lp = e.getLp();
		//Parametrage de la notion de chauffeur ou passager
		this.setVientAvecVoiture(chauffeur);

		//Parametrage de la voiture choisie
		if (!chauffeur){
			voitureCourante= -99;
		}
		voitureCourante=num_voiture;
		lp.add(this);
		e.setLp(lp);

	}

	public int getVoitureCourante() {
		return voitureCourante;
	}

	public void setVoitureCourante(int voitureCourante) {
		this.voitureCourante = voitureCourante;
	}

}
