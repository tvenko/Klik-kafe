package si.fri.prpo.zrna;

import javax.ejb.EJB;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
public class Prestreznik {
	
	@EJB
	private StevecNarocilSBLocal sn;
	
	
	@AroundInvoke
	public Object prispeloNovoNarocilo(InvocationContext kontekstProzenja) throws Exception {
		int stNarocil = sn.novoNarocilo();
		
		
		return kontekstProzenja.proceed();
	}
	
}
