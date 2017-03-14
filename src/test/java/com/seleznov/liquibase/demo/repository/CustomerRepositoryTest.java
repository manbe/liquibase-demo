package com.seleznov.liquibase.demo.repository;

import com.seleznov.liquibase.demo.entity.CustomerEntity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

/**
 * @author Illia Seleznov
 */

public class CustomerRepositoryTest extends AbstractRepositoryTest{

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void shouldFindAllCustomer() {
        List<CustomerEntity> customerEntityList = customerRepository.findAll();
        assertThat(customerEntityList, hasSize(1));
        assertThat(customerEntityList.get(0).getName(), is("lol"));
    }


    @Override
    protected String getTestChangelog() {
        return "customer_change_data.xml";
    }
}