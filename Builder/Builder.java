import java.util.Scanner;
public class Builder {
	public static void main(String[] args) {
		Padeiro padeiro = new Padeiro();
		Scanner sc = new Scanner(System.in);
		System.out.println("Olá! Você vai querer uma torta doce ou salgada?");

		TortaBuilder builder = new NullTortaBuilder();

		String escolha = sc.nextLine();

		switch(escolha){
			case "doce":
				builder = new TortaDoceBuilder();
				break;
			case "salgada":
				builder = new TortaSalgadaBuilder();
				break;
		}

		padeiro.setBuilder(builder);
		padeiro.AssarTorta();
	}
}

class Padeiro {
	private TortaBuilder builder;

	public void setBuilder(TortaBuilder builder) {
		this.builder = builder;
	}

	public void AssarTorta() {
		this.builder.BuildMassa();
		this.builder.BuildRecheio();
	}
}

interface TortaBuilder {
	public void BuildMassa();
	public void BuildRecheio();
}

class TortaSalgadaBuilder implements TortaBuilder {
	@Override
	public void BuildMassa(){
		System.out.println("Massa salgada pronta!");
	}
	@Override
	public void BuildRecheio(){
		System.out.println("Recheio salgado pronto!");
	}
}

class TortaDoceBuilder implements TortaBuilder {
	@Override
	public void BuildMassa(){
		System.out.println("Massa doce pronta!");
	}
	@Override
	public void BuildRecheio(){
		System.out.println("Recheio doce pronto!");
	}
}

class NullTortaBuilder implements TortaBuilder {
	@Override
	public void BuildMassa(){
		System.out.println("Por favor, escolha entre doce ou salgado! Sem isso não consigo fazer a massa...");
	}
	@Override
	public void BuildRecheio(){
		System.out.println("Por favor, escolha entre doce ou salgado! Sem isso não consigo fazer o recheio...");
	}
}