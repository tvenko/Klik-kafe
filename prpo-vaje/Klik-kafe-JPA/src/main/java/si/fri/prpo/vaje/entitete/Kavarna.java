package si.fri.prpo.vaje.entitete;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.List;


/**
 * The persistent class for the "Kavarna" database table.
 * 
 */
@XmlRootElement
@Entity
@Table(name="\"Kavarna\"")
@NamedQueries({
	@NamedQuery(name="Kavarna.findAll", query="SELECT k FROM Kavarna k"),
	@NamedQuery(name="Kavarna.findId", query="SELECT k FROM Kavarna k WHERE k.id = :id"),
	@NamedQuery(name="Kavarna.findName", query="SELECT k FROM Kavarna k WHERE k.name = :name")
})
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