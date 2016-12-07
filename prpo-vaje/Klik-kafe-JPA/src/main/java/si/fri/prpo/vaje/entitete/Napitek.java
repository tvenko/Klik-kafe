package si.fri.prpo.vaje.entitete;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.List;


/**
 * The persistent class for the "Napitek" database table.
 * 
 */
@XmlRootElement
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
	private Integer prepTime;

	private double price;

	private String size;

	private String type;

	//bi-directional many-to-one association to Napitki_kavarne
	@OneToMany(mappedBy="napitek")
	private List<Napitki_kavarne> napitkiKavarnes;

	//bi-directional many-to-one association to Napitki_narocila
	@OneToMany(mappedBy="napitek")
	private List<Napitki_narocila> napitkiNarocilas;

	public Napitek() {
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

	public List<Napitki_kavarne> getNapitkiKavarnes() {
		return this.napitkiKavarnes;
	}

	public void setNapitkiKavarnes(List<Napitki_kavarne> napitkiKavarnes) {
		this.napitkiKavarnes = napitkiKavarnes;
	}

	public Napitki_kavarne addNapitkiKavarne(Napitki_kavarne napitkiKavarne) {
		getNapitkiKavarnes().add(napitkiKavarne);
		napitkiKavarne.setNapitek(this);

		return napitkiKavarne;
	}

	public Napitki_kavarne removeNapitkiKavarne(Napitki_kavarne napitkiKavarne) {
		getNapitkiKavarnes().remove(napitkiKavarne);
		napitkiKavarne.setNapitek(null);

		return napitkiKavarne;
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