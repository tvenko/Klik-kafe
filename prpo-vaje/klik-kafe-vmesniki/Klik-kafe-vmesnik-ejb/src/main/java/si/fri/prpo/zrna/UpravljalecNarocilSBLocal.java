package si.fri.prpo.zrna;

import javax.ejb.Local;

@Local
public interface UpravljalecNarocilSBLocal {
	
	void sprejmiNarocilo();
	void prekliciNarocilo();
}
