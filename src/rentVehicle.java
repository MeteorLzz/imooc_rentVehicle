import java.util.Scanner;

public class rentVehicle {

	static vehicle audiA4 = new car("�µ�A4", 500, 4);
	static vehicle mazda6 = new car("���Դ�6", 400, 4);
	static vehicle kinglong = new car("����", 800, 20);
	static vehicle chervolet = new pickup("ѩ����6", 450, 4, 2);
	static vehicle songhuajiang = new truck("�ɻ���", 400, 4);
	static vehicle iveco = new truck("��ά��", 1000, 20);

	static vehicle[] order = { audiA4, mazda6, kinglong, chervolet,
			songhuajiang, iveco };

	public static void info() {
		System.out.println("�����⳵�����ͼ����Ŀ��");
		System.out.println("���\t��������\t���\t����");
		for (int i = 0; i < order.length; i++) {
			if (order[i] instanceof car) {
				System.out.println(i + 1 + "\t" + order[i].name + "\t"
						+ order[i].cost + "Ԫ/��" + "\t" + order[i].peopleNum
						+ "��");
			} else if (order[i] instanceof pickup) {
				System.out.println(i + 1 + "\t" + order[i].name + "\t"
						+ order[i].cost + "Ԫ/��" + "\t" + order[i].peopleNum
						+ "��" + order[i].cargoNum + "��");
			} else {
				System.out.println(i + 1 + "\t" + order[i].name + "\t"
						+ order[i].cost + "Ԫ/��" + "\t" + order[i].cargoNum
						+ "��");
			}

		}

	}
	
	public static void rent(){
		int total = 0;
		System.out.println("��ӭʹ�ö����⳵ϵͳ��");
		System.out.println("���Ƿ�Ҫ�⳵��    1����    2����");
		Scanner sc = new Scanner(System.in);

		int input = sc.nextInt();
		if (input == 2) {
			System.out.println("�ټ���");
			System.exit(0);
		} else if (input == 1) {
			info();
			System.out.println("��������Ҫ�⳵��������");

			int quantity = sc.nextInt();

			for (int i = 0; i < quantity; i++) {
				System.out.println("�������" + (i + 1) + "�����ı�ţ�");
				int number = sc.nextInt();
				total += order[number - 1].cost;
			}
			System.out.println("�������⳵������");
			int days = sc.nextInt();

			System.out.println("�ܼ�:" + total * days + "Ԫ");
		} else {
			System.out.println("�����������������룡");
			rent();
		}
		sc.close();
	}

	public static void main(String[] args) {
		rent();
	}

}
