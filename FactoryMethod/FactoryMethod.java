public class FactoryMethod {
	public static void main(String[] args) {
		Whatsapp whats = new Microfone();
		whats.mandar();
	}
}

interface Midia {
	public void abrir();
}

class Texto implements Midia {
	@Override
	public void abrir(){
		System.out.println("O texto será aberto no Word");
	}
}

class Imagem implements Midia {
	@Override
	public void abrir(){
		System.out.println("A imagem será aberta no Chrome");
	}
}

class Audio implements Midia {
	@Override
	public void abrir(){
		System.out.println("O áudio será aberto no Windows Media Player");
	}
}

abstract class Whatsapp {
	Midia midia;

	Whatsapp() {
		this.midia = gerarConteudo();
	}

	public abstract Midia gerarConteudo();
	public void mandar() {
		this.midia.abrir();
	}
}

class CaixaDeTexto extends Whatsapp {
	@Override
	public Midia gerarConteudo() {
		return new Texto();
	}
}

class Camera extends Whatsapp {
	@Override
	public Midia gerarConteudo() {
		return new Imagem();
	}
}

class Microfone extends Whatsapp {
	@Override
	public Midia gerarConteudo() {
		return new Audio();
	}
}