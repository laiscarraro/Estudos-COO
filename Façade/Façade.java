public class Façade {
	public static void main(String[] args) {
		Compilador c = new Compilador();
		c.compilar();
	}
}

class Compilador {
	ClasseDificil1 classe1;
	ClasseDificil2 classe2;
	Compilador() {
		this.classe1 = new ClasseDificil1();
		this.classe2 = new ClasseDificil2();
	}
	public void compilar() {
		classe1.fazerCoisasDificeis();
		classe2.fazerCoisasDificeis();
	}
}

class ClasseDificil1 {
	public void fazerCoisasDificeis() {
		System.out.println("Coisas difíceis estão sendo feitas");
	}
}

class ClasseDificil2 {
	public void fazerCoisasDificeis() {
		System.out.println("Coisas difíceis estão sendo terminadas aaaaa");
		terminarCoisasDificeis();
	}

	public void terminarCoisasDificeis() {
		System.out.println("As coisas difíceis foram terminadas");
	}
}