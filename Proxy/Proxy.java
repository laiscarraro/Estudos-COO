import java.util.concurrent.TimeUnit ;

public class Proxy {
	public static void main(String[] args)  throws InterruptedException{
		Imagem im = new ImagemProxy();
		im.carregar();
	}
}

interface Imagem {
	public void carregar() throws InterruptedException;
}

class ImagemProxy implements Imagem {
	Imagem im;
	ImagemProxy() {
		this.im = new ImagemReal();
	}
	@Override
	public void carregar()  throws InterruptedException{
		System.out.println("Carregando imagem...");
		this.im.carregar();
	}
}

class ImagemReal implements Imagem {
	public void carregar()  throws InterruptedException{
		TimeUnit.SECONDS.sleep(5);
		System.out.println("Imagem");
	}
}