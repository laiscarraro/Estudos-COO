public class Decorator {
	public static void main(String[] args) {
		Foto foto = new FotoNormal();
		foto.mostrar();
		System.out.println("");
	}
}

interface Foto {
	public void mostrar();
}

class FotoNormal implements Foto {
	@Override
	public void mostrar() {
		System.out.print("foto");
	}
}

abstract class FotoDecorator implements Foto {
	Foto foto;
	FotoDecorator(Foto f) {
		this.foto = f;
	}
	@Override
	public void mostrar() {
		foto.mostrar();
	}
}

class FiltroDecorator extends FotoDecorator {
	FiltroDecorator(Foto f) {
		super(f);
	}
	@Override
	public void mostrar() {
		super.mostrar();
		addFiltro();
	}

	public void addFiltro() {
		System.out.print(" com filtro");
	}
}

class BordaDecorator extends FotoDecorator {
	BordaDecorator(Foto f) {
		super(f);
	}
	@Override
	public void mostrar() {
		super.mostrar();
		addBorda();
	}

	public void addBorda() {
		System.out.print(" com borda");
	}
}