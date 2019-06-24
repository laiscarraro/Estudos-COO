import java.util.*;
public class Composite {
	public static void main(String[] args) {
		Planta macieira = new Arvore(5, 2);
		Planta broto = new Folha();

		System.out.println("Plantando o broto na macieira:");
		macieira.plantar(broto);

		System.out.println("Podando a macieira:");
		macieira.podar();

		System.out.println("Podando a macieira:");
		macieira.podar();
	}
}

interface Planta {
	public void podar();
	public void plantar(Planta p);
}

class Folha implements Planta {
	@Override
	public void podar() {
		System.out.println("A folhinha foi podada, aaaah :(");
	}
	@Override
	public void plantar(Planta p) {
		System.out.println("Ei, ta doido? Não da pra plantar coisas numa folha, mds");
	}
}

class Arvore implements Planta {
	List<Planta> galhos = new ArrayList<Planta>();
	Arvore(int folhas, int arvores) {
		for(int i = 0; i < folhas; i++) {
			this.galhos.add(new Folha());
		}
		for(int i = 0; i < arvores; i++) {
			this.galhos.add(new Arvore(folhas, arvores - 1));
		}
	}

	@Override
	public void podar() {
		for(Planta p : this.galhos) {
			p.podar();
		}
		galhos.removeAll(galhos);
	}

	@Override
	public void plantar(Planta p) {
		this.galhos.add(p);
		System.out.println("Folhinha plantada!! Uhu!!!");
	}
}