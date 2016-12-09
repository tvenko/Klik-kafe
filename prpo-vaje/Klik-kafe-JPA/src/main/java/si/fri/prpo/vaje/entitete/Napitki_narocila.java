package si.fri.prpo.vaje.entitete;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The persistent class for the "Napitki_narocila" database table.
 * 
 */
@Entity
@Table(name="\"Napitki_narocila\"")
@NamedQuery(name="Napitki_narocila.findAll", query="SELECT n FROM Napitki_narocila n")
public class Napitki_narocila implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private Napitki_narocilaPK id;

	private Integer quantity;

	//bi-directional many-to-one association to Napitek
	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn(name="id_napitka", insertable=false, updatable=false)
	private Napitek napitek;

	//bi-directional many-to-one association to Narocilo
	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn(name="id_narocila", insertable=false, updatable=false)
	private Narocilo narocilo;

	public Napitki_narocila() {
	}

	public Napitki_narocilaPK getId() {
		return this.id;
	}

	public void setId(Napitki_narocilaPK id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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