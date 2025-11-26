import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.swing.*;




class Node {
    String nome;
    Node left, right;

    Node(String nome) {
        this.nome = nome;
        this.left = this.right = null;
    }
}


class ArvoreBinaria {
    private Node raiz;

    public boolean inserir(String nome) {
        if (raiz == null) {
            raiz = new Node(nome);
            return true;
        }
        return inserirRec(raiz, nome);
    }

    private boolean inserirRec(Node atual, String nome) {
        int cmp = nome.compareToIgnoreCase(atual.nome);

        if (cmp == 0) {
            return false; 
        } else if (cmp < 0) {
            if (atual.left == null) {
                atual.left = new Node(nome);
                return true;
            }
            return inserirRec(atual.left, nome);
        } else {
            if (atual.right == null) {
                atual.right = new Node(nome);
                return true;
            }
            return inserirRec(atual.right, nome);
        }
    }

    public boolean buscar(String nome) {
        return buscarRec(raiz, nome);
    }

    private boolean buscarRec(Node atual, String nome) {
        if (atual == null) return false;

        int cmp = nome.compareToIgnoreCase(atual.nome);

        if (cmp == 0) return true;
        else if (cmp < 0) return buscarRec(atual.left, nome);
        else return buscarRec(atual.right, nome);
    }

    public List<String> listar() {
        List<String> alunos = new ArrayList<>();
        listarRec(raiz, alunos);
        return alunos;
    }

    private void listarRec(Node atual, List<String> lista) {
        if (atual != null) {
            listarRec(atual.left, lista);
            lista.add(atual.nome);
            listarRec(atual.right, lista);
        }
    }
}


public class SistemaUnicsulGUI extends JFrame {

    private static Map<String, ArvoreBinaria> campi = new LinkedHashMap<>();

    public SistemaUnicsulGUI() {
        setTitle("Sistema Unicsul");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        
        campi.put("Anália Franco", new ArvoreBinaria());
        campi.put("Guarulhos", new ArvoreBinaria());
        campi.put("Liberdade", new ArvoreBinaria());
        campi.put("Paulista", new ArvoreBinaria());
        campi.put("São Miguel", new ArvoreBinaria());
        campi.put("Santo Amaro", new ArvoreBinaria());
        campi.put("Villa Lobos", new ArvoreBinaria());

        
        JButton btnCadastrar = new JButton("Cadastrar Aluno");
        JButton btnLocalizar = new JButton("Localizar Aluno");
        JButton btnListar = new JButton("Listar Alunos do Campus");

        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));
        panel.add(btnCadastrar);
        panel.add(btnLocalizar);
        panel.add(btnListar);

        add(panel);

        
        btnCadastrar.addActionListener(e -> cadastrarAluno());
        btnLocalizar.addActionListener(e -> localizarAluno());
        btnListar.addActionListener(e -> listarAlunosCampus());
    }

    private void cadastrarAluno() {
        String nome = JOptionPane.showInputDialog(this, "Digite o nome do aluno:");
        if (nome == null || nome.trim().isEmpty()) return;

        
        for (Map.Entry<String, ArvoreBinaria> entry : campi.entrySet()) {
            if (entry.getValue().buscar(nome)) {
                JOptionPane.showMessageDialog(this, "Aluno já cadastrado em algum campus!");
                return;
            }
        }

        
        String campusEscolhido = (String) JOptionPane.showInputDialog(
                this,
                "Selecione o campus:",
                "Cadastro de Aluno",
                JOptionPane.PLAIN_MESSAGE,
                null,
                campi.keySet().toArray(),
                null
        );

        if (campusEscolhido == null) return;

        boolean inserido = campi.get(campusEscolhido).inserir(nome);
        if (inserido) {
            JOptionPane.showMessageDialog(this, "Aluno cadastrado no campus " + campusEscolhido);
        } else {
            JOptionPane.showMessageDialog(this, "Erro: aluno já existe neste campus.");
        }
    }

    private void localizarAluno() {
        String nome = JOptionPane.showInputDialog(this, "Digite o nome do aluno:");
        if (nome == null || nome.trim().isEmpty()) return;

        for (Map.Entry<String, ArvoreBinaria> entry : campi.entrySet()) {
            if (entry.getValue().buscar(nome)) {
                JOptionPane.showMessageDialog(this, "Aluno encontrado no campus " + entry.getKey());
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Aluno não localizado.");
    }

    private void listarAlunosCampus() {
        String campusEscolhido = (String) JOptionPane.showInputDialog(
                this,
                "Selecione o campus:",
                "Listagem de Alunos",
                JOptionPane.PLAIN_MESSAGE,
                null,
                campi.keySet().toArray(),
                null
        );

        if (campusEscolhido == null) return;

        List<String> alunos = campi.get(campusEscolhido).listar();
        if (alunos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum aluno cadastrado neste campus.");
        } else {
            
            StringBuilder sb = new StringBuilder("Alunos do campus " + campusEscolhido + ":\n\n");
            for (String aluno : alunos) {
                sb.append(aluno).append("\n");
            }

            
            JTextArea textArea = new JTextArea(sb.toString());
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(300, 200));

            JOptionPane.showMessageDialog(this, scrollPane, 
                    "Lista de Alunos - " + campusEscolhido, JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SistemaUnicsulGUI().setVisible(true);
        });
    }
}
