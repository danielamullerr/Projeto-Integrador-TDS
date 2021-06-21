package forms;

import api.Api;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MarketPlace extends JFrame{
    private JPanel rootContainer;
    private JPanel marketPlaceContainer;
    private JButton adicionarProdutoButton;
    private JScrollPane JScrollPane;
    private JTable table;
    private  Api api;

    public MarketPlace(Api api) {
        this.api = api;
        initForm();
        pack();

        adicionarProdutoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                CadastroProduto newProduto = new CadastroProduto(api);
                newProduto.setVisible(true);


            }
        });
    }

    private void initForm() {

        setTitle("From Guri");
        setContentPane(rootContainer);
        initTable();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();

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

   private void initTable(){
       DefaultTableModel tableModel = new DefaultTableModel();
       Object[] titulo = {
               "Tela S10 Quebrada", "Computador Estragado",
               "Janela Quebrada",
       };
       tableModel.addColumn("Titulo", titulo);

       Object[] descricao = {
               "Tela de celular quebrada modelo S10 Samsung", "Computador estragado modelo Dell Inspirion",
               "Janela de madeira quebrada"
       };
       tableModel.addColumn("Descrição", descricao);

       Object[] categoria = {
               "Informática", "Informática",
               "Reforma"
       };
       tableModel.addColumn("Categoria", categoria);

       Object[] cep = {
               "940.67-123", "345.21-435",
               "653.34-765"
       };

       tableModel.addColumn("Cep", cep);

       table.setModel(tableModel);

       DefaultTableCellRenderer defaultHeaderRenderer = (DefaultTableCellRenderer) table
               .getTableHeader()
               .getDefaultRenderer();
       defaultHeaderRenderer.setHorizontalAlignment(JLabel.CENTER);
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
