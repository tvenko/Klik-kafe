package si.fri.prpo.vaje.entitete;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "Napitki_narocila" database table.
 * 
 */
@Entity
@Table(name="\"Napitki_narocila\"")
@NamedQuery(name="Napitki_narocila.findAll", query="SELECT n FROM Napitki_narocila n")
public class Napitki_narocila implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	//bi-directional many-to-one association to Napitek
	@ManyToOne
	@JoinColumn(name="id_napitka")
	private Napitek napitek;

	//bi-directional many-to-one association to Narocilo
	@ManyToOne
	@JoinColumn(name="id_narocila")
	private Narocilo narocilo;

	public Napitki_narocila() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Napitek getNapitek() {
		return this.napitek;
	}

	public void setNapitek(Napitek napitek) {
		this.napitek = napitek;
	}

	public Narocilo getNarocilo() {
		return this.narocilo;
	}

	public void setNarocilo(Narocilo narocilo) {
		this.narocilo = narocilo;
	}

}