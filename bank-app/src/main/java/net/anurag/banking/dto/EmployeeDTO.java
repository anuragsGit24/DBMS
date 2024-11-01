package net.anurag.banking.dto;

public class EmployeeDTO {
    private Long id;
    private String name;
    private String position;
    private Long accountId; // Foreign key reference to Account table

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public Long getAccountId() { return accountId; }
    public void setAccountId(Long accountId) { this.accountId = accountId; }
}

