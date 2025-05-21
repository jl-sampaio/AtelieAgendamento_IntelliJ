import java.io.Serializable;
import java.time.LocalDateTime;

public class Agendamento implements Serializable {
    private Cliente cliente;
    private Servico servico;
    private LocalDateTime dataHora;

    public Agendamento(Cliente cliente, Servico servico, LocalDateTime dataHora) {
        this.cliente = cliente;
        this.servico = servico;
        this.dataHora = dataHora;
    }

    public Cliente getCliente() { return cliente; }
    public Servico getServico() { return servico; }
    public LocalDateTime getDataHora() { return dataHora; }

    public String toString() {
        return cliente.getNome() + " - " + servico.getNome() + " em " + dataHora.toString().replace("T", " ");
    }
}