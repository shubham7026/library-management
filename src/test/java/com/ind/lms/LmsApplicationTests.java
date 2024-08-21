package com.ind.lms;

import com.ind.lms.entity.Product;
import com.ind.lms.repository.interfaces.IProductRepository;
import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import org.apache.catalina.core.ApplicationContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Iterator;
import java.util.Optional;
import java.util.Random;

@SpringBootTest
class LmsApplicationTests {


	@Inject
	private IProductRepository iProductRepository ;

	@Test
	void contextLoads() {
		/*Iterator<String> iterator = context.getAttributeNames().asIterator();
		while (iterator.hasNext()){
			System.out.println(iterator.next());
		}*/
	}

	@Test
	void createProduct(){

		int id = new Random().nextInt(100);

		Product product = new Product(id,"Bottle", 250.00, "Green Bottle with aluminium");
		iProductRepository.save(product);
		product = iProductRepository.findById(id).orElse(null);
		Assertions.assertNotNull(product);
		Assertions.assertEquals("Bottle", product.getName());

	}

	@Test
	void deleteAll (){
		iProductRepository.deleteAll();
		Long count = iProductRepository.count();
		Assertions.assertEquals(0,count);
	}

}
