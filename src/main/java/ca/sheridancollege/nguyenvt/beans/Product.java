package ca.sheridancollege.nguyenvt.beans;

import java.io.Serializable;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {

	private Long id;
	private String name;
	private double price;
	private Long quantity;
	private double total;
}
