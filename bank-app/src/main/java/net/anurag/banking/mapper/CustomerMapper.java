package net.anurag.banking.mapper;

import net.anurag.banking.dto.CustomerDTO;
import net.anurag.banking.dto.AccountDTO;
import net.anurag.banking.entity.Customer;
import net.anurag.banking.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    // Convert Customer entity to CustomerDTO
    public CustomerDTO toDto(Customer customer) {
        if (customer == null) {
            return null;
        }

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setName(customer.getName());
        customerDTO.setPhoneNumber(customer.getPhoneNumber());

        // Map account if it exists
        if (customer.getAccount() != null) {
            AccountDTO accountDTO = new AccountDTO();
            accountDTO.setId(customer.getAccount().getId());
            accountDTO.setAccountNumber(customer.getAccount().getAccountNumber());
            accountDTO.setAccountHolderName(customer.getAccount().getAccountHolderName());
            accountDTO.setBalance(customer.getAccount().getBalance());
            customerDTO.setAccount(accountDTO);
        }

        return customerDTO;
    }

    // Convert CustomerDTO to Customer entity
    public Customer toEntity(CustomerDTO customerDTO) {
        if (customerDTO == null) {
            return null;
        }

        Customer customer = new Customer();
        customer.setId(customerDTO.getId());
        customer.setName(customerDTO.getName());
        customer.setPhoneNumber(customerDTO.getPhoneNumber());

        // Map account if it exists
        if (customerDTO.getAccount() != null) {
            Account account = new Account();
            account.setId(customerDTO.getAccount().getId());
            account.setAccountNumber(customerDTO.getAccount().getAccountNumber());
            account.setAccountHolderName(customerDTO.getAccount().getAccountHolderName());
            account.setBalance(customerDTO.getAccount().getBalance());
            customer.setAccount(account);
        }

        return customer;
    }
}
