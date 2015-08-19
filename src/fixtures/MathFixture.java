package fixtures;
import codebase.MathUtilities;
import fit.*;

public class MathFixture  extends ColumnFixture {
	private long primeLong = 1L;
	private int primeInt = 1;
	private int fibonacciInt = 1;
	private long fibonacciLong = 1L;
	
	public boolean testPrimeInt(){
		return MathUtilities.isPrime(primeInt);
	}
	
	public long testFibonacciInt(){
		return MathUtilities.fibonacci(fibonacciInt);
	}
	
	public long testFibonacciLong(){
		return MathUtilities.fibonacci(fibonacciLong);
	}
	
	public boolean testPrimeLong(){
		return MathUtilities.isPrime(primeLong);
	}
	
	public int getPrimeInt() {
		return primeInt;
	}

	public void setPrimeInt(int primeInt) {
		this.primeInt = primeInt;
	}
	
	public long getFibonacciLong() {
		return fibonacciLong;
	}

	public void setFibonacciLong(long fibonacciLong) {
		this.fibonacciLong = fibonacciLong;
	}

	public int getFibonacciInt() {
		return fibonacciInt;
	}

	public void setFibonacciInt(int fibonacciInt) {
		this.fibonacciInt = fibonacciInt;
	}

	public long getPrimeLong() {
		return primeLong;
	}

	public void setPrimeLong(long primeLong) {
		this.primeLong = primeLong;
	}
}