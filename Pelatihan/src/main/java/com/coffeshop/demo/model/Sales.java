package com.coffeshop.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
@Data
@Entity
public class Sales {
 @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
private String date;
@ManyToOne
@JoinColumn(name = "code_coffee", referencedColumnName = "code")
private Coffee codeCoffee;
@ManyToOne
@JoinColumn(name = "id_barista", referencedColumnName = "id")
private Barista idBarista;
public void setBarista(Barista barista) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setBarista'");
}
public void setCoffee(Coffee coffee) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setCoffee'");
}

}
