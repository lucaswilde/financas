package webServices.ws;

import java.util.Date;

import javax.xml.ws.WebFault;

@WebFault(name="ServiceExceptionSOAP")
public class ServiceExceptionSOAP extends Exception{
	
	private static final long serialVersionUID = 7712466072766257080L;
	private String faultDetail;

	public ServiceExceptionSOAP(String faultMessage, String faultDetail) {
		super(faultMessage);
		this.faultDetail = faultDetail;
	}

	// será usado pelo JAX-B para definir o conteúdo do elemento detail do Fault
	public InfoFault getFaultInfo() {
		return new InfoFault(faultDetail, new Date());
	}
}
