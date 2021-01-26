package object;

class Book implements Cloneable{ //interface 명시 
	String title;
	String author;
	
	public Book(String title, String author){
		this.title = title;
		this.author = author;
	}

	@Override
	public String toString() {
		return author+","+title;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
	
		return super.clone();
	}
	
 @Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

	//직접 불리는 메서드가 아니고 인스턴스가 힙메모리에서 해제될때 가비지 콜렉터에의해서 수행되는 코드부분이다
	
}

public class ToStringTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		Book book = new Book("토지", "박경리");
		System.out.println(book);
		
		String str = new String("토지");
		System.out.println(str.toString());

		Book book2 = (Book)book.clone();
		System.out.println(book2); //Cloneable interface명시안하면 오류남
		
	}

}
