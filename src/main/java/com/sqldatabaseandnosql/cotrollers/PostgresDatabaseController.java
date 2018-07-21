package com.sqldatabaseandnosql.cotrollers;

import com.sqldatabaseandnosql.dao.CustomerRepository;
import com.sqldatabaseandnosql.dto.CustomerForm;
import com.sqldatabaseandnosql.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostgresDatabaseController {
    private static List<Customer> customers = new ArrayList<>();

    private final CustomerRepository repository;

    @Autowired
    public PostgresDatabaseController(CustomerRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = { "/customersList" }, method = RequestMethod.GET)
    public String personList(Model model) {
        repository.findAll().forEach(customers::add);
        model.addAttribute("customers", customers);
        return "customersList";
    }

    @RequestMapping(value = { "/addCustomer" }, method = RequestMethod.GET)
    public String addPersonForm(Model model) {
        CustomerForm customerForm = new CustomerForm();
        model.addAttribute("CustomerForm", customerForm);
        return "addCustomer";
    }

    @RequestMapping(value = { "/addCustomer" }, method = RequestMethod.POST)
    public String addPersonSave(@ModelAttribute("CustomerForm") CustomerForm customerForm) {

        String login = customerForm.getLogin();
        String password = customerForm.getPassword();
        String city = customerForm.getCity();

            Customer newCustomer = Customer.builder()
                    .withLogin(login)
                    .withPassword(password)
                    .withCity(city)
                    .build();
            repository.save(newCustomer);

            return "redirect:/customersList";
    }
}
