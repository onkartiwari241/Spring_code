package com.onkar.OneToOne.JPA_Mapping;

import com.onkar.OneToOne.JPA_Mapping.entity.*;
import com.onkar.OneToOne.JPA_Mapping.repo.CategoryRepo;
import com.onkar.OneToOne.JPA_Mapping.repo.ProductRepo;
import com.onkar.OneToOne.JPA_Mapping.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class JpaMappingApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JpaMappingApplication.class, args);
	}

	@Autowired
	private StudentRepo studentRepo;

	@Autowired
	private CategoryRepo categoryRepo;
	@Autowired
	private ProductRepo productRepo;

	@Override
	public void run(String... args) throws Exception {
//OneToOne
//		StudentEntity studentEntity = new StudentEntity();
//		studentEntity.setId(104);
//		studentEntity.setName("Shreyansh");
//		studentEntity.setAbout("DB Trainer");
//
//		LaptopEntity laptopEntity = new LaptopEntity();
//		laptopEntity.setLaptop_id(3);
//		laptopEntity.setLaptop_name("intel core i3");
//		laptopEntity.setBrand("Hp");
//
//		// Importnat
//		laptopEntity.setStudentEntity(studentEntity);
//		studentEntity.setLaptopEntity(laptopEntity);
//
//		StudentEntity save = studentRepo.save(studentEntity);
//		System.out.println(save);

		//for fetching details
//		StudentEntity recievedStudent = studentRepo.findById(104).get() ;//.orElseThrow(() -> new RuntimeException("Data not avilablee..."));
//
//		System.out.println(recievedStudent.getId());
//		System.out.println(recievedStudent.getName());
//		System.out.println(recievedStudent.getAbout());
//
//		LaptopEntity laptopEntity = recievedStudent.getLaptopEntity();
//		System.out.println("Laptop Id => "+laptopEntity.getLaptop_id());
//		System.out.println("Laptop name => "+laptopEntity.getLaptop_name());
//		System.out.println("Laptop brand => "+laptopEntity.getBrand());


//OneToMany
//		StudentEntity studentEntity = new StudentEntity();
//		studentEntity.setId(201);
//		studentEntity.setName("Aman Mishra");
//		studentEntity.setAbout("Php Devp.");
//
//		AddressEntity a1 = new AddressEntity();
//
//		a1.setAddressId(251);
//		a1.setStreet("Sathra");
//		a1.setCity("Ayodhya");
//		a1.setCountry("India");
//		a1.setStudentEntity(studentEntity);
//
//		AddressEntity a2 = new AddressEntity();
//
//		a2.setAddressId(252);
//		a2.setStreet("Marema");
//		a2.setCity("Ayodhya");
//		a2.setCountry("India");
//		a2.setStudentEntity(studentEntity);
//
//		ArrayList<AddressEntity> addressEntities = new ArrayList<>();
//		addressEntities.add(a1);
//		addressEntities.add(a2);
//
//		studentEntity.setAddressEntities(addressEntities);
//
//		StudentEntity savedData = studentRepo.save(studentEntity);
//
//		List<AddressEntity> addressEntity = savedData.getAddressEntities();
//
//
//		System.out.println("id => "+savedData.getId());
//		System.out.println("name => "+savedData.getName());
//		System.out.println("about => "+savedData.getAbout());
//		System.out.println("address => "+addressEntity.get(0).getAddressId()+" "+addressEntity.get(1).getAddressId());

//ManyToMany

//
//		CategoryEntity category1 = new CategoryEntity();
//
//		category1.setId("c1");
//		category1.setTittle("Electronics");
//
//		CategoryEntity category2 = new CategoryEntity();
//
//		category2.setId("c2");
//		category2.setTittle("Mobile");
//
//		ProductEntity p1 = new ProductEntity();
//
//		p1.setProductId("p1");
//		p1.setProductName("Iphone 14 max pro");
//
//		ProductEntity p2 = new ProductEntity();
//		p2.setProductId("p2");
//		p2.setProductName("Samsung guuru");
//
//		ProductEntity p3 = new ProductEntity();
//		p3.setProductId("p3");
//		p3.setProductName("LG Washing Machine");
//
//		List<ProductEntity> listData1 = category1.getProductEntity();
//		listData1.add(p1);
//		listData1.add(p2);
//		listData1.add(p3);
//
//		List<ProductEntity> listData2 = category2.getProductEntity();
//		listData2.add(p1);
//		listData2.add(p2);
//
//		categoryRepo.save(category1);
//		categoryRepo.save(category2);

		CategoryEntity categoryEntity = categoryRepo.findById("c1").get();
		System.out.println(categoryEntity.getProductEntity().size());

		ProductEntity p1 = productRepo.findById("p1").get();
		System.out.println(p1.getCategoryEntity().size());

	}
}
