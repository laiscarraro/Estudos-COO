import java.util.*;
public class Flyweight {
	public static void main(String[] args) {
		FlyweightFactory fac = new FlyweightFactory();
		FlyweightClass fly = fac.getFlyweight(2);
		fly.metodo(1);

		FlyweightClass fly2 = fac.getFlyweight(2);
		fly2.metodo(2);
	}
}

class FlyweightFactory {
	HashMap<Integer, FlyweightClass> flyweightPool = new HashMap<>();
	public FlyweightClass getFlyweight(int chave) {
		if(flyweightPool.get(chave) != null) {
			System.out.println("Objeto ja criado");
			return flyweightPool.get(chave);
		} else {
			System.out.println("Objeto sendo criado");
			FlyweightClass f = new FlyweightConcreto(chave);
			flyweightPool.put(chave, f);
			return f;
		}
	}
}

abstract class FlyweightClass {
	int intrinseco;
	FlyweightClass(int chave) {
		this.intrinseco = chave;
	}
	public abstract void metodo(int extrinseco);
}

class FlyweightConcreto extends FlyweightClass {
	FlyweightConcreto(int chave) {
		super(chave);
	}
	@Override
	public void metodo(int extrinseco) {
		System.out.println(this.intrinseco + extrinseco);
	}
}