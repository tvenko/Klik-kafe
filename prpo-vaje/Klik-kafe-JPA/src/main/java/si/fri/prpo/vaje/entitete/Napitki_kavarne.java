package si.fri.prpo.vaje.entitete;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "Napitki_kavarne" database table.
 * 
 */
@Entity
@Table(name="\"Napitki_kavarne\"")
@NamedQuery(name="Napitki_kavarne.findAll", query="SELECT n FROM Napitki_kavarne n")
public class Napitki_kavarne implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	//bi-directional many-to-one association to Kavarna
	@ManyToOne
	@JoinColumn(name="id_kavarna")
	private Kavarna kavarna;

	//bi-directional many-to-one association to Napitek
	@ManyToOne
	@JoinColumn(name="id_napitka")
	private Napitek napitek;

	public Napitki_kavarne() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

}