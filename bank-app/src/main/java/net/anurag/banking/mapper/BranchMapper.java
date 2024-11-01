package net.anurag.banking.mapper;

import net.anurag.banking.dto.BranchDTO;
import net.anurag.banking.entity.Account;
import net.anurag.banking.entity.Branch;
import org.springframework.stereotype.Component;

@Component
public class BranchMapper {

    // Convert Branch entity to BranchDTO
    public BranchDTO toDto(Branch branch) {
        if (branch == null) {
            return null;
        }

        BranchDTO branchDTO = new BranchDTO();
        branchDTO.setBranchId(branch.getBranchId());
        branchDTO.setBranchName(branch.getBranchName());
        branchDTO.setLocation(branch.getLocation());

        // Set the account ID for the DTO
        if (branch.getAccount() != null) {
            branchDTO.setAccountId(branch.getAccount().getId());
        }

        return branchDTO;
    }

    // Convert BranchDTO to Branch entity
    public Branch toEntity(BranchDTO branchDTO) {
        if (branchDTO == null) {
            return null;
        }

        Branch branch = new Branch();
        branch.setBranchId(branchDTO.getBranchId());
        branch.setBranchName(branchDTO.getBranchName());
        branch.setLocation(branchDTO.getLocation());

        // Set the account based on account ID
        if (branchDTO.getAccountId() != null) {
            Account account = new Account();
            account.setId(branchDTO.getAccountId());  // Assuming you have a method to set the account ID in Account entity
            branch.setAccount(account);
        }

        return branch;
    }
}

