package chapter6;

import java.util.ArrayList;

public class Student {

	String studentName;
	ArrayList<Book> bookList;

	public Student(String studentName) {
		this.studentName = studentName;

		bookList = new ArrayList<Book>();
	}

	public void addBook(String title) {
		Book book = new Book(title);
		bookList.add(book);
	}

	public void showStudejtInfo() {
		System.out.print(studentName + "�л��� ���� å�� :");
		for (Book book : bookList) {
			System.out.print(book.getTitle() +" ");
		}
		System.out.println("�Դϴ�");
	}

}
