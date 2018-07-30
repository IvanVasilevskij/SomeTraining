package com.sqldatabaseandnosql.cotrollers;

import com.sqldatabaseandnosql.dao.CustomerRepository;
import com.sqldatabaseandnosql.dto.CustomerForm;
import com.sqldatabaseandnosql.dto.LoginForm;
import com.sqldatabaseandnosql.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PostgresDatabaseController {

    private static final Logger LOG = LoggerFactory.getLogger(PostgresDatabaseController.class);
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
    public String customersList(Model model) {
        LoginForm loginForm = new LoginForm();
        model.addAttribute("customerForm", loginForm);

        List<Customer> customers = new ArrayList<>();
        repository.findAll().forEach(customers::add);
        model.addAttribute("customers", customers);
        return "customersList";
    }

    @RequestMapping(value = { "/addCustomer" }, method = RequestMethod.GET)
    public String addCustomerForm(Model model) {
        CustomerForm customerForm = new CustomerForm();
        model.addAttribute("customerForm", customerForm);
        return "addCustomer";
    }

    @RequestMapping(value = { "/addCustomer" }, method = RequestMethod.POST)
    public String checkInformation(@Valid CustomerForm customerForm,
                                   BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            Customer newCustomer = Customer.builder()
                    .withLogin(customerForm.getLogin())
                    .withPassword(customerForm.getPassword())
                    .withCity(customerForm.getCity())
                    .build();
            repository.save(newCustomer);

            return "redirect:/customersList";
        } else {
//            model.addAttribute("customerForm", customerForm);
            return "addCustomer";
        }
    }

    @RequestMapping(value = { "/changeCustomer" }, method = RequestMethod.GET)
    public String addChangeCustomerForm(@Valid LoginForm loginForm,
                                        BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            Customer customer = repository.findByLogin(loginForm.getLogin());
            model.addAttribute("customer", customer);
            model.addAttribute("loginForm", loginForm);
            return "changeCustomer";
        } else {
            return "changeCustomer";
        }
    }
}
