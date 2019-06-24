public class Visitor {
	public static void main(String[] args) {
		BanheiroVisitor joao = new HomemBanheiroVisitor();
		BanheiroVisitor lais = new MulherBanheiroVisitor();

		Banheiro b = new BanheiroMasculino();

		b.acceptVisitor(lais);
		b.acceptVisitor(joao);
	}
}

interface BanheiroVisitor {
	void visitarBanheiroFeminino();
	void visitarBanheiroMasculino();
}

class MulherBanheiroVisitor implements BanheiroVisitor {
	@Override
	public void visitarBanheiroFeminino() {
		System.out.println("Mulher diz: Lugar certo");
	}

	@Override
	public void visitarBanheiroMasculino() {
		System.out.println("Mulher diz: ops");
	}
}

class HomemBanheiroVisitor implements BanheiroVisitor {
	@Override
	public void visitarBanheiroFeminino() {
		System.out.println("Homem diz: ops");
	}

	@Override
	public void visitarBanheiroMasculino() {
		System.out.println("Homem diz: Lugar certo");
	}
}

interface Banheiro {
	void acceptVisitor(BanheiroVisitor v);
}

class BanheiroFeminino implements Banheiro {
	@Override
	public void acceptVisitor(BanheiroVisitor v) {
		v.visitarBanheiroFeminino();
	}
}

class BanheiroMasculino implements Banheiro {
	@Override
	public void acceptVisitor(BanheiroVisitor v) {
		v.visitarBanheiroMasculino();
	}
}