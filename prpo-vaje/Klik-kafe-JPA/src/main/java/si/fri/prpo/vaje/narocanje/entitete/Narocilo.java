package si.fri.prpo.vaje.narocanje.entitete;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "Narocilo" database table.
 * 
 */
@Entity
@Table(name="\"Narocilo\"")
@NamedQueries({ 
		@NamedQuery(name="Narocilo.findAll", query="SELECT n FROM Narocilo n"), 
		//@NamedQuery(name="Narocilo.findPaid", query="SELECT n FROM Narocilo n WHERE n.paymentStatus = \"paid\""),
		//@NamedQuery(name="Narocilo.findWaiting", query="SELECT n FROM Narocilo n WHERE n.prepStatus = \"waiting\"")
})
public class Narocilo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="item_list")
	private String itemList;

	@Column(name="payment_status", length=50)
	private String paymentStatus;

	@Column(name="prep_status", length=50)
	private String prepStatus;

	@Column(name="prep_time", nullable=true, length=50)
	private String prepTime;

	//bi-directional many-to-one association to Kavarna
	@ManyToOne
	@JoinColumn(name="id_kavarna")
	private Kavarna kavarna;

	//bi-directional many-to-one association to Napitek
	@ManyToOne
	@JoinColumn(name="id_napitek")
	private Napitek napitek;

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

	public String getItemList() {
		return this.itemList;
	}

	public void setItemList(String itemList) {
		this.itemList = itemList;
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

	public String getPrepTime() {
		return this.prepTime;
	}

	public void setPrepTime(String prepTime) {
		this.prepTime = prepTime;
	}

	public Kavarna getKavarna() {
		return this.kavarna;
	}

	public void setKavarna(Kavarna kavarna) {
		this.kavarna = kavarna;
	}

	public Napitek getNapitek() {
		return this.napitek;
	}

	public void setNapitek(Napitek napitek) {
		this.napitek = napitek;
	}

	public Uporabnik getUporabnik() {
		return this.uporabnik;
	}

	public void setUporabnik(Uporabnik uporabnik) {
		this.uporabnik = uporabnik;
	}

}