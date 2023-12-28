package damain;
 
import javax.swing.*;
import test.*;

public class QRCodeScanner extends JFrame {
    private JTextArea resultTextArea;

    public QRCodeScanner() {
        initComponents();
        //startScanning();  // Comienza el escaneo automáticamente al iniciar la interfaz
    }

    public void initComponents() {
        resultTextArea = new JTextArea();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Escáner QR App");

        getContentPane().add(resultTextArea, java.awt.BorderLayout.CENTER);

        pack();
    }

    public void startScanning() {
        // La lógica aquí dependerá de cómo se comporta tu escáner
        // Este ejemplo asume que el escáner emite los caracteres como entrada de teclado
        StringBuilder scannedData = new StringBuilder();

        // Crear un KeyListener que escuche los eventos de teclado
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char ch = evt.getKeyChar();

                // Procesar el código QR escaneado
                String qrCode = scannedData.toString();
                resultTextArea.setText("Resultado del escaneo: " + qrCode);

                String url = qrCode;
                CGEscanear interfazEscanear = new CGEscanear(); 
                interfazEscanear.escanearYActualizarTabla(url);

                // Reiniciar el StringBuilder para el próximo escaneo
                scannedData.setLength(0);
            }
        });

        // Asegurarse de que el JFrame tenga el foco para recibir eventos de teclado
        requestFocus();
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new QRCodeScanner().setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}