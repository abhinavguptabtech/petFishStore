package com.store.petfish.Repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="aquarium_type")
public class AquariumType {
	
	@Id
	@Column(name="Aqua_Name")
	private String aquaName;
	
	@Column(name="Aqua_Water_Capacity")
	private int aquaWaterCapacity;
	
	@Column(name="Aqua_Description")
	private String aquaDescription;


}
