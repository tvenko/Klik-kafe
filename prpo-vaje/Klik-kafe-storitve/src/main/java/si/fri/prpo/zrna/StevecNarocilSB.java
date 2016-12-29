package si.fri.prpo.zrna;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

/**
 * Session Bean implementation class SteveNarocilSB
 */
@Singleton
public class StevecNarocilSB implements StevecNarocilSBRemote, StevecNarocilSBLocal {
	
	private static final Logger LOGGER = Logger.getLogger("serverLog");
	private static int stevecNarocil;
	
    /**
     * Default constructor. 
     */
    public StevecNarocilSB() {
        // TODO Auto-generated constructor stub
    }
    
    @PostConstruct
    private void inicializirajStevec() {
    	stevecNarocil = 0;
    }

	@Override
	public int novoNarocilo() {
		stevecNarocil++;
		LOGGER.info("Prispelo novo narocilo ... Skupno narocil: " + stevecNarocil);
		return stevecNarocil;
	}

}
