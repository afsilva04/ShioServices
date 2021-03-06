package com.shio.admin.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
public class InventoryDTO {

    @Id
    @GeneratedValue
    private Long id;
    private int quantity;
    private Long productId;
    private String productName;
    private Long subsidiaryId;
    private String subsidiaryName;

}
