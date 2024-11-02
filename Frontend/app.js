const apiUrl = "http://localhost:8080/api";

// Customer Functions
async function fetchCustomers() {
    try {
        const response = await fetch(`${apiUrl}/customers`);
        const data = await response.json();
        document.getElementById("customerDetails").innerHTML = JSON.stringify(data, null, 2);
    } catch (error) {
        console.error("Error fetching customers:", error);
    }
}

document.getElementById("customerForm").addEventListener("submit", async (event) => {
    event.preventDefault();
    const name = document.getElementById("customerName").value;
    const contact = document.getElementById("customerContact").value;

    try {
        await fetch(`${apiUrl}/customers`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({ name, contact }),
        });
        alert("Customer added successfully");
        fetchCustomers();
    } catch (error) {
        console.error("Error adding customer:", error);
    }
});

// Account Functions
async function fetchAccounts() {
    try {
        const response = await fetch(`${apiUrl}/accounts`);
        const data = await response.json();
        document.getElementById("accountDetails").innerHTML = JSON.stringify(data, null, 2);
    } catch (error) {
        console.error("Error fetching accounts:", error);
    }
}

document.getElementById("accountForm").addEventListener("submit", async (event) => {
    event.preventDefault();
    const customerId = document.getElementById("accountCustomerId").value;
    const type = document.getElementById("accountType").value;
    const balance = document.getElementById("initialBalance").value;

    try {
        await fetch(`${apiUrl}/accounts`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({ customerId, type, balance }),
        });
        alert("Account created successfully");
        fetchAccounts();
    } catch (error) {
        console.error("Error creating account:", error);
    }
});

// Transaction Functions
async function fetchTransactions() {
    try {
        const response = await fetch(`${apiUrl}/transactions`);
        const data = await response.json();
        document.getElementById("transactionDetails").innerHTML = JSON.stringify(data, null, 2);
    } catch (error) {
        console.error("Error fetching transactions:", error);
    }
}

document.getElementById("transactionForm").addEventListener("submit", async (event) => {
    event.preventDefault();
    const accountId = document.getElementById("transactionAccountId").value;
    const type = document.getElementById("transactionType").value;
    const amount = document.getElementById("transactionAmount").value;

    try {
        await fetch(`${apiUrl}/transactions`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({ accountId, type, amount }),
        });
        alert("Transaction successful");
        fetchTransactions();
    } catch (error) {
        console.error("Error creating transaction:", error);
    }
});

// Loan Functions
async function fetchLoans() {
    try {
        const response = await fetch(`${apiUrl}/loans`);
        const data = await response.json();
        document.getElementById("loanDetails").innerHTML = JSON.stringify(data, null, 2);
    } catch (error) {
        console.error("Error fetching loans:", error);
    }
}

document.getElementById("loanForm").addEventListener("submit", async (event) => {
    event.preventDefault();
    const customerId = document.getElementById("loanCustomerId").value;
    const type = document.getElementById("loanType").value;
    const amount = document.getElementById("loanAmount").value;
    const interestRate = document.getElementById("loanInterestRate").value;
    const duration = document.getElementById("loanDuration").value;

    try {
        await fetch(`${apiUrl}/loans`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({ customerId, type, amount, interestRate, duration }),
        });
        alert("Loan application successful");
        fetchLoans();
    } catch (error) {
        console.error("Error applying for loan:", error);
    }
});

// Branch Functions
async function fetchBranches() {
    try {
        const response = await fetch(`${apiUrl}/branches`);
        const data = await response.json();
        document.getElementById("branchDetails").innerHTML = JSON.stringify(data, null, 2);
    } catch (error) {
        console.error("Error fetching branches:", error);
    }
}

document.getElementById("branchForm").addEventListener("submit", async (event) => {
    event.preventDefault();
    const location = document.getElementById("branchLocation").value;
    const contact = document.getElementById("branchContact").value;

    try {
        await fetch(`${apiUrl}/branches`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({ location, contact }),
        });
        alert("Branch added successfully");
        fetchBranches();
    } catch (error) {
        console.error("Error adding branch:", error);
    }
});
// Fixed Deposit Functions
async function fetchFixedDeposits() {
    try {
        const response = await fetch(`${apiUrl}/fixedDeposits`);
        const data = await response.json();
        document.getElementById("fixedDepositDetails").innerHTML = JSON.stringify(data, null, 2);
    } catch (error) {
        console.error("Error fetching fixed deposits:", error);
    }
}

document.getElementById("fixedDepositForm").addEventListener("submit", async (event) => {
    event.preventDefault();
    const customerId = document.getElementById("fdCustomerId").value;
    const amount = document.getElementById("fdAmount").value;
    const interestRate = document.getElementById("fdInterestRate").value;
    const duration = document.getElementById("fdDuration").value;

    try {
        await fetch(`${apiUrl}/fixedDeposits`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({ customerId, amount, interestRate, duration }),
        });
        alert("Fixed Deposit created successfully");
        fetchFixedDeposits();
    } catch (error) {
        console.error("Error creating fixed deposit:", error);
    }
});

// Card Management Functions
async function fetchCards() {
    try {
        const response = await fetch(`${apiUrl}/cards`);
        const data = await response.json();
        document.getElementById("cardDetails").innerHTML = JSON.stringify(data, null, 2);
    } catch (error) {
        console.error("Error fetching cards:", error);
    }
}

document.getElementById("cardForm").addEventListener("submit", async (event) => {
    event.preventDefault();
    const customerId = document.getElementById("cardCustomerId").value;
    const type = document.getElementById("cardType").value;
    const number = document.getElementById("cardNumber").value;

    try {
        await fetch(`${apiUrl}/cards`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({ customerId, type, number }),
        });
        alert("Card issued successfully");
        fetchCards();
    } catch (error) {
        console.error("Error issuing card:", error);
    }
});

// UPI Payment Functions
async function fetchUpiPayments() {
    try {
        const response = await fetch(`${apiUrl}/upiPayments`);
        const data = await response.json();
        document.getElementById("upiPaymentDetails").innerHTML = JSON.stringify(data, null, 2);
    } catch (error) {
        console.error("Error fetching UPI payments:", error);
    }
}

document.getElementById("upiPaymentForm").addEventListener("submit", async (event) => {
    event.preventDefault();
    const customerId = document.getElementById("upiCustomerId").value;
    const receiverId = document.getElementById("upiReceiverId").value;
    const amount = document.getElementById("upiAmount").value;

    try {
        await fetch(`${apiUrl}/upiPayments`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({ customerId, receiverId, amount }),
        });
        alert("UPI Payment successful");
        fetchUpiPayments();
    } catch (error) {
        console.error("Error processing UPI payment:", error);
    }
});
