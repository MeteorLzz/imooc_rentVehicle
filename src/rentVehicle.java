import java.util.Scanner;

public class rentVehicle {

	static vehicle audiA4 = new car("奥迪A4", 500, 4);
	static vehicle mazda6 = new car("马自达6", 400, 4);
	static vehicle kinglong = new car("金龙", 800, 20);
	static vehicle chervolet = new pickup("雪弗兰6", 450, 4, 2);
	static vehicle songhuajiang = new truck("松花江", 400, 4);
	static vehicle iveco = new truck("依维柯", 1000, 20);

	static vehicle[] order = { audiA4, mazda6, kinglong, chervolet,
			songhuajiang, iveco };

	public static void info() {
		System.out.println("您可租车的类型及其价目表：");
		System.out.println("序号\t汽车名称\t租金\t容量");
		for (int i = 0; i < order.length; i++) {
			if (order[i] instanceof car) {
				System.out.println(i + 1 + "\t" + order[i].name + "\t"
						+ order[i].cost + "元/天" + "\t" + order[i].peopleNum
						+ "人");
			} else if (order[i] instanceof pickup) {
				System.out.println(i + 1 + "\t" + order[i].name + "\t"
						+ order[i].cost + "元/天" + "\t" + order[i].peopleNum
						+ "人" + order[i].cargoNum + "吨");
			} else {
				System.out.println(i + 1 + "\t" + order[i].name + "\t"
						+ order[i].cost + "元/天" + "\t" + order[i].cargoNum
						+ "吨");
			}

		}

	}
	
	public static void rent(){
		int total = 0;
		System.out.println("欢迎使用逗逗租车系统！");
		System.out.println("您是否要租车？    1、是    2、否");
		Scanner sc = new Scanner(System.in);

		int input = sc.nextInt();
		if (input == 2) {
			System.out.println("再见！");
			System.exit(0);
		} else if (input == 1) {
			info();
			System.out.println("请输入您要租车的数量：");

			int quantity = sc.nextInt();

			for (int i = 0; i < quantity; i++) {
				System.out.println("请输入第" + (i + 1) + "辆车的编号：");
				int number = sc.nextInt();
				total += order[number - 1].cost;
			}
			System.out.println("请输入租车天数：");
			int days = sc.nextInt();

			System.out.println("总计:" + total * days + "元");
		} else {
			System.out.println("输入有误！请重新输入！");
			rent();
		}
		sc.close();
	}

	public static void main(String[] args) {
		rent();
	}

}
