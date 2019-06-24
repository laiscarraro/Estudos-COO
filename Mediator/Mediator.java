public class Mediator {
	public static void main(String[] args) {
		Mulher lais = new Mulher();
		Marido tres = new Marido();

		Advogado adv = new Advogado();

		lais.m = adv;
		tres.m = adv;

		adv.mulher = lais;
		adv.marido = tres;

		lais.responder("Te odeio");
		tres.responder("Eu sei q vc me ama");
		lais.responder("Ok te amo msm");
		tres.responder("Advogado, ta demitido, n vai ter divorcio");
	}
}

interface Mediador {
	void conversar(String m);
}

class Advogado implements Mediador {
	Mulher mulher;
	Marido marido;
	@Override
	public void conversar(String m) {
		System.out.println(m);
	}
}

abstract class CasalDivorciado {
	Mediador m;
	public abstract void responder(String mensagem);
}

class Marido extends CasalDivorciado {
	@Override
	public void responder(String mensagem) {
		m.conversar(mensagem);
	}
}

class Mulher extends CasalDivorciado {
	@Override
	public void responder(String mensagem) {
		m.conversar(mensagem);
	}
}