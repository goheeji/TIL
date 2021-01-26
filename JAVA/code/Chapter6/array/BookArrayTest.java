package array;

public class BookArrayTest {

	public static void main(String[] args) {

		Book[] library = new Book[5]; // 책이 5권이 생긴것이아니라 배열이 생긴것이다. 
		
		//책이 5권이 생기려면 다섯번 new를해야한다
		library[0] = new Book("태백산맥1","조정레");
		library[1] = new Book("태백산맥2","조정레");
		library[2] = new Book("태백산맥3","조정레");
		library[3] = new Book("태백산맥4","조정레");
		library[4] = new Book("태백산맥5","조정레");

		for (int i = 0; i < library.length; i++) {

			System.out.println(library[i]); //address값이 출력이된다.
			library[i].showBookInfo();
		}

	}
}
