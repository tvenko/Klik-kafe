package si.fri.prpo.zrna;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NeveljavnoNarociloMapper implements ExceptionMapper<NeveljavnoNarociloException>{

	@Override
	public Response toResponse(NeveljavnoNarociloException exception) {
		return Response.status(Response.Status.BAD_REQUEST)
				.entity("Narocilo je neveljavno, prosimo preglejte "
						+ "ali ste izplolnili vsa polja").build();
	}

}
