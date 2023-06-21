package com.Usopp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//@ComponentScan(basePackages = "com.Usopp")
//@EnableAutoConfiguration
//@Configuration
@SpringBootApplication
@RestController
@RequestMapping("api/v1/postgres")
public class Main {

    public final CustomerRepository customerRepository;

    public Main(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args){
        System.out.println("hello world");
        SpringApplication.run(Main.class, args);
    }
    @GetMapping
    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }
    record Customer1(
            String name,
            Integer age,
            String email
    ){

    }
    @PostMapping
    public void addCustomer(@RequestBody Customer1 customer1){
         Customer customer = new Customer();
         customer.setName(customer1.name());
         customer.setEmail(customer1.email());
         customer.setAge(customer1.age());
         customerRepository.save(customer);

    }
    @DeleteMapping("{customerId}")
    public void deletecustomer(@PathVariable("customerId") Integer id){
        customerRepository.deleteById(id);
    }


    record Customer2(
            String name,
            Integer age,
            String email
    ){

   }
    @PutMapping("{customerId}")
    public void Updatecustomer1(@PathVariable("customerId") Integer id, @RequestBody Customer customer) {
        Customer existingCustomer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));

        // Update the existing customer's information
        existingCustomer.setName(customer.getName());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setAge(customer.getAge());

        customerRepository.save(existingCustomer);
    }
//
//    @PutMapping("{customerId}")
//    public void Updatecustomer1(@PathVariable("customerId") Integer id,@RequestBody Customer2 customer2){
//        Customer customer = new Customer();
//        customer.setName(customer2.name());
//        customer.setEmail(customer2.email());
//        customer.setAge(customer2.age());
//        customerRepository.save(customer);
//    }


//    @GetMapping("/yash")
//    public yashop yash(){
//       yashop  yash1= new  yashop("hello",List.of("java","harsh","avi","jolo"),new Person("Alex",20,50.00));
//        return yash1;
//    }
//    record Person(String name,int age,double money){
//
//    }
//
//    record yashop(String yash, List<String> favprog,Person person){
//
//    }

//    class yashop{
//        private final String yashop;
//
//        yashop(String yashop) {
//            this.yashop = yashop;
//        }
//        public String getYashop(){
//            return yashop;
//
//        }
//
//        @Override
//        public String toString() {
//            return "yashop{" +
//                    "yashop='" + yashop + '\'' +
//                    '}';
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            yashop yashop1 = (yashop) o;
//            return Objects.equals(yashop, yashop1.yashop);
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(yashop);
//        }
//    }
}
