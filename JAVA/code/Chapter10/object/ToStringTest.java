package object;

class Book implements Cloneable{ //interface ��� 
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

	//���� �Ҹ��� �޼��尡 �ƴϰ� �ν��Ͻ��� ���޸𸮿��� �����ɶ� ������ �ݷ��Ϳ����ؼ� ����Ǵ� �ڵ�κ��̴�
	
}

public class ToStringTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		Book book = new Book("����", "�ڰ渮");
		System.out.println(book);
		
		String str = new String("����");
		System.out.println(str.toString());

		Book book2 = (Book)book.clone();
		System.out.println(book2); //Cloneable interface��þ��ϸ� ������
		
	}

}
