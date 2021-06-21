package forms;

import api.Api;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroProduto extends JFrame{
    private JPanel rootContainer;
    private JPanel cadastroContainer;
    private JLabel categorias;
    private JLabel descricao;
    private JTextField textFieldDescricao;
    private JLabel tituloanuncio;
    private JTextField textFieldTitulo;
    private JLabel cepLabel;
    private JTextField textFieldCep;
    private JComboBox categoriasComboBox;
    private JButton salvarButton;
    private JButton cancelarButton;
    private Api api;

    public CadastroProduto(Api api) {
        this.api = api;
        initForm();
        pack();

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                MarketPlace nomeVariavel = new MarketPlace(api);
                nomeVariavel.setVisible(true);

            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                MarketPlace nomeVariavel = new MarketPlace(api);
                nomeVariavel.setVisible(true);

                }
            }
        );
    }

    private void initForm() {
        setTitle("From Guri");
        setContentPane(rootContainer);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    public void showMe() {
        java.awt.EventQueue .invokeLater(new Runnable()
        {
            @Override
            public void run() {
                pack();
                setVisible(true);
            }
        });
    }


}
