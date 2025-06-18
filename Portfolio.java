package com.example.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portfolioId;

    private LocalDate createdAt;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL)
    private List<Security> securities = new ArrayList<>();

    public Portfolio() {
        this.createdAt = LocalDate.now();
    }

    public Portfolio(Client client) {
        this.client = client;
        this.createdAt = LocalDate.now();
    }

    
    public Long getPortfolioId() { return portfolioId; }
    public void setPortfolioId(Long portfolioId) { this.portfolioId = portfolioId; }

    public LocalDate getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDate createdAt) { this.createdAt = createdAt; }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    public List<Security> getSecurities() { return securities; }
    public void setSecurities(List<Security> securities) { this.securities = securities; }
}
