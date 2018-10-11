package visao;

import controle.Dijkstra;
import java.awt.Toolkit;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modelo.Aresta;
import modelo.Grafo;
import modelo.Vertice;

/**
 * @author Augusto
 */

public class Dashboard extends javax.swing.JFrame {

    public static void main(String args[]) {
        //Definição do Look And Feel
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {}

        //Criação e Exibição do Frame
        java.awt.EventQueue.invokeLater(() -> {
            new Dashboard().setVisible(true);
        });
    }
    
    private Grafo g;
    private TBM_Vertice tbmVertice;
    private TBM_Aresta tbmAresta;
    private DefaultComboBoxModel<Vertice> modelVertice, modelVertice1;
    
    public Dashboard() {
        //Título do Frame
        super("Gerenciador de Grafos");

        //Instanciação dos objetos
        g = new Grafo ();
        tbmVertice = new TBM_Vertice(g);
        modelVertice = new DefaultComboBoxModel<>();
        modelVertice1 = new DefaultComboBoxModel<>();
        tbmAresta = new TBM_Aresta(g);
        
        //Componentes da tela
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
        
        atualizar();
    }

    private void atualizar () {
        numArestas.setText(String.valueOf(g.getArestas().size()));
        numVertices.setText(String.valueOf(g.getVertices().size()));
        
        tbmVertice.atualizar();
        modelVertice.removeAllElements();
        modelVertice1.removeAllElements();
        for (Vertice v: g.getVertices()) {
            modelVertice.addElement(v);
            modelVertice1.addElement(v);
        }
        
        tbmAresta.atualizar();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        divisaoAbas = new javax.swing.JTabbedPane();
        panelGrafo = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        numArestas = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        numVertices = new javax.swing.JLabel();
        panelVertice = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaVertice = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        inputDescricao = new javax.swing.JTextField();
        btnAddVertice = new javax.swing.JButton();
        btnExcluirVertice = new javax.swing.JButton();
        panelAresta = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaAresta = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jcbVertOrigem = new javax.swing.JComboBox<>();
        jcbVertDestino = new javax.swing.JComboBox<>();
        inputDistancia = new javax.swing.JTextField();
        inputDirigido = new javax.swing.JCheckBox();
        btnAddAresta = new javax.swing.JButton();
        btnExcluirAresta = new javax.swing.JButton();
        panelDijkstra = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        inputVertInicio = new javax.swing.JComboBox<>();
        inputVertFim = new javax.swing.JComboBox<>();
        btnCalcular = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 70)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("ARESTAS:");

