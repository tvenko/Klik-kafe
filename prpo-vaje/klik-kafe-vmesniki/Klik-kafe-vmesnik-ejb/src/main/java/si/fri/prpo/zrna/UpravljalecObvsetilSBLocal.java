package si.fri.prpo.zrna;

import java.io.IOException;

import javax.ejb.Local;
import javax.servlet.http.HttpServletResponse;

@Local
public interface UpravljalecObvsetilSBLocal {
	
	void pripraviRacun(int id_narocila, HttpServletResponse response) throws IOException ;

}
