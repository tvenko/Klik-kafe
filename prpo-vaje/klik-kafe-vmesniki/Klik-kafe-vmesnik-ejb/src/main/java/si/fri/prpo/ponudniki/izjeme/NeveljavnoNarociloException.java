package si.fri.prpo.ponudniki.izjeme;
import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)

public class NeveljavnoNarociloException extends Exception {
	
	public NeveljavnoNarociloException(String message) {
		super(message);
	}

}