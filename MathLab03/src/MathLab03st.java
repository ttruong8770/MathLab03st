import javax.swing.JOptionPane;
public class MathLab03st 
{
	public static void main (String args[])
	{   
		String strNum1 = JOptionPane.showInputDialog("Enter Numerator 1"); 
		String strDen1 = JOptionPane.showInputDialog("Enter Denominator 1");
		String strNum2 = JOptionPane.showInputDialog("Enter Numerator 2"); 
		String strDen2 = JOptionPane.showInputDialog("Enter Denominator 2");
		
		int num1 = Integer.parseInt(strNum1);
		int den1 = Integer.parseInt(strDen1);
		int num2 = Integer.parseInt(strNum2);
		int den2 = Integer.parseInt(strDen2);


		Rational r1 = new Rational(num1,den1);
		Rational r2 = new Rational(num2,den2);
		Rational r3 = new Rational();
		
		r3.multiply(r1,r2);
		String mul = r1.getOriginal() + " * " + r2.getOriginal() + "  =  " + r3.getRational();
		r3.divide(r1,r2);
		String div = r1.getOriginal() + " / " + r2.getOriginal() + "  =  " + r3.getRational();		
		r3.add(r1,r2);
		String add = r1.getOriginal() + " + " + r2.getOriginal() + "  =  " + r3.getRational();
		r3.subtract(r1,r2);
		String sub = r1.getOriginal() + " - " + r2.getOriginal() + "  =  " + r3.getRational();
		
		String output = mul + "\n" + div + "\n" + add + "\n" + sub;
		
		JOptionPane.showMessageDialog(null,output);
          
		System.exit(0);
	}
}


		


class Rational
{
	
	private int firstNum;	// entered numerator
	private int firstDen;	// entered denominator
	private int num;		// reduced numerator
	private int den;		// reduced denominator
	
	public Rational()
	{


	}
	
	public Rational(int n, int d)
	{
			firstNum = n;
			firstDen = d;		
			reduce();
	}
	
	private int getGCF(int n1,int n2)
	{
		int rem = 0;
		int gcf = 0;
		do
		{
			rem = n1 % n2;
			if (rem == 0)
				gcf = n2;
			else
			{
				n1 = n2;
				n2 = rem;
			}
		}
		while (rem != 0);
		return gcf;
	}


	public void reduce()
	{
		int gcf = getGCF(firstNum,firstDen);
		num = firstNum / gcf;
		den = firstDen / gcf;
	}
	
	public double getDecimal()
	{
		return (double)num/den;
	}


	public String getRational()
	{
		int gcf = getGCF(num,den);
		return (num / gcf)+ "/" + (den / gcf);
	}
	
	public String getOriginal()
	{
		return firstNum + "/" + firstDen; 
	}
	
	public int getNum()
	{
		return num;
	}


	public int getDen()
	{
		return den;
	}
	
	public void multiply(Rational r1, Rational r2)
	{
		num = r1.getNum() * r2.getNum();
		den = r1.getDen() * r2.getDen();
	}


	public void divide(Rational r1, Rational r2)
	{
		num = r1.getNum() * r2.getDen();
		den = r1.getDen() * r2.getNum();
	}
	
	public void add(Rational r1, Rational r2)
	{
		num = (r1.getNum() * r2.getDen()) + (r2.getNum() * r1.getDen());
		den = r1.getDen() * r2.getDen();
	}
	
	public void subtract(Rational r1, Rational r2)
	{
		num = (r1.getNum() * r2.getDen()) - (r2.getNum() * r1.getDen());
		den = r1.getDen() * r2.getDen();
	}
 
}