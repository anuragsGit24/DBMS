const apiUrl = "http://localhost:8080/api";
function addStyles() {
    const style = document.createElement("style");
    style.textContent = `
        .account-entry {
            margin-bottom: 10px;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .account-entry p {
            margin: 5px 0;
        }
    `;
    document.head.appendChild(style);
}

// Call this function to add the CSS when the page loads
addStyles();
function addCustomerStyles() {
    const style = document.createElement("style");
    style.textContent = `
        .customer-entry {
            margin-bottom: 10px;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .customer-entry p {
            margin: 5px 0;
        }
    `;
    document.head.appendChild(style);
}

// Call this function to add the CSS when the page loads
addCustomerStyles();
function addEmployeeStyles() {
    const style = document.createElement("style");
    style.textContent = `
        .employee-entry {
            margin-bottom: 10px;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #f9f9f9;
        }
        .employee-entry p {
            margin: 5px 0;
        }
    `;
    document.head.appendChild(style);
}

// Call this function to add the CSS when the page loads
addEmployeeStyles();

function addTransactionStyles() {
    const style = document.createElement("style");
    style.textContent = `
        .transaction-entry {
            margin-bottom: 10px;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #f9f9f9;
        }
        .transaction-entry p {
            margin: 5px 0;
        }
    `;
    document.head.appendChild(style);
}

// Call this function to add the CSS when the page loads
addTransactionStyles();

function addLoanStyles() {
    const style = document.createElement("style");
    style.textContent = `
        .loan-entry {
            margin-bottom: 10px;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #f3f8fb;
        }
        .loan-entry p {
            margin: 5px 0;
        }
    `;
    document.head.appendChild(style);
}

// Call this function to add the CSS when the page loads
addLoanStyles();
function addBranchStyles() {
    const style = document.createElement("style");
    style.textContent = `
        .branch-entry {
            margin-bottom: 10px;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #f9f9f9;
        }
        .branch-entry p {
            margin: 5px 0;
        }
    `;
    document.head.appendChild(style);
}

// Call this function to add the CSS when the page loads
addBranchStyles();

function addFixedDepositStyles() {
    const style = document.createElement("style");
    style.textContent = `
        .fixed-deposit-entry {
            margin-bottom: 10px;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #f9f9f9;
        }
        .fixed-deposit-entry p {
            margin: 5px 0;
        }
    `;
    document.head.appendChild(style);
}

// Call this function to add the CSS when the page loads
addFixedDepositStyles();
function addCardPaymentStyles() {
    const style = document.createElement("style");
    style.textContent = `
        .card-entry {
            margin-bottom: 10px;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #f9f9f9;
        }
        .card-entry p {
            margin: 5px 0;
        }
    `;
    document.head.appendChild(style);
}

// Call this function to add the CSS when the page loads
addCardPaymentStyles();
function addUpiPaymentStyles() {
    const style = document.createElement("style");
    style.textContent = `
        .upi-entry {
            margin-bottom: 10px;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #f9f9f9;
        }
        .upi-entry p {
            margin: 5px 0;
        }
    `;
    document.head.appendChild(style);
}

// Call this function to add the CSS when the page loads
addUpiPaymentStyles();
// Customer Functions
async function fetchCustomers() {
    try {
        const response = await fetch(`${apiUrl}/customers`);
        const data = await response.json();

        // Clear the existing content before displaying updated data
        const customerDetailsDiv = document.getElementById("customerDetails");
        customerDetailsDiv.innerHTML = "";

        // Loop through each customer and create a structured view
        data.forEach(customer => {
            const customerDiv = document.createElement("div");
            customerDiv.classList.add("customer-entry");

            customerDiv.innerHTML = `
                <p><strong>ID:</strong> ${customer.id}</p>
                <p><strong>Name:</strong> ${customer.name || "N/A"}</p>
                <p><strong>Phone Number:</strong> ${customer.phoneNumber || "N/A"}</p>
                <hr> <!-- Optional: Adds a horizontal line between entries -->
            `;
            customerDetailsDiv.appendChild(customerDiv);
        });
    } catch (error) {
        console.error("Error fetching customers:", error);
    }
}

