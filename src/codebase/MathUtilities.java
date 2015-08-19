package codebase;
public enum MathUtilities{;
	public static boolean isPrime(int number){
		if (number < 2){
			return false;
		}
		long numberLong = 0L;
		numberLong += number;
		return isPrime(numberLong);
	}

	public static boolean isPrime(long number){
		if (number < 2){
			return false;
		}
		for (long l = 2L; l <= number / l; l++){
			if (number % l == 0){
				return false;
			}
		}
		return true;
	}
	
	public static long fibonacci(int index){
		if (index <= 0){
			return 0L;
		}
		if (index == 1){
			return 1L;
		}
		long [] sequence = new long [index + 1];
		sequence[0] = 0;
		sequence[1] = 1;
		for (int i = 2; i < index + 1; i++){
			sequence[i] = sequence[i - 1] + sequence[i - 2];
		}
		return sequence[index];
	}

	public static long fibonacci(long index){
		if (index < 0){
			return 0;
		}
		if (index == 0){
			return 0;
		}
		if (index == 1){
			return 1L;
		}
		return fibonacci(index - 1) + fibonacci(index - 2);
	}
	
	public static void main (String [] args){
		System.out.println(fibonacci(20L));
		System.out.println(fibonacci(20));
	}
}
