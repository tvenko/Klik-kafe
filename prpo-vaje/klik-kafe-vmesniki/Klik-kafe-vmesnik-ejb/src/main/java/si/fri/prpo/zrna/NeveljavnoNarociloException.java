package si.fri.prpo.zrna;
import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)

public class NeveljavnoNarociloException extends Exception {
	
	public NeveljavnoNarociloException() {
		
	}
	
	public String error() {
		return "Napaka pri oddaji narocila.";
	}
}