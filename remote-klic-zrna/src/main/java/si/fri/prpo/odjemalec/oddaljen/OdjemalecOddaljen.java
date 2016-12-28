package si.fri.prpo.odjemalec.oddaljen;

import java.util.ArrayList;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import si.fri.prpo.zrna.UpravljalecUporabnikovSBRemote;
import si.fri.prpo.zrna.UpravljalecUporabnikovSB;
import si.fri.prpo.vaje.entitete.Uporabnik;

public class OdjemalecOddaljen {

	public static void main(String[] args) {
		// JNDI naslov zrna – dolocen s strani streznika
		String JNDINaslovZrna = "ejb:Klik-kafe-EAR-0.0.1-SNAPSHOT/Klik-kafe-storitve-0.0.1-SNAPSHOT/UpravljalecUporabnikovSB!si.fri.prpo.zrna.UpravljalecUporabnikovSBRemote";
		// inicializiramo zacetni kontekst
		try {
			Properties env = new Properties();
			env.put(Context.INITIAL_CONTEXT_FACTORY, org.jboss.naming.remote.client.InitialContextFactory.class.getName());
			env.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
			env.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
			env.put("jboss.naming.client.ejb.context", true);
			Context ctx = new InitialContext(env);
			UpravljalecUporabnikovSBRemote uur = (UpravljalecUporabnikovSBRemote)ctx.lookup(JNDINaslovZrna);
			String povezava = "Ni povezave";
			povezava = uur.getResponse();
			System.out.println(povezava);
			
			ArrayList<Uporabnik> seznamUporabnikov = (ArrayList<Uporabnik>)uur.oddaljenoVrni();
			System.out.println("\n>Uporabniki:\nIme    | Priimek    | Email");
			System.out.println("--------------------------------------");
			for (Uporabnik u : seznamUporabnikov) {
				System.out.printf("%6s | %10s | %10s\n", u.getName(), u.getSurname(), u.getEmail());
			}
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
