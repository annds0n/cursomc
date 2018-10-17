package com.andensonsilva.cursomc.domain;

import com.andensonsilva.cursomc.domain.enums.EstadoPagamento;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pagamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;

    private Integer estadoPapamento;

    @OneToOne
    @JoinColumn(name = "pedido_id")
    @MapsId
    private Pedido pedido;

    public Pagamento() {  }

    public Pagamento(Integer id, EstadoPagamento estadoPapamento, Pedido pedido) {
        this.id = id;
        this.estadoPapamento = estadoPapamento.getCodigo();
        this.pedido = pedido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EstadoPagamento getEstadoPapamento() {
        return EstadoPagamento.toEnum(estadoPapamento);
    }

    public void setEstadoPapamento(EstadoPagamento estadoPapamento) {
        this.estadoPapamento = estadoPapamento.getCodigo();
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pagamento pagamento = (Pagamento) o;
        return Objects.equals(id, pagamento.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}