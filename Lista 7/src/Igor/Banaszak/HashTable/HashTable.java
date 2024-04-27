package Igor.Banaszak.HashTable;

import Igor.Banaszak.HashFunction.HashFunction;

import java.util.Comparator;

public abstract class HashTable<T> {
	
	protected final double maxLoadFactor;
	protected final Comparator<? super T> comparator;
	protected final HashFunction<T> hashFunction;
	protected final int startSize = 10;
	protected int size = 0;

	protected int colisions = 0;
	protected int insertComparisons = 0;
	protected int lookUpComparisons = 0;
	protected int hash = 0;


	protected HashTable(double maxLoadFactor, Comparator<? super T> comparator,HashFunction<T> hashFunction) {
		this.maxLoadFactor = maxLoadFactor;
		this.comparator = comparator;
		this.hashFunction = hashFunction;
	}
	
	public final double loadFactor() {
		return size() / ((double) capacity());
	}
	
	
	public abstract int capacity();
	public abstract int size();
	
	public abstract void insert(T object);
	public abstract boolean lookUp(T object);
	
	public abstract int collisions();
	public abstract int insertComparisons();
	public abstract int lookUpComparisons();
	public abstract int hashFunctionEvaluations();
}
