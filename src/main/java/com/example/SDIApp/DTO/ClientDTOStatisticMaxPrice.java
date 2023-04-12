package com.example.SDIApp.DTO;
public class ClientDTOStatisticMaxPrice {
    private Integer clientDTOid;
    private String name;
    private int maxPrice;

    //constructor
    public ClientDTOStatisticMaxPrice(Integer id, String clientName, int price)
    {
        this.clientDTOid = id;
        this.name = clientName;
        this.maxPrice = price;
    }

    //getters
    public Integer getClientDTOid() { return this.clientDTOid;}
    public String getName() {return this.name; }
    public int getMaxPrice() { return maxPrice; }
}
