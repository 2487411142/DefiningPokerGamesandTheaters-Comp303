package chapter9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Client {
	
	public static void main(String[] args){
		
		ArrayList<Movie> movies = new ArrayList<>(Movies.movies());
		
		Long result = movies.stream()
		.map(Movie::title)
		.map(String::toLowerCase)
		.flatMap(s -> Arrays.stream(s.split("[\\s,]+")))
		.filter(Predicate.isEqual("the"))
		.count();
		
		Movie m = movies.stream()
				.reduce((m1, m2) -> m1.time() > m2.time() ? m1 : m2)
				.get();
		
		Map<String, Integer> map = movies.stream()
				.collect(Collectors.toMap(Movie::title, Movie::time));
		
		 
		Movies.movies().stream()
				      .collect(Collectors.groupingBy(Movie::decade))
				      .entrySet()
				      .stream()
				      .filter(e -> e.getKey().equals("50s") || e.getKey().equals("60s"))
				      .flatMap(e -> e.getValue().stream())
				      .forEach(System.out::println);
		
		
	}
}