        numArestas.setFont(new java.awt.Font("Tahoma", 0, 70)); // NOI18N
        numArestas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        numArestas.setText("-");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 70)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("VÉRTICES:");

        numVertices.setFont(new java.awt.Font("Tahoma", 0, 70)); // NOI18N
        numVertices.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        numVertices.setText("-");

        javax.swing.GroupLayout panelGrafoLayout = new javax.swing.GroupLayout(panelGrafo);
        panelGrafo.setLayout(panelGrafoLayout);
        panelGrafoLayout.setHorizontalGroup(
            panelGrafoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGrafoLayout.createSequentialGroup()
                .addGroup(panelGrafoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGrafoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGrafoLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panelGrafoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(numVertices, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numArestas, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelGrafoLayout.setVerticalGroup(
            panelGrafoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGrafoLayout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addGroup(panelGrafoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numVertices, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(panelGrafoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numArestas, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );

        divisaoAbas.addTab("Grafo", panelGrafo);

        tabelaVertice.setModel(tbmVertice);
        tabelaVertice.setToolTipText("");
        jScrollPane1.setViewportView(tabelaVertice);

        jLabel4.setText("Descrição:");

        btnAddVertice.setText("Adicionar");
        btnAddVertice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddVerticeActionPerformed(evt);
            }
        });

        btnExcluirVertice.setText("Excluir");
        btnExcluirVertice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirVerticeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelVerticeLayout = new javax.swing.GroupLayout(panelVertice);
        panelVertice.setLayout(panelVerticeLayout);
        panelVerticeLayout.setHorizontalGroup(
            panelVerticeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVerticeLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(panelVerticeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(inputDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelVerticeLayout.createSequentialGroup()
                        .addComponent(btnAddVertice)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluirVertice, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        panelVerticeLayout.setVerticalGroup(
            panelVerticeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVerticeLayout.createSequentialGroup()
                .addGroup(panelVerticeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelVerticeLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelVerticeLayout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(inputDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panelVerticeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnExcluirVertice)
                            .addComponent(btnAddVertice))))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        divisaoAbas.addTab("Vértices", panelVertice);

        tabelaAresta.setModel(tbmAresta);
        jScrollPane2.setViewportView(tabelaAresta);

        jLabel1.setText("Vértice de Origem:");

        jLabel2.setText("Vértice de Destino:");

        jLabel3.setText("Distância:");

        jcbVertOrigem.setModel(modelVertice);

        jcbVertDestino.setModel(modelVertice1);

        inputDirigido.setText("Dirigido");

        btnAddAresta.setText("Adicionar");
        btnAddAresta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddArestaActionPerformed(evt);
            }
        });

        btnExcluirAresta.setText("Excluir");
        btnExcluirAresta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirArestaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelArestaLayout = new javax.swing.GroupLayout(panelAresta);
        panelAresta.setLayout(panelArestaLayout);
        panelArestaLayout.setHorizontalGroup(
            panelArestaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelArestaLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(panelArestaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelArestaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(inputDirigido)
                        .addComponent(jcbVertOrigem, 0, 176, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(jcbVertDestino, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addComponent(inputDistancia))
                    .addGroup(panelArestaLayout.createSequentialGroup()
                        .addComponent(btnAddAresta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnExcluirAresta, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        panelArestaLayout.setVerticalGroup(
            panelArestaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelArestaLayout.createSequentialGroup()
                .addGroup(panelArestaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelArestaLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcbVertOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcbVertDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(inputDistancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(inputDirigido)
                        .addGap(34, 34, 34)
                        .addGroup(panelArestaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnExcluirAresta)
                            .addComponent(btnAddAresta)))
                    .addGroup(panelArestaLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        divisaoAbas.addTab("Arestas", panelAresta);

        jLabel5.setText("Vértice do Início:");

        jLabel6.setText("Vértice do Fim:");

        inputVertInicio.setModel(modelVertice);

        inputVertFim.setModel(modelVertice1);

        btnCalcular.setText("Calcular");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDijkstraLayout = new javax.swing.GroupLayout(panelDijkstra);
        panelDijkstra.setLayout(panelDijkstraLayout);
        panelDijkstraLayout.setHorizontalGroup(
            panelDijkstraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDijkstraLayout.createSequentialGroup()
                .addGroup(panelDijkstraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDijkstraLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(panelDijkstraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputVertInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(80, 80, 80)
                        .addGroup(panelDijkstraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(inputVertFim, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelDijkstraLayout.createSequentialGroup()
                        .addGap(273, 273, 273)
                        .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        panelDijkstraLayout.setVerticalGroup(
            panelDijkstraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDijkstraLayout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(panelDijkstraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDijkstraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputVertInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputVertFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(149, Short.MAX_VALUE))
        );

        divisaoAbas.addTab("Dijkstra", panelDijkstra);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(divisaoAbas, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(divisaoAbas, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (JOptionPane.showConfirmDialog(this, "Você deseja mesmo sair?") == JOptionPane.YES_OPTION) {
            this.dispose();
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    private void btnAddArestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddArestaActionPerformed
        try {
            Aresta a = new Aresta((Vertice)jcbVertOrigem.getSelectedItem(), (Vertice)jcbVertDestino.getSelectedItem(), Float.parseFloat(inputDistancia.getText()), inputDirigido.isSelected());
            if (!g.adicionarAresta(a)) throw new Exception(); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Informe as informações corretas e tente novamente!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        atualizar();
        jcbVertOrigem.requestFocus();
    }//GEN-LAST:event_btnAddArestaActionPerformed

    private void btnExcluirArestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirArestaActionPerformed
        int row = tabelaAresta.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Primeiramente, selecione uma aresta na tabela!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (JOptionPane.showConfirmDialog(this, "Você deseja excluir a aresta '" + g.getArestas().get(row).toString() + "' ?") == JOptionPane.NO_OPTION) return;
        if (!g.removerAresta(g.getArestas().get(row))) JOptionPane.showMessageDialog(this, "Erro ao excluir a aresta!", "Erro", JOptionPane.ERROR_MESSAGE);
        atualizar();
    }//GEN-LAST:event_btnExcluirArestaActionPerformed

    private void btnExcluirVerticeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirVerticeActionPerformed
        int row = tabelaVertice.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Primeiramente, selecione um vértice na tabela!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (JOptionPane.showConfirmDialog(this, "Você deseja excluir o vértice '" + g.getVertices().get(row).getDescricao() + "' ?") == JOptionPane.NO_OPTION) return;
        if (!g.removerVertice(g.getVertices().get(row))) JOptionPane.showMessageDialog(this, "Erro ao excluir o vértice!", "Erro", JOptionPane.ERROR_MESSAGE);
        atualizar();
    }//GEN-LAST:event_btnExcluirVerticeActionPerformed

    private void btnAddVerticeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddVerticeActionPerformed
        if (inputDescricao.getText().equals("")) JOptionPane.showMessageDialog(this, "Insira uma descrição!", "Erro", JOptionPane.ERROR_MESSAGE);
        Vertice v = new Vertice(inputDescricao.getText());
        if (!g.adicionarVertice(v)) JOptionPane.showMessageDialog(this, "Tente novamente com outra descrição!", "Erro", JOptionPane.ERROR_MESSAGE);
        inputDescricao.setText("");
        inputDescricao.requestFocus();
        atualizar();
    }//GEN-LAST:event_btnAddVerticeActionPerformed

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        try {
            Vertice v1 = (Vertice)inputVertInicio.getSelectedItem();
            Vertice v2 = (Vertice)inputVertFim.getSelectedItem();
            float distancia = Dijkstra.getMenorDistancia(g, v1, v2);
            if (distancia == Float.POSITIVE_INFINITY) JOptionPane.showMessageDialog(this, "Não existe uma rota entre esses vértices!", "Erro", JOptionPane.ERROR_MESSAGE);
            else JOptionPane.showMessageDialog(this, "A menor distância entre esses vértices é " + distancia + ".", "Resultado", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Não foi possível realizar o cálculo!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnCalcularActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddAresta;
    private javax.swing.JButton btnAddVertice;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnExcluirAresta;
    private javax.swing.JButton btnExcluirVertice;
    private javax.swing.JTabbedPane divisaoAbas;
    private javax.swing.JTextField inputDescricao;
    private javax.swing.JCheckBox inputDirigido;
    private javax.swing.JTextField inputDistancia;
    private javax.swing.JComboBox<Vertice> inputVertFim;
    private javax.swing.JComboBox<Vertice> inputVertInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<Vertice> jcbVertDestino;
    private javax.swing.JComboBox<Vertice> jcbVertOrigem;
    private javax.swing.JLabel numArestas;
    private javax.swing.JLabel numVertices;
    private javax.swing.JPanel panelAresta;
    private javax.swing.JPanel panelDijkstra;
    private javax.swing.JPanel panelGrafo;
    private javax.swing.JPanel panelVertice;
    private javax.swing.JTable tabelaAresta;
    private javax.swing.JTable tabelaVertice;
    // End of variables declaration//GEN-END:variables
}
