package si.fri.prpo.vaje.entitete;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;


/**
 * The persistent class for the "Napitek" database table.
 * 
 */
@XmlRootElement
@Entity
@Table(name="\"Napitek\"")
@NamedQueries({
	@NamedQuery(name="Napitek.findAll", query="SELECT new si.fri.prpo.vaje.entitete.Napitek(n.id, n.prepTime, n.price, n.size, n.type) FROM Napitek n"),
	@NamedQuery(name="Napitek.findId", query="SELECT new si.fri.prpo.vaje.entitete.Napitek(n.id, n.prepTime, n.price, n.size, n.type) FROM Napitek n WHERE n.id = :id")
})
public class Napitek implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="prep_time")
	private Integer prepTime;

	private double price;

	private String size;

	private String type;

	//bi-directional many-to-many association to Kavarna
	@ManyToMany
	@JoinTable(
		name="\"Napitki_kavarne\""
		, joinColumns={
			@JoinColumn(name="id_napitka")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_kavarna")
			}
		)
	private List<Kavarna> kavarnas;

	//bi-directional many-to-one association to Napitki_narocila
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@OneToMany(mappedBy="napitek")
	private List<Napitki_narocila> napitkiNarocilas;

	public Napitek() {
	}
	
	public Napitek(Integer id, Integer prepTime, double price, String size, String type) {
		this.id = id;
		this.prepTime = prepTime;
		this.price = price;
		this.size = size;
		this.type = type;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPrepTime() {
		return this.prepTime;
	}

	public void setPrepTime(Integer prepTime) {
		this.prepTime = prepTime;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
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

	public List<Kavarna> getKavarnas() {
		return this.kavarnas;
	}

	public void setKavarnas(List<Kavarna> kavarnas) {
		this.kavarnas = kavarnas;
	}

	public List<Napitki_narocila> getNapitkiNarocilas() {
		return this.napitkiNarocilas;
	}

	public void setNapitkiNarocilas(List<Napitki_narocila> napitkiNarocilas) {
		this.napitkiNarocilas = napitkiNarocilas;
	}

	public Napitki_narocila addNapitkiNarocila(Napitki_narocila napitkiNarocila) {
		getNapitkiNarocilas().add(napitkiNarocila);
		napitkiNarocila.setNapitek(this);

		return napitkiNarocila;
	}

	public Napitki_narocila removeNapitkiNarocila(Napitki_narocila napitkiNarocila) {
		getNapitkiNarocilas().remove(napitkiNarocila);
		napitkiNarocila.setNapitek(null);

		return napitkiNarocila;
	}

}