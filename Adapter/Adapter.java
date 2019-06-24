public class Adapter {
	public static void main(String[] args) {
		CarregadorDeCelular carregador = new CarregadorDeCelular();
		TomadaDe2Pinos tomada = new TomadaDe2Pinos();
		Adaptador adaptador = new Adaptador();
		carregador.fonte = adaptador;
		adaptador.tomada = tomada;
		carregador.fonte.plugar3Pinos();
	}
}

class CarregadorDeCelular {
	FonteDe3Pinos fonte;
}

interface FonteDe3Pinos {
	public void plugar3Pinos();
}

class Adaptador implements FonteDe3Pinos {
	TomadaDe2Pinos tomada;
	@Override
	public void plugar3Pinos() {
		System.out.print("Fonte de 3 pinos ");
		tomada.plugar2Pinos();
	}
}

class TomadaDe2Pinos {
	public void plugar2Pinos() {
		System.out.println("plugada com sucesso na tomada de 2 pinos!");
	}
}