package si.fri.prpo.vaje.narocanje.entitete;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "Uporabnik" database table.
 * 
 */
@Entity
@Table(name="\"Uporabnik\"")
@NamedQueries({
	@NamedQuery(name="Uporabnik.findAll", query="SELECT u FROM Uporabnik u"),
	@NamedQuery(name="Uporabnik.findId", query="SELECT u FROM Uporabnik u WHERE u.id = :userid"),
	@NamedQuery(name="Uporabnik.delete", query="DELETE FROM Uporabnik u WHERE u.name = :name")
})
public class Uporabnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(length=50)
	private String email;
	
	@Column(nullable=true)
	private double latitude;

	@Column(nullable=true)
	private double longitude;
	
	@Column(columnDefinition = "VARCHAR(30)", nullable=false)
	private String name;

	@Column(columnDefinition = "VARCHAR(30)", nullable=false)
	private String surname;

	@Column(length=20)
	private String username;

	//bi-directional many-to-one association to Narocilo
	@OneToMany(mappedBy="uporabnik")
	private List<Narocilo> narocilos;

	public Uporabnik() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Narocilo> getNarocilos() {
		return this.narocilos;
	}

	public void setNarocilos(List<Narocilo> narocilos) {
		this.narocilos = narocilos;
	}

	public Narocilo addNarocilo(Narocilo narocilo) {
		getNarocilos().add(narocilo);
		narocilo.setUporabnik(this);

		return narocilo;
	}

	public Narocilo removeNarocilo(Narocilo narocilo) {
		getNarocilos().remove(narocilo);
		narocilo.setUporabnik(null);

		return narocilo;
	}

}