// Event listener to create a customer when the form is submitted
document.getElementById("customerForm").addEventListener("submit", async (event) => {
    event.preventDefault(); // Prevent the default form submission

    const name = document.getElementById("customerName").value;
    const phoneNumber = document.getElementById("customerContact").value;

    console.log("Form submitted with:", { name, phoneNumber }); // Debugging statement

    try {
        const response = await fetch(`${apiUrl}/customers`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({ name, phoneNumber }),
        });

        if (!response.ok) {
            const errorData = await response.json();
            throw new Error(`Error: ${errorData.message || response.statusText}`);
        }

        alert("Customer added successfully");
        fetchCustomers(); // Refresh the customer list
    } catch (error) {
        console.error("Error adding customer:", error);
        alert(`Failed to add customer: ${error.message}`);
    }
});

// Account Functions
async function fetchAccounts() {
    try {
        const response = await fetch(`${apiUrl}/accounts`);
        const data = await response.json();

        // Clear the existing content before displaying updated data
        const accountDetailsDiv = document.getElementById("accountDetails");
        accountDetailsDiv.innerHTML = "";

        // Loop through each account and create a structured view
        data.forEach(account => {
            const accountDiv = document.createElement("div");
            accountDiv.classList.add("account-entry");

            accountDiv.innerHTML = `
                <p><strong>ID:</strong> ${account.id}</p>
                <p><strong>Account Number:</strong> ${account.accountNumber || "N/A"}</p>
                <p><strong>Account Holder Name:</strong> ${account.accountHolderName || "N/A"}</p>
                <p><strong>Balance:</strong> ${account.balance}</p>
                <hr> <!-- Optional: Adds a horizontal line between entries -->
            `;
            accountDetailsDiv.appendChild(accountDiv);
        });
    } catch (error) {
        console.error("Error fetching accounts:", error);
    }
}

// Event listener to create an account when the form is submitted
document.getElementById("accountForm").addEventListener("submit", async (event) => {
    event.preventDefault();
    const customerId = document.getElementById("accountCustomerId").value;
    const accountNumber = document.getElementById("accountNumber").value;
    const balance = document.getElementById("initialBalance").value;
    const accountHolderName = document.getElementById("accountHolderName").value;

    try {
        await fetch(`${apiUrl}/accounts`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({ customerId, accountNumber, balance, accountHolderName }),
        });
        alert("Account created successfully");
        fetchAccounts(); // Refresh the accounts list
    } catch (error) {
        console.error("Error creating account:", error);
    }
});
//Employee functions
async function fetchEmployees() {
    try {
        const response = await fetch(`${apiUrl}/employees`);
        const data = await response.json();

        // Clear the existing content before displaying updated data
        const employeeDetailsDiv = document.getElementById("employeeDetails");
        employeeDetailsDiv.innerHTML = "";

        // Loop through each employee and create a structured view
        data.forEach(employee => {
            const employeeDiv = document.createElement("div");
            employeeDiv.classList.add("employee-entry");

            employeeDiv.innerHTML = `
                <p><strong>ID:</strong> ${employee.id}</p>
                <p><strong>Name:</strong> ${employee.name || "N/A"}</p>
                <p><strong>Position:</strong> ${employee.position || "N/A"}</p>
                <p><strong>Account ID:</strong> ${employee.accountId || "N/A"}</p>
                <hr> <!-- Optional: Adds a horizontal line between entries -->
            `;
            employeeDetailsDiv.appendChild(employeeDiv);
        });
    } catch (error) {
        console.error("Error fetching employees:", error);
    }
}

// Event listener to create an employee when the form is submitted
document.getElementById("employeeForm").addEventListener("submit", async (event) => {
    event.preventDefault();

    const name = document.getElementById("employeeName").value;
    const position = document.getElementById("employeePosition").value;
    const accountId = document.getElementById("employeeAccountId").value;

    try {
        const response = await fetch(`${apiUrl}/employees`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({ name, position, accountId }),
        });

        if (!response.ok) {
            const errorData = await response.json();
            throw new Error(`Error: ${errorData.message || response.statusText}`);
        }

        alert("Employee created successfully");
        fetchEmployees(); // Refresh the employee list
    } catch (error) {
        console.error("Error creating employee:", error);
        alert(`Failed to create employee: ${error.message}`);
    }
});

