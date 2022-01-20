package com.br.ms.communication.bank.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name="pagamento")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pagamento implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	private Cartao cartao;

	private BigDecimal valorCompra;

}
