import java.util.*;
public class ChainOfResponsibility {
	public static void main(String[] args) {
		Ajuda sucessor = new SucessorAjuda();

		sucessor.ajuda();
	}
}

abstract class Ajuda {
	Ajuda ajuda;
	public void ajuda() {
		ajuda.ajuda();
	}
}

class BotaoAjuda extends Ajuda {
	@Override
	public void ajuda() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Oi, posso ajudar?");
		String podeAjudar = sc.nextLine();
		if(podeAjudar.equals("s")) {
			mostrarAjuda();
		} else {
			System.out.println("Vou falar com o meu supervisor");
			ajuda.ajuda();
		}
	}

	public void mostrarAjuda() {
		System.out.println("Tenta desligar e ligar dnv");
	}
}

class SucessorAjuda extends BotaoAjuda {
	SucessorAjuda() {
		this.ajuda = new BotaoAjuda();
	}
	public void mostrarAjuda() {
		System.out.println("Liga pra sua mae");
	}
}