// Transaction Functions
async function fetchTransactions() {
    try {
        const response = await fetch(`${apiUrl}/transactions`);
        const data = await response.json();

        // Clear the existing content before displaying updated data
        const transactionDetailsDiv = document.getElementById("transactionDetails");
        transactionDetailsDiv.innerHTML = "";

        // Loop through each transaction and create a structured view
        data.forEach(transaction => {
            const transactionDiv = document.createElement("div");
            transactionDiv.classList.add("transaction-entry");

            transactionDiv.innerHTML = `
                <p><strong>Transaction ID:</strong> ${transaction.transactionId}</p>
                <p><strong>Account ID:</strong> ${transaction.accountId || "N/A"}</p>
                <p><strong>Type:</strong> ${transaction.transactionType || "N/A"}</p>
                <p><strong>Amount:</strong> ${transaction.amount || "N/A"}</p>
                <hr> <!-- Optional: Adds a horizontal line between entries -->
            `;
            transactionDetailsDiv.appendChild(transactionDiv);
        });
    } catch (error) {
        console.error("Error fetching transactions:", error);
    }
}

// Event listener to create a transaction when the form is submitted
document.getElementById("transactionForm").addEventListener("submit", async (event) => {
    event.preventDefault();

    const accountId = document.getElementById("transactionAccountId").value;
    const transactionType = document.getElementById("transactionType").value;
    const amount = document.getElementById("transactionAmount").value;

    try {
        const response = await fetch(`${apiUrl}/transactions`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({ accountId, transactionType, amount }),
        });

        if (!response.ok) {
            const errorData = await response.json();
            throw new Error(`Error: ${errorData.message || response.statusText}`);
        }

        alert("Transaction successful");
        fetchTransactions(); // Refresh the transaction list
    } catch (error) {
        console.error("Error creating transaction:", error);
        alert(`Failed to create transaction: ${error.message}`);
    }
});

// Loan Functions
async function fetchLoans() {
    try {
        const response = await fetch(`${apiUrl}/loans`);
        const data = await response.json();

        // Clear the existing content before displaying updated data
        const loanDetailsDiv = document.getElementById("loanDetails");
        loanDetailsDiv.innerHTML = "";

        // Loop through each loan and create a structured view
        data.forEach(loan => {
            const loanDiv = document.createElement("div");
            loanDiv.classList.add("loan-entry");

            loanDiv.innerHTML = `
                <p><strong>Loan ID:</strong> ${loan.loanId}</p>
                <p><strong>Account ID:</strong> ${loan.accountId || "N/A"}</p>
                <p><strong>Type:</strong> ${loan.loanType || "N/A"}</p>
                <p><strong>Amount:</strong> ${loan.loanAmount || "N/A"}</p>
                <p><strong>Interest Rate:</strong> ${loan.interestRate || "N/A"}</p>
                <hr> <!-- Optional: Adds a horizontal line between entries -->
            `;
            loanDetailsDiv.appendChild(loanDiv);
        });
    } catch (error) {
        console.error("Error fetching loans:", error);
    }
}

// Event listener to apply for a loan when the form is submitted
document.getElementById("loanForm").addEventListener("submit", async (event) => {
    event.preventDefault();

    const accountId = document.getElementById("loanAccountId").value;
    const loanType = document.getElementById("loanType").value;
    const loanAmount = document.getElementById("loanAmount").value;
    const interestRate = document.getElementById("loanInterestRate").value;

    try {
        const response = await fetch(`${apiUrl}/loans`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({ accountId, loanType, loanAmount, interestRate }),
        });

        if (!response.ok) {
            const errorData = await response.json();
            throw new Error(`Error: ${errorData.message || response.statusText}`);
        }

        alert("Loan application successful");
        fetchLoans(); // Refresh the loan list
    } catch (error) {
        console.error("Error applying for loan:", error);
        alert(`Failed to apply for loan: ${error.message}`);
    }
});

// Branch Functions
addBranchStyles();

// Function to fetch and display branches in a structured format
async function fetchBranches() {
    try {
        const response = await fetch(`${apiUrl}/branches`);
        const data = await response.json();

        // Clear the existing content before displaying updated data
        const branchDetailsDiv = document.getElementById("branchDetails");
        branchDetailsDiv.innerHTML = "";

        // Loop through each branch and create a structured view
        data.forEach(branch => {
            const branchDiv = document.createElement("div");
            branchDiv.classList.add("branch-entry");

            branchDiv.innerHTML = `
                <p><strong>Branch ID:</strong> ${branch.branchId}</p>
                <p><strong>Location:</strong> ${branch.location || "N/A"}</p>
                <p><strong>Branch Name:</strong> ${branch.branchName || "N/A"}</p>
                <p><strong>Account ID:</strong> ${branch.accountId || "N/A"}</p>
                <hr> <!-- Optional: Adds a horizontal line between entries -->
            `;
            branchDetailsDiv.appendChild(branchDiv);
        });
    } catch (error) {
        console.error("Error fetching branches:", error);
    }
}

// Event listener to add a new branch when the form is submitted
document.getElementById("branchForm").addEventListener("submit", async (event) => {
    event.preventDefault();

    const location = document.getElementById("branchLocation").value;
    const branchName = document.getElementById("branchName").value;
    const accountId = document.getElementById("branchAccountId").value;

    try {
        const response = await fetch(`${apiUrl}/branches`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({ location, branchName, accountId }),
        });

        if (!response.ok) {
            const errorData = await response.json();
            throw new Error(`Error: ${errorData.message || response.statusText}`);
        }

        alert("Branch added successfully");
        fetchBranches(); // Refresh the branch list
    } catch (error) {
        console.error("Error adding branch:", error);
        alert(`Failed to add branch: ${error.message}`);
    }
});

// Fixed Deposit Functions
async function fetchFixedDeposits() {
    try {
        const response = await fetch(`${apiUrl}/fixed-deposits`);
        const data = await response.json();

        // Clear the existing content before displaying updated data
        const fixedDepositDetailsDiv = document.getElementById("fixedDepositDetails");
        fixedDepositDetailsDiv.innerHTML = "";

        // Loop through each fixed deposit and create a structured view
        data.forEach(fd => {
            const fdDiv = document.createElement("div");
            fdDiv.classList.add("fixed-deposit-entry");

            fdDiv.innerHTML = `
                <p><strong>Fixed Deposit ID:</strong> ${fd.fixedDepositId || "N/A"}</p>
                <p><strong>Account ID:</strong> ${fd.accountId || "N/A"}</p>
                <p><strong>Employee ID:</strong> ${fd.employeeId || "N/A"}</p>
                <p><strong>Amount:</strong> ${fd.amount || "N/A"}</p>
                <p><strong>Interest Rate:</strong> ${fd.interestRate || "N/A"}</p>
                <p><strong>Maturity Date:</strong> ${fd.maturityDate || "N/A"}</p>
                <hr> <!-- Optional: Adds a horizontal line between entries -->
            `;
            fixedDepositDetailsDiv.appendChild(fdDiv);
        });
    } catch (error) {
        console.error("Error fetching fixed deposits:", error);
    }
}

