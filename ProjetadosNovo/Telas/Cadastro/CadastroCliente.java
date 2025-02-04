import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;

public class CadastroCliente extends JFrame {
    /* Declaração de labels, campos de texto e outros componentes */
    private JLabel lblNome = new JLabel("Nome:");
    private JTextField txtNome = new JTextField(15);
    private JLabel lblEmail = new JLabel("Email:");
    private JTextField txtEmail = new JTextField(15);
    private JLabel lblGenero = new JLabel("Gênero:");
    private JRadioButton rdFeminino = new JRadioButton("Feminino");
    private JRadioButton rdMasculino = new JRadioButton("Masculino");
    private ButtonGroup grupoGenero = new ButtonGroup();
    private JLabel lblPeso = new JLabel("Peso:");
    private JTextField txtPeso = new JTextField(5);
    private JLabel lblAltura = new JLabel("Altura:");
    private JTextField txtAltura = new JTextField(5);
    private JLabel lblIdade = new JLabel("Idade:");
    private JTextField txtIdade = new JTextField(5);
    private JLabel lblLista = new JLabel("Plano:");
    private JButton btnCadastro = new JButton("Cadastrar");
    private JComboBox<String> comboBox = new JComboBox<>(new String[] {"Mensal","Semestral","Anual"});

    public CadastroCliente() {
        /* Configurações iniciais da janela */
        this.setTitle("Cadastro de Cliente");
        this.setSize(800, 400);
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo((Component)null);
        this.setResizable(false);

        /* Configurar fontes */
        Font labelFont = new Font("Arial", Font.BOLD, 14);
        Font fieldFont = new Font("Arial", Font.PLAIN, 14);
        Font buttonFont = new Font("Arial", Font.BOLD, 16);

        lblNome.setFont(labelFont);
        lblEmail.setFont(labelFont);
        lblGenero.setFont(labelFont);
        lblPeso.setFont(labelFont);
        lblAltura.setFont(labelFont);
        lblIdade.setFont(labelFont);
        lblLista.setFont(labelFont);
        txtNome.setFont(fieldFont);
        txtEmail.setFont(fieldFont);
        txtPeso.setFont(fieldFont);
        txtAltura.setFont(fieldFont);
        txtIdade.setFont(fieldFont);
        rdFeminino.setFont(fieldFont);
        rdMasculino.setFont(fieldFont);
        comboBox.setFont(fieldFont);
        btnCadastro.setFont(buttonFont);

        /* Painel principal usando GridBagLayout */
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5, 5, 5, 20); // Adicionado maior espaçamento horizontal

        /* Adiciona os componentes ao painel principal */
        this.addComponent(panel, constraints, this.lblNome, this.txtNome, 0, 0);
        this.addComponent(panel, constraints, this.lblEmail, this.txtEmail, 0, 1);

        /* Painel para peso e altura na mesma célula */
        JPanel panelPesoAltura = new JPanel(new GridBagLayout());
        GridBagConstraints subConstraints = new GridBagConstraints();
        subConstraints.insets = new Insets(0, 5, 0, 5);

        subConstraints.gridx = 0;
        panelPesoAltura.add(lblPeso, subConstraints);

        subConstraints.gridx = 1;
        panelPesoAltura.add(txtPeso, subConstraints);

        subConstraints.gridx = 2;
        panelPesoAltura.add(lblAltura, subConstraints);

        subConstraints.gridx = 3;
        panelPesoAltura.add(txtAltura, subConstraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        panel.add(panelPesoAltura, constraints);

        constraints.gridx = 2;
        constraints.gridwidth = 1;
        this.addComponent(panel, constraints, this.lblIdade, this.txtIdade, 2, 0);

        /* Painel para os botões de rádio do gênero */
        JPanel panelGenero = new JPanel(new GridBagLayout());
        GridBagConstraints generoConstraints = new GridBagConstraints();
        generoConstraints.insets = new Insets(0, 5, 0, 5);

        generoConstraints.gridx = 0;
        panelGenero.add(rdFeminino, generoConstraints);

        generoConstraints.gridx = 1;
        panelGenero.add(rdMasculino, generoConstraints);

        constraints.gridx = 2;
        constraints.gridy = 1;
        panel.add(lblGenero, constraints);

        constraints.gridx = 3;
        panel.add(panelGenero, constraints);

        this.grupoGenero.add(this.rdFeminino);
        this.grupoGenero.add(this.rdMasculino);

        constraints.gridx = 2;
        constraints.gridheight = 1;
        this.addComponent(panel, constraints, this.lblLista, this.comboBox, 2, 2);

        /* Posiciona o botão de cadastro no canto inferior direito */
        constraints.gridx = 4;
        constraints.gridy = 5;
        constraints.anchor = GridBagConstraints.SOUTHEAST;
        constraints.insets = new Insets(20, 0, 0, 20);
        panel.add(btnCadastro, constraints);

        this.add(panel);
        this.setVisible(true);
    }

    /* Método utilitário para adicionar componentes ao painel com GridBagLayout */
    private void addComponent(JPanel panel, GridBagConstraints constraints, JComponent label, JComponent field, int gridx, int gridy) {
        constraints.gridx = gridx;
        constraints.gridy = gridy;
        if (label != null) {
            panel.add(label, constraints);
            ++constraints.gridx;
        }

        if (field != null) {
            panel.add(field, constraints);
        }
    }

    public static void main(String[] args) {
        /* Cria e exibe a janela de cadastro */
        new CadastroCliente();
    }
}
