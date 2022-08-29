package com.demo.hometask.controller;

import com.demo.hometask.objects.Details;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import static com.demo.hometask.objects.Details.*;

@RestController
// Class
public class TestController {
	// Constructor
	TestController() {
		a.add(1);
		a.add(2);
	}

	@GetMapping("/hello/{name}/{age}")
	public void insert(@PathVariable("name") String name,
					   @PathVariable("age") int age) {

		// Print and display name and age
		System.out.println(name);
		System.out.println(age);
	}

	// Creating an empty ArrayList
	ArrayList<Integer> a = new ArrayList<>();

	// Annotation
	@DeleteMapping("/hello/{id}")
	// Method
	public void deleteById(@PathVariable("id") int id) {
		a.remove(new Integer((id)));
		print();
	}

	// Handling post request
	@PostMapping("/EnterDetails")
	String insert(@RequestBody Details ob) {
		// Storing the incoming data in the list
		Data.add(new Details(ob.number, ob.name));

		// Iterating using foreach loop
		for (Details obd : Data) {
			System.out.println(obd.name + " " + ob.number);
		}
		return "Data Inserted";
	}

	// Method
	void print() {
		for (int elements : a) {
			System.out.print(elements);
		}
	}
}
