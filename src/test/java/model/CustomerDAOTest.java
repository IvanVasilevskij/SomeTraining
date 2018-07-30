package model;

import com.sqldatabaseandnosql.Application;
import com.sqldatabaseandnosql.model.Customer;
import com.sqldatabaseandnosql.dao.CustomerRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CustomerDAOTest {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerDAOTest.class);

    @Autowired
    public CustomerRepository repository;

    @Before
    @Rollback(false)
    public void setUp() {
        Customer cus1 = Customer.builder()
                .withLogin("Elisabeth Megan")
                .withPassword("666")
                .withCity("SPb")
                .build();
        repository.save(cus1);
        Customer cus2 = Customer.builder()
                .withLogin("Maxim Smith")
                .withPassword("222")
                .withCity("SPb")
                .build();
        repository.save(cus2);
        Customer cus3 = Customer.builder()
                .withLogin("Maxim Morgan")
                .withPassword("666")
                .withCity("Msk")
                .build();
        repository.save(cus3);
    }

    @After
    public void tearDown() throws Exception {
        repository.deleteAll();
    }

    @Test
    public void testFindAll() {
        List<Customer> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        LOG.info("expected count = 3" + " - received count = " + list.size());
        assertEquals(3, list.size());
    }

    @Test
    public void testCount() {
        long expectedCount = 3L;
        long receivedCount = repository.count();
        LOG.info("expected count = " + expectedCount + " - received count = " + receivedCount);
        assertEquals(3, receivedCount);
    }

    @Test
    public void testFindByLoginEndsWith() {
        List<Customer> list = repository.findByLoginEndsWith("an");
        for (Customer customer : list) {
            LOG.info(customer.toString()+"\n");
        }
        assertEquals(2, list.size());
    }

    @Test
    public void testFindByLoginLikeOrCity() {
        List<Customer> list = repository.findByLoginLikeOrCity("%Maxim%", "SPb");
        for (Customer customer : list) {
            LOG.info(customer.toString()+"\n");
        }
        assertEquals(3, list.size());
    }

    @Test
    public void testFindByLogin() {
        Customer customer = repository.findByLogin("Elisabeth Megan");
        assertEquals("666", customer.getPassword());
        LOG.info(customer.toString()+"\n");
    }

    @Test
    public void refreshTheCustomer() {
        Customer customer = repository.findByLogin("Elisabeth Megan");
        Customer mutateCustomer = Customer.mutator(customer)
                .withPassword("222")
                .mutate();
        repository.save(mutateCustomer);
        LOG.info(customer.getId()+" :Id customer");
        LOG.info(mutateCustomer.getId()+" :Id changeCustomer");
        assertEquals("222", repository.findByLogin("Elisabeth Megan").getPassword());
    }
}
