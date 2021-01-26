package generic;

public class GenericPrinter<T extends Material> {

	private T material;

	public T getMeterial() {
		return material;
	}

	public void setMeterial(T material) {
		this.material = material;
	}

	public String toString() {
		return material.toString();
	}
	
	public void printing(){
		material.doPrinting();
	}

}
