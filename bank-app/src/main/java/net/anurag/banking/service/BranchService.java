package net.anurag.banking.service;

import net.anurag.banking.dto.BranchDTO;

import java.util.List;

public interface BranchService {
    List<BranchDTO> getAllBranches();
    BranchDTO getBranchById(Long id);
    BranchDTO createBranch(BranchDTO branchDTO);
    boolean deleteBranch(Long id);
}

