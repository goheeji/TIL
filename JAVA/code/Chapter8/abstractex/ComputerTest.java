package abstractex;

public class ComputerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Computer computer = new DeskTop();
		computer.display();
		computer.turnOff();
		
		Computer myNote = new MyNoteBook();
		NoteBook myNote2 = new MyNoteBook(); //�Ȱ��� �׻� ����Ŭ������ �����ϰ��ִ�.
		

	}

}
