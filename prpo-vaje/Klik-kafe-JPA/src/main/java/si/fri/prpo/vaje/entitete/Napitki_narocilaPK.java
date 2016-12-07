package si.fri.prpo.vaje.entitete;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the "Napitki_narocila" database table.
 * 
 */
@Embeddable
public class Napitki_narocilaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_narocila", insertable=false, updatable=false)
	private Integer idNarocila;

	@Column(name="id_napitka", insertable=false, updatable=false)
	private Integer idNapitka;

	public Napitki_narocilaPK() {
	}
	public Integer getIdNarocila() {
		return this.idNarocila;
	}
	public void setIdNarocila(Integer idNarocila) {
		this.idNarocila = idNarocila;
	}
	public Integer getIdNapitka() {
		return this.idNapitka;
	}
	public void setIdNapitka(Integer idNapitka) {
		this.idNapitka = idNapitka;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof Napitki_narocilaPK)) {
			return false;
		}
		Napitki_narocilaPK castOther = (Napitki_narocilaPK)other;
		return 
			this.idNarocila.equals(castOther.idNarocila)
			&& this.idNapitka.equals(castOther.idNapitka);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idNarocila.hashCode();
		hash = hash * prime + this.idNapitka.hashCode();
		
		return hash;
	}
}