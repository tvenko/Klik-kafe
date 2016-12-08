package si.fri.prpo.zrna;

import java.util.ArrayList;

import javax.ejb.Local;

import si.fri.prpo.vaje.entitete.Kavarna;

@Local
public interface UpravljalecKavarnSBLocal {
	
	ArrayList<Kavarna> returnAll();
	Kavarna returnById(int id);
	
}
