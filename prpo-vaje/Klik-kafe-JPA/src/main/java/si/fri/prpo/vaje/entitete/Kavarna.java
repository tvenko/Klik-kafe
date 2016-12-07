package si.fri.prpo.vaje.entitete;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "Kavarna" database table.
 * 
 */
@Entity
@Table(name="\"Kavarna\"")
@NamedQuery(name="Kavarna.findAll", query="SELECT k FROM Kavarna k")
public class Kavarna implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private double latitude;

	private double longitude;

	private String name;

	//bi-directional many-to-many association to Napitek
	@ManyToMany(mappedBy="kavarnas")
	private List<Napitek> napiteks;

	//bi-directional many-to-one association to Narocilo
	@OneToMany(mappedBy="kavarna")
	private List<Narocilo> narocilos;

	public Kavarna() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Napitek> getNapiteks() {
		return this.napiteks;
	}

	public void setNapiteks(List<Napitek> napiteks) {
		this.napiteks = napiteks;
	}

	public List<Narocilo> getNarocilos() {
		return this.narocilos;
	}

	public void setNarocilos(List<Narocilo> narocilos) {
		this.narocilos = narocilos;
	}

	public Narocilo addNarocilo(Narocilo narocilo) {
		getNarocilos().add(narocilo);
		narocilo.setKavarna(this);

		return narocilo;
	}

	public Narocilo removeNarocilo(Narocilo narocilo) {
		getNarocilos().remove(narocilo);
		narocilo.setKavarna(null);

		return narocilo;
	}

}