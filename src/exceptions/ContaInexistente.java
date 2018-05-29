package exceptions;

	/**
	 * Classe de exce��o se conta n�o existe 
	 * @author Controller 
	 */

public class ContaInexistente extends Exception{

	private static final long serialVersionUID = 1L;

	public ContaInexistente(String msg){
		super(msg);
	}
	
	public ContaInexistente(String msg, Throwable cause){
		super(msg, cause);
	}

	public ContaInexistente(Throwable cause){
		super(cause);
	}
}