// Event listener to add a new fixed deposit when the form is submitted
document.getElementById("fixedDepositForm").addEventListener("submit", async (event) => {
    event.preventDefault();

    const accountId = document.getElementById("fdAccountId").value;
    const employeeId = document.getElementById("fdEmployeeId").value;
    const amount = document.getElementById("fdAmount").value;
    const interestRate = document.getElementById("fdInterestRate").value;
    const maturityDate = document.getElementById("fdmaturityDate").value;

    try {
        const response = await fetch(`${apiUrl}/fixed-deposits`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({ accountId, employeeId, amount, interestRate, maturityDate }),
        });

        if (!response.ok) {
            const errorData = await response.json();
            throw new Error(`Error: ${errorData.message || response.statusText}`);
        }

        alert("Fixed Deposit created successfully");
        fetchFixedDeposits(); // Refresh the fixed deposit list
    } catch (error) {
        console.error("Error creating fixed deposit:", error);
        alert(`Failed to create fixed deposit: ${error.message}`);
    }
});
// Card Management Functions
async function fetchCards() {
    try {
        const response = await fetch(`${apiUrl}/card-payments`);
        const data = await response.json();

        // Clear the existing content before displaying updated data
        const cardDetailsDiv = document.getElementById("cardDetails");
        cardDetailsDiv.innerHTML = "";

        // Loop through each card payment and create a structured view
        data.forEach(card => {
            const cardDiv = document.createElement("div");
            cardDiv.classList.add("card-entry");

            cardDiv.innerHTML = `
                <p><strong>Transaction ID:</strong> ${card.transactionId || "N/A"}</p>
                <p><strong>Card Number:</strong> ${card.cardNumber || "N/A"}</p>
                <p><strong>Amount:</strong> ${card.amount || "N/A"}</p>
                <hr> <!-- Optional: Adds a horizontal line between entries -->
            `;
            cardDetailsDiv.appendChild(cardDiv);
        });
    } catch (error) {
        console.error("Error fetching cards:", error);
    }
}

// Event listener to add a new card payment when the form is submitted
document.getElementById("cardForm").addEventListener("submit", async (event) => {
    event.preventDefault();

    const transactionId = document.getElementById("cardTransactionId").value;
    const cardNumber = document.getElementById("cardNumber").value;
    const amount = document.getElementById("amount").value;

    try {
        const response = await fetch(`${apiUrl}/card-payments`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({ transactionId, cardNumber, amount }),
        });

        if (!response.ok) {
            const errorData = await response.json();
            throw new Error(`Error: ${errorData.message || response.statusText}`);
        }

        alert("Card payment done successfully");
        fetchCards(); // Refresh the card payment list
    } catch (error) {
        console.error("Error issuing card:", error);
        alert(`Failed to process card payment: ${error.message}`);
    }
});
// UPI Payment Functions
async function fetchUpiPayments() {
    try {
        const response = await fetch(`${apiUrl}/upi-transactions`);
        const data = await response.json();

        // Clear the existing content before displaying updated data
        const upiPaymentDetailsDiv = document.getElementById("upiPaymentDetails");
        upiPaymentDetailsDiv.innerHTML = "";

        // Loop through each UPI payment and create a structured view
        data.forEach(upi => {
            const upiDiv = document.createElement("div");
            upiDiv.classList.add("upi-entry");

            upiDiv.innerHTML = `
                <p><strong>UPI ID:</strong> ${upi.upiId || "N/A"}</p>
                <p><strong>Transaction ID:</strong> ${upi.transactionId || "N/A"}</p>
                <p><strong>Account ID:</strong> ${upi.accountId || "N/A"}</p>
                <p><strong>Amount:</strong> ${upi.amount || "N/A"}</p>
                <p><strong>Transaction Type:</strong> ${upi.transactionType || "N/A"}</p>
                <hr> <!-- Optional: Adds a horizontal line between entries -->
            `;
            upiPaymentDetailsDiv.appendChild(upiDiv);
        });
    } catch (error) {
        console.error("Error fetching UPI payments:", error);
    }
}

// Event listener to add a new UPI payment when the form is submitted
document.getElementById("upiPaymentForm").addEventListener("submit", async (event) => {
    event.preventDefault();

    const upiId = document.getElementById("upiId").value;
    const transactionId = document.getElementById("upiTransactionId").value;
    const accountId = document.getElementById("upiAccountId").value;
    const amount = document.getElementById("upiAmount").value;
    const transactionType = document.getElementById("upiTransactionType").value;

    try {
        const response = await fetch(`${apiUrl}/upi-transactions`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({ upiId, transactionId, accountId, amount, transactionType }),
        });

        if (!response.ok) {
            const errorData = await response.json();
            throw new Error(`Error: ${errorData.message || response.statusText}`);
        }

        alert("UPI payment successful");
        fetchUpiPayments(); // Refresh the UPI payment list
    } catch (error) {
        console.error("Error processing UPI payment:", error);
        alert(`Failed to process UPI payment: ${error.message}`);
    }
});


        fetchUpiPayments();
    } catch (error) {
        console.error("Error processing UPI payment:", error);
    }
});
