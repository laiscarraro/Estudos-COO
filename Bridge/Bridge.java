public class Bridge {
	public static void main(String[] args) {
		Botao voltar = new BotaoVoltar();
		voltar.imp = new ImpBotaoEspanhol();
		voltar.clicar();
	}
}

abstract class Botao {
	ImpBotao imp;
	public void clicar(){
		this.imp.ImpClicar();
	}
}

class BotaoMenu extends Botao {
	@Override
	public void clicar() {
		System.out.print("Clicando no botao Menu ");
		super.clicar();
	}
}

class BotaoVoltar extends Botao {
	@Override 
	public void clicar() {
		System.out.print("Clicando no botao Voltar ");
		super.clicar();
	}
}

interface ImpBotao {
	public void ImpClicar();
}

class ImpBotaoEspanhol implements ImpBotao {
	@Override
	public void ImpClicar(){
		System.out.println("(obs.: clicks in spanish)");
	}
}

class ImpBotaoIngles implements ImpBotao {
	@Override
	public void ImpClicar(){
		System.out.println("(obs.: clicks in gringo)");
	}
}