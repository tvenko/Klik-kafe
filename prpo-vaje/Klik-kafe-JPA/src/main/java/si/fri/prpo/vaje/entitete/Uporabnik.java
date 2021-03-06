package si.fri.prpo.vaje.entitete;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;


/**
 * The persistent class for the "Uporabnik" database table.
 * 
 */
@XmlRootElement
@Entity
@Table(name="\"Uporabnik\"")
@NamedQueries({
	@NamedQuery(name="Uporabnik.findAll", query="SELECT new si.fri.prpo.vaje.entitete.Uporabnik(u.id, u.email, u.name, u.surname, u.latitude, u.longitude, u.username) FROM Uporabnik u"),
	@NamedQuery(name="Uporabnik.findId", query="SELECT new si.fri.prpo.vaje.entitete.Uporabnik(u.id, u.email, u.name, u.surname, u.latitude, u.longitude, u.username) FROM Uporabnik u WHERE u.id = :userid"),
	@NamedQuery(name="Uporabnik.delete", query="DELETE FROM Uporabnik u WHERE u.name = :name"),
	@NamedQuery(name="Uporabnik.idDelete", query="DELETE FROM Uporabnik u WHERE u.id = :userid"),
	@NamedQuery(name="Uporabnik.findName", query="SELECT new si.fri.prpo.vaje.entitete.Uporabnik(u.id, u.email, u.name, u.surname, u.latitude, u.longitude, u.username) FROM Uporabnik u WHERE u.username = :username")
})
public class Uporabnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String email;

	private double latitude;

	private double longitude;

	private String name;

	private String surname;

	private String username;

	//bi-directional many-to-one association to Narocilo
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@OneToMany(mappedBy="uporabnik", cascade = CascadeType.REMOVE)
	private List<Narocilo> narocilos;

	public Uporabnik() {
	}
	
	// Constructor for the findAll named query
	public Uporabnik(Integer id, String email, String name, String surname, double latitude, double longitude, String username) {
		this.id = id;
		this.email = email;
		this.name = name;
		this.surname = surname;
		this.latitude = latitude;
		this.longitude = longitude;
		this.username = username;
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