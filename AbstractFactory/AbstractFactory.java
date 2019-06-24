public class AbstractFactory {
	public static void main(String[] args) {
		VestidoAbstractFactory factory = new VestidoNatalinoFactory();
		factory.CriaVestidoP().descricao();
		factory.CriaVestidoM().descricao();
		factory.CriaVestidoG().descricao();
	}
}

abstract class VestidoAbstrato {
	String nome;
	String tamanho;
	String cor;

	VestidoAbstrato() {
		this.nome = "Vestido";
	}

	public void descricao() {
		System.out.println(this.nome + " de tamanho " + this.tamanho + ", na cor " + this.cor + ".");
	}
}

abstract class VestidoNormalAbstrato extends VestidoAbstrato {
	VestidoNormalAbstrato(){
		super();
		this.cor = "preta";
	}
}

abstract class VestidoNatalinoAbstrato extends VestidoAbstrato {
	VestidoNatalinoAbstrato(){
		super();
		this.cor = "verde com bolinhas vermelhas";
	}
}

class VestidoNormalP extends VestidoNormalAbstrato {
	VestidoNormalP(){
		super();
		this.tamanho = "p";
	}
}

class VestidoNormalM extends VestidoNormalAbstrato {
	VestidoNormalM(){
		super();
		this.tamanho = "m";
	}
}

class VestidoNormalG extends VestidoNormalAbstrato {
	VestidoNormalG(){
		super();
		this.tamanho = "g";
	}
}

class VestidoNatalinoP extends VestidoNatalinoAbstrato {
	VestidoNatalinoP(){
		super();
		this.tamanho = "p";
	}
}

class VestidoNatalinoM extends VestidoNatalinoAbstrato {
	VestidoNatalinoM(){
		super();
		this.tamanho = "m";
	}
}

class VestidoNatalinoG extends VestidoNatalinoAbstrato {
	VestidoNatalinoG(){
		super();
		this.tamanho = "g";
	}
}

abstract class VestidoAbstractFactory {
	public abstract VestidoAbstrato CriaVestidoP();
	public abstract VestidoAbstrato CriaVestidoM();
	public abstract VestidoAbstrato CriaVestidoG();
}

class VestidoNormalFactory extends VestidoAbstractFactory {
	@Override
	public VestidoAbstrato CriaVestidoP() {
		return new VestidoNormalP();
	}
	@Override
	public VestidoAbstrato CriaVestidoM() {
		return new VestidoNormalM();
	}
	@Override
	public VestidoAbstrato CriaVestidoG() {
		return new VestidoNormalG();
	}
}

class VestidoNatalinoFactory extends VestidoAbstractFactory {
	@Override
	public VestidoAbstrato CriaVestidoP() {
		return new VestidoNatalinoP();
	}
	@Override
	public VestidoAbstrato CriaVestidoM() {
		return new VestidoNatalinoM();
	}
	@Override
	public VestidoAbstrato CriaVestidoG() {
		return new VestidoNatalinoG();
	}
}
