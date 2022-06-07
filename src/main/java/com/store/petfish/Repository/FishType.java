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
@Table(name="fish_type")
public class FishType {
	
	@Id
	@Column(name="Fish_Name")
	private String fishName;
	
	@Column(name="Fins")
	private int Fins;
	
	@Column(name="Fish_Description")
	private String fishDescription;

}
