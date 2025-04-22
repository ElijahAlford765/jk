package com.example.jk.petService;

import jakarta.persistence.*;

@Entity
public class PetService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serviceId;
    private int providerId;
    private String description;

    private float price;
    @Column(nullable = false)
    private String availability;
    private int reportCount;
    @Column(nullable = false)
    private boolean approved;
    private String serviceType;

    public PetService() {
    }

    public PetService(int providerId, String description, float price, String availability, boolean approved, int reportCount, String serviceType) {
        this.providerId = providerId;
        this.description = description;
        this.price = price;
        this.availability = availability;
        this.reportCount = reportCount;

        this.approved = approved;
        this.serviceType = serviceType;
    }

    public boolean isApproved() {
        return approved;

    }
    public void setApproved(boolean approved){
        this.approved = approved;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }



    public int getReportCount() {
        return reportCount;
    }

    public void setReportCount(int reportCount) {
        this.reportCount = reportCount;
    }


    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "PetService{" +
                "serviceId=" + serviceId +
                ", providerId=" + providerId +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", availability='" + availability + '\'' +
                '}';
    }
}

