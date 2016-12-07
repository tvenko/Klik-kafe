package si.fri.prpo.vaje.entitete;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "Narocilo" database table.
 * 
 */
@Entity
@Table(name="\"Narocilo\"")
@NamedQuery(name="Narocilo.findAll", query="SELECT n.id, n.paymentStatus, n.prepStatus, n.prepTime, n.totalPrice, n.kavarna.id, n.kavarna.name FROM Narocilo n")
public class Narocilo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="payment_status")
	private String paymentStatus;

	@Column(name="prep_status")
	private String prepStatus;

	@Column(name="prep_time")
	private Integer prepTime;

	@Column(name="total_price")
	private double totalPrice;

	//bi-directional many-to-one association to Napitki_narocila
	@OneToMany(mappedBy="narocilo", fetch = FetchType.EAGER)
	private List<Napitki_narocila> napitkiNarocilas;

	//bi-directional many-to-one association to Kavarna
	@ManyToOne
	@JoinColumn(name="id_kavarna")
	private Kavarna kavarna;

	//bi-directional many-to-one association to Uporabnik
	@ManyToOne
	@JoinColumn(name="id_uporabnik")
	private Uporabnik uporabnik;

	public Narocilo() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPaymentStatus() {
		return this.paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getPrepStatus() {
		return this.prepStatus;
	}

	public void setPrepStatus(String prepStatus) {
		this.prepStatus = prepStatus;
	}

	public Integer getPrepTime() {
		return this.prepTime;
	}

	public void setPrepTime(Integer prepTime) {
		this.prepTime = prepTime;
	}

	public double getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<Napitki_narocila> getNapitkiNarocilas() {
		return this.napitkiNarocilas;
	}

	public void setNapitkiNarocilas(List<Napitki_narocila> napitkiNarocilas) {
		this.napitkiNarocilas = napitkiNarocilas;
	}

	public Napitki_narocila addNapitkiNarocila(Napitki_narocila napitkiNarocila) {
		getNapitkiNarocilas().add(napitkiNarocila);
		napitkiNarocila.setNarocilo(this);

		return napitkiNarocila;
	}

	public Napitki_narocila removeNapitkiNarocila(Napitki_narocila napitkiNarocila) {
		getNapitkiNarocilas().remove(napitkiNarocila);
		napitkiNarocila.setNarocilo(null);

		return napitkiNarocila;
	}

	public Kavarna getKavarna() {
		return this.kavarna;
	}

	public void setKavarna(Kavarna kavarna) {
		this.kavarna = kavarna;
	}

	public Uporabnik getUporabnik() {
		return this.uporabnik;
	}

	public void setUporabnik(Uporabnik uporabnik) {
		this.uporabnik = uporabnik;
	}

}