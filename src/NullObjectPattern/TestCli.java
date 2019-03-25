package NullObjectPattern;

public class TestCli {

	public static void main(String[] args) {
		AbstractCustomer customer1 = CustomerFactory.getCustomer("xh");
		AbstractCustomer customer2 = CustomerFactory.getCustomer("xn");
		AbstractCustomer customer3 = CustomerFactory.getCustomer("xm");
		AbstractCustomer customer4 = CustomerFactory.getCustomer("Laura");

		System.out.println("Customers");
		System.out.println(customer1.getName());
		System.out.println(customer2.getName());
		System.out.println(customer3.getName());
		System.out.println(customer4.getName());
	}
}
