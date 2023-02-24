package com.example.simpleJPAH2;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

@Entity
@Table(name= "Cliente")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder @Data
public class Cliente {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(name = "name")
private String name;
@Column(name = "direction")
private String direction;


}
