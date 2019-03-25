package strategyPattern;

/**
 * 抽象策略接口
 * 
 */
interface Strategy {
	public void caculatePrice(double price);
}

/**
 * 超级vip
 * 
 */
class SuperVipCaculate implements Strategy {

	@Override
	public void caculatePrice(double price) {
		System.out.println("SuperVip price:" + price * 0.8);
	}
}

/**
 * Vip
 * 
 */
class VipCaculate implements Strategy {

	@Override
	public void caculatePrice(double price) {
		System.out.println("Vip price:" + price * 0.9);
	}
}

/**
 * 普通
 */
class NominalCaculate implements Strategy {
	@Override
	public void caculatePrice(double price) {
		System.out.println("Nominal pirce:" + price);
	}
}

/**
 * 商场
 * 
 */
class Market {
	private Strategy strategy;

	public void caculatePrice(double price, String cusGrade) {
		strategy = new NominalCaculate();
		if ("superVip".equals(cusGrade)) {
			strategy = new SuperVipCaculate();
		}
		if ("vip".equals(cusGrade)) {
			strategy = new VipCaculate();
		}
		strategy.caculatePrice(price);
	}
}

public class StrategyPatternCli {
	public static void main(String[] args) {
		Market market = new Market();
		market.caculatePrice(100, "vip");
		market.caculatePrice(100, "superVip");
		market.caculatePrice(100, "");
	}
}