package si.fri.prpo.vaje.narocanje.entitete;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "Napitek" database table.
 * 
 */
@Entity
@Table(name="\"Napitek\"")
@NamedQueries({
	@NamedQuery(name="Napitek.findAll", query="SELECT n FROM Napitek n"),
	@NamedQuery(name="Napitek.findId", query="SELECT n FROM Napitek n WHERE n.id = :id")
})
public class Napitek implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="prep_time")
	private String prepTime;

	@Column(nullable=true)
	private String size;

	@Column(length=30)
	private String type;

	//bi-directional many-to-one association to Narocilo
	@OneToMany(mappedBy="napitek")
	private List<Narocilo> narocilos;

	public Napitek() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPrepTime() {
		return this.prepTime;
	}

	public void setPrepTime(String prepTime) {
		this.prepTime = prepTime;
	}

	public String getSize() {
		return this.size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Narocilo> getNarocilos() {
		return this.narocilos;
	}

	public void setNarocilos(List<Narocilo> narocilos) {
		this.narocilos = narocilos;
	}

	public Narocilo addNarocilo(Narocilo narocilo) {
		getNarocilos().add(narocilo);
		narocilo.setNapitek(this);

		return narocilo;
	}

	public Narocilo removeNarocilo(Narocilo narocilo) {
		getNarocilos().remove(narocilo);
		narocilo.setNapitek(null);

		return narocilo;
	}

}