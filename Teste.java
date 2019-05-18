//Esta é a classe pública do arquivo, que deve dar seu nome. Um arquivo não pode conter mais de uma classe public
//Nela, deixei o main
public class Teste {
	public static void main(String[] args) {
		System.out.println("OIEEEE");
	}
}
//Uma classe é um modelo que define comportamentos e o estado interno de algo.
//Os comportamentos são definidos pelos métodos, e o estado interno, pelos atributos.
//Os atributos são meramente variáveis, que podem ser de classe (campos estáticos, que não variam de instância para instância)
//ou de instância (mudam em cada instância), ou até mesmo temporárias (em escopo de método, deixam de existir após sua execução)
//Uma instância de uma classe, ou um Objeto, é a especificação de uma classe, e suas variáveis passam a ser definidas.
//Quando os dados são agrupados em objetos, passam a ter um significado, tanto para o programador quanto para o usuário.

//Aqui, eu decidi criar uma classe abstrata, e não uma interface, porque aqui eu defino o que uma vestimenta é,
//e não apenas o que ela pode fazer.
//Por exemplo, defini duas variáveis que todas as vestimentas apresentam, e um construtor geral.
//Por fim, declarei também um método, usar(), o qual vai ser comum a todas as vestimentas, mas que vai ser
//implementado de uma forma diferente em cada filha, e por isso poderia ser abstrato.
//No entanto, como a classe Acessório não precisa implementar algo diferente, resolvi deixar como concreto
// como se fosse um comportamento default do método.
abstract class Vestimenta {
	String ocasiao;
	boolean disponivel;

	Vestimenta(String ocasiao) {
		this.ocasiao = ocasiao;
		this.disponivel = true;
	}

	public void usar() throws NaoDisponivelException {};
}
//OBS.: Uma vestimenta não pode ser instanciada, porque é abstrata. Isso faz sentido no mundo real, devemos ser mais específicos.

//Aqui eu escolhi fazer uma interface porque, além de ser abstrata, a classe só fala sobre um comportamento específico,
//o qual pode ser implementado de formas diferentes. Além disso, não queria que todas as vestimentas fossem laváveis (ex.: acessório)
//Não escrevi abstract porque ele é "chamável"
//A única coisa é que eu não posso chamar ele com uma Vestimenta, porque Vestimenta não é instanciável, por ser abstrata

interface Lavavel {
	void lavar();
}
//Não foi necessário definir o método como public, pois todos os métodos de interface são obrigatoriamente public, assim como abstract

//A classe Roupa herda os comportamentos e atributos de Vestimenta e, ainda, implementa o comportamento de lavável.
class Roupa extends Vestimenta implements Lavavel {
	int maxUsos;
	int usos;

	//Essa classe apresenta duas variáveis um pouco mais específicas, que não estão em todas as vestimentas.
	//Por isso, além de usar o construtor padrão de vestimeta (super()), inicializa, também, suas próprias variáveis.

	Roupa(String ocasiao) {
		super(ocasiao);
		this.usos = 0;
	}

	//A anotação @Override só anuncia ao compilador que o método está sobrescrevendo aquele da superclasse ou da interface.
	//Nesse caso, estamos sobrescrevendo o método usar.
	//Ele pode lançar uma exceção, ou seja, se ela não for tratada por quem chamar o método, a execução do programa será interrompida.
	//Essa exceção foi criada por mim, porque se encaixa no contexto do programa.
	@Override
	public void usar() throws NaoDisponivelException {
		if(!this.disponivel) {
			//Aqui eu instanciei uma PrecisaLavarException como se fosse uma NaoDisponivelException
			if(this.usos == this.maxUsos) throw new PrecisaLavarException();
			//É que, na verdade, ela é, pois é filha dela, e herda todos os seus comportamentos
			//Isso se chama Polimorfismo
			else throw new NaoDisponivelException();
		}
		else this.usos++;
		if(this.usos == this.maxUsos) this.disponivel = false;
	}

	//Aqui, novamente a anotação @Override anuncia que um método está sendo sobrescrito.
	//No caso, aqui, o método da interface está sendo implementado. Então, não é como em cima, que era opcional
	//Porque, em cima, o método já estava implementado na classe, e era concreto
	//Aqui, o método da interface era abstrato, então eu sou obrigada a implementar ele.
	@Override
	public void lavar() {
		this.usos = 0;
		this.disponivel = true;
	}
}


class Calcado extends Vestimenta implements Lavavel {
	boolean meia;
	boolean limpo;

	Calcado(String ocasiao) {
		super(ocasiao);
		this.limpo = true;
	}

	@Override
	public void usar() throws NaoDisponivelException {
		if(!this.disponivel) {
			if(!this.limpo) throw new PrecisaLavarException();
			else throw new NaoDisponivelException();
		}
	}

	@Override
	public void lavar() {
		this.limpo = true;
		this.disponivel = true;
	}
}

//Aqui, eu não precisei sobrescrever o método usar() porque ele não era abstrato. 
//Ao invés disso, acessório chamará o método default implementado na superclasse.
class Acessorio extends Vestimenta {
	Acessorio(String ocasiao) {
		super(ocasiao);
	}
}

//Aqui, criei uma exception genérica para uma vestimenta que não está disponível. 
//A classe é filha de Exception, pois deve ser Throwable (interface implementada por Exception)
class NaoDisponivelException extends Exception {
	//Aqui eu criei dois construtores diferentes
	//Isso não dá problema, porque o compilador decide qual método utilizar em tempo de execução
	//Isso é chamado de Late Binding ou Vinculação Tardia
	NaoDisponivelException(String mensagem) {
		super(mensagem);
	}
	NaoDisponivelException() {
		super("Ops! Esta peça não está disponível");
	}
}

//Essa classe também é uma exceção, pois é filha de NaoDisponivelException que, por sua vez, é filha de Exception
//Já que Exception implementa Throwable, NDE herda os comportamentos de Ex., e de sua implementação de Throwable
//Desse modo, PLE também herda tudo isso
class PrecisaLavarException extends NaoDisponivelException {
	PrecisaLavarException() {
		super("Ops! Você precisa lavar essa peça antes de usá-la novamente.");
	}
}
