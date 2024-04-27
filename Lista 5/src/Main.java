import java.util.Comparator;

import core.*;
import testing.*;
import testing.comparators.*;
import testing.generation.*;
import testing.generation.conversion.*;

public class Main {


	public static void main(String[] args) {
		Comparator<MarkedValue<Integer>> markedComparator = new MarkedValueComparator<>(new IntegerComparator());

//		LinkedListGenerator<MarkedValue<Integer>> generator = new LinkedListGenerator(new MarkingGenerator<>(new RandomIntegerArrayGenerator(10)));
		MarkingGenerator<Integer> generator = new MarkingGenerator<Integer>(new ReversedIntegerArrayGenerator());


		SortingAlgorithm<MarkedValue<Integer>> algorithm = new QuickSort<>(markedComparator);


		Result result = Tester.runNTimes(algorithm, generator, 500, 20);

		printStatistic("time [ms]", result.averageTimeInMilliseconds(), result.timeStandardDeviation());
		printStatistic("comparisons", result.averageComparisons(), result.comparisonsStandardDeviation());
		printStatistic("swaps", result.averageSwaps(), result.swapsStandardDeviation());

		System.out.println("always sorted: " + result.sorted());
		System.out.println("always stable: " + result.stable());

		System.out.println("--------------------------");
		System.out.println("linked");

//		LinkedListGenerator<MarkedValue<Integer>> generator2 = new LinkedListGenerator(new MarkingGenerator<>(new RandomIntegerArrayGenerator(10)));
		MarkingGenerator<Integer> generator2 = new MarkingGenerator<Integer>(new ReversedIntegerArrayGenerator());


		SortingAlgorithm<MarkedValue<Integer>> algorithm2 = new QuickSort<>(markedComparator);


		Result result2 = Tester.runNTimes(algorithm2, generator2, 200, 20);

		printStatistic("time [ms]", result2.averageTimeInMilliseconds(), result2.timeStandardDeviation());
		printStatistic("comparisons", result2.averageComparisons(), result2.comparisonsStandardDeviation());
		printStatistic("swaps", result2.averageSwaps(), result2.swapsStandardDeviation());

		System.out.println("always sorted: " + result2.sorted());
		System.out.println("always stable: " + result2.stable());
	}

	private static void printStatistic(String label, double average, double stdDev) {
		System.out.println(label + ": " + double2String(average) + " +- " + double2String(stdDev));
	}

	private static String double2String(double value) {
		return String.format("%.12f", value);
	}

}
