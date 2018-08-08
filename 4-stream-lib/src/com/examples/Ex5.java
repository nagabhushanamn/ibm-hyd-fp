package com.examples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Product implements Comparable<Product> {

	private String name;
	private double price;
	private ProductType type;

	public Product(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

	public Product(String name, double price, ProductType type) {
		super();
		this.name = name;
		this.price = price;
		this.type = type;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", type=" + type + "]";
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}
	
	

	public ProductType getType() {
		return type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}

	@Override
	public int compareTo(Product o) {
		return (int) (this.price - o.price);
	}

}

public class Ex5 {

	public static void main(String[] args) {
		
		Product[] products= {
				new Product("laptop", 6000,ProductType.ELEC),
				new Product("mobile", 8000,ProductType.ELEC),
				new Product("ipad", 5000,ProductType.ELEC),
				//new Product("laptop", 6000,ProductType.ELEC),
				new Product("camera", 7000,ProductType.ELEC),
				new Product("watch", 100,ProductType.ELEC),
				//new Product("mobile", 8000,ProductType.ELEC),
				new Product("food1", 10,ProductType.FOOD),
				new Product("food2", 30,ProductType.FOOD),
				new Product("food3", 20,ProductType.FOOD),
		};
		
		//----------------------------------------------------
		
		Stream<Product> stream=Arrays.stream(products);
		stream.filter(p->p.getPrice()>3000)
		      .limit(4)
		      .distinct()
		      .forEach(System.out::println);;
		
		//----------------------------------------------------
		      
		      
		 // map  ==> n-input    ==> n-output
		 // flatMap ==> n-input ==> n or > n output
		      
		      
		 Stream<String> namesStream=Stream.of("nag","indu","ria");
		 
		 namesStream
		 .map(n->n.toUpperCase())
		 .forEach(n->System.out.println(n));
		 
		 Stream<String> menuStream=Stream.of("idly,vada,poori","chicken,mutton,fish");
		 menuStream
		 .flatMap(menu->Stream.of(menu.split(",")))
		 .forEach(System.out::println);
		 
		//----------------------------------------------------
		 
		 
		 Arrays.stream(products)
		 .filter(p->p.getPrice()>5000)
		 .map(Product::getName)
		 .forEach(System.out::println);
		 
		//----------------------------------------------------
		 
		 
		 Arrays.stream(products)
		 //.sorted((p1,p2)->(int)(p2.getPrice()-p1.getPrice()))
		 .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
		 .forEach(System.out::println);
		 
		 
		//----------------------------------------------------
		 // Terminal methods
//     ----------------------------------------------------
		 
		boolean b= Arrays.stream(products)
		 .noneMatch(p->p.getPrice()>4000);
		System.out.println(b);
		
//		----------------------------------------------------
		long c= Arrays.stream(products)
				  .count();
		
//		----------------------------------------------------
		
		Optional<Product> optional=
		 Arrays.stream(products)
		.filter(p->p.getPrice()>1000)
		.findFirst();
		
		System.out.println(optional.isPresent());
		System.out.println(optional.get());
		
//		----------------------------------------------------
		
		
		optional=Arrays.stream(products)
		.min(Comparator.comparingDouble(Product::getPrice));
		
		System.out.println(optional.get());
		
//		----------------------------------------------------
		
		
		Object[] objects=Arrays.stream(products)
		.filter(p->p.getPrice()>4000)
		.toArray();
		
		Product[] productsOut=
				Arrays.stream(products)
				.filter(p->p.getPrice()>4000)
				//.toArray(size->new Product[size]);
				.toArray(Product[]::new);
		
//		----------------------------------------------------
		
		
		List<Product> list=Arrays.stream(products)
		.filter(p->p.getPrice()>4000)
		.collect(Collectors.toList());
		
		Set<Product> set=Arrays.stream(products)
				.filter(p->p.getPrice()>4000)
				.collect(Collectors.toSet());
		
		
		Map<String, Double> map=Arrays.stream(products)
				.filter(p->p.getPrice()>4000)
				.collect(Collectors.toMap(Product::getName, Product::getPrice));
		
		System.out.println(map);
		
//		----------------------------------------------------
		
		Map<ProductType, List<Product>> map2=Arrays.stream(products)
				.filter(p->p.getPrice()>1)
				.collect(Collectors.groupingBy(Product::getType));
		
		System.out.println(map2);
		
		

	}

}
