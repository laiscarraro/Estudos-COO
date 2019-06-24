public class Singleton {
	public static void main(String[] args) {
		Zeus.rezarZeus().trovejar();
		Zeus.rezarZeus().chover();
		Zeus.rezarZeus().lerSobreZeus();
	}
}

class Zeus {
	static Zeus zeusOficial;
	String infoZeus;

	private Zeus() {
		this.infoZeus = "Zeus eh uma coisa, ele eh mo de boas";
	}

	public static Zeus rezarZeus() {
		if(zeusOficial == null) {
			return new Zeus();
		} else {
			return zeusOficial;
		}
	}

	public void chover() {
		System.out.println("Olha ai a chuva");
	}

	public void lerSobreZeus() {
		System.out.println(this.infoZeus);
	}

	public void trovejar() {
		System.out.println("Brummm");
	}

}