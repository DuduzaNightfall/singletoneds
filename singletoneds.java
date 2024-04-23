public class FilaDeImpressao {
    private static FilaDeImpressao instancia;
    private List<String> documentos;

    private FilaDeImpressao() {
        documentos = new ArrayList<>();
    }

    public static synchronized FilaDeImpressao getInstance() {
        if (instancia == null) {
            instancia = new FilaDeImpressao();
        }
        return instancia;
    }

    public synchronized void fila(String documento) {
        documentos.add(documento);
    }

    public synchronized void imprimeDocumento() {
        if (!documentos.isEmpty()) {
            String documento = documentos.get(0);
            System.out.println("Imprimindo documento: " + documento);
            documentos.remove(0);
        } else {
            System.out.println("Não há documentos na fila para imprimir.");
        }
    }

    public synchronized void removeDocumento(String documento) {
        documentos.remove(documento);
    }

    public synchronized void removeTodosDocumentos() {
        documentos.clear();
    }
}
