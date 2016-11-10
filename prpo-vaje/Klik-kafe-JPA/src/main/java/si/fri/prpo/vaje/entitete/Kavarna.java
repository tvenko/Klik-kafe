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

	//bi-directional many-to-one association to Napitki_kavarne
	@OneToMany(mappedBy="kavarna")
	private List<Napitki_kavarne> napitkiKavarnes;

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

	public List<Napitki_kavarne> getNapitkiKavarnes() {
		return this.napitkiKavarnes;
	}

	public void setNapitkiKavarnes(List<Napitki_kavarne> napitkiKavarnes) {
		this.napitkiKavarnes = napitkiKavarnes;
	}

	public Napitki_kavarne addNapitkiKavarne(Napitki_kavarne napitkiKavarne) {
		getNapitkiKavarnes().add(napitkiKavarne);
		napitkiKavarne.setKavarna(this);

		return napitkiKavarne;
	}

	public Napitki_kavarne removeNapitkiKavarne(Napitki_kavarne napitkiKavarne) {
		getNapitkiKavarnes().remove(napitkiKavarne);
		napitkiKavarne.setKavarna(null);

		return napitkiKavarne;
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