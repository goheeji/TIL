package array;

//깊은복사 예제
public class ObjectCopy2 {

	public static void main(String[] args) {
		Book[] library = new Book[5];
		Book[] copyLibrary = new Book[5];

		library[0] = new Book("태백산맥1", "조정레");
		library[1] = new Book("태백산맥2", "조정레");
		library[2] = new Book("태백산맥3", "조정레");
		library[3] = new Book("태백산맥4", "조정레");
		library[4] = new Book("태백산맥5", "조정레");

		copyLibrary[0] = new Book();
		copyLibrary[1] = new Book();
		copyLibrary[2] = new Book();
		copyLibrary[3] = new Book();
		copyLibrary[4] = new Book();

		for (int i = 0; i < library.length; i++) {
			copyLibrary[i].setTitle(library[i].getTitle());
			copyLibrary[i].setAuthor(library[i].getAuthor());

		}

		library[0].setTitle("나목");
		library[0].setAuthor("박완서");

		for (Book book : library) {
			book.showBookInfo();
		}

		System.out.println("===================");

		for (Book book : copyLibrary) {
			book.showBookInfo(); // 바뀌지 않았다.
		}
	}

}
