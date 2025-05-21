import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class TelaAgendamento extends JFrame {
    private JComboBox<Cliente> comboClientes;
    private JComboBox<Servico> comboServicos;
    private JTextField campoDataHora;
    private JButton botaoAgendar;
    private ArrayList<Agendamento> listaAgendamentos;

    public TelaAgendamento(ArrayList<Cliente> clientes, ArrayList<Servico> servicos, ArrayList<Agendamento> listaAgendamentos) {
        this.listaAgendamentos = listaAgendamentos;

        setTitle("Agendamento");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        add(new JLabel("Cliente:"));
        comboClientes = new JComboBox<>(clientes.toArray(new Cliente[0]));
        add(comboClientes);

        add(new JLabel("Serviço:"));
        comboServicos = new JComboBox<>(servicos.toArray(new Servico[0]));
        add(comboServicos);

        add(new JLabel("Data e Hora (aaaa-MM-dd HH:mm):"));
        campoDataHora = new JTextField();
        add(campoDataHora);

        botaoAgendar = new JButton("Agendar");
        add(botaoAgendar);

        botaoAgendar.addActionListener(e -> {
            try {
                Cliente cliente = (Cliente) comboClientes.getSelectedItem();
                Servico servico = (Servico) comboServicos.getSelectedItem();
                String dataHoraStr = campoDataHora.getText();

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                LocalDateTime dataHora = LocalDateTime.parse(dataHoraStr, formatter);

                Agendamento agendamento = new Agendamento(cliente, servico, dataHora);
                listaAgendamentos.add(agendamento);
                JOptionPane.showMessageDialog(null, "Agendamento realizado com sucesso!");
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Formato inválido. Use: yyyy-MM-dd HH:mm");
            }
        });

        setVisible(true);
    }
}