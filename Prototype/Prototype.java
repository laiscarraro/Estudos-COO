public class Prototype {
	public static void main(String[] args) {
		FornoIndustrial forno = new FornoIndustrial();

		ReceitaDaTorta torta = new TortaDeFrango();

		TortaDeFrango tortaClone = (TortaDeFrango) forno.assarTorta(torta);

		System.out.println("O padeiro me deu uma torta " + torta.sabor + ". Ele disse que era uma " + torta.nome + ".");
		System.out.println("Então eu fiz uma " + tortaClone.nome + ", que é " + tortaClone.sabor + ".");
	}
}

class FornoIndustrial {
	ReceitaDaTorta receita;
	public ReceitaDaTorta assarTorta(ReceitaDaTorta receita) {
		return receita.clonarTorta();
	}
}

abstract class ReceitaDaTorta implements Cloneable {
	String nome;
	String sabor;

	public abstract ReceitaDaTorta clonarTorta();
}

abstract class TortaDoce extends ReceitaDaTorta {
	TortaDoce(){
		this.sabor = "doce";
	}
}

abstract class TortaSalgada extends ReceitaDaTorta {
	TortaSalgada(){
		this.sabor = "salgada";
	}
}

class TortaDeMaca extends TortaDoce {
	TortaDeMaca(){
		this.nome = "Torta de Maçã";
	}

	@Override
	public ReceitaDaTorta clonarTorta() {
		TortaDeMaca torta = null;

		try {
			torta = (TortaDeMaca) super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("Ops, derrubei a torta de maçã no chão...");
		}

		return torta;
	}
}

class TortaDeChocolate extends TortaDoce {
	TortaDeChocolate(){
		this.nome = "Torta de Chocolate";
	}

	@Override
	public ReceitaDaTorta clonarTorta() {
		TortaDeChocolate torta = null;

		try {
			torta = (TortaDeChocolate) super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("Ops, derrubei a torta de chocolate no chão...");
		}

		return torta;
	}
}

class TortaDeFrango extends TortaSalgada {
	TortaDeFrango(){
		this.nome = "Torta de Frango";
	}

	@Override
	public ReceitaDaTorta clonarTorta() {
		TortaDeFrango torta = null;

		try {
			torta = (TortaDeFrango) super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("Ops, derrubei a torta de frango no chão...");
		}

		return torta;
	}
}