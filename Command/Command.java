public class Command {
	public static void main(String[] args) {
		Documento d = new DocumentoDeTexto();
		Comando com = new ComandoAbrir();

		com.d = d;

		com.executar();
	}
}

abstract class Documento {
	public abstract void abrir();
	public abstract void fechar();
}

class DocumentoDeDesenho extends Documento {
	@Override
	public void abrir() {
		System.out.println("Documento de desenho sendo aberto");
	}

	@Override
	public void fechar() {
		System.out.println("Documento de desenho sendo fechado");
	}
}

class DocumentoDeTexto extends Documento {
	@Override
	public void abrir() {
		System.out.println("Documento de texto sendo aberto");
	}

	@Override
	public void fechar() {
		System.out.println("Documento de texto sendo fechado");
	}
}

abstract class Comando {
	Documento d;
	public abstract void executar();
}

class ComandoAbrir extends Comando {
	@Override
	public void executar(){
		d.abrir();
	}
}

class ComandoFechar extends Comando {
	@Override
	public void executar() {
		d.fechar();
	}
}