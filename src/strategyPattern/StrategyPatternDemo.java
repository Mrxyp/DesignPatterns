package strategyPattern;

import javax.swing.text.IconView;

/* 策略模式:
 * 策略模式定义了一系列算法，并将每个算法封装起来，使他们可以相互替换，且算法的变化不会影响到使用算法的客户。
 * */
public class StrategyPatternDemo {
	public static void main(String agrs[]){
		ICaculator c=new Dev();
		System.out.println(c.caculator("6/3"));
		
		ICaculator c1=new Plus();
		System.out.println(c1.caculator("6+3"));
	}
}
interface ICaculator{//抽象接口
	public int caculator(String exp);
}

abstract class AbstractCaculator{//辅助抽象类
	public int[] split(String exp,String opt){
		String array[]=exp.split(opt);
		int arrayint[]=new int[2];
		arrayint[0]=Integer.parseInt(array[0]);
		arrayint[1]=Integer.parseInt(array[1]);
		return arrayint;
	}
}

 class Plus extends AbstractCaculator implements ICaculator {//加法类  
    @Override  
    public int caculator(String exp) {  
        int arrayInt[] = split(exp,"\\+");  
        return arrayInt[0]+arrayInt[1];  
    }  
}  
 
 class Mul extends AbstractCaculator implements ICaculator {//乘法类  
	    @Override  
	    public int caculator(String exp) {  
	        int arrayInt[] = split(exp,"\\*");  
	        return arrayInt[0]*arrayInt[1];  
	    }  
	}  
 
 class Sub extends AbstractCaculator implements ICaculator {//减法类  
	    @Override  
	    public int caculator(String exp) {  
	        int arrayInt[] = split(exp,"-");  
	        return arrayInt[0]-arrayInt[1];  
	    }  
	}  
 class Dev extends AbstractCaculator implements ICaculator {//除法类  
	    @Override  
	    public int caculator(String exp) {  
	        int arrayInt[] = split(exp,"\\/");  
	        return arrayInt[0]/arrayInt[1];  
	    }  
	}  