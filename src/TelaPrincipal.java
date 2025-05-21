import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TelaPrincipal extends JFrame {
    private ArrayList<Cliente> listaClientes = ArquivoUtil.carregar("clientes.dat");
    private ArrayList<Servico> listaServicos = ArquivoUtil.carregar("servicos.dat");
    private ArrayList<Agendamento> listaAgendamentos = ArquivoUtil.carregar("agendamentos.dat");

    public TelaPrincipal() {
        setTitle("Sistema de Agendamento - Ateliê de Maquiagem");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();

        JMenu menuCadastro = new JMenu("Cadastros");
        JMenuItem menuCliente = new JMenuItem("Cadastrar Cliente");
        JMenuItem menuServico = new JMenuItem("Cadastrar Serviço");

        JMenu menuAgendamento = new JMenu("Agendamento");
        JMenuItem menuNovoAgendamento = new JMenuItem("Novo Agendamento");

        JMenu menuVisualizar = new JMenu("Visualizar");
        JMenuItem menuVerAgendamentos = new JMenuItem("Ver Agendamentos");

        menuCliente.addActionListener(e -> new TelaCadastroCliente(listaClientes));
        menuServico.addActionListener(e -> new TelaCadastroServico(listaServicos));
        menuNovoAgendamento.addActionListener(e -> new TelaAgendamento(listaClientes, listaServicos, listaAgendamentos));
        menuVerAgendamentos.addActionListener(e -> mostrarAgendamentos());

        menuCadastro.add(menuCliente);
        menuCadastro.add(menuServico);
        menuAgendamento.add(menuNovoAgendamento);
        menuVisualizar.add(menuVerAgendamentos);

        menuBar.add(menuCadastro);
        menuBar.add(menuAgendamento);
        menuBar.add(menuVisualizar);

        setJMenuBar(menuBar);

        JLabel labelBoasVindas = new JLabel("Bem-vindo ao sistema do Ateliê!", JLabel.CENTER);
        labelBoasVindas.setFont(new Font("Arial", Font.BOLD, 16));
        add(labelBoasVindas);

        setVisible(true);
    }

    private void mostrarAgendamentos() {
        if (listaAgendamentos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum agendamento encontrado.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (Agendamento a : listaAgendamentos) {
            sb.append(a.toString()).append("\n");
        }

        JTextArea textArea = new JTextArea(sb.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(350, 200));

        JOptionPane.showMessageDialog(this, scrollPane, "Agendamentos", JOptionPane.INFORMATION_MESSAGE);
    }

    public void salvarTudo() {
        ArquivoUtil.salvar("clientes.dat", listaClientes);
        ArquivoUtil.salvar("servicos.dat", listaServicos);
        ArquivoUtil.salvar("agendamentos.dat", listaAgendamentos);
    }

    public static void main(String[] args) {
        TelaPrincipal tela = new TelaPrincipal();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> tela.salvarTudo()));
    }
}