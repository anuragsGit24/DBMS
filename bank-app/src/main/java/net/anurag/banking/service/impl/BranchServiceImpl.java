package net.anurag.banking.service.impl;

import net.anurag.banking.dto.BranchDTO;
import net.anurag.banking.entity.Branch;
import net.anurag.banking.mapper.BranchMapper;
import net.anurag.banking.repository.BranchRepository;
import net.anurag.banking.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BranchServiceImpl implements BranchService {

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private BranchMapper branchMapper;

    @Override
    public List<BranchDTO> getAllBranches() {
        return branchRepository.findAll()
                .stream()
                .map(branchMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public BranchDTO getBranchById(Long id) {
        return branchRepository.findById(id)
                .map(branchMapper::toDto)
                .orElse(null);
    }

    @Override
    public BranchDTO createBranch(BranchDTO branchDTO) {
        Branch branch = branchMapper.toEntity(branchDTO);
        Branch savedBranch = branchRepository.save(branch);
        return branchMapper.toDto(savedBranch);
    }

    @Override
    public boolean deleteBranch(Long id) {
        if (branchRepository.existsById(id)) {
            branchRